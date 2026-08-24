package com.ms_prestamos.errors;

import org.springframework.http.HttpStatusCode;
import java.time.LocalDateTime;

public class ApiErrors {

    private String mensaje;
    private HttpStatusCode status;
    private LocalDateTime timestamp;

    public ApiErrors(){}

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
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}



