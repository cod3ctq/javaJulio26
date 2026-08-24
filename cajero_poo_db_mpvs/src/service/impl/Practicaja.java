package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import exception.*;
import models.Atm;
import models.Ticket;
import service.OperacionesAvanzadas;
import service.OperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Practicaja extends Atm implements OperacionesBasicas, OperacionesAvanzadas {


    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException{

            Object data [] = null;
            Scanner scan = new Scanner(System.in);
            System.out.println("INGRESA LA REFERENCIA:");
            String ref = scan.nextLine();
            System.out.println("INGRESA el monto:");
            double monto = scan.nextDouble();

            //existe la llave (ref) ?
            if (!Atm.cacheRST.containsKey(ref)){
                throw new BusinessException(Mensajes.INVALID_REFERENCE);
            }else if (Atm.cacheRST.get(ref).getMonto()!=monto) {
                throw new BusinessException(Mensajes.INCORRECT_AMOUNT);
            }else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
                throw new BusinessException(Mensajes.ALREADY_COLLECTED);
            } else{
                String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
                for (int i = 0; i< Atm.cuentas.size(); i++){
                    if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)){
                        data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());
                        Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                        break;
                    }
                }
            }
            return data;
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto) throws InvalidAmountException,
            DailyWithdrawalLimitExceededException, DailyAmountLimitReachedException, InsufficientBalanceException,
            MinimumBalanceReachedException {

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
        } else if(existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta()+ LocalDate.now()).size()== Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) {//validar cantidad de retiros al dia
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

            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(),"RETIRO", Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);
        }
        ticket = new Ticket(this.getUbicacion(), Atm.folio++, LocalDate.now(), "RETIRO", "******" +
                cuenta.getNumCuenta().substring(6, 9), monto);
        //CONTROLAR EL REGISTRO DEL RETIRO EN EL CACHE DE RETIROS
        if (existePrevio){
            Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
        }else {
            Atm.getCacheRetiros().put(cuenta.getNumCuenta()+ LocalDate.now(), new ArrayList<Ticket>());
            Atm.getCacheRetiros().get(cuenta.getNumCuenta()+ LocalDate.now()).add(ticket);

        }

        data[0]= ticket;
        data[1]= monto;

        return data;
    }
 //*****************HACER EJERCICIO
    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {

        return null;
    }

    //***************

    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto) throws BusinessException {
        Ticket ticket = null;
        if (monto%50!=0 && monto%20!=0){
            //System.out.println("la cantidad debe de ser multiplo de 20 o de 50");
            throw new BusinessException(Mensajes.INVALID_DEPOSIT_AMOUNT);
        }
        else if (monto > cuenta.getSaldoMax()){
            //System.out.println("DEPOSITO NO PERMITIDO. MONTO MAYOR AL MAXIMO DE LA CUENTA");
            throw new BusinessException(Mensajes.AMOUNT_EXCEEDS_ACCOUNT_MAXIMUM);
        } else if ((cuenta.getSaldo() + monto )> cuenta.getSaldoMax()) {
            //System.out.println("NO PERMITIDO. TOPE MAXIMO DE LA CUENTA ALCANZADO");
            throw new BusinessException(Mensajes.ACCOUNT_MAXIMUM_REACHED);
        } else {
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo()+ monto);
            Atm.cuentas.set(indexAnterior, cuenta);
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(),"DEPOSITO",
                    Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);
            ticket = new Ticket(this.getUbicacion(), Atm.folio++, LocalDate.now(), "DEPOSITO", "******" +
                    cuenta.getNumCuenta().substring(6, 9), monto);

        }
        return ticket;
    }
}
