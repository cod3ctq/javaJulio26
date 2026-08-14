package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.RecibosDAO;
import dto.CuentaDTO;
import dto.RecibosDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

public abstract class Atm {
    public static int folio=0;
    private String ubicacion;
    private double efectivo;

    //Atributo con composicion
    public static List<CuentaDTO> cuentas;
    public static Map<String, RetiroSinTarjeta> cacheRST = new HashMap<String, RetiroSinTarjeta>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<RetiroSinTarjeta>();

    public static Map<String, List<RecibosDTO>> recibosConvenio = new HashMap<String, List<RecibosDTO>>();

    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public RecibosDAO recibosDAO = new RecibosDAO();

    //Guarda el numero de retiros y monto total de los mismos por cuenta + fecha
    public static Map<String, List<Ticket>> cacheRetiros = new HashMap<String, List<Ticket>>();

    public Atm(){
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetiroSinTarjeta();
        recibosConvenio = recibosDAO.cargarRecibos();
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



    @Override
    public String toString() {
        return "Models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", efectivo=" + efectivo +
                '}';
    }



    //Imprime en consola la informacion de las cuentas que en este punto ya deberian estar cargadas
    public static void imprimirCuentas (){
        //Por cada cuenta(elemento) dentro de cuentas (lista)
        for(dto.CuentaDTO cuenta:cuentas){
            System.out.println(cuenta);
        }
    }

    //Buscar cuenta
    public static CuentaDTO buscarCuenta (String numTarjeta) throws AccountNotFoundException {
        CuentaDTO cuenta = null;

        for(CuentaDTO c:cuentas){
            if(c.getNumTarjeta().equals(numTarjeta)){
                cuenta = c;
                break;
            }
        }
        //Sí existe la cuenta ....
        if(cuenta!=null){
            return cuenta;
        }else{
            //lanzar una excepcion
            //Momento 1
            throw new AccountNotFoundException("No existe una cuenta con este numero de tarjeta");
        }
    }

    public void consultarSaldo(String numTarjeta){
        //Momento 2 de las excepciones: Permite "atrapar" o manejar las excepciones que el programa pueda lanzar.
        //En el momento 1 se hacen las excepciones.
        //El momento 2 se debe hacer en el punto en que se ejecuta el metodo
        //El momento 1 se debe hacer en la logica del metodo
        try{
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("Saldo disponible: $"+cuenta.getSaldo());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

//    public void imprimirCacheRetiros(){
//        for(String key: cacheRetiros.keySet()){
//            for(Models.Ticket t: cacheRetiros.get(key)){
//                System.out.println(t);
//            }
//        }
//    }

    public static Map<String, RetiroSinTarjeta> generarRetiroSinTarjeta(){
        RetiroSinTarjeta rst = null;
        //itera dentro de la lista de cuentas para obtener el numero de cuenta
        for(CuentaDTO cuenta:cuentas){
            //Crea el retiro sin tarjeta en base al numero de cuenta de cada cuenta
            rst = new RetiroSinTarjeta(cuenta.getNumCuenta(),
                    CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),
                    Double.parseDouble(CuentaHelper.generarMonto())); // Consigue el valor double dandole un String
            //Añade el objeto rst al mapa asociado a su llave unica (referencia)
            cacheRST.put(rst.getReferencia(), rst);
        }
        return cacheRST;
    }

    //Temporal, Solo para ver los datos del mapa en consola
    public static void imprimirRetirosSinTarjeta(){
        for(String key: cacheRST.keySet()){
            System.out.println(cacheRST.get(key));
        }
    }

    public static void imprimirCacheServicios(){
        for(String key: recibosConvenio.keySet()){
            System.out.println("SERVICIO "+key);
            for(dto.RecibosDTO dto: recibosConvenio.get(key)){
                System.out.println("---:" +dto);
            }
        }
    }

    public RecibosDTO buscarRecibo (String convenio, String referencia) throws BusinessException {
        RecibosDTO rdto = null;

        if (!recibosConvenio.containsKey(convenio)){
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        }else {
            for (RecibosDTO r: recibosConvenio.get(convenio)) {
                if (r.getReferencia().equals(referencia)) {
                    rdto = r;
                    break;
                }
            }
            if (rdto == null) {
                throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
            }
            return rdto;
        }
    }




    public abstract Object[] cobrarRetiroSinTarjeta();






}
