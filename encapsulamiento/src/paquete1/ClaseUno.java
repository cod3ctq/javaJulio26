package paquete1;

public class ClaseUno {

    private String primeratributo;
    protected int segundoatributo;
    public String terceratributo;

    public ClaseUno(String primeratributo, int segundoatributo, String terceratributo) {
        this.primeratributo = primeratributo;
        this.segundoatributo = segundoatributo;
        this.terceratributo = terceratributo;
    }

    public String getPrimeratributo() {
        return primeratributo;
    }

    public void setPrimeratributo(String primeratributo) {
        this.primeratributo = primeratributo;
    }

    public int getSegundoatributo() {
        return segundoatributo;
    }

    public void setSegundoatributo(int segundoatributo) {
        this.segundoatributo = segundoatributo;
    }

    public String getTerceratributo() {
        return terceratributo;
    }

    public void setTerceratributo(String terceratributo) {
        this.terceratributo = terceratributo;
    }

    @Override
    public String toString() {
        return "ClaseUno{" +
                "primeratributo='" + primeratributo + '\'' +
                ", segundoatributo=" + segundoatributo +
                ", terceratributo='" + terceratributo + '\'' +
                '}';
    }
}
