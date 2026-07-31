public class Main {
    public static void main(String[] args) {




    /*
    No es posible insyanciar directamente a una clase abstracta
    PrestamoBancario pb = new PrestamoBancario();
    pb.calcularMensualidad();
    */


    /*
    Objeto de clase hija, reutiliza el codigo heredado a travez
    de este objeto accedo a los metodos que inicialmente
    eran abstractos, ahora ya aqui tiene una logica particular
    */
        PrestamoPersonal pp = new PrestamoPersonal("", 70000,
                24, 12, 64000, "yomero",
                5.00, "calle 30 sur", true);

        pp.calcularMensualidad();
        pp.calcularInteres();


        PrestamoAutomovil pa = new PrestamoAutomovil("", 400000, 60, 10,
                385000, "pepe", 10000, false);


    }
}