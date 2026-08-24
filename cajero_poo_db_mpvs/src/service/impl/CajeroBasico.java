package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.ReciboDTO;
import exception.*;
import models.*;
import service.OperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements OperacionesBasicas {

//falta un override


    @Override
    public Object[] retirar (CuentaDTO cuenta, double monto) throws InvalidAmountException,
            DailyWithdrawalLimitExceededException, DailyAmountLimitReachedException, InsufficientBalanceException,
            MinimumBalanceReachedException{

        Ticket ticket = null;
        Object[] data = new Object[2];

        boolean existePrevio = false;
        existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta()+LocalDate.now());
        double totalRetirado=0.0;
        if (existePrevio){
            for (Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now())){
                totalRetirado= totalRetirado + t.getMonto();
            }
        }
        //validar que el monto sea multiplo de 100
        //VALIDAR EL MONTO MINIMO
        if (monto%100!=0){//si no es multiplo de 100
            System.out.println("Monto invalido, dese ser multiplo de 100");
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if(existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta()+ LocalDate.now()).size()==Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) {//validar cantidad de retiros al dia
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
               // System.out.println("Limites de retiros diarios alcanzado");
        } else if ((totalRetirado + monto) > Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
            throw  new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
            //System.out.println("MONTO DE RETIRO DIARIO ALCANZADO");
        } else if (cuenta.getSaldo() < monto) {//QUE ME ALCANCE
            throw  new InsufficientBalanceException(Mensajes.INSUFFICENT_BALANCE);
            //System.out.println("saldo insuficiente");
        } else if (cuenta.getSaldo() - monto < cuenta.getSaldoMin()) {
            throw  new MinimumBalanceReachedException(Mensajes.MINIMUN_BALANCE);
            //System.out.println("RETIRO NO DISPONIBLE, MINIMO DE LA CUENTA ALCANZADO");
        } else {
            //obtengo el indice de la cuenta original dentro del cache (list)
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            //afectando el saldo del objeto temporal
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el cache de la lista, reemplazando el objeto con los datos actualizados
            Atm.cuentas.set(indexAnterior, cuenta);
            //actualiza el saldo de la cuenta en la base de datos
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());
            //registrar el movimiento
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(),"RETIRO", Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);
        }//duda con esta llave

        ticket = new Ticket(this.getUbicacion(), Atm.folio++, LocalDate.now(), "RETIRO", "******" +
                cuenta.getNumCuenta().substring(6, 9), monto);
        //CONTROLAR EL REGISTRO DEL RETIRO EN EL CACHE DE RETIROS
        if (existePrevio){
            Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
        }else {
            Atm.getCacheRetiros().put(cuenta.getNumCuenta()+ LocalDate.now(), new ArrayList<Ticket>());
            Atm.getCacheRetiros().get(cuenta.getNumCuenta()+ LocalDate.now()).add(ticket);

        }

        //CONSTRUYE EL ARRAY DE DATOS DE SALIDA---para que nos de dos datos, porque el cajero dara un tocket y dinero,
        // osea dos elemntos, cuando solo se dara uno, no es necesario hacer lo de data
        data[0]= ticket;
        data[1]= monto;

        // Y QUE AL RETIRAR NO QUEDE POR DEBAJO DEL MINIMO
        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {
        Ticket ticket = null;
        ReciboDTO recibo = buscarRecibo(convenio, referencia);

        if(recibo==null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }else if(recibo.getStatus()=='0') {
            throw new BusinessException(Mensajes.AlREADY_PAYED);
        }else if(( cuentaDTO.getSaldo() - recibo.getMonto() ) < cuentaDTO.getSaldoMin()) {
            throw new BusinessException(Mensajes.MINIMUN_BALANCE);
        }else{
            //Nivel de objeto (memoria)
            int indexAnterior = Atm.cacheServicios.get(convenio).indexOf(recibo);
            recibo.setStatus('0');
            Atm.cacheServicios.get(convenio).set(indexAnterior,recibo);

            //actualizar el saldo de la cuenta cargda en el cache dto.CuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo()-recibo.getMonto());
            Atm.cuentas.set(posicion,cuentaActual);

            //descuenta el saldo en base de datos
            this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(), cuentaActual.getSaldo());
            //registra el movimiento
            this.movDAO.registrarMovimiento( new MovimientoDTO(cuentaActual.getCuentaId(),
                    "PAGO SERVICIOS",Date.valueOf(LocalDate.now()),recibo.getMonto()));

            this.servicioDAO.actualizarStatusRecibido(referencia);
            ticket = new Ticket(this.getUbicacion(), Atm.folio++,LocalDate.now(),
                    "PAGO SERVICIOS",cuentaActual.getNumCuenta(),recibo.getMonto());
            return ticket;
        }
    }
 //******************* EJERCICIO EN CAJERO Y PRACTICAJA
