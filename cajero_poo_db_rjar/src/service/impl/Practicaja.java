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
    public Object[] cobrarRetiroSinTarjeta() throws BusinessException {
        Object data[] = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia");
        String ref = scan.nextLine();
        System.out.println("Ingresa el monto");
        double monto = scan.nextDouble();

        //existe la llave(ref)

        if (!Atm.cacheRST.containsKey(ref)) {
            throw new BusinessException(Mensajes.INVALID_REFRENCE);
        } else if (Atm.cacheRST.get(ref).getMonto()!=monto) {
            throw new BusinessException(Mensajes.INCORRECT_AMOUNT);
        } else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        } else {
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
            //Procesar el cobro
            for (int i = 0; i < Atm.cuentas.size(); i++) {
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());

                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;

                }

            }

        }

        return data;
    }


    @Override
    public Object[] retirar(CuentaDTO cuenta, double monto) throws InvalidAmountException, DailyWithdrawalLimitExceededException,
            DailyAmountLimitReachedException, InsufficientBalanceException,
            MinimumBalanceReachedException {
        Ticket ticket = null;
        Object[] data = new Object[2];

        boolean existePrevio = false;
        existePrevio = Atm.getCacheRetros().containsKey(cuenta.getNumCuenta() + LocalDate.now());
        double totalRetirado = 0.0;
        if (existePrevio) {
            for (Ticket t : Atm.getCacheRetros().get(cuenta.getNumCuenta() + LocalDate.now())) {
                totalRetirado = totalRetirado + t.getMonto();
            }
        }

        //Validarque EL MONTO sea multiplo de 100
        if (monto % 100 != 0) {//si no es multiplo de 100
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetros().get(cuenta.getNumCuenta() + LocalDate.now()).size() == Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) { //validar cantidad de retirospor dia
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWA_AMOUNT);
        } else if ((totalRetirado + monto) > Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
            //que me alcance <entity.Cuenta DTO>
        } else if (cuenta.getSaldo() < monto) {
            throw new InsufficientBalanceException(Mensajes.INSUFFICENT_BALANCE);
        } else if (cuenta.getSaldo() - monto < cuenta.getSaldoMin())
            throw new MinimumBalanceReachedException(Mensajes.MINIMUN_BALANCE);

        else {
            //obtengo el indice de la cuenta original dentro del cache(list)
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            //afceta el saldo del objeto tempopral

            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el cache de la lista, reemplazando el objeto con
            //los datos actualizandos
            Atm.cuentas.set(indexAnterior, cuenta);

            //actualiza el saldo de la cuenta en la base de datos
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //resgistrar el movimiento
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(), "RETIRO", Date.valueOf(LocalDate.now()), monto);
            movDAO.registrarMovimiento(mov);
            //controlar el registro del retiro en el cache de retiros
            if (existePrevio) {
                //COMO ya existe la llave, se accede directo a la lista para añadir un valor
                Atm.getCacheRetros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);

            } else {
                //si llave no existe (es su primer retiro)primero se crea el registro en el mapa
                Atm.getCacheRetros().put(cuenta.getNumCuenta() + LocalDate.now(), new ArrayList<Ticket>());
                Atm.getCacheRetros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);

            }
            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "RETIRO",
                    "******" + cuenta.getNumCuenta().substring(6, 9),
                    monto);

            //cotsuye el array de datos de salida

            data[0] = ticket;
            data[1] = monto;

        }
        //que la retirar no quede por debajo del minimo


        return data;


    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referncia) {
        return null;
    }

    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto)
            throws BusinessException { //Se coloca throwsa nivel de
        Ticket ticket = null;

        if (monto % 50 != 0 && monto % 20 != 0) {
            throw new BusinessException(Mensajes.ILLEGAL_ARGUMENT);
        } else if (monto > cuenta.getSaldoMax()) {
            throw new BusinessException(Mensajes.DEPOSIT_NOT_ALLOWED);
        } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
            throw new BusinessException(Mensajes.ILLEGAL_STATE_EXCEPTION);
        } else {
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            Atm.cuentas.set(indexAnterior, cuenta);
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            MovimientoDTO mov = new MovimientoDTO(cuenta.getCuentaId(), "DEPOSITO",
                    Date.valueOf(LocalDate.now()), monto);
            this.movDAO.registrarMovimiento(mov);
            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "DEPOSITO",
                    "******" + cuenta.getNumCuenta().substring(6, 9),
                    monto);
        }

        return ticket;
    }
}
