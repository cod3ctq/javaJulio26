package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServiciosDAO;
import dto.CuentaDTO;
import dto.MovimientoDTO;
import dto.ReciboDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;


import java.sql.DriverManager;
import java.util.*;


public abstract class Atm {

    public static int folio = 0;
    private String ubicacion;
    private double efcetivo;


    //atributo con composicion
    public static List<CuentaDTO> cuentas;
    public static Map<String, RetiroSinTarjeta> cacheRST = new HashMap<String, RetiroSinTarjeta>();
    //Guarda el numero de retiros y monto totalde los mismos por cuenta+fecha
    public static Map<String, List<Ticket>> cacheRetros = new HashMap<String, List<Ticket>>();
    public static Set<RetiroSinTarjeta> cacheRetirosCobrados = new HashSet<RetiroSinTarjeta>();
    public static Map<String, List<ReciboDTO>> cacheServicios = new HashMap<String, List<ReciboDTO>>();


    //cREAR un objeto de la claseDAO
    public CuentaDAO cuentaDAO = new CuentaDAO();
    public MovimientoDAO movDAO = new MovimientoDAO();
    public ServiciosDAO serviciosDAO = new ServiciosDAO();

    public Atm() {
        cuentas = cuentaDAO.cargarCuentas();
        cacheRST = generarRetirosSinTarjeta();
        cacheServicios = serviciosDAO.cargarCacheServicios();
    }

    public static Map<String, List<Ticket>> getCacheRetros() {
        return cacheRetros;
    }

    public static void setCacheRetros(Map<String, List<Ticket>> cacheRetros) {
        Atm.cacheRetros = cacheRetros;
    }

    public static Set<RetiroSinTarjeta> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<RetiroSinTarjeta> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
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

    public static Map<String, RetiroSinTarjeta> getCacheRST() {
        return cacheRST;
    }

    public static void setCacheRST(Map<String, RetiroSinTarjeta> cacheRST) {
        Atm.cacheRST = cacheRST;
    }

    public List<CuentaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    public double getEfcetivo() {
        return efcetivo;
    }

    public void setEfcetivo(double efcetivo) {
        this.efcetivo = efcetivo;
    }

    @Override
    public String toString() {
        return "models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", efcetivo=" + efcetivo +
                '}';
    }

    public Atm(String ubicacion, String folio, double efcetivo) {
        this.ubicacion = ubicacion;

        this.efcetivo = efcetivo;
    }

    //Imprime en consola la informacion de las cuentas
    //que en este punto, ya deberian estar cargadas
    public static void imprimirCuentas() {
        //Por cada cuenta(elmento)
        for (CuentaDTO cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    //buscar cuenta
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
            System.out.println("saldo disponible: " + cuenta.getSaldo());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

        public abstract Object[] cobrarRetiroSinTarjeta() ;

//

    public void imprimirCacheRetros() {
        for (String key : cacheRetros.keySet()) {
            for (Ticket t : cacheRetros.get(key)) {
                System.out.println(t);
            }
        }

    }

    public static Map<String, RetiroSinTarjeta> generarRetirosSinTarjeta() {
        RetiroSinTarjeta srt = null;

        //itera dentro de la lista de cuentas, para obtener el numero de cuenta
        for (CuentaDTO cuenta : cuentas) {

            //Cre el retiro sin tarjeta, enbaes al numero
            srt = new RetiroSinTarjeta(cuenta.getNumCuenta(), CuentaHelper.generarReferencia(),
                    CuentaHelper.generarClave(),

                    Double.parseDouble(CuentaHelper.generrarMonto()));
            cacheRST.put(srt.getReferencia(), srt);

        }

        return cacheRST;
    }

    //Temporal solo para ver datos en consola
    public static void imprimirRetirosSinTarjeta() {
        for (String key : cacheRST.keySet()) {
            System.out.println(cacheRST.get(key));
        }
    }

    public static void imprimirCacheServicios() {

        for(String key:cacheServicios.keySet()){
            System.out.println("SERVICIO : "+key);
            for(ReciboDTO dto : cacheServicios.get(key)){
                System.out.println("----: "+dto);
            }
        }
    }

    public ReciboDTO buscarRecibo(String convenio, String referencia) throws BusinessException {
        ReciboDTO dto = null;
        if (! cacheServicios.containsKey(convenio)) {

            throw new BusinessException(Mensajes.AGREEMENT_NOT_FOUND);
        } else {
            for (ReciboDTO item : cacheServicios.get(convenio))
            {
                System.out.println("cuenta actual"+item);
                if (item.getReferencia().equals(referencia)) {
                    dto = item;
                    break;
                }

            }
        }
        System.out.println("print1"+dto);
        if (dto == null) {
            throw new BusinessException(Mensajes.REFERENCE_NOT_FOUND);
        }
        return dto;

        }
    }


