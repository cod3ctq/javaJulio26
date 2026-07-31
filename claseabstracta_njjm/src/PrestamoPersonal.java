public class PrestamoPersonal extends PrestamoBancario{

    double ingresoMensual;
    String direccion;
    boolean avalRequerido;

    public PrestamoPersonal(){}

    public PrestamoPersonal(String folio, double monto, int plazoMeses, double tasaInteres, double saldoPendiente, String beneficiario, double ingresoMensual, String direccion, boolean avalRequerido) {
        super(folio, monto, plazoMeses, tasaInteres, saldoPendiente, beneficiario);
        this.ingresoMensual = ingresoMensual;
        this.direccion = direccion;
        this.avalRequerido = avalRequerido;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isAvalRequerido() {
        return avalRequerido;
    }

    public void setAvalRequerido(boolean avalRequerido) {
        this.avalRequerido = avalRequerido;
    }

    @Override
    public String toString() {
        return "PrestamoPersonal{" +
                "ingresoMensual=" + ingresoMensual +
                ", direccion='" + direccion + '\'' +
                ", avalRequerido=" + avalRequerido +
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

        double interes = monto * (tasaInteres / 100) * (plazoMeses / 12);
        return (monto + interes) / plazoMeses;
    }

    @Override
    public double calcularInteres() {

        return monto * (tasaInteres / 100) * (plazoMeses / 12);
    }
}
