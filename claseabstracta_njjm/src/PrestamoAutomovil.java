public class PrestamoAutomovil extends PrestamoBancario{

    double enganche;
    boolean avalRequerido;

    PrestamoAutomovil(){}

    public PrestamoAutomovil(String folio, double monto, int plazoMeses, double tasaInteres, double saldoPendiente, String beneficiario, double enganche, boolean avalRequerido) {
        super(folio, monto, plazoMeses, tasaInteres, saldoPendiente, beneficiario);
        this.enganche = enganche;
        this.avalRequerido = avalRequerido;
    }

    @Override
    public double calcularMensualidad() {

        double tasaMensual = (tasaInteres / 100) / 12;
        return (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoMeses));
    }

    @Override
    public double calcularInteres() {

        double totalPagado = calcularMensualidad() * plazoMeses;
        return totalPagado - monto;
    }
}