//    @Override
//    public models.Ticket pagarServicio(dto.CuentaDTO cuentaDTO, String convenio, String referencia){
//        models.Ticket ticket = null;
//        ServicioDTO recibo = buscarRecibo(convenio,referencia);
//
//        if (recibo == null){
//            throw new exception.BusinessException(constants.Mensajes.REFERENCE_NOT_FOUNF);
//        }else if(recibo.getStatus()=='0') {
//            throw new exception.BusinessException(constants.Mensajes.AlREADY_PAYED);
//        }else if ((cuentaDTO.getSaldo()- recibo.getMonto() ) < cuentaDTO.getSaldoMin()){
//            throw new exception.BusinessException(constants.Mensajes.MINIMUN_BALANCE);
//        }else{
//                //nivel de objeto (memoria)
//                int indexAnterior = cacheServicios.get(convenio).indexOf(recibo);
//                recibo.setStatus('0');
//                cacheServicios.get(convenio).set(indexAnterior,recibo);
//
//                //actualizar el saldo de la cuenta cargada en el cache dto.CuentaDTO
//                dto.CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
//                int posicion = cuentas.indexOf(cuentaActual);
//                cuentaActual.setSaldo(cuentaActual.getSaldo()-recibo.getMonto());
//                cuentas.set(posicion,cuentaActual);
//
//                //descuenta el saldo en base de datos
//                this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(), cuentaActual.getSaldo());
//                //registrar el movimiento
//                this.movDAO.registrarMovimiento( new dto.MovimientoDTO(cuentaActual.getCuentaId(),"PAGO SERVICIOS", Date.valueOf(LocalDate.now()),
//                        recibo.getMonto()));
//
//                this.servicioDAO.actualizarStatusRecibido(referencia);
//                ticket= new models.Ticket(this.getUbicacion(), folio++, LocalDate.now(),
//                        "PAGO SERVICIOS", cuentaActual.getNumCuenta(),recibo.getMonto());
//                return ticket;
//            }
//        }
//    }

//        Object data [] = null; //inicializo el ticket
//        Scanner scan = new Scanner(System.in);
//        System.out.println("INGRESA EL CONVENIO:");
//        String conv = scan.nextLine();
//        System.out.println("INGRESA LA REFERENCIA:");
//        String ref = scan.nextLine();
////necesito la lista dde los convenios y referencias, con un mapa
//        return data;
//
//    }
//**************************************************
    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object data [] = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("INGRESA LA REFERENCIA:");
        String ref = scan.nextLine();
        System.out.println("INGRESA LA CLAVE:");
        String clave = scan.nextLine();

        //existe la llave (ref) ?
        if (!Atm.cacheRST.containsKey(ref)){
            throw new BusinessException(Mensajes.INVALID_REFERENCE);
        }else if (! Atm.cacheRST.get(ref).getClave().equals(clave)) {
            throw new BusinessException(Mensajes.INVALID_KEY);
        }else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        } else{
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
            //actualizar el cache de cuentas (cuentas) procesar el cobro
            for (int i = 0; i< Atm.cuentas.size(); i++){
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)){
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());
                    //eliminacion directa,simple y funcional
                    //cacheRST.remove(ref);
                    //al terminar de cobrarlo, pasalo al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
            }
            System.out.println("IMPRIMIR EL TICKET ?\n 1= Si 0= No");
            int imp = scan.nextInt();
            if (imp==0){
                data[0]= null;
            }
        }
        return data;
    }
}
