public class CajaCobro {

    //#caja
    //cajero
    //totalCobrado
    //totalPorCaja
    //#ventasCobradas
    public static double totalGlobal = 0.0;


    private int numeroCaja;
    private String Cajero;
    private double totalPorCaja;
    private int ventasCobradas;



    public CajaCobro(int numeroCaja, String cajero, double totalPorCaja, int ventasCobradas) {
        this.numeroCaja = numeroCaja;
        Cajero = cajero;
        this.totalPorCaja = totalPorCaja;
        this.ventasCobradas = ventasCobradas;
    }

    //metodo estatuco recupera el valor ompartido por todas las intancias
    //de esta clase.
    //para invocarlo no necesitas hacerlo a partir de una instancia en particular
    //puedes invocarlo directamente desde la clase
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
        return Cajero;
    }

    public void setCajero(String cajero) {
        Cajero = cajero;
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
                ", Cajero='" + Cajero + '\'' +
                ", totalPorCaja=" + totalPorCaja +
                ", ventasCobradas=" + ventasCobradas +
                '}';
    }

    //incrementando un contador global
    public void registrarVenta(double monto) {
        totalGlobal = totalGlobal + monto;//incrementa el contador global

        this.totalPorCaja = totalPorCaja + monto;//incrementa el contador individual de cada caja

        this.ventasCobradas++;//incrementa el numero de ventas en cada caja

    }



    //al ser estatico, este metodo ejecuta exactamente la misma logica
    //afectando exactamente la misma variable (dirección de memoria)
    //incrementando un contador global







}
