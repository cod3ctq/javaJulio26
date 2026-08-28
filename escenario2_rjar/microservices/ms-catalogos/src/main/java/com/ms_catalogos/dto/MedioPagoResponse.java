package com.ms_catalogos.dto;

    public class MedioPagoResponse {

        private int medioId;
        private String descripcion;

        public MedioPagoResponse(){}

        public MedioPagoResponse(int medioId, String descripcion) {
            this.medioId = medioId;
            this.descripcion = descripcion;
        }

        public int getMedioId() {
            return medioId;
        }

        public void setMedioId(int medioId) {
            this.medioId = medioId;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return "MedioPagoResponse{" +
                    "medioId=" + medioId +
                    ", descripcion='" + descripcion + '\'' +
                    '}';
        }
    }

