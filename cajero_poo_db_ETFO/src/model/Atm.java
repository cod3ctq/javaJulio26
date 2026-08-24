package model;

import exception.*;
import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ReciboDAO;
import dto.CuentaDTO;
import dto.ReciboDTO;
import util.CuentaHelper;

import java.util.*;

public abstract class Atm {

    private String ubicacion;
    public static int folio = 0;
    private double efectivo;

    //Atributos con composicion
    public static List<CuentaDTO> cuentas;
    // Guarda el numero de retiros y monto total de los mismos por cuenta + fecha
    public static Map<String, List<Ticket>> cacheRetiros = new HashMap<String, List<Ticket>>();
    public static Map<String, RetiroSinTarjeta> cacheRST = new HashMap<String, RetiroSinTarjeta>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<>();
    public static Map<String, List<ReciboDTO>> cacheRecibos = new HashMap<String, List<ReciboDTO>>();
    //Clases de JDBC (temporalmente estaran aqui, despues ese ubicaran en su lugar correcto)

    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ReciboDAO reciboDAO = new ReciboDAO();

    //Manipulamos el constructor vacio
    public Atm ()
    {
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetiroSinTarjeta();
        cacheRecibos = reciboDAO.cargarRecibos();
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

    public static Map<String, List<ReciboDTO>> getCacheRecibos() {
        return cacheRecibos;
    }

    public static void setCacheRecibos(Map<String, List<ReciboDTO>> cacheRecibos) {
        Atm.cacheRecibos = cacheRecibos;
    }

    @Override
    public String toString() {
        return "model.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", efectivo=" + efectivo +
                '}';
    }

    // Obtiene todas las cuentas almacenadas en base de datos

    //Imprime en consola la informacion de las cuentas que en este punto, ya deberian estar cargadas
    public static void imprimirCuentas() {
        //Por cada cuenta(elemento) dentro de las cuentas(lista)
        for(CuentaDTO cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }
    //Buscar cuenta
    public static CuentaDTO buscarCuenta(String numTarjeta) throws AccoutNotFoundException { //Excepcion personalizada
        CuentaDTO cuenta = null;

        for(CuentaDTO c : cuentas) {
            if(c.getNumTarjeta().equals(numTarjeta)) {
                cuenta = c;
                break;
            }
        }
        //Si existe la cuenta
        if(cuenta != null) {
            return cuenta;
        }else{
            //Lanzar una excepcion
            throw new AccoutNotFoundException("No existe una cuenta con este numero de tarjeta");

        }
        //Al lanzar una excepcion los return salen sobrando
    }

    public void  consultarSaldo(String numTarjeta){
        try {
            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            System.out.println("Saldo disponible: " + cuenta.getSaldo());
        } catch (Exception ex) {

        }
    }

    public void imprimirCacheRetiro() {
        for (String key:cacheRetiros.keySet()) {
            for (Ticket t:cacheRetiros.get(key)) {
                System.out.println(t);
            }
        }
    }

    public void imprimirCacheServicios() {
        for (String key : cacheRecibos.keySet()) {
            System.out.println(key);
            System.out.println("-------------");
            for (ReciboDTO t : cacheRecibos.get(key)) {
                System.out.println(t);
            }
        }
    }

    public ReciboDTO buscarRecibo(String convenio, String referencia) throws BusinessException {
        ReciboDTO dto = null;
        if(!cacheRecibos.containsKey(convenio)) {
            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        } else {
            for (ReciboDTO item : cacheRecibos.get(convenio)) {
                if (item.getReferencia().equals(referencia)) {
                    dto = item;
                    break;
                }
            }
            if (dto != null) {
                throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
            }
            return dto;
        }
    }

    public static Map<String, RetiroSinTarjeta> generarRetiroSinTarjeta() {
        RetiroSinTarjeta rst = null;
        //Itera dentro de la lista de cuentas para obtener el numero de cuenta
        for(CuentaDTO cuenta : cuentas){
            //Crea el retiro sin tarjeta, en bae al numero de cuenta de cada cuenta
            rst = new RetiroSinTarjeta
                    (
                            cuenta.getNumCuenta(),
                            CuentaHelper.generarReferencia(),
                            CuentaHelper.generarClave(),
                            Double.parseDouble(CuentaHelper.generarMonto())
                    );
            // Añade el objeto RST al mapa asociado a su llave unica
            cacheRST.put(rst.getReferencia(), rst);
        }
        return cacheRST;
    }

    // Temporal, solo para ver los datos en consola
    public static void imprimirRetirosSinTarjeta() {
        for(String key:cacheRST.keySet()) {
            System.out.println(cacheRST.get(key));
        }
    }

    protected abstract Object[] cobrarRetirosSinTarjeta();

    //Cuando queremos devolver datos de diferentes tipos lo correcto es usar Object[]
}
