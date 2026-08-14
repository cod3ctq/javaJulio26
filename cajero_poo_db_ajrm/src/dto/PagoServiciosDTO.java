package dto;

import java.time.LocalDateTime;

public class PagoServiciosDTO {

    private int reciboId;
    private int servicioId;
    private String referenciaId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private double monto;
    private boolean status;

    public PagoServiciosDTO(int reciboId, int servicioId, String referenciaId, LocalDateTime fechaInicio, LocalDateTime fechaFinal, double monto, boolean status) {
        this.reciboId = reciboId;
        this.servicioId = servicioId;
        this.referenciaId = referenciaId;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.monto = monto;
        this.status = status;
    }

    public int getReciboId() {return reciboId;}

    public void setReciboId(int reciboId) {this.reciboId = reciboId;}

    public int getServicioId() {return servicioId;}

    public void setServicioId(int servicioId) {this.servicioId = servicioId;}

    public String getReferenciaId() {return referenciaId;}

    public void setReferenciaId(String referenciaId) {this.referenciaId = referenciaId;}

    public LocalDateTime getFechaInicio() {return fechaInicio;}

    public void setFechaInicio(LocalDateTime fechaInicio) {this.fechaInicio = fechaInicio;}

    public LocalDateTime getFechaFinal() {return fechaFinal;}

    public void setFechaFinal(LocalDateTime fechaFinal) {this.fechaFinal = fechaFinal;}

    public double getMonto() {return monto;}

    public void setMonto(double monto) {this.monto = monto;}

    public boolean isStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    @Override
    public String toString() {
        return "dto.PagoServiciosDTO{" +
                "reciboId=" + reciboId +
                ", servicioId=" + servicioId +
                ", referenciaId='" + referenciaId + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", monto=" + monto +
                ", status=" + status +
                '}';
    }
}
