//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de la clase padre
        Boleto b1 = new Boleto("A01","19/09/2006",100.00);
//        System.out.println(b1.getFecha());
//        System.out.println(b1.getFolio());
//        System.out.println(b1.getPrecio());
//        System.out.println(b1);

        //objetos de las clases hijas
        BoletoConcierto bc = new BoletoConcierto("A02","19/10/2017",3000.00,
                "Corona Capital","General",
                "Juanito Perez","TicketMaster");

        BoletoAvion ba = new BoletoAvion("E12","19/10/2014",5000.00,"CDMX",
                "BARCELONA","F30","T1","06:00",
                "22:00","JUANITO PEREZ",7.5);

        BoletoEstacionamiento be =new BoletoEstacionamiento("DJSM01","22/03/2023",
                5.00,"09:20","KMD-02-HG","5.00","12:18");

//        System.out.println(bc.getFecha());
//        System.out.println(bc.getFolio());
//        System.out.println(bc.getPrecio());
//        //llamar los atributos propios de la clase hija
//        System.out.println(bc.getEvento());
//        System.out.println(bc.getEmpresa());
//        System.out.println(bc.getNombre());

        //invocar a los miembros heredados
        //desde cualquier objeto de las clases hijas
        //llamando los atributos con los getters
        System.out.println("Boleto concierto");
        System.out.println(bc.getFecha());
        System.out.println(bc.getFolio());
        System.out.println(bc.getPrecio());

        System.out.println("Boleto avion");
        System.out.println(ba.getFecha());
        System.out.println(ba.getFolio());
        System.out.println(ba.getPrecio());

        System.out.println("Boleto estacionamiento");
        System.out.println(be.getFecha());
        System.out.println(be.getFolio());
        System.out.println(be.getPrecio());

        //invocar a los miembros propios de cada objeto
        //set agrega un valor a cada atributo
        System.out.println("CONCIERTO");
        bc.setEvento("Tecate PalNorte");
        bc.setEmpresa("TicketMaster ACME");
        bc.setZona("Gradas");

        System.out.println("AVION");
        ba.setOrigen("MTY");
        ba.setDestino("Cancun");
        ba.setTerminal("T50");
        ba.setKilosDocumentados(10);

        System.out.println("ESTACIONAMIENTO");
        be.setPrecioHora("10.00");
        be.setPlacas("YHA-71-DT");
        be.setHoraSalida("15:18");

        //desde un objeto de la clase padre no es posible
        // acceder a los miembros de las clases hijas
//        b1.setPlacas("");
//        b1.setPrecioHora("");
//        b1.setDestino("");
//        b1.setEvento("");

    }
}