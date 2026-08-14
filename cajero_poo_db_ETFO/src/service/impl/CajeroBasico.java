package service.impl;

import model.*;
import constants.Constants;
import constants.Mensajes;
import exception.*;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.ReciboDTO;
import model.Ticket;
import service.Operacionesbasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements Operacionesbasicas {

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
        //Validar monto sea multiplo de 100
        if(existePrevio){
            for (Ticket t : Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now())) {
                totalRetirado += t.getMonto();
            }
        }
        if (monto % 100 != 0) { //Si no es multiplo de 100
            //System.out.println("Monto invalido");
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).size() == Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) { //Validar cantidad de retiros por dia
            //System.out.println("limite de retiros diarios alcanzados");
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_LIMIT_AMOUNT);
        } else if (totalRetirado + monto > Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) {
            //System.out.println("Monto de retiro alcanzado");
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
        } else if(cuenta.getSaldo() < monto) {//Que me alcance <dto.CuentaDTO>
            //System.out.println("Saldo insuficiente.");
            throw new InsufficientBalanceException(Mensajes.INSUFFICENT_BALANCE);
        }else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {//Que al retirar, no quede por debajo del mínimo    System.out.p
            //System.out.println("Retiro no disponible, mínimo de la cuenta alcanzado");
            throw new MinimumBalanceReachedException(Mensajes.MINIMUM_BALANCE);
        } else {
            // Que me alcance
            if (cuenta.getSaldo() < monto) {
                System.out.println("Saldo insuficiente");
            } else if (cuenta.getSaldo() - monto < cuenta.getSaldoMin()) {
                System.out.println("Retiro no disponible, minimo de la cuenta alcanzado");
            } else {
                //Obtengo el indice de la cuenta original dentro del cache(list)
                int indexAnterior = Atm.cuentas.indexOf(cuenta);
                //Estoy afectando el saldo del objeto temporal
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                //Actualizar el cache de la lista, reemplazando el objeto con los datos actulizados
                Atm.cuentas.set(indexAnterior, cuenta);
                //Actualiza el saldo de la cuenta en la base de datos
                this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
                //Registrar el movimiento
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
                    // Si la llave no existe(es su primer retiro), primero se crea el registro en el mapa
                    Atm.getCacheRetiros().put(cuenta.getNumCuenta() + LocalDate.now(), new ArrayList<Ticket>());
                    Atm.getCacheRetiros().get(cuenta.getNumCuenta() + LocalDate.now()).add(ticket);
                }
                // Construye el array de datos de salida
                data[0] = ticket;
                data[1] = monto;
            }
        }
        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia) {
        Ticket ticket = null;
        ReciboDTO recibo = buscarRecibo(convenio, referencia);
        if (recibo == null) {
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        } else if (recibo.getStatus()=='0') {
            throw new BusinessException(Mensajes.ALREADY_PAYED);
        } else if ((cuenta.getSaldo() - recibo.getMonto()) < cuenta.getSaldoMin()) {
            throw new BusinessException(Mensajes.INSUFFICENT_BALANCE);
        }
        else {
            // Nivel Objeto
            // status 0 pagado, 1 No pagado
            int indexAnterior = Atm.cacheRecibos.get(convenio).indexOf(recibo);
            recibo.setStatus('0');
            Atm.getCacheRecibos().get(convenio).set(indexAnterior, recibo);
            //actualizar el saldo de la cuenat cargada en el cahe en cuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuenta.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo() - recibo.getMonto());
            Atm.cuentas.set(posicion, cuentaActual);
            cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(), cuentaActual.getSaldo());

            movDAO.registrarMovimiento(new MovimientoDTO
                    (
                            cuentaActual.getCuentaId(),
                            "PAGO SERVICIOS",
                            Date.valueOf(LocalDate.now()),
                            recibo.getMonto()

                    ));
            this.reciboDAO.actualizarStatusRecibo(referencia);
            ticket = new Ticket
                    (
                            this.getUbicacion(),
                            Atm.folio++,
                            LocalDate.now(),
                            "PAGO SERVICIOS",
                            cuentaActual.getNumCuenta(),
                            recibo.getMonto()
                    );
            return ticket;
        }

    }
}
