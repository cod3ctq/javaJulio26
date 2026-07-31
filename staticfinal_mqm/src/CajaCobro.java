public class CajaCobro {

    public static double totalGlobal = 0.0;

    private int numeroCaja;
    private String cajero;
    private double totalPorCaja;
    private int ventasCobradas;

    public CajaCobro(int numeroCaja, String cajero, double totalPorCaja, int ventasCobradas) {
        this.numeroCaja = numeroCaja;
        this.cajero = cajero;
        this.totalPorCaja = totalPorCaja;
        this.ventasCobradas = ventasCobradas;
    }

    //este metodo estatico recupera el valor compartido por todas las instancias de esta clase
    //particularidad de todos los miembros estaticos,, no se necesitar hacerlo a partir
    // de una instancia en particular, puede invocarse directamente desde la clase
    public static double getTotalGlobal() {
        return totalGlobal;
    }

    public static void setTotalGlobal(double totalGlobal) {
        CajaCobro.totalGlobal = totalGlobal;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public double getTotalPorCaja() {
        return totalPorCaja;
    }

    public void setTotalPorCaja(double totalPorCaja) {
        this.totalPorCaja = totalPorCaja;
    }

    public int getVentasCobradas() {
        return ventasCobradas;
    }

    public void setVentasCobradas(int ventasCobradas) {
        this.ventasCobradas = ventasCobradas;
    }

    @Override
    public String toString() {
        return "CajaCobro{" +
                "numeroCaja=" + numeroCaja +
                ", cajero='" + cajero + '\'' +
                ", totalPorCaja=" + totalPorCaja +
                ", ventasCobradas=" + ventasCobradas +
                '}';
    }


    public void registraVenta(double monto){
        totalGlobal = totalGlobal + monto;//incrementa el contador global
        this.totalPorCaja = totalPorCaja + monto;//incrementa el contador individual de cada caja
        this.ventasCobradas++;//incrementa el num de ventas procesadas en cada caja
    }

    //Al ser estatico, este modelo ejecuta exactamente la misma logica afectando
    //a exacamente la misma variable (direccion de memoria)
    //incrementando un contador global
}
