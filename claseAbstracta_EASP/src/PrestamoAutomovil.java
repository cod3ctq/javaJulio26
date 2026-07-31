public class PrestamoAutomovil extends PrestamoBancario {

    double enganche;
    boolean avalRequerido;

    public PrestamoAutomovil(){}

    public PrestamoAutomovil(String folio, double monto, int plazoMeses, double tazaInteres, double saldoPendiente, String beneficiario, double enganche, boolean avalRequerido) {
        super(folio, monto, plazoMeses, tazaInteres, saldoPendiente, beneficiario);
        this.enganche = enganche;
        this.avalRequerido = avalRequerido;
    }

    public double getEnganche() {
        return enganche;
    }

    public void setEnganche(double enganche) {
        this.enganche = enganche;
    }

    public boolean isAvalRequerido() {
        return avalRequerido;
    }

    public void setAvalRequerido(boolean avalRequerido) {
        this.avalRequerido = avalRequerido;
    }

    @Override
    public String toString() {
        return "PrestamoAutomovil{" +
                "enganche=" + enganche +
                ", avalRequerido=" + avalRequerido +
                ", folio='" + folio + '\'' +
                ", monto=" + monto +
                ", plazoMeses=" + plazoMeses +
                ", tazaInteres=" + tazaInteres +
                ", saldoPendiente=" + saldoPendiente +
                ", beneficiario='" + beneficiario + '\'' +
                '}';
    }

    @Override
    public double calcularMensualidad() {
        double tazaMensual = (tazaInteres/100) / 12;
        return (monto * tazaMensual) / (1 - Math.pow(1 + tazaMensual, -plazoMeses));
    }

    @Override
    public double calcularInteres() {
        double totalPagado = calcularMensualidad() * plazoMeses;
        return totalPagado - monto;
    }
}
