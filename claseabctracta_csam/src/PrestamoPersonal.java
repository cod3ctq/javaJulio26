public class PrestamoPersonal extends PrestamoBancario{

    double ingresoMensual;
    String direcccion;
    boolean aval;

    public PrestamoPersonal(String folio, double monto, int plazoMeses, double tasaInteres, double saldoPendiente, String beneficiario, double ingresoMensual, String direcccion, boolean aval) {
        super(folio, monto, plazoMeses, tasaInteres, saldoPendiente, beneficiario);
        this.ingresoMensual = ingresoMensual;
        this.direcccion = direcccion;
        this.aval = aval;
    }

    @Override
    public double calcularMensualidad() {
        double interes = monto+(tasaInteres/100) * (plazoMeses/12);
        return (monto+interes)/plazoMeses;
    }

    @Override
    public double calcularInteres() {

        return monto*(tasaInteres/100);
    }
}
