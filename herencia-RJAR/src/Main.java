public class Main {
    public static void main(String[] args) {
         //objeto de la clase padre
        Boleto b1= new Boleto("A01","12/09/2006",100.00);
//        System.out.println(b1.getFecha());
//        System.out.println(b1.getFolio());
//        System.out.println(b1.getPrecio());
        System.out.println(b1);
//
//        //opbjeto de la clase hija
        BoletoConcierto bc=new BoletoConcierto("A02","19/10/2017",5000.00,
                "Corona Capital","General","Juanito Perez","TicketMaster");

        BoletoAvion ba= new BoletoAvion("A02","19/10/2017",3000.00,"CDMX",
                "Barcelona","F30","T1","06:00","22:00","Juanito Perez", 7.5);

        BoletoEstacionamiento be = new BoletoEstacionamiento("DJSM01","22/10/2023",
                5.00,"09:20","kMD-02-HG",5.00,"12:18");

        //iNVOCANDO A LOS MIEMBROS HEREDADOS (desde cualquier objeto de las clases hijas)
        System.out.println("Boleto Concierto");
        System.out.println(bc.getFecha());
        System.out.println(bc.getFolio());
        System.out.println(bc.getPrecio());
        System.out.println("Boleto Avion");
        System.out.println(ba.getFecha());
        System.out.println(ba.getFolio());
        System.out.println(ba.getPrecio());
        System.out.println("Boleto Estacionamiento");
        System.out.println(be.getFecha());
        System.out.println(be.getFolio());
        System.out.println(be.getPrecio());

//invocar a los miembros propios de cada objeto
        System.out.println("CONCIERTO");
        bc.setEvento("Tecate PalNorte");
        bc.setEmpresa("TicketMaster ACME");
        bc.setZona("Gadas");

        System.out.println("AVION");
        ba.setOrigen("MTY");
        ba.setDestino("Cancun");
        ba.setTerminal("T05");
        ba.setKilosDocumentados(10);

        System.out.println("ESTACIONAMIENTO");
        be.setPrecioHora(10.00);
        be.setPlacas("YHA-71-DT");
        be.setHoraSalida("15:18");
    //Desde un objeto de la clase Padre, no es posible acceder a los miembros de las clases hijas


    }
    }
