public class Main {
    public static void main(String[] args) {


//        //No es posible istanciar directamente a una clase anstracta
//        PrestamoBancario pb= new PrestamoBancario();
//        pb.calcularMensualidad();

        //Objeto de clase hija, reutilizando el codigo heredado
        //a traves de este objeto accedo a los metodos que inicialmente
        //eran abstractos, ahora ya aqui tiene logica particular
        PrestamoPersonal pp=new PrestamoPersonal("MX001",70000,24,12,64000,
                "YO",5.00,"Calle 30 Sur", true);


        PrestamoAutomovil pa=new PrestamoAutomovil("MX478HS",
                400000,60,10,
                385000,"Pepito",
                10000,false);
    pp.calcularMensualidad();
    pp.calcularInteres();

        pa.calcularMensualidad();
        pa.calcularInteres();

        System.out.println("Mensualidad prestamo:"+pp.calcularMensualidad());
        System.out.println("Mensualidad prestamo:"+pa.calcularMensualidad());
        System.out.println("Interes prestamo personal:"+pp.calcularMensualidad());
        System.out.println("Interes prestamo personal:"+pa.calcularMensualidad());

    }
}