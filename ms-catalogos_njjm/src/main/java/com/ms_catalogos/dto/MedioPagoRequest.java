package com.ms_catalogos.dto;

import jakarta.validation.constraints.NotNull;

public class MedioPagoRequest {

        private int medioId;

        @NotNull(message = "La descripcion no puede ser nulo")
        private String descripcionMedioPago;

        public MedioPagoRequest(){}

        public MedioPagoRequest(int medioId, String descripcionMedioPago) {
            this.medioId = medioId;
            this.descripcionMedioPago = descripcionMedioPago;
        }

        public int getMedioId() {
            return medioId;
        }

        public void setMedioId(int medioId) {
            this.medioId = medioId;
        }

        public String getDescripcionMedioPago() {
            return descripcionMedioPago;
        }

        public void setDescripcionMedioPago(String descripcionMedioPago) {
            this.descripcionMedioPago = descripcionMedioPago;
        }

        @Override
        public String toString() {
            return "MedioPagoRequest{" +
                    "medioId=" + medioId +
                    ", descripcionMedioPago='" + descripcionMedioPago + '\'' +
                    '}';
        }
    }

