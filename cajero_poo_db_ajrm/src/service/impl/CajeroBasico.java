package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.ReciboDTO;
import exception.*;
import models.Atm;
import models.Ticket;
import service.OperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements OperacionesBasicas {


    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object[] data = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("INGRESA LA REFERENCIA");
        String ref = scan.nextLine();
        System.out.println("INGRESA LA CLAVE");
        String clave = scan.nextLine();

        //Existe la llave (ref)
        if( ! Atm.cacheRST.containsKey(ref)) {
            throw new BusinessException(Mensajes.INVALID_REFERENCE);
        }else if( ! Atm.cacheRST.get(ref).getClave().equals(clave)){
            throw new BusinessException(Mensajes.INCORRECT_AMOUNT);
        }else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        }else {
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
            //Procesar el cobro
            for(int i = 0; i< Atm.cuentas.size(); i++) {
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());

                    //Al terminar de cobrarlo, pasalo al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
            }
            System.out.println("Imprimir models.Ticket ?\n 1=Si 0=no");
            int imp = scan.nextInt();
            if(imp==0){
                data[0] = null;
            }
        }
        return new Object[0];
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto)
            throws InvalidAmountException, DailyAmountLimitReachedException,
            DailyWithdrawalLimitExceededException, MinimumBalanceReachedException,
            InsufficientBalanceException {

            Ticket ticket = null;
            Object[] data = new Object[2];

            boolean existePrevio = false;
            existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta() + LocalDate.now());
            double totalRetirado = 0.0;

            if (existePrevio){
                for (Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now())){
                    totalRetirado = totalRetirado + t.getMonto();
                }
            }

            //Validar el monto sea multiplo de 100
            if(monto%100!=0){ //Si no es multiplo de 100
                throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);

            }else if(existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta() +
                    LocalDate.now()).size()== Constants.DAILY_MAX_QUANTITY_AMOUNT_WITHDRAWAL_LIMIT){ //Validar cantidad de retiros por dia
                throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);

            } else if ((totalRetirado + monto) > Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
                throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);

            }else if(cuenta.getSaldo() < monto ){
                throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);

            }else if(cuenta.getSaldo() - monto  < cuenta.getSaldoMin()){
                throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
            }else {
                //Obtengo el indice de la cuenta original dentro del cache (lista)
                int indexAnterior = Atm.cuentas.indexOf(cuenta);

                //Afectando el saldo del objeto temporal
                cuenta.setSaldo(cuenta.getSaldo()-monto);


                //Actualizar el cache de la lista, reemplazando el objeto con
                //los datos actualizados
                Atm.cuentas.set(indexAnterior, cuenta);


                //Actualiza el saldo de la cuenta en la base de datos
                this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());


                //Registrar el movimiento
                MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(),"RETIRO",
                        Date.valueOf(LocalDate.now()), monto);
               this.movDAO.registrarMovimiento(mov);


                ticket = new Ticket(this.getUbicacion(),
                        Atm.folio++,
                        LocalDate.now(),
                        "RETIRO",
                        "******"+cuenta.getNumCuenta().substring(6,9),
                        monto);

                //Controlar el registro del retiro en el cache de retiros
                if(existePrevio){
                    //Como ya existe la llave, se accede directo a la lista para añadir un valor
                    Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);

                }else{
                    //Si la llave no existe (es su primer retiro), primero se crea el registro en el mapa
                    Atm.getCacheRetiros().put(cuenta.getNumCuenta() + LocalDate.now(), new ArrayList<Ticket>());


                    Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);
                }

                //Construye el array de datos de salida
                data[0] = ticket;
                data[1] = monto;
            }

        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {
        Ticket ticket = null;
        ReciboDTO recibo = buscarRecibo(convenio, referencia);

        if(recibo==null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);

        }else if (recibo.getStatus()=='0') {
            throw new BusinessException(Mensajes.ALREADY_PAYED);

        }else if (( cuentaDTO.getSaldo() - recibo.getMonto()) < cuentaDTO.getSaldoMin()) {
            throw new BusinessException(Mensajes.MINIMUM_BALANCE);
        }else {
            //Nivel de objeto (memoria)
            int indexAnterior = Atm.cacheServicios.get(convenio).indexOf(recibo);
            recibo.setStatus('0');
            Atm.cacheServicios.get(convenio).set(indexAnterior, recibo);

            //Actualizar el saldo de la cuenta cargada en el cache dto.CuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo()-recibo.getMonto());
            Atm.cuentas.set(posicion,cuentaActual);

            //Descuenta el saldo en base de datos
            this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(), cuentaActual.getSaldo());

            //Registrar el movimiento
            this.movDAO.registrarMovimiento( new MovimientoDTO(cuentaActual.getCuentaId(),
                    "PAGO SERVICIOS", Date.valueOf(LocalDate.now()),recibo.getMonto()));

            this.serviciosDAO.actualizarStatusRecibo(referencia);

            ticket = new Ticket(this.getUbicacion(), Atm.folio++,LocalDate.now(),
                    "PAGO SERVICIOS",cuentaActual.getNumCuenta(),recibo.getMonto());
            return ticket;
        }

    }




}
