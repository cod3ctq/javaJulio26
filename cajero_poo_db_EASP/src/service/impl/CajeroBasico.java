package service.impl;

import exception.*;
import models.Atm;
import models.Ticket;
import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.RecibosDTO;
import service.OperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements OperacionesBasicas {

    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object data[] = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia");
        String ref = scan.nextLine();
        System.out.println("Ingresa la clave");
        String clave = scan.nextLine();

        //Existe la llave(ref)
        if(!Atm.cacheRST.containsKey(ref)){
            throw new BusinessException(Mensajes.INVALID_REFERENCE);

        }else if (!Atm.cacheRST.get(ref).getClave().equals(clave)){
            throw new BusinessException(Mensajes.INVALID_NIP);

        }else if(Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))){
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);

        }else{
            //Procesar el cobro
            for(int i = 0; i< Atm.cuentas.size(); i++){
                if(Atm.cuentas.get(i).getNumCuenta().equals(Atm.cacheRST.get(ref).getNumCuenta())) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());
                    //Al terminar de cobrarlo, pasalo al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
            }
            System.out.println("Imprimir Models.Ticket?\n 1 = SI, 0 = NO");
            int imp = scan.nextInt();
            if(imp==0){
                data[0] = null;
            }
        }
        return data;
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto) throws
            InvalidAmountExcepton,
            DailyWithdrawalLimitExceededException,
            DailyAmountLimitReachedException,
            InsufficientBalanceException,
            MinimumBalanceReachedException
    {
        Ticket ticket = null;
        Object[] data = new Object[2];

        boolean existePrevio = false;
        existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta()+LocalDate.now());
        double totalRetirado = 0.0;
        if (existePrevio){
            for(Ticket t: Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now())){
                totalRetirado = totalRetirado + t.getMonto();
            }
        }

        //Validar monto multiplo de 100
        if(monto%100!=0){ //Si no es multiplo de 100
            throw new InvalidAmountExcepton(Mensajes.INVALID_WITHDRAWAL_AMOUNT); //Generamos excepciones creadas por nosotros mismos
        }else if(existePrevio
        && Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).size()== Constants.DAILY_MAX_WITHDRAWAL_LIMIT){ //Validar cantidad de retiros por dia
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
        }else if(totalRetirado + monto > Constants.DAILY_MAX_AMOUNT_LIMIT) { //Validar monto de retiro diario
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);

            //Que me alcance
        }else if (cuenta.getSaldo()<monto){
            throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);
            //Que al retirar, no quede por debajo del minimo
        }else if (cuenta.getSaldo()-monto < cuenta.getSaldoMin()){
            throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
        }else{
            //Obtengo el indice de la cuenta original dentro del cache(lista)
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            //Afectamos el saldo del objeto temporal
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            //Actualizar el cache de la lista reemplazando el objeto con los datos actualizados
            Atm.cuentas.set(indexAnterior, cuenta);

            //Actualiza el saldo de la cuenta en la base de datos con un metodo heredado de la clase padre ATM
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //Registrar el movimiento
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(), "RETIRO", Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);

            ticket = new Ticket(
                    this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "Retiro",
                    "*****"+cuenta.getNumCuenta().substring(6,10),
                    monto
                    );
            //Construye el array de datos de salida
            data[0] = ticket;
            data[1] = monto;

            //controlar el registro del retiro en el cache de retiros
            if (existePrevio){
                //Como ya existe la llave, se accede directo a la lista para añadir un valor
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
            }else {
                //La llave no existe (es su primer retiro del dia)
                //Primero se crea el registro en el mapa
                Atm.getCacheRetiros().put(cuenta.getNumCuenta()+LocalDate.now(), new ArrayList<Ticket>());
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
            }

        }

        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {
        Ticket ticket = null;
        RecibosDTO recibo = buscarRecibo(convenio, referencia);


        if (recibo == null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);

        }else if ((cuentaDTO.getSaldo() - recibo.getMonto() < cuentaDTO.getSaldoMin())) {
            throw new BusinessException(Mensajes.MINIMUM_BALANCE);
        }else {
            //Nivel de objeto (memoria)
            int indexAnterior = Atm.recibosConvenio.get(convenio).indexOf(recibo);
            recibo.setStatus('0');
            Atm.recibosConvenio.get(convenio).set(indexAnterior, recibo);

            //Actualizar el saldo de la cuenta cargada en el cache dto.CuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo()-recibo.getMonto());
            Atm.cuentas.set(posicion, cuentaActual);

            //Actualizar la base de datos
            this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(), cuentaActual.getSaldo());
            this.movDAO.registrarMovimiento(new MovimientoDTO(cuentaActual.getCuentaId(),
                    "PAGO SERVICIOS", Date.valueOf(LocalDate.now()),recibo.getMonto()));
            this.recibosDAO.actualizarStatus(referencia);

            ticket = new Ticket(this.getUbicacion(), Atm.folio++, LocalDate.now(), "PAGO SERVICIOS", cuentaActual.getNumCuenta(), recibo.getMonto());
            return ticket;
        }
    }


}
