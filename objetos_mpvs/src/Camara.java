public class Camara {
    String resolucion;
    String tipoLente;
    int zoom;
    String tipoZoom;
    int cams;
    boolean flash;

    //permite inicializar una instancia vacia del objeto.
    public Camara(){}

    //Constructor

    public Camara(String resolucion, String tipoLente, int zoom, String tipoZoom, int cams, boolean flash) {
        this.resolucion = resolucion;
        this.tipoLente = tipoLente;
        this.zoom = zoom;
        this.tipoZoom = tipoZoom;
        this.cams = cams;
        this.flash = flash;
    }

    //getter and setter
    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoLente() {
        return tipoLente;
    }

    public void setTipoLente(String tipoLente) {
        this.tipoLente = tipoLente;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getTipoZoom() {
        return tipoZoom;
    }

    public void setTipoZoom(String tipoZoom) {
        this.tipoZoom = tipoZoom;
    }

    public int getCams() {
        return cams;
    }

    public void setCams(int cams) {
        this.cams = cams;
    }

    public boolean isFlash() {
        return flash;
    }

    public void setFlash(boolean flash) {
        this.flash = flash;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "resolucion='" + resolucion + '\'' +
                ", tipoLente='" + tipoLente + '\'' +
                ", zoom=" + zoom +
                ", tipoZoom='" + tipoZoom + '\'' +
                ", cams=" + cams +
                ", flash=" + flash +
                '}';
    }
}
