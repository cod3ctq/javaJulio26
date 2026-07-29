//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de la clase padre
        Boleto b1 = new Boleto("A01", "12/06/2026",100);
        System.out.println(b1.getFecha());
        System.out.println(b1.getFolio());
        System.out.println(b1.getPrecio());
        System.out.println(b1);

        //objetos de la clase hija
        BoletoConcierto bc = new BoletoConcierto("A02","19/10/2017",3000.00,"Corona Capital",
                "General","Juanito Perez","TicketMaster");
        BoletoAvion ba = new BoletoAvion();
        BoletoEstacionamiento be = new BoletoEstacionamiento("DJSM01", "22/03/2023",5.00, "09:20","KMD-02-HG",5.00,"12:18");

        System.out.println("Boleto CONCIERTO:");
        System.out.println(bc.getFecha());
        System.out.println(bc.getFolio());
        System.out.println(bc.getPrecio());

        System.out.println("Boleto AVION:");
        System.out.println(ba.getFecha());
        System.out.println(ba.getFolio());
        System.out.println(ba.getPrecio());

        System.out.println("Boleto ESTACIONAMIENTO:");
        System.out.println(be.getFecha());
        System.out.println(be.getFolio());
        System.out.println(be.getPrecio());

        System.out.println(bc.getEvento());
        System.out.println(bc.getEmresa());
        System.out.println(bc.getNombre());

        //INVOCAR A LOS MIEMBROS PROPIOS DE CADA OBJETO:
        System.out.println("BOLETO");
        bc.setEvento("tecate PalNorte");
        bc.setEmresa("TicketMaster acme");
        bc.setZona("gradas");

        System.out.println("AVION");
        ba.setOrigen("MTY");
        ba.setDestino("CANCUN");
        ba.setTerminal("T50");
        ba.setKilosDocumentados(10);

        System.out.println("ESTACIONAMIENTO");
        be.setPrecioHora(10);
        be.setPlacas("YHA-71-DT");
        be.setHoraSalida("15:18");
        System.out.println(be);

        //No se puede acceder a los miembros de la clase hija desde un objeto de la clase padre,
        // ya que las hijas no heredan sus datos al padre. P/E:
        //b1.setPlacas("TDH-63-DT");
        //b1.setPrecioHora("");
        

    }
}