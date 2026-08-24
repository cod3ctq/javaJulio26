package models;

import java.time.LocalDate;

public class Ticket {

    private String ubication;
    private int folio;
    private LocalDate fecha;
    private String tipoOperacion;
    private String numCuenta;
    private double monto;

    public Ticket(String ubication, int folio, LocalDate fecha, String tipoOperacion, String numCuenta, double monto) {
        this.ubication = ubication;
        this.folio = folio;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.numCuenta = numCuenta;
        this.monto = monto;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "models.Ticket{" +
                "ubication='" + ubication + '\'' +
                ", folio=" + folio +
                ", fecha=" + fecha +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", monto=" + monto +
                '}';
    }
}
