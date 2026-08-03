//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //no es posible instanciar directamente una clase abstracta
//        PrestamoBancario pb =new PrestamoBancario();
//        pb.calcularMensualidad();

        //objeto de clase hoja, reutilizando el codigo heredado
        //a traves de este objeto accedo a los metodos que inicialmente eran abstractos,
        //ahora aqui ya tiene una logica particular
        PrestamoPersonal pp = new PrestamoPersonal("MX001",70000,24,
                12, 64000,"yomero",5.00,
                "Calle 30 sur",true);

        pp.calcularMensualidad();
        pp.calcularInteres();

        PrestamoAutomovil pa = new PrestamoAutomovil("MX478HS",400000,60,
                10,385000,"Pepito",
                10000,false);

        pa.calcularInteres();
        pa.calcularMensualidad();

        System.out.println("Mensualidad prestamo personal: "+pp.calcularMensualidad());
        System.out.println("Mensualidad prestamo automovil: "+pa.calcularMensualidad());
        System.out.println("Interes prestamo personal: "+pp.calcularInteres());
        System.out.println("Interes prestamo automovil: "+pa.calcularInteres());
    }
}