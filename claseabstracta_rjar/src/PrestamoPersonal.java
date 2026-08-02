public class PrestamoPersonal extends PrestamoBancario{

    double ingresoMensual;
    String direccion;
    boolean avalRequerido;


    public PrestamoPersonal(String folio, double monto, int plazoMeses, double tasaInteres, double saldoPendiente, String beneficiario, double ingresoMensual, String direccion, boolean avalRequerido) {
        super(folio, monto, plazoMeses, tasaInteres, saldoPendiente, beneficiario);
        this.ingresoMensual = ingresoMensual;
        this.direccion = direccion;
        this.avalRequerido = avalRequerido;

    }

    @Override
    public double calcularMensualidad() {
        double interes= monto*(tasaInteres/100)*(plazoMeses/12);
        return (monto+interes)/plazoMeses;
    }

    @Override
    public double calcularInteres() {
        return monto*(tasaInteres/100)*(plazoMeses/12);
    }
}
