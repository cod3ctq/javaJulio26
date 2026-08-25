package com.example.ms_transacciones.errors;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrors {
    String mensaje;
    List<String> detalles;
    HttpStatusCode status;
    LocalDateTime timestamp;
    public ApiErrors(String mensaje, List<String> detalles, HttpStatusCode status, LocalDateTime timestamp) {
        this.mensaje = mensaje;
        this.detalles = detalles;
        this.status = status;
        this.timestamp = timestamp;
    }
    public ApiErrors(String mensaje, HttpStatusCode status, LocalDateTime timestamp) {
        this.mensaje = mensaje;
        this.status = status;
        this.timestamp = timestamp;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public List<String> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }
    public HttpStatusCode getStatus() {
        return status;
    }
    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ApiErrors{" +
                "mensaje='" + mensaje + '\'' +
                ", detalles=" + detalles +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
