package models;

public class RetiroSinTarjeta {

    private String numCuenta;
    private String referencia;
    private String clave;
    private double monto;


    public RetiroSinTarjeta(String numCuenta, String referencia, String clave, double monto) {
        this.numCuenta = numCuenta;
        this.referencia = referencia;
        this.clave = clave;
        this.monto = monto;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "models.RetiroSinTarjeta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", referencia='" + referencia + '\'' +
                ", clave='" + clave + '\'' +
                ", monto=" + monto +
                '}';
    }
}
