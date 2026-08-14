package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServiciosDAO;
import dto.CuentaDTO;
import dto.ReciboDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

public abstract class Atm {

    public static int folio = 0;
    private String ubicacion;
    private double efectivo;

    //Atributo con composicion
    public static List<CuentaDTO> cuentas;
    public static Map<String,RetiroSinTarjeta> cacheRST = new HashMap<String,RetiroSinTarjeta>();


    //Guarda el numero de retiros y monto total de los mismos por cuenta + fecha
    public static Map<String,List<Ticket>> cacheRetiros = new HashMap<String,List<Ticket>>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<RetiroSinTarjeta>();
    public static Map<String,List<ReciboDTO>> cacheServicios = new HashMap<String,List<ReciboDTO>>();


    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ServiciosDAO serviciosDAO = new ServiciosDAO();


    public Atm() {
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetiroSinTarjeta();
        cacheServicios = serviciosDAO.cargarCacheServicios();
    }

    public static Map<String, List<ReciboDTO>> getCacheServicios() {
        return cacheServicios;
    }

    public static void setCacheServicios(Map<String, List<ReciboDTO>> cacheServicios) {
        Atm.cacheServicios = cacheServicios;
    }

    public static Map<String, List<Ticket>> getCacheRetiros() {
        return cacheRetiros;
    }

    public static void setCacheRetiros(Map<String, List<Ticket>> cacheRetiros) {
        Atm.cacheRetiros = cacheRetiros;
    }

    public static Map<String, RetiroSinTarjeta> getCacheRST() {
        return cacheRST;
    }

    public static void setCacheRST(Map<String, RetiroSinTarjeta> cacheRST) {
        Atm.cacheRST = cacheRST;
    }

    public static Set<RetiroSinTarjeta> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<RetiroSinTarjeta> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    public Atm(String ubicacion, double efectivo) {
        this.ubicacion = ubicacion;
        this.efectivo = efectivo;
    }

    public static void generarRetirosSinTarjeta() {
    }

    public static void imprimirRetirosSinTarjeta() {
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<CuentaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    public static int getFolio() {
        return folio;
    }

    public static void setFolio(int folio) {
        Atm.folio = folio;
    }


    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }


    @Override
    public String toString() {
        return "models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", efectivo=" + efectivo +
                '}';
    }


    //Imprime en consola la informacion de las cuentas
//    //que en este punto, ya deberian estar cargadas
    public static void imprimirCuentas() {
        //Por cada cuenta(elemento) dentro de cuentas (lista)
        for (dto.CuentaDTO cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    //Buscar cuenta
    public static CuentaDTO buscarCuenta(String numTarjeta) throws AccountNotFoundException {
        CuentaDTO cuenta = null;
        for (CuentaDTO c : cuentas) {
            if (c.getNumTarjeta().equals(numTarjeta)) {
                cuenta = c;
                break;
            }
        }
        //Si existe la cuenta...
        if (cuenta != null) {
            return cuenta;
        } else {
            //lanzar una excepcion
            throw new AccountNotFoundException("No existe una cuenta con este numero de tarjeta");
        }
    }

    public void consultarSaldo(String numTarjeta) {

        try {
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("Saldo disponible: " + cuenta.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


//    public void imprimirCacheRetiros(){
//        for (String key: cacheRetiros.keySet()){
//            for (models.Ticket t : cacheRetiros.get(key)){
//                System.out.println(t);
//            }
//        }
//    }

    public static Map<String,RetiroSinTarjeta> generarRetiroSinTarjeta(){

        RetiroSinTarjeta rst = null;

        //Itera deontro de la lista de cuentas, para obtener el numero de cuenta.
        for(CuentaDTO cuenta:cuentas){
            //Crea el retiro sin tarjeta, en base al numero de cuenta de cada cuenta.
            rst = new RetiroSinTarjeta(cuenta.getNumCuenta(),
                    CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),
                    Double.parseDouble(CuentaHelper.generarMonto()));
            //Añade el objeto rst al mapa, asociado a su llave unica.
            cacheRST.put(rst.getReferencia(), rst);
        }
        return cacheRST;
    }

    public static void imprimirRetiroSinTarjeta(){
        for(String key:cacheRST.keySet()){
            System.out.println(cacheRST.get(key));
        }
    }

    public static void imprimirCacheServicios(){
        for(String key:cacheServicios.keySet()){
            System.out.println("SERVICIOS :"+key);
            for (dto.ReciboDTO dto : cacheServicios.get(key)){
                System.out.println("----- "+dto);
            }
        }
    }

    public ReciboDTO buscarRecibo (String convenio, String referencia)
            throws BusinessException {
        ReciboDTO dto = null;

        if ( ! cacheServicios.containsKey(convenio) ){
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        }else {

            for(ReciboDTO item : cacheServicios.get(convenio))
            {

                if(item.getReferencia().equals(referencia)){
                    dto = item;
                    break;
                }
            }
        }
        if (dto == null) {
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        }
            return  dto;
    }

    //Este metodo lo va a convertir en una clase abstracta
    public abstract Object[] cobrarRetiroSinTarjeta();
}
