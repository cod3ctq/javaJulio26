package service.impl;

import exception.*;
import models.Atm;
import models.Ticket;
import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import service.OperacionesAvanzadas;
import service.OperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PractiCaja extends Atm implements OperacionesBasicas, OperacionesAvanzadas {


    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object data[] = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia");
        String ref = scan.nextLine();
        System.out.println("Ingresa el monto");
        Double monto = scan.nextDouble();

        if(!Atm.cacheRST.containsKey(ref)){
            throw new BusinessException(Mensajes.INVALID_REFERENCE);

        }else if (Atm.cacheRST.get(ref).getMonto() != monto){
            throw new BusinessException(Mensajes.INCORRECT_AMOUNT);

        }else if(Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))){
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);

        }else{
            for(int i = 0; i< Atm.cuentas.size(); i++){
                if(Atm.cuentas.get(i).getNumCuenta().equals(Atm.cacheRST.get(ref).getNumCuenta())) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
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

        if(monto%100!=0){
            throw new InvalidAmountExcepton(Mensajes.INVALID_WITHDRAWAL_AMOUNT);
        }else if(existePrevio
                && Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).size()== Constants.DAILY_MAX_WITHDRAWAL_LIMIT){
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
        }else if(totalRetirado + monto > Constants.DAILY_MAX_AMOUNT_LIMIT) {
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);

        }else if (cuenta.getSaldo()<monto){
            throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);

        }else if (cuenta.getSaldo()-monto < cuenta.getSaldoMin()){
            throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
        }else{

            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            Atm.cuentas.set(indexAnterior, cuenta);

            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

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
            data[0] = ticket;
            data[1] = monto;

            if (existePrevio){
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
            }else {
                Atm.getCacheRetiros().put(cuenta.getNumCuenta()+LocalDate.now(), new ArrayList<Ticket>());
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+LocalDate.now()).add(ticket);
            }

        }

        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {
        return null;
    }


    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto) throws BusinessException {
        Ticket ticket = null;

        if(monto%50 != 0 && monto%20 != 0){
            throw new BusinessException(Mensajes.INVALID_DEPOSIT_AMOUNT);

        }else if (monto>cuenta.getSaldoMax()){
            throw new BusinessException(Mensajes.AMOUNT_ABOVE_MAX_BALANCE);

        }else if (monto+cuenta.getSaldo()>cuenta.getSaldoMax()){
            throw new BusinessException(Mensajes.MAX_BALANCE_REACHED);

        }else{
            int indexAnterior = Atm.cuentas.indexOf(cuenta);

            cuenta.setSaldo(cuenta.getSaldo()+monto);

            Atm.cuentas.set(indexAnterior, cuenta);

            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(), "DEPOSITO", Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);

            ticket = new Ticket(
                    this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "DEPOSITO",
                    "*****"+cuenta.getNumCuenta().substring(6,10),
                    monto
            );
        }
        return ticket;
    }
}
