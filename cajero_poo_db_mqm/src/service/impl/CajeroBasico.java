package service.impl;

import constants.Constants;
import constants.Mensajes;
import dto.CuentaDTO;
import dto.MoivmientoDTO;
import dto.ServicioDTO;
import exception.*;
import models.*;
import service.OperacionesBasicas;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CajeroBasico extends Atm implements OperacionesBasicas {

    @Override
    public Object[] cobrarRetiroSinTarjeta() throws BussinessException{
        Object[] data = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la referencia: ");
        String ref = scan.nextLine();
        System.out.println("Ingreda la clave: ");
        String clave = scan.nextLine();

        //validar si existe la llave (referencia)
        if (! Atm.cacheRST.containsKey(ref)){
            //System.out.println("Referencia invalida");
            throw new BussinessException(Mensajes.INVALID_REFERENCE);
        }else if (! Atm.cacheRST.get(ref).getClave().equals(clave)){//valida si existe la clave
            //System.out.println("Clave invalida");
            throw new BussinessException(Mensajes.INVALID_CLUE);
        }else if (Atm.cacheRetirosCobrados.contains(Atm.cacheRST.get(ref))) { //corroborar que no se realizara otro retiro con la misma referencia
            //System.out.println("Referencia, cobrada");
            throw new BussinessException(Mensajes.COLLECTED_REFERENCE);
        }else {
            String numCuentaRST = Atm.cacheRST.get(ref).getNumCuenta();
            double montoADescontar = Atm.cacheRST.get(ref).getMonto();
            //procesar el cobro
            //retirar((dto.CuentaDTO) getCuentas(cuentas).equals(numCuentaRST),cacheRST.get(ref).getMonto());//mio
            for (int i = 0; i< Atm.cuentas.size(); i++){
                if (Atm.cuentas.get(i).getNumCuenta().equals(numCuentaRST)){
                    data = retirar(buscarCuenta(Atm.cuentas.get(i).getNumTarjeta()),
                            montoADescontar);
                    //elimincacion directa simple y funcional
                    //cacheRST.remove(ref);
                    //al terminar de cobrar, pasa al conjunto de los ya cobrados
                    Atm.cacheRetirosCobrados.add(Atm.cacheRST.get(ref));
                    break;
                }
            }
            System.out.println("Imprimir models.Ticket ?\n 1=Si, 0=No");
            int imp = scan.nextInt();
            if (imp==0){
                data[0] = null;
            }
        }
        return data;
    }

    @Override
    //enfoque 1 una excepcion por cada validacion
    public Object[] retirar(CuentaDTO cuenta, double monto)
            throws InvalidAmountException,//propagar las excepciones
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

        if (monto%100!=0){ //si no es multiplo de 100
            //System.out.println("Monto invalido, debe ser multiplo de 100");
            throw new InvalidAmountException(Mensajes.INVALID_AMOUNT);
        } else if (existePrevio && Atm.getCacheRetiros().get(cuenta.getNumCuenta()+
                LocalDate.now()).size()==
                Constants.DAILY_MAX_QUANTITY_WITHDRAWAL_LIMIT) { //validar cantidad de retiros por dia
            //System.out.println("Limite de retiros diarios alcanzado");
            throw new DailyWithdrawalLimitExceededException(Mensajes.DAILY_WITHDRAWAL_AMOUNT);
        } else if ((totalRetirado + monto) >
                Constants.DAILY_MAX_AMOUNT_WITHDRAWAL_LIMIT) { //valida el monto maximo
            //System.out.println("Monto de retiro diario alcanzado");
            throw new DailyAmountLimitReachedException(Mensajes.DAILY_AMOUNT_LIMIT);
        }else if (cuenta.getSaldo()<monto){ //que me alcance <dto.CuentaDTO>
            //System.out.println("Saldo insuficiente");
            throw new InsufficientBalanceException(Mensajes.INSUFFICIENT_BALANCE);
        } else if (cuenta.getSaldo()-monto<cuenta.getSaldoMin()) {
            //System.out.println("Retiro no disponible, minimo de la cuenta alcnazado");
            throw new MinimumBalanceReachedException(Mensajes.MINIMUN_BALANCE);
        }else {
            //obtener el indice de la cuenta original dentro del cache (la lista)
            int indexAnterior = Atm.cuentas.indexOf(cuenta);
            //afectando el saldo del objeto temporal
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            //actualizar el cache de la lista reemplazando el objeto con los datos actualizados
            Atm.cuentas.set(indexAnterior,cuenta);
            //actualiza el saldo de la cuenta en la BASE DE DATOS
            this.cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //registrar el movimiento
            MoivmientoDTO mov = new MoivmientoDTO(cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto);
            this.movDAO.registrarMovimiento(mov);

            //genera el ticket
            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "RETIRO",
                    "******"+cuenta.getNumCuenta().substring(6,10),
                    monto);

            //controlar el registro del retiro en el cache de retiros
            if (existePrevio){ //si ya existe la llave, se accede directo a la lista
                // para añadir un valor
                Atm.getCacheRetiros().get(cuenta.getNumCuenta()+
                        LocalDate.now()).add(ticket);
            }else{  //si no existe (es el primer retiro), se crea
                // el primer registro en el mapa
                Atm.getCacheRetiros().put(cuenta.getNumCuenta()+
                        LocalDate.now(), new ArrayList<Ticket>());
            }

            //construye el array de datos de salida
            data[0] = ticket;
            data [1] = monto;
        }

        //que al retirar no quede por debajo del minimo

        return data;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia) {

        Ticket ticket = null;
        ServicioDTO servicio = buscarServicio(convenio,referencia);

        if (servicio==null){
            throw new BussinessException(Mensajes.REFERENCE_NOT_FOUND);
        } else if (servicio.getStatus().equals("0")) {
            throw new BussinessException(Mensajes.ALREADY_PAYED);
        }else if ((cuentaDTO.getSaldo()-servicio.getMonto())<cuentaDTO.getSaldoMin()) {
            throw new BussinessException(Mensajes.MINIMUN_BALANCE);
        }else{
            //nivel de objeto (en la memoria)

            int indexAnterior = Atm.cachePagoServicios.get(convenio).indexOf(servicio);
            servicio.setStatus("0");
            Atm.cachePagoServicios.get(convenio).set(indexAnterior,servicio);

            //actualizar el saldo de la cuenta cargada en el cache cuentaDTO
            CuentaDTO cuentaActual = buscarCuenta(cuentaDTO.getNumTarjeta());
            int posicion = Atm.cuentas.indexOf(cuentaActual);
            cuentaActual.setSaldo(cuentaActual.getSaldo()- servicio.getMonto());
            Atm.cuentas.set(posicion,cuentaActual);

            //descuenta del saldo en base de datos
            this.cuentaDAO.actualizarSaldo(cuentaActual.getNumCuenta(),
                    cuentaActual.getSaldo());

            //registrar el movimiento
            this.movDAO.registrarMovimiento(new MoivmientoDTO(
                    cuentaActual.getCuentaId(),
                    "PAGO SERVICIOS",Date.valueOf(LocalDate.now()),
                    servicio.getMonto()));
            this.pagoDAO.actualizarMonto(referencia);

            ticket = new Ticket(this.getUbicacion(),
                    Atm.folio++,
                    LocalDate.now(),
                    "PAGO SERVICIOS",
                    "******"+cuentaActual.getNumCuenta().substring(6,10),
                    servicio.getMonto());
            return ticket;
        }
    }
}
