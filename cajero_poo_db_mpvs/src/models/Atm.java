package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServicioDAO;
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

    //ATRIBUTO CON COMPOSICION
    public static List<CuentaDTO> cuentas;
    public static Map<String,RetiroSinTarjeta> cacheRST = new HashMap<String,RetiroSinTarjeta>();
    public static Map<String, List <Ticket>> cacheRetiros = new HashMap<String,List<Ticket>>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<RetiroSinTarjeta>();
    public static Map<String,List<ReciboDTO>> cacheServicios = new HashMap<String, List<ReciboDTO>>();

    //CLASES DE JDBC
    //TEMPORALMENTE ESTARAN AQUI, DESPUES SE UBICARAN EN SU LUGAR CORRECTO

    public CuentaDAO cuentaDAO= new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ServicioDAO servicioDAO = new ServicioDAO();//***********

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

    public Atm() {
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetirosSinTarjeta();
        cacheServicios = servicioDAO.cargarCacheServicios();//*****************
    }

    public Atm(String ubicacion, double efectivo) {
        this.ubicacion = ubicacion;
        this.efectivo = efectivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public static int getFolio() {
        return folio;
    }

    public static void setFolio(int folio) {
        Atm.folio = folio;
    }

    public List<CuentaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", efectivo=" + efectivo +
                '}';
    }

    //IMPRIME EN CONSOLA LA INFORMACION DE LAS CUENTAS QUE EN ESTE PUNTO, YA DEBERIAN ESTAR CARGADAS
    public static void imprimirCuentas() {
        //por cada cuenta (elemento) dentro de cuentas (lista)
        for (dto.CuentaDTO cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    //METODO: BUSCAR CUENTA
    public static CuentaDTO buscarCuenta(String numTarjeta) throws AccountNotFoundException {
        CuentaDTO cuenta = null;

        for (CuentaDTO c : cuentas) {
            if (c.getNumTarjeta().equals(numTarjeta)) {
                cuenta = c;
                break;
            }
        }
        //si existe la cuenta...
        if (cuenta != null) {
            return cuenta;
        } else {
            //lanzar una excepcion
            throw new AccountNotFoundException("NO EXISTE UNA CUENTA CON ESTE NUMERO DE TARJETA");
        }
    }

    public void consultarSaldo (String numTarjeta){
        try {
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("saldo disponible " + cuenta.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
//    public void imprimirCacheRetiros(){
//        for (String key:cacheRetiros.keySet()){
//            for (models.Ticket t: cacheRetiros.get(key)){
//                System.out.println(t);
//            }
//        }
//    }

    //NUEVO METODO
    public static Map<String, RetiroSinTarjeta> generarRetirosSinTarjeta(){
        RetiroSinTarjeta rst = null;

        //itera dentro de la lista de cuentas para obtener el numero de cuenta
        for (CuentaDTO cuenta : cuentas){
            //crear el retiro sin tarjeta, en base al numero de cuenta de cada cuenta
            rst = new RetiroSinTarjeta(cuenta.getNumCuenta(),
                    CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),
                    Double.parseDouble(CuentaHelper.generarMonto()));
            //añade el objeto rst al mapa, asociado a su llave unica
            cacheRST.put(rst.getReferencia(),rst);
        }
        return cacheRST;
    }
    //temporal solo para ver datos en consola
    public static void imprimirRetirosSinTarjeta (){
        for (String key : cacheRST.keySet()){
            System.out.println(cacheRST.get(key));
        }
    }
    public static void imprimirCacheServicios(){
        for (String key:cacheServicios.keySet()){
            System.out.println("servicio:" + key);
            for (dto.ReciboDTO dto : cacheServicios.get(key)){
                System.out.println("------"+ dto);
            }
        }
    }

    public ReciboDTO buscarRecibo (String convenio, String referencia) throws BusinessException {
        ReciboDTO dto = null;
        if ( ! cacheServicios.containsKey(convenio) ){
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        }else {
            for (ReciboDTO item : cacheServicios.get(convenio)){
                if (item.getReferencia().equals(referencia)){
                    dto = item;
                    break;
                }
            }
        }
        if (dto == null){
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }
        return dto;
    }
    public abstract Object[] cobrarRetiroSinTarjeta();
}
