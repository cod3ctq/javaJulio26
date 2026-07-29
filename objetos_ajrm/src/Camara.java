public class Camara {

        String resolucion;
        String tipoLente;
        int zoom;
        String tipoZoom;
        int cams;
        boolean flash;



    public Camara(){}

    public Camara(String resolucion, String tipoLente, int zoom, String tipoZoom, int cams, boolean flash) {
        this.resolucion = resolucion;
        this.tipoLente = tipoLente;
        this.zoom = zoom;
        this.tipoZoom = tipoZoom;
        this.cams = cams;
        this.flash = flash;


    }
}
