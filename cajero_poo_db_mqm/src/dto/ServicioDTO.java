package dto;

import java.sql.Date;

public class ServicioDTO {

    private String convenio;
    private String referencia;
    private String fechaInicio; //es consulta no se genera por eso string
    private String fechaFin;
    private double monto;
    private String status;

    public ServicioDTO(String convenio, String referencia, String fechaInicio, String fechaFin, double monto, String status) {
        this.convenio = convenio;
        this.referencia = referencia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.status = status;
    }

    public ServicioDTO(String referencia, Date fechaInicio, Date fechaFin, double monto, char status) {
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "dto.ServicioDTO{" +
                "convenio='" + convenio + '\'' +
                ", referencia='" + referencia + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", monto=" + monto +
                ", status='" + status + '\'' +
                '}';
    }
}
