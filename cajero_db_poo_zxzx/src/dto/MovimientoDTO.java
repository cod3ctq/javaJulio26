package dto;

import java.sql.Date;

public class MovimientoDTO {

    private int cuentaId;
    private String tipo;
    private Date fechaOp;
    private double monto;

    public MovimientoDTO(int cuentaId, String tipo, Date fechaOp, double monto) {
        this.cuentaId = cuentaId;
        this.tipo = tipo;
        this.fechaOp = fechaOp;
        this.monto = monto;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
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
                "cuentaId=" + cuentaId +
                ", tipo='" + tipo + '\'' +
                ", fechaOp=" + fechaOp +
                ", monto=" + monto +
                '}';
    }
}

