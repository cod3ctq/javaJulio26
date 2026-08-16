package dto;

import java.sql.Date;

public class ServicioDTO {

    private String convenio;
    private String referencia;
    private Date fechaInicio; //es consulta no se genera por eso string
    private Date fechaFin;
    private double monto;
    private char status;

    public ServicioDTO(String convenio, String referencia, Date fechaInicio, Date fechaFin, double monto, char status) {
        this.convenio = convenio;
        this.referencia = referencia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.status = status;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServicioDTO{" +
                "convenio='" + convenio + '\'' +
                ", referencia='" + referencia + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", monto=" + monto +
                ", status=" + status +
                '}';
    }
}
