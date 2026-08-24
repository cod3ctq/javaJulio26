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
        Object data[] = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia");
        String ref = scan.nextLine();
        System.out.println("Ingresa la clave");
        String clave = scan.nextLine();

        //existe la llave(ref)

        if (!Atm.cacheRST.containsKey(ref)) {
            throw new BusinessException(Mensajes.INVALID_REFRENCE);
        } else if (!Atm.cacheRST.get(ref).getClave().equals(clave)) {
            throw new BusinessException(Mensajes.INVALID_KEY);
        } else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) {
            throw new BusinessException(Mensajes.ALREADY_COLLECTED);
        } else {
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();

            //Procesar el cobro

            for (int i = 0; i < Atm.cuentas.size(); i++) {
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)) {
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()), Atm.cacheRST.get(ref).getMonto());

                    //Eliminacion directa, simple y funcional
                    //cacheRST.remove(ref);
                    //Al termina de cobrarlo, pasalo al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;

                }

            }
            System.out.println("imprimir models.Ticket ?\n 1=Si 0=No");
            int imp = scan.nextInt();
            if (imp == 0) {
                data[0] = null;
            }
        }

        return data;

    }

    @Override
    //PROPAGAR LA EXCEPTION
    public Object[] retirar(CuentaDTO cuenta, double monto)
            throws InvalidAmountException, DailyWithdrawalLimitExceededException,
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
        Ticket ticket = null;
        ReciboDTO recibo = buscarRecibo(convenio, referncia);

        if(recibo==null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }else if(recibo.getStatus()=='0') {
            throw new BusinessException(Mensajes.ALREADY_PAYED);
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

            this.serviciosDAO.actualizarStatusRecibo(referncia);
            ticket = new Ticket(this.getUbicacion(), Atm.folio++,LocalDate.now(),
                    "PAGO SERVICIOS",cuentaActual.getNumCuenta(),recibo.getMonto());
            return ticket;
        }


        }

    }







