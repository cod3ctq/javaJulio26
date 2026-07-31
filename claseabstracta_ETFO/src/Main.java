public class Main {
    public static void main(String[] args) {

        //No es posible instanciar directamente ua clase abstracta
        //PrestamoBancario pb = new PrestamoBancario();
        //pb.calcularMensualidad();


        //Objeto de la clase hija, reutilizando el codigo herdado
        //a traves de este objeto accedo a los metodos que incialmente
        //eran abstractos, ahora ya aqui tiene una logica particular
        PrestamoPersonal pp = new PrestamoPersonal
                (
                        "MX001",
                        70000,
                        24,
                        12,
                        64000,
                        "yomero",
                        5.00,
                        "calle 30 sur",
                        true
                );
        System.out.println("Mensualidad prestamo persona: " + pp.calcularMensualidad());
        System.out.println("Interes prestamo persona: " + pp.calcularInteres());

        PrestamoAutomovil pa = new PrestamoAutomovil
                (
                        "",
                        400000,
                        60,
                        10,
                        385000,
                        "pepito",
                        10000,
                        false
                );
        System.out.println("Mensualidad prestamo automovil: " + pa.calcularMensualidad());
        System.out.println("Interes prestamo automovil: " + pa.calcularInteres());
    }
}