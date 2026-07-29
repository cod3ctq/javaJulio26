public class Main {
    public static void main(String[] args) {

        //Objeto de la clase padre
        Boleto b1 = new Boleto("A01", "12/08/2006", 100.00);
        System.out.println
                (
                        b1.getFecha() + "\n" +
                        b1.getFolio() + "\n" +
                        b1.getPrecio()
                );
        System.out.println(b1);

        //Objeto de la clase hija
        BoletoConcierto bc = new BoletoConcierto
                (
                        "A02",
                        "27/07/2003",
                        3000,
                        "Corona Capital",
                        "General",
                        "Juanito Perez",
                        "Ticketmaster"
                );
        BoletoAvion ba = new BoletoAvion
                (
                        "A02",
                        "19/10/2016",
                        5000.00,
                        "CDMX",
                        "Barcelona",
                        "F30",
                        "T1",
                        "6:00",
                        "22:00",
                        "Juanito Perez",
                        7.5
                );
        BoletoEstacionamiento be = new BoletoEstacionamiento
                (
                        "A02",
                        "29/07/2026",
                        5,
                        "09:20",
                        "DJSM01",
                        5,
                        "12:18"
                );
        //Invocando a los miembros heredaros (Folio, Precio y Fecha) desde cualquier objeto de las clases hijas
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
        //Invocar a los miembros propios de cada objeto
        System.out.println("BOLETO");
        bc.setEvento("Tecate PalNorte");
        bc.setEmpresa("Ticketmaster ACME");
        bc.setZona("Gradas");

        System.out.println("AVION");
        ba.setOrigen("MTY");
        ba.setDestino("Cancun");
        ba.setTerminal("T50");
        ba.setKiloDocumentos(10);

        System.out.println("ESTACIONAMIENTO");
        be.setPrecioHora(10.00);
        be.setPlacas("YHA-71-DT");
        be.setHoraSalida("15:18");
        /* //Desde un objeto de la clase padre, NO ES POSIBLE ACCEDER A LOS MIEMBROS DE LAS CLASES HIJAS
        // NO ES BIDIRECCIONAL
        b1.setPlacas("XML-10-L2");
        b1.setPrecioHora("");
        b1.setDestino();
        b1.setEvento();
        */
        /*System.out.println
                (
                        bc.getFecha() + "\n" +
                        bc.getFolio() + "\n" +
                        bc.getPrecio() + "\n" +

                        bc.getEvento() + "\n" +
                        bc.getZona() + "\n" +
                        bc.getEmpresa() + "\n" +
                        bc.getPrecio()
                );
        */
    }
}

