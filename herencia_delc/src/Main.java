//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

  Boleto b1 = new Boleto("A01","12/09/2006",100.00);

        System.out.println(b1.getFecha());
        System.out.println(b1.getFolio());
        System.out.println(b1.getPrecio());

        System.out.println(b1);


        //objeto clase hija
        BoletoConcierto bc = new BoletoConcierto("A02","19/10/2017",3000.00,
                "Corona Capital","General","Juan Perez","TiketMaster");

        BoletoAvion ba =new BoletoAvion("A02","19/10/2017",5000.00,"cdmx",
                "barcelona","F30", "t1","06:00","22:00","Juan Perez",7.5);

        BoletoEstacionamiento be = new BoletoEstacionamiento("A02","19/10/2017",15.00,
                "13:00","D-1FR-52",15);

//Invocando a los miembros heredados (desde cualquier objeto de las clases hijas)
        System.out.println("Boleto concierto");
        System.out.println(bc.getFecha());
        System.out.println(bc.getFolio());
        System.out.println(bc.getPrecio());
        System.out.println("Boleto Avion");
        System.out.println(ba.getFecha());
        System.out.println(ba.getFolio());
        System.out.println(ba.getPrecio());
        System.out.println("Boleto estacionamiento");
        System.out.println(be.getFecha());
        System.out.println(be.getFolio());
        System.out.println(be.getPrecio());

    }
}