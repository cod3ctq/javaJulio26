package service.impl;

import model.*;
import exception.*;
import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import model.Ticket;
import service.OperacionesAvanzadas;
import service.Operacionesbasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;


import java.util.Scanner;

public class PractiCaja extends Atm implements Operacionesbasicas, OperacionesAvanzadas {
    @Override
    public Object[] cobrarRetirosSinTarjeta() throws BusinessException {
        Object [] data = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la referencia");
        String ref = sc.nextLine();
        System.out.println("Ingresa la clave");
        String clave = sc.nextLine();
        if (!Atm.cacheRST.containsKey(ref)) {
            //System.out.println("Referencia  invalida");
            throw new BusinessException(Mensajes.INVALID_REFERENCE);
        } else if (!Atm.cacheRST.get(ref).getClave().equals(clave)) {
            //System.out.println("Clave invalida");
            throw new BusinessException(Mensajes.INVALID_KEY);
        } else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            //System.out.println("Referencia ya cobrada");
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        }
        else {
            //String numCuentaRST = cacheRST.get(ref).getNumCuenta();
            for (int i = 0; i < Atm.cuentas.size(); i++) {
                if(Atm.cuentas.get(i).getNumCuenta().equals(Atm.cacheRST.get(ref).getNumCuenta())) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());
                    //Al terminar de cobrarlo, pasalo al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    // Eliminacion directa, simple y funcional
                    // cacheRST.remove(ref);
                    break;
                }
            }
            System.out.println("Imprimir ticket ?" + "\n" + "0. No 1. Si");
            int imp = sc.nextInt();
            if (imp == 0) {
                data[0] = null;
            }
        }
        return data;
    }

    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto) throws
            InvalidAmountException,
            DailyWithdrawalLimitExceededException,
            DailyAmountLimitReachedException,
            InsufficientBalanceException,
            MinimumBalanceReachedException
    {
        Ticket ticket =  null;
        Object[] data = new Object[2];
        boolean existePrevio = Atm.getCacheRetiros().containsKey(cuenta.getNumCuenta() + LocalDate.now());
        double totalRetirado = 0;
        if(existePrevio){
            for (Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now())) {
                totalRetirado += t.getMonto();
            }
        }
        if (monto % 100 != 0) {
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).size() == Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) {
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_LIMIT_AMOUNT);
        } else if (totalRetirado + monto > Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
        } else if(cuenta.getSaldo() < monto) {
            throw new InsufficientBalanceException(Mensajes.INSUFFICENT_BALANCE);
        }else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
        } else {
            if (cuenta.getSaldo() < monto) {
                System.out.println("Saldo insuficiente");
            } else if (cuenta.getSaldo() - monto < cuenta.getSaldoMin()) {
                System.out.println("Retiro no disponible, minimo de la cuenta alcanzado");
            } else {
                int indexAnterior = Atm.cuentas.indexOf(cuenta);
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                Atm.cuentas.set(indexAnterior, cuenta);
                this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
                MovimientoDTO mov = new MovimientoDTO
                        (
                                cuenta.getCuentaId(),
                                "RETIRO",
                                Date.valueOf(LocalDate.now()),
                                monto
                        );
                this.movDAO.registrarMovimiento(mov);
                ticket = new Ticket
                        (
                                this.getUbicacion(),
                                Atm.folio++,
                                LocalDate.now(),
                                "RETIRO",
                                "******" + cuenta.getNumCuenta().substring(6, 9),
                                monto
                        );
                if(existePrevio) {
                    Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);
                } else {
                    Atm.getCacheRetiros().put(cuenta.getNumCuenta() + LocalDate.now(), new ArrayList<Ticket>());
                    Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);
                }
                data[0] = ticket;
                data[1] = monto;
            }
        }
        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia) {
        return null;
    }

    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto) throws BusinessException {
        Ticket ticket = null;
        if(monto % 50 != 0 && monto % 20 != 0) {
            //System.out.println("La cantidad debe ser multiplo de 20 o 50");
            throw new BusinessException(Mensajes.INVALID_QUANTITY);
        } else if (monto>cuenta.getSaldoMax()) {
            //System.out.println("Deposito no permitido. Monto excede el maximo de la cuenta");
            throw new BusinessException(Mensajes.MAXIMUM_BALANCE_EXCEEDED);
        } else if (cuenta.getSaldo() + monto > cuenta.getSaldoMax()) {
            //System.out.println("No permitido. Tope");
            throw new BusinessException(Mensajes.MAXIMUM_BALANCE_EXCEEDED);
        } else {
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            Atm.cuentas.set(indexAnterior, cuenta);
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            MovimientoDTO mov = new MovimientoDTO
                    (
                            cuenta.getCuentaId(),
                            "DEPOSITO",
                            Date.valueOf(LocalDate.now()),
                            monto
                    );
            this.movDAO.registrarMovimiento(mov);
            ticket = new Ticket
                    (
                            this.getUbicacion(),
                            Atm.folio++,
                            LocalDate.now(),
                            "DEPOSITO",
                            "******" + cuenta.getNumCuenta().substring(6,9),
                            monto
                    );
        }
        return ticket;
    }
}
