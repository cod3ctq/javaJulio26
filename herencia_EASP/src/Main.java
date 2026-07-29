public class Main {
    public static void main(String[] args) {

        //La herencia no solo permite que un objeto tenga los metodos y atributos de otro objeto,
        //Puede hacer que un objeto tenga especializacion

        //Objeto de la clase padre
        Boleto b1 = new Boleto("A01", "12/09/2006", 100.00);
        System.out.println(b1.getFolio()); //Propios de la clase padre
        System.out.println(b1.getFecha());
        System.out.println(b1.getPrecio());
        System.out.println(b1+"\n");

        //Objetos de las clases hijas
        BoletoConcierto bc = new BoletoConcierto("A02", "19/10/2017", 3000.00,
                                                "Corona Capital", "General", "Juanito Pérez", "TicketMaster");

        BoletoAvion ba= new BoletoAvion("A03", "20/11/2014", 5000, "CDMX", "Barcelona",
                "F03", "T1", "06:00", "22:00", "Juanito Pérez", 7.5);

        BoletoEstacionamiento be = new BoletoEstacionamiento();

        System.out.println("Boleto concierto");
        System.out.println(bc.getFolio()); //Heredados de la clase padre
        System.out.println(bc.getFecha());
        System.out.println(bc.getPrecio()+"\n");

        System.out.println(bc.getEvento()); //Propios de la clase hija
        System.out.println(bc.getEmpresa());
        System.out.println(bc.getNombre());
        System.out.println(bc.getZona());
        System.out.println(bc+"\n"+"\n");

        System.out.println("Boleto Avion");
        System.out.println(ba.getFolio()); //Heredados de la clase padre
        System.out.println(ba.getFecha());
        System.out.println(ba.getPrecio()+"\n");

        System.out.println(ba.getOrigen()); //Propios de la clase hija
        System.out.println(ba.getDestino());
        System.out.println(ba.getAsiento());
        System.out.println(ba.getTerminal());
        System.out.println(ba.getHoraLlegada());
        System.out.println(ba.getHoraSalida());
        System.out.println(ba.getCliente());
        System.out.println(ba.getKilosDocumentados()+"\n"+"\n");

        System.out.println("Boleto estacionamiento");
        be.setFolio("DJSM01");//Heredados de la clase padre
        be.setFecha("22/03/2023");
        be.setPrecio(5.00);

        be.setHoraEntrada("09:20"); //Propios de la case hija
        be.setPlacas("KMD-02-HG");
        be.setPrecioHora(5.00);
        be.setHoraSalida("12:18");

        System.out.println(be.getFolio()); //Heredados de la clase padre
        System.out.println(be.getFecha());
        System.out.println(be.getPrecio()+"\n");
        System.out.println(be.getHoraEntrada()); //Propios de la clase hija
        System.out.println(be.getPlacas());
        System.out.println(be.getPrecioHora());
        System.out.println(be.getHoraSalida()+"\n"+"\n");

//        //Desde un objeto de la clase Padre, no es posible acceder a los miembros de las clases hijas.
//        //La herencia es unidireccional Padre --> Hijas
//        b1.setPlacas();
//        b1.setPrecioHora();
//        b1.setDestino();
//        b1.setEvento();








    }
}