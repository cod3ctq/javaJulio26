public class PrestamoAutomovil extends PrestamoBancario{

    double enganche;
    boolean aval;

    public PrestamoAutomovil(String folio, double monto, int plazoMeses, double tasaInteres, double saldoPendiente, String beneficiario, double enganche, boolean aval) {
        super(folio, monto, plazoMeses, tasaInteres, saldoPendiente, beneficiario);
        this.enganche = enganche;
        this.aval = aval;
    }

    public double getEnganche() {
        return enganche;
    }

    public void setEnganche(double enganche) {
        this.enganche = enganche;
    }

    public boolean isAval() {
        return aval;
    }

    public void setAval(boolean aval) {
        this.aval = aval;
    }

    @Override
    public String toString() {
        return "PrestamoAutomovil{" +
                "enganche=" + enganche +
                ", aval=" + aval +
                ", folio='" + folio + '\'' +
                ", monto=" + monto +
                ", plazoMeses=" + plazoMeses +
                ", tasaInteres=" + tasaInteres +
                ", saldoPendiente=" + saldoPendiente +
                ", beneficiario='" + beneficiario + '\'' +
                '}';
    }

    @Override
    public double calcularMensualidad() {
        double tasamensual=(tasaInteres/100)/12;

        return (monto * tasamensual)/
                ( 1- Math.pow(1 + tasamensual,-plazoMeses));
    }

    @Override
    public double calcularInteres() {
        return 0;
    }
}
