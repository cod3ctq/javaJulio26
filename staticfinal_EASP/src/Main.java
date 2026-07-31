public class Main {
    public static void main(String[] args) {

        String[] apps={"Whatsapp", "Instagram", "FaceTime", "Safari", "YouTube", "Apple Music", "Apple TV"};

        //Multiples objetos de la misma clase
        Iphone o1 = new Iphone("11", "Lightning", 64, apps, 15);

        Iphone o2 = new Iphone("15 Pro Max", "USB C", 256, apps, 26);

        Iphone o3 = new Iphone("13 Pro", "Lightning", 256, apps, 26);

        Iphone o4 = new Iphone("X", "Lightning", 128, apps, 18);

        //Verificar el valor del fabricante y sistema operativo en cualquiera de los objetos.
        //Ya no se puede llamar al valor a travez de getter
//        System.out.println("So o1: "+o1.getSistemaOperativo());
//        System.out.println("So o2: "+o2.getSistemaOperativo());
//        System.out.println("So o3: "+o3.getSistemaOperativo());
//        System.out.println("So o4: "+o4.getSistemaOperativo());
//
//        System.out.println("Fabricante o1: "+o1.getFabricante());
//        System.out.println("Fabricante o2: "+o2.getFabricante());
//        System.out.println("Fabricante o3: "+o3.getFabricante());
//        System.out.println("Fabricante o4: "+o4.getFabricante());
//        System.out.println("Fabricante del objeto Iphone: "+Iphone.getFabricante());

        //Para invocar un valor final debe ser directamente a traves del objeto
        System.out.println("El fabricante de cada objeto de la clase Iphone es: "+Iphone.FABRICANTE);
        System.out.println("El Sistema Operativo de cada objeto de la clase Iphone es: "+Iphone.SISTEMA_OPERATIVO);

//        //Al ser valores final, ya no se pueden modificar de ninguna manera
//        o3.setSistemaOperativo("Android");
//        o3.setFabricante("Sony");
//        System.out.println(o3.getSistemaOperativo());
//        System.out.println(o3.getFabricante());
//        System.out.println("So o2: "+o2.getSistemaOperativo());
//        o3.SISTEMA_OPERATIVO = "Maemo";
//        o3.FABRICANTE = "Sony";

        //Final:
        /*
        1. Atributo: crea CONSTANTES
        2. Metodo: Impide la sobreescritura
        3. Clase: Bloquea la herencia
         */


        ///-----------------------------------------------Ejercicio Cajas---------------------------------------------------------------
        System.out.println("Ejercicio Cajas");
        CajaCobro c1= new CajaCobro(1, "Luis", 0.00, 0);
        CajaCobro c2= new CajaCobro(2, "Sara", 0.00, 0);
        CajaCobro c3= new CajaCobro(3, "Gabriela", 0.00, 0);

        c1.registraVenta(500);
        c2.registraVenta(120);
        c1.registraVenta(900);
        c3.registraVenta(123);
        c1.registraVenta(983);
        c3.registraVenta(2300);
        c1.registraVenta(290);
        c2.registraVenta(134);
        c2.registraVenta(985);
        c1.registraVenta(2354);
        c3.registraVenta(847);
        c2.registraVenta(436);
        c2.registraVenta(384);
        c1.registraVenta(500);
        c1.registraVenta(500);
        c3.registraVenta(9482);
        c2.registraVenta(500);
        c2.registraVenta(500);
        c1.registraVenta(843);
        c3.registraVenta(362);
        c1.registraVenta(746);
        c3.registraVenta(535);
        c2.registraVenta(200);
        c1.registraVenta(853);
        c3.registraVenta(500);
        c1.registraVenta(380);
        c3.registraVenta(472);
        c1.registraVenta(500);
        c3.registraVenta(884);
        c2.registraVenta(845);
        c1.registraVenta(484);
        c2.registraVenta(894);

        //Invocamos al metodo de instancia, a partir de una instancia en particular "c1, c2, c3"
        System.out.println("Total caja 1: "+c1.getTotalPorCaja());
        System.out.println("Total ventas: "+c1.getVentasCobradas());
        System.out.println("Total caja 2: "+c2.getTotalPorCaja());
        System.out.println("Total ventas: "+c2.getVentasCobradas());
        System.out.println("Total caja 3: "+c3.getTotalPorCaja());
        System.out.println("Total ventas: "+c3.getVentasCobradas());

        //Invocamos al metodo estatico directamente de la clase "CajaCobro"
        System.out.println("Total global: "+CajaCobro.getTotalGlobal());




    }
}