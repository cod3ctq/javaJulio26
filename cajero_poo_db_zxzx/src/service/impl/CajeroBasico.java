package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.ReciboDTO;
import exception.*;
import models.*;
import service.IOperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas {


    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object[] data = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nIngresa la referencia: ");
        String ref = scan.nextLine();
        System.out.print("\nIngresa la clave: ");
        String clave = scan.nextLine();

        //Validar si existe la llave (referencia)
        if(! Atm.cacheRST.containsKey(ref)){
            throw new BusinessException(Mensajes.INVALID_REFERENCE);
        }else if(! Atm.cacheRST.get(ref).getClave().equals(clave)){
            throw new BusinessException(Mensajes.INVALID_KEY);
        }else if(Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        }else{
                String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
                double montoADscontar = Atm.cacheRST.get(ref).getMonto();
                //Procesar el cobro
                int indexAnterior;
                for(int i = 0; i < Atm.cuentas.size(); i++){
                    if(Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)){
                        data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), //accede al método retirar (abajo)
                                Atm.cacheRST.get(ref).getMonto());

                        //Eliminación directa, simple y funcional
                        //cacheRST.remove(ref);

                        //Al terminar de cobrarlo, pásalo al conjunto de los ya cobrados
                        Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                        break;
                    }
                }
                System.out.println("\n¿Imprimir models.Ticket?" +
                        "\n1. Sí" +
                        "\n0. No");
                int imp = scan.nextInt();
                if(imp==0){
                    data[0] = null;
                }
        }
        return data;
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto)
            throws InvlidAmountException, DailyWithdrawalLimitExceededException, DailyAmountLimitReachedException,
            InsufficientBalanceException, MinimumBalanceReachedException{
        Ticket ticket = null;
        Object[] data = new Object[2];

        boolean existePrevio = false;
        existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta() + LocalDate.now());
        double totalRetirado = 0.0;
        if(existePrevio){
            for(Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now())){
                totalRetirado = totalRetirado + t.getMonto();
            }
        }

        //Validar el monto sea múltiplo de 100
        if(monto%100!=0){ //Si no es múltiplo de 100
            throw new InvlidAmountException(Mensajes.INVALID_WITHDRAWAL_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta() +
                LocalDate.now()).size() == Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) { //Validar cantidad de retiro por día
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
        } else if ( (totalRetirado + monto) > Constants.DAILY_MAX__AMOUNT_WITHDRAWAL_LIMIT){
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_AMOUNT);
        }else if(cuenta.getSaldo() < monto){//Que me alcance <dto.CuentaDTO>
            throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);
        }else if((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){//Que al retirar, no quede por debajo del mínimo
            throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
        }else{

            //Obtengo el índice de la cuenta original dentro del caché(lista)
            int indexAnterior = Atm.cuentas.indexOf(cuenta);

            //afectando el saldo del objeto temporal
            cuenta.setSaldo(cuenta.getSaldo()-monto);

            //Actualizar el caché de la lista reemplazando el objeto con los datos actualizados
            Atm.cuentas.set(indexAnterior,cuenta);

            //Actualiza el saldo de la cuenta en la base de datos
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo()); //El this.CuantaDAO es porque lo está heredando del padre (models.Atm), y la instancia es pública

            //registrar el movimiento
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(),"RETIRO", Date.valueOf(LocalDate.now()),
                    monto);
            this.movDAO.registrarMovimiento(mov);

            //Creamos el models.Ticket
            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "RETIRO",
                    "******"+cuenta.getNumCuenta().substring(6,9),
                    monto);

            //Controlr el registro del retiro en el caché de retiros
            if(existePrevio){
                //Como ya existe la llave, se accede directo a la lista para añadir un valor
                Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);
            }else{
                //Si llave no existe (es su primer retiro) primero se crea el registro en el mapa
                Atm.getCacheRetiros().put(cuenta.getNumCuenta() + LocalDate.now(), new ArrayList<Ticket>());
                //Se añade
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
        ReciboDTO recibo = buscarRecibo(convenio,referencia);
        if(recibo==null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }else if(recibo.getStatus()=='0') {
            throw new BusinessException(Mensajes.ALREADY_PAYED);
        }else if((cuentaDTO.getSaldo() - recibo.getMonto())< cuentaDTO.getSaldoMin()) {
            throw new BusinessException(Mensajes.MINIMUM_BALANCE);
        }else{
            //Nivel de objeto (memoria)
            int indexAnterior = Atm.cacheServicios.get(convenio).indexOf(recibo);
            recibo.setStatus('0');
            Atm.cacheServicios.get(convenio).set(indexAnterior,recibo);

            //Actualizar el saldo de la cuenta cargada en el caché dto.CuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo()-recibo.getMonto());
            Atm.cuentas.set(posicion,cuentaActual);

            //Descuenta el saldo en base de datos
            this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(),cuentaActual.getSaldo());

            //Registrar el movimiento
            this.movDAO.registrarMovimiento(new MovimientoDTO(cuentaActual.getCuentaId(),
                    "PAGO SERVICIOS",Date.valueOf(LocalDate.now()),recibo.getMonto()));

            this.serviciosDAO.actualizarStatusRecibo(referencia);
            ticket = new Ticket(this.getUbicacion(), Atm.folio++,LocalDate.now(),"PAGO SERVICIOS",
                    cuentaActual.getNumCuenta(),recibo.getMonto());
            return ticket;
        }
    }
}
