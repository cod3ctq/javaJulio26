package paquete1;

public class claseUno {

    private String primerAtributo;
    protected int segundoAtributo;
    public String tercerAtributo;

    public claseUno() { }

    public claseUno(String primerAtributo, int segundoAtributo, String tercerAtributo) {
        this.primerAtributo = primerAtributo;
        this.segundoAtributo = segundoAtributo;
        this.tercerAtributo = tercerAtributo;
    }

    public String getPrimerAtributo() {
        return primerAtributo;
    }

    public void setPrimerAtributo(String primerAtributo) {
        this.primerAtributo = primerAtributo;
    }

    public int getSegundoAtributo() {
        return segundoAtributo;
    }

    public void setSegundoAtributo(int segundoAtributo) {
        this.segundoAtributo = segundoAtributo;
    }

    public String getTercerAtributo() {
        return tercerAtributo;
    }

    public void setTercerAtributo(String tercerAtributo) {
        this.tercerAtributo = tercerAtributo;
    }

    @Override
    public String toString() {
        return "claseUno{" +
                "primerAtributo='" + primerAtributo + '\'' +
                ", segundoAtributo=" + segundoAtributo +
                ", tercerAtributo='" + tercerAtributo + '\'' +
                '}';
    }
}
