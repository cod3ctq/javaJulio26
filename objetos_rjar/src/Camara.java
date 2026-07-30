public class Camara {

    String resolucion; //HD FULL 2k 3
    String tipoLente;
    int zoom;
    String tipoZomm;
    int cams;
    boolean flash;

    public Camara(String resolucion, String tipoLente, int zoom, String tipoZomm, int cams, boolean flash) {
        this.resolucion = resolucion;
        this.tipoLente = tipoLente;
        this.zoom = zoom;
        this.tipoZomm = tipoZomm;
        this.cams = cams;
        this.flash = flash;
    }

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

    public String getTipoZomm() {
        return tipoZomm;
    }

    public void setTipoZomm(String tipoZomm) {
        this.tipoZomm = tipoZomm;
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

    @Override
    public String toString() {
        return "Camara{" +
                "resolucion='" + resolucion + '\'' +
                ", tipoLente='" + tipoLente + '\'' +
                ", zoom=" + zoom +
                ", tipoZomm='" + tipoZomm + '\'' +
                ", cams=" + cams +
                ", flash=" + flash +
                '}';
    }

    public void setFlash(boolean flash) {
        this.flash = flash;


    }
}
