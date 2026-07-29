//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //objeto de la clase  padre
        Boleto b1 = new Boleto("AO1" ,"12/07/2006",100.00);
        System.out.println(b1.getFolio());
        System.out.println(b1.getFecha());
        System.out.println(b1.getPrecio());
        System.out.println(b1);

        //objeto de la clase hija
        BoletoConcierto bc = new BoletoConcierto("a02","19/10/2017" , 100.00, "cocaflow" , "CSDMX" ,"Corona" ,"rictk master");
        BoletoAvion ba = new BoletoAvion("a02","19/10/2017" , 600.00,"CDMX","Barcelona","F30","t1",
                "6:99","22:00","juanito perez",7.5);
        BoletoEstacionamiento be = new BoletoEstacionamiento("a02","19/10/2017" , 100.00,"9:20","kmd-1708",5.00 ,"12,19");

        //Invocando a los miembros heredados (desde cualquier objeto de las clases hijas)
        System.out.println("Boleto concierto");
        System.out.println(bc.getFecha());
        System.out.println(bc.getFolio());
        System.out.println(bc.getPrecio());
        System.out.println("Boleto Avion");
        System.out.println(ba.getFecha());
        System.out.println(ba.getFolio());
        System.out.println(ba.getPrecio());
        System.out.println();
        System.out.println(be.getFecha());
        System.out.println(be.getFolio());
        System.out.println(be.getPrecio());
    }
}