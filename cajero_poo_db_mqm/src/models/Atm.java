package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServicioDAO;
import dto.CuentaDTO;
import dto.ServicioDTO;
import exception.AccountNotFoundException;
import exception.BussinessException;
import util.CuentaHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public abstract class Atm {

    public static int folio = 0;//contador general miembro de clase estatico

    private String ubicacion;
    private double efectivo;

    //atributo con composicion
    public static List<CuentaDTO> cuentas;


    public static Map<String, RetiroSinTarjeta> cacheRST =
            new HashMap<String, RetiroSinTarjeta>();
    //guarda el num de retiros y monto total de los mismos por cuenta +fecha
    public static Map<String,List<Ticket>> cacheRetiros =
            new HashMap<String, List<Ticket>>();

    //set es una especie de mapa que guarda valores de unica ocacion
    //en este caso se usara como un registro de lo ya cobrado
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados =
            new HashSet<RetiroSinTarjeta>();

//    public static List<ServicioDTO> pagoDTO;
    public static Map<String,List<ServicioDTO>> cachePagoServicios =
            new HashMap<String, List<ServicioDTO>>();

    //clases de JDBC
    //(temporalmente estaran aqui, despues se ubicaran en su lugar correcto)
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ServicioDAO pagoDAO = new ServicioDAO();

    public Atm (){
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetirosSinTarjeta();
//        pagoDTO = pagoDAO.cargarServicios();
        cachePagoServicios = pagoDAO.cachePagoServicios();

    }

//    public static List<ServicioDTO> getPagoDTO() {
//        return pagoDTO;
//    }
//
//    public static void setPagoDTO(List<ServicioDTO> pagoDTO) {
//        Atm.pagoDTO = pagoDTO;
//    }

    public static Map<String, List<ServicioDTO>> getCachePagoServicios() {
        return cachePagoServicios;
    }

    public static void setCachePagoServicios(Map<String, List<ServicioDTO>> cachePagoServicios) {
        Atm.cachePagoServicios = cachePagoServicios;
    }

    public static Set<RetiroSinTarjeta> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<RetiroSinTarjeta> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    public static Map<String, RetiroSinTarjeta> getCacheRST() {
        return cacheRST;
    }

    public static void setCacheRST(Map<String, RetiroSinTarjeta> cacheRST) {
        Atm.cacheRST = cacheRST;
    }

    public static Map<String, List<Ticket>> getCacheRetiros() {
        return cacheRetiros;
    }

    public static void setCacheRetiros(Map<String, List<Ticket>> cacheRetiros) {
        Atm.cacheRetiros = cacheRetiros;
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

    //imprime en consola la informacion de las cuentas
    //que en este punto, ya deberian estar cargadas
    public static void imprimirCuentas(){
        //por cada cuenta(elemento) dentro de cuentas(lista)
        for (CuentaDTO cuenta:cuentas){
            System.out.println(cuenta);
        }
    }
    //buscar cuenta
    //                                             el throws va a nivel de metodo
    public static CuentaDTO buscarCuenta(String numTarjeta) throws AccountNotFoundException{
        CuentaDTO cuenta = null;
        for (CuentaDTO c:cuentas){
            if (c.getNumTarjeta().equals(numTarjeta)){
                cuenta = c;
                break;
            }
        }

        //si existe la cuenta...
        if(cuenta != null){
            return cuenta;
        }else {
            //lanzar una excepcion
            throw new AccountNotFoundException("No existe una cuenta " +
                    "con este numero de tarjeta");
        }
        //return null;//--> solo returna null para que no marque error
    }

    public void consultarSaldo (String numTarjeta) throws AccountNotFoundException{
        try{
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("Saldo disponible: "+cuenta.getSaldo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirCacheRetiros(){
        for (String key : cacheRetiros.keySet()){
            for (Ticket t : cacheRetiros.get(key)){
                System.out.println(t);
            }
        }
    }

    public static Map<String,RetiroSinTarjeta> generarRetirosSinTarjeta(){
        RetiroSinTarjeta rst = null;//obeto temporal
        //itera dentro de la lista de cuentas para obtener el numero de cuenta
        for (CuentaDTO cuenta : cuentas){
            //crea el retiro sin tarjeta en base al numero de cuenta de cada cuenta
            rst = new RetiroSinTarjeta(cuenta.getNumCuenta(),
                    CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),
                    Double.parseDouble(CuentaHelper.generarMonto()));
            //añade el objeto rst al mapa asociado a su llave unica
            cacheRST.put(rst.getReferencia(), rst);
        }

        return cacheRST;
    }
    //temporal
    public static void imprimirRetirosSinTarjeta(){
        for (String key : cacheRST.keySet()){
            System.out.println(cacheRST.get(key));
        }
    }

//-----------
//servicios
//-----------

    public ServicioDTO buscarServicio (String convenio,String referencia) throws BussinessException {
        ServicioDTO convenioServicio = null;

        if (!cachePagoServicios.containsKey(convenio)) {
            throw new BussinessException(Mensajes.REFERENCE_NOT_FOUND);
        } else {
            for (ServicioDTO item : cachePagoServicios.get(convenio)) {
                if (item.getReferencia().equals(referencia)) {
                    convenioServicio = item;
                    break;
                }
            }
        }

        if (convenioServicio == null) {
            throw new BussinessException(Mensajes.REFERENCE_NOT_FOUND);
        }
        return convenioServicio;
    }


    public static void imprimirServicios(){
        for (String key : cachePagoServicios.keySet()){
            for (ServicioDTO t : cachePagoServicios.get(key)){
                System.out.println(t);
            }
        }
    }

    public void consultarMonto (String convenio, String referencia) throws BussinessException{
        try{
            ServicioDTO servicios = buscarServicio(convenio, referencia);
            System.out.println("Monto a pagar : "+servicios.getMonto());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //este metodo va a convertir a la clase object en una clase abstracta
    public abstract Object [] cobrarRetiroSinTarjeta();
}
