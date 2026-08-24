package com.ms_catalogos.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TIPO_TARJETA")
public class TipoTarjeta implements Serializable {


        @Id
        @Column(name= "TIPO_T_ID", columnDefinition = "NUMBER")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int tipoTId;

        @Column (name = "DESCRIPCION", columnDefinition = "VARCHAR(100)")
        private String descripcion;

        public int getTipoTId() {
            return tipoTId;
        }

        public void setTipoTId(int tipoTId) {
            this.tipoTId = tipoTId;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
}
