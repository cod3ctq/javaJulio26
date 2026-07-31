public class Main {
    public static void main(String[] args) {

//        //No se puede instanciar directamente una clase abstracta
//        PrestamoBancario pb = new PrestamoBancario();

        //Objeto de clase hija, reutilizando el codigo heredado
        //a traves de este objeto accedo a los metodos que inicialmente eran abstractos, ahora aqui ya tienen una logica particular
        PrestamoPersonal pp = new PrestamoPersonal("MX0001", 70000.00, 24, 12, 64000,
                "Yomero", 5.00, "Calle X", true);

        PrestamoAutomovil pa = new PrestamoAutomovil("MX0002", 400000.00, 60, 10, 385000, "Pepito", 10000, false);

        pp.calcularMensualidad();
        pp.calcularInteres();

        pa.calcularInteres();
        pa.calcularMensualidad();

        System.out.println("Mensualidad prestamo personal: "+pp.calcularMensualidad());
        System.out.println("Mensualidad prestamo automovil: "+pa.calcularMensualidad());
        System.out.println("Interes prestamo personal: "+pp.calcularInteres());
        System.out.println("Interes prestamo automovil: "+pa.calcularInteres());



    }
}