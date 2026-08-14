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

    //atributo con composición
    public static List<CuentaDTO> cuentas;
    public static Map<String, RetiroSinTarjeta> cacheRST = new HashMap<String,RetiroSinTarjeta>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<RetiroSinTarjeta>();
    public static Map<String,List<ReciboDTO>> cacheServicios = new HashMap<String,List<ReciboDTO>>();

    //Crear un objeto de la clase dao.CuentaDAO y dao.MovimientoDAO
    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ServiciosDAO serviciosDAO = new ServiciosDAO();


    //Guarda el número de retiros y monto total de los mismo por cuenta+fecha
    public static Map<String,List<Ticket>> cacheRetiros = new HashMap<String,List<Ticket>>();

    public Atm(){
        cuentas = cuentaDAO.cargarCentas();
        cacheRST = generarRetirosSinTarjeta();
        cacheServicios = serviciosDAO.cargarCacheServicios();
    }

    public static Map<String, List<ReciboDTO>> getCacheServicios() {
        return cacheServicios;
    }

    public static void setCacheServicios(Map<String, List<ReciboDTO>> cacheServicios) {
        Atm.cacheServicios = cacheServicios;
    }

    public static Set<RetiroSinTarjeta> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<RetiroSinTarjeta> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
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

    //Obtiene todas las cuentas almacenadas en base de datos


    //Imprime en consola la información de las cuentas que en este punto ya deberían estar cargadas
    public static void imprimirCuentas(){

        //Por cada cuenta(elemento) dentro de cuentas (lista)
        for(dto.CuentaDTO cuenta:cuentas){
            System.out.println(cuenta);
        }
    }

    //Buscar cuenta
    public static CuentaDTO buscarCuenta(String numTarjeta) throws AccountNotFoundException {
        CuentaDTO cuenta = null;
        for(CuentaDTO c:cuentas){
            if(c.getNumTarjeta().equals(numTarjeta)){
                cuenta = c;
                break;
            }
        }
        //Si existe la cuenta...
        if(cuenta!=null){
            return cuenta;
        }else{

            //Lanzar una excepción (Porque el método no es tipo VOID, tendría que devolver un valor de tipo entity.Cuenta)
            //Momento 1
            throw new AccountNotFoundException("\nNo existe una cuenta con este número de tarjeta.");
        }
    }

    public void consultarSaldo(String numTarjeta){
        try{
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("\nSaldo disponible: "+cuenta.getSaldo());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

//    public void imprimirCacheRetiros(){
//        for(String key:cacheRetiros.keySet()){
//            for(models.Ticket t:cacheRetiros.get(key)){
//                System.out.println(t);
//            }
//        }
//    }

    public static Map<String,RetiroSinTarjeta> generarRetirosSinTarjeta(){
        RetiroSinTarjeta rst = null;

        //Itera detro de la lista de cuentas para obtener el número de cuenta
        for(CuentaDTO cuenta:cuentas){

            //Crea el retiro sin tarjeta, en base al número de cuenta de ada cuenta
            rst = new RetiroSinTarjeta(cuenta.getNumCuenta(), CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),Double.parseDouble(CuentaHelper.generarMonto()));

            //Aade el objeto rst al mapa asociado a su llave unica
            cacheRST.put(rst.getReferencia(),rst);
        }
        return cacheRST;
    }

    public static void imprimirRetirosSinTarjeta(){
        for (String key:cacheRST.keySet()){
            System.out.println(cacheRST.get(key));
        }
    }

    public static void imprimirCacheServicios(){
        for(String key:cacheServicios.keySet()){
            System.out.println("SERVICIO: "+key);
            for(dto.ReciboDTO dto:cacheServicios.get(key)){
                System.out.println("------: "+dto);
            }
        }
    }

    public ReciboDTO buscarRecibo (String convenio, String referencia)
            throws BusinessException {
        ReciboDTO dto = null;
        if(!cacheServicios.containsKey(convenio)){
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        }else{
            for(ReciboDTO item : cacheServicios.get(convenio)){
                if(item.getReferencia().equals(referencia)){
                    dto = item;
                    break;
                }
            }
        }
        if (dto == null) {
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }else{
            return dto;
        }
    }

    public abstract Object[] cobrarRetiroSinTarjeta();

}
