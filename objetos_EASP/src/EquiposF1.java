public class EquiposF1 {

    String equipo;
    String piloto1;
    String piloto2;
    String sede;
    int puntos;
    int primerCarrera;
    boolean victoria;

    public EquiposF1(){}

    public EquiposF1(String equipo, String piloto1, String piloto2, String sede, int puntos, int primerCarrera, boolean victoria) {
        this.equipo = equipo;
        this.piloto1 = piloto1;
        this.piloto2 = piloto2;
        this.sede = sede;
        this.puntos = puntos;
        this.primerCarrera = primerCarrera;
        this.victoria = victoria;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPiloto1() {
        return piloto1;
    }

    public void setPiloto1(String piloto1) {
        this.piloto1 = piloto1;
    }

    public String getPiloto2() {
        return piloto2;
    }

    public void setPiloto2(String piloto2) {
        this.piloto2 = piloto2;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPrimerCarrera() {
        return primerCarrera;
    }

    public void setPrimerCarrera(int primerCarrera) {
        this.primerCarrera = primerCarrera;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }

    @Override
    public String toString() {
        return "EquiposF1{" +
                "equipo='" + equipo + '\'' +
                ", piloto1='" + piloto1 + '\'' +
                ", piloto2='" + piloto2 + '\'' +
                ", sede='" + sede + '\'' +
                ", puntos=" + puntos +
                ", primerCarrera=" + primerCarrera +
                ", victoria=" + victoria +
                '}';
    }
}
