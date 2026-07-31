//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //No es posible instanciar directamente una clase abstracta
        //PrestamoBancario pb = new PrestamoBancario();
        //pb.calcularMensualidad();

        //Objeto de clase hija, reutilizando el cógio heredado.
        //A través de este objeto accedo a los métodos que inicialmente eran abstractos, ahora ya aquí tiene una
        //lógica particular.
        PrestamoPersonal pp = new PrestamoPersonal("MX001",70000,24,12,
                64000,"Yo Mero",5,"Calle 30 sur",true);

        pp.calcularMensualidad();
        pp.calcularInteres();

        PrestamoAutomovil pa = new PrestamoAutomovil("MDJFI345",400000,60,10,
                385000,"Pepito",10000,false);

        pa.calcularMensualidad();
        pa.calcularInteres();

        System.out.println("\nMensualidad préstamo personal: "+pp.calcularMensualidad());
        System.out.println("Mensualidad préstamo automóvil: "+pa.calcularMensualidad());
        System.out.println("\nInteres préstamo personal: "+pp.calcularInteres());
        System.out.println("Interes préstamo automóvil: "+pa.calcularInteres());

    }
}