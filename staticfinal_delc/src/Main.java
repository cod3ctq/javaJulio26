public class Main {
    public static void main(String[] args) {

        String[] apps = {"Whatsapp", "Instagram", "Facetime", "Safari", "Youtube", "Apple Music", "Apple Tv"};


        Iphone o1 = new Iphone("11", "lightning", 64,
                apps, 15);
        Iphone o2 = new Iphone("15 Pro MAX", "USB C", 256,
                apps, 26);
        Iphone o3 = new Iphone("13 Pro", "lightning", 256,
                apps, 26);
        Iphone o4 = new Iphone("x", "lightning", 128,
                apps, 18);

        //Verificar el valor del fabricante y sistema operativo en cualquiera de los objetos
        //System.out.println(o1.getSistemaOperativo());
        //System.out.println(o2.getSistemaOperativo());
        System.out.println(o3.SISTEMA_OPERATIVO);
        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //System.out.println(o1.getFabricante());
        //System.out.println(o2.getFabricante());
        System.out.println(o3.FABRICANTE);
        System.out.println(Iphone.FABRICANTE);

        //Alterar el valor estatico de una instancia en particular
        //o3.setSistemaOperativo("Maemo");
        //o3.setFabricante("Sony");

        //System.out.println(o3.getSistemaOperativo());
        //System.out.println(o3.getFabricante());


        //final: cual son sus 3 niveles de accion, que hacen

        /*
        Atributo: crea Constantes
        Metodo: Impedir la sobreescritura
        Clase: Bloquear la herencia
         */



//-----------------------------------------------------------------
/*
        CajaCobro c1 = new CajaCobro(1,"Luis",0.0,0);
        CajaCobro c2 = new CajaCobro(2,"Sara",0.0,0);
        CajaCobro c3 = new CajaCobro(3,"Gabriela",0.0,0);

        c3.registrarVenta(500);
        c2.registrarVenta(263);
        c1.registrarVenta(422);
        c1.registrarVenta(2900);
        c3.registrarVenta(320);
        c2.registrarVenta(741);
        c1.registrarVenta(985);
        c2.registrarVenta(356);
        c1.registrarVenta(123);
        c3.registrarVenta(756);
        c3.registrarVenta(157);
        c1.registrarVenta(647);
        c1.registrarVenta(6563);
        c1.registrarVenta(235);
        c2.registrarVenta(8642);
        c2.registrarVenta(321);
        c3.registrarVenta(645);
        c2.registrarVenta(894);
        c1.registrarVenta(212);
        c1.registrarVenta(354);
        c3.registrarVenta(745);
        c1.registrarVenta(311);
        c1.registrarVenta(114);
        c1.registrarVenta(125);
        c2.registrarVenta(245);
        c1.registrarVenta(364);
        c1.registrarVenta(123);
        c1.registrarVenta(584);
        c2.registrarVenta(345);
        c2.registrarVenta(513);
        c1.registrarVenta(987);
        c2.registrarVenta(7894);
        c1.registrarVenta(321);
        c3.registrarVenta(312);


        //invoca al objeto estatico a partir de la clase
        System.out.println("Total ($$) global: "+CajaCobro.getTotalGlobal());


        //invoca a un metodo de instancia, se hace a partir de una instancia en particular
        System.out.println("Total ($$) caja 1: "+c1.getTotalPorCaja() + " en :"+c1.getVentasCobradas());
        System.out.println("Total ($$) caja 1: "+c2.getTotalPorCaja() + " en :"+c2.getVentasCobradas());
        System.out.println("Total ($$) caja 1: "+c3.getTotalPorCaja() + " en :"+c3.getVentasCobradas());

*/

    }
}