public class CajaCobro {

    public static double totalGlobal=0;

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

    //Este metodo estatico recupera el valor compartido por todas las instancias de esta clase.
    //Para invocarlo, no necesitas hacerlo a partir de una instancia en particular
    //Puedes invocarlo directamente de la clase.
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
        totalGlobal= totalGlobal + monto; //Incrementando un contador global para todas las cajas

        this.totalPorCaja = totalPorCaja + monto; //Incrementa el valor individual de cada caja

        this.ventasCobradas++; ///Incrementa el numero de ventas procesadas en cada caja
    }



    //Al ser estatico, este metodo ejecuta exactamente la misma logica afectando a exactamente la misma variable (direccion de memoria)
    //Incrementando un contador global



}
