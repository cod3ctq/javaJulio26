package dto;

import java.sql.Date;

public class MovimientoDTO {
    private int cuentaID;
    private String tipo;
    private Date fechaOp;
    private double monto;

    public MovimientoDTO(int cuentaID, String tipo, Date fechaOp, double monto) {
        this.cuentaID = cuentaID;
        this.tipo = tipo;
        this.fechaOp = fechaOp;
        this.monto = monto;
    }

    public int getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaOp() {
        return fechaOp;
    }

    public void setFechaOp(Date fechaOp) {
        this.fechaOp = fechaOp;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "dto.MovimientoDTO{" +
                "cuentaID=" + cuentaID +
                ", tipo='" + tipo + '\'' +
                ", fechaOp=" + fechaOp +
                ", monto=" + monto +
                '}';
    }
}
