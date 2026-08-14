package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MoivmientoDTO;
import exception.*;
import service.OperacionesBasicas;
import service.OpercionesAvanzadas;
import models.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Practicaja extends Atm implements OperacionesBasicas, OpercionesAvanzadas {

    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BussinessException{

        Object[] data = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia: ");
        String ref = scan.nextLine();
        System.out.println("Ingresa el monto: ");
        double monto = scan.nextDouble();

        if (! Atm.cacheRST.containsKey(ref)){
            throw new BussinessException(Mensajes.INVALID_REFERENCE);
        }else if (Atm.cacheRST.get(ref).getMonto()!= monto){//monto incorrecto
            throw new BussinessException(Mensajes.INCORRECT_AMOUNT);
        }else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BussinessException(Mensajes.COLLECTED_REFERENCE);
        }else {
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
            double montoADescontar = Atm.cacheRST.get(ref).getMonto();
            for (int i = 0; i< Atm.cuentas.size(); i++){
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)){
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()),
                            montoADescontar);
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
            }
        }
        return data;
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto) throws InvalidAmountException,//propagar las excepciones
            DailyWithdrawalLimitExceededException,
            DailyAmountLimitReachedException,
            InsufficientBalanceException,
            MinimumBalanceReachedException{

        Ticket ticket = null;
        Object [] data = new Object[2];

        boolean existePrevio = false;
        existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta()+
                LocalDate.now());
        double totalRetirado = 0.0;
        if (existePrevio){
            for (Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta()+
                    LocalDate.now())){
                totalRetirado = totalRetirado + t.getMonto();
            }
        }

        if (monto%100!=0){
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta()+
                LocalDate.now()).size()==
                Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) {
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
        } else if ((totalRetirado + monto) >
                Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
        }else if (cuenta.getSaldo()<monto){
            throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);
        } else if (cuenta.getSaldo()-monto<cuenta.getSaldoMin()) {
            throw new MinimumBalanceReachedException(Mensajes.MINIMUN_BALANCE);
        }else {
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            Atm.cuentas.set(indexAnterior,cuenta);
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            MoivmientoDTO mov = new MoivmientoDTO(cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto);
            this.movDAO.registrarMovimiento(mov);

            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "RETIRO",
                    "******"+cuenta.getNumCuenta().substring(6,10),
                    monto);

            if (existePrevio){
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+
                        LocalDate.now()).add(ticket);
            }else{
                Atm.getCacheRetiros().put(cuenta.getNumCuenta()+
                        LocalDate.now(), new ArrayList<Ticket>());
            }

            data[0] = ticket;
            data [1] = monto;
        }
        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {
        return null;
    }

    @Override
    //enfoque 2 una excepcion por todas las validaciones
    //usar la excepcion BUSSINESSEXCEPTION para todas las validaciones

    public Ticket depositar(CuentaDTO cuenta, double monto)
            throws BussinessException{
        Ticket ticket = null;
        //validacion de billetes
        if (monto%50!=0 && monto%20!=0){
            //System.out.println("La cantidad debe ser miltiplo de 20 o 50");
            throw new BussinessException(Mensajes.INVALID_QUANTITY_AMOUNT);
        }else if (monto> cuenta.getSaldoMax()){ //calcula si el deposito es el maximo de la cuenta
            //System.out.println("Deposito no permitido. Monto mayor al maximo de la cuenta");
            throw new BussinessException(Mensajes.AMOUNT_EXCEEDING_ACCOUNT_LIMIT);
        } else if (cuenta.getSaldo() + monto > cuenta.getSaldoMax()) {
            //System.out.println("Operacion no permitida. Tope maximo alcanzado");
            throw new BussinessException(Mensajes.INVALID_OPERATION_MAXIMUM_LIMIT_REACHED);

        }else {
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo()+monto);
            Atm.cuentas.set(indexAnterior,cuenta);
            //this es un constructor que hace explicita la accion al
            // objeto que se le hace llamar algun metodo, especificamente a el
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            MoivmientoDTO mov = new MoivmientoDTO(cuenta.getCuentaId(), "DEPOSITO",
                    Date.valueOf(LocalDate.now()),monto);
            this.movDAO.registrarMovimiento(mov);

            ticket = new Ticket(this.getUbicacion(), Atm.folio++, LocalDate.now(),
                    "DEPOSITO",
                    "******"+cuenta.getNumCuenta().substring(6,10),monto);
        }
        return ticket;
    }
}
