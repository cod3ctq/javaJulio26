
public class Main {
    public static void main(String[] args) {


        String [] apps = {"WhatsApp","Instragam","FaceTime","Safari","YouTube","Apple Music","Apple TV"};

        Iphone o1 = new Iphone("11","Lightning",64,apps,15);
        Iphone o2 = new Iphone("15 Pro Max","USB C",256,apps,26);
        Iphone o3 = new Iphone("13 Pro","Lightning",256,apps,26);
        Iphone o4 = new Iphone("X","Lightning",128,apps,18);

        //Verificar el valor del fabricante y sistema operativo en cualquiera de los objetos.
//        System.out.println(o1.getSistemaOperativo());
//        System.out.println(o2.getSistemaOperativo());
        System.out.println(o3.SISTEMA_OPERATIVO); //Invocando a través de una instancia
        System.out.println(Iphone.SISTEMA_OPERATIVO); //Invocando directamente desde la clase (mnera correcta)

        //Alterar el valor estático de una instancia en particular, ya no es posible si se ha declarado como constante
        //(final)
//        o3.SISTEMA_OPERATIVO = "Maemo";

        System.out.println(o3.getSistemaOperativo());
        System.out.println(o3.getFabricante());

        //final: cual son sus 3 niveles de acción, qué hacen

        /*
        1.Atributo: crea CONSTANTES
        2.Método: impedir la sobreescritura
        3.Clase:
         */


        //------------------------------------------------------------------------------------------------------------

        CajaCobro c1 = new CajaCobro(1,"Luis",0.0,0);
        CajaCobro c2 = new CajaCobro(2,"Sara",0.0,0);
        CajaCobro c3 = new CajaCobro(3,"Gabriela",0.0,0);

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

        //Invocando al método estático a partir de la clase directamente
        System.out.println("\nTotal goblal: $"+CajaCobro.getTotalGlobal());

        //Invocando a un método de instancia, necesito hacerlo a partir de una isntancia en particular
        System.out.println("\nTotal caja 1: $"+c1.getTotalPorCaja()+" en: "+c1.getVentasCobradas()+" ventas");
        System.out.println("Total caja 2: $"+c2.getTotalPorCaja()+" en: "+c2.getVentasCobradas()+" ventas");
        System.out.println("Total caja 3: $"+c3.getTotalPorCaja()+" en: "+c3.getVentasCobradas()+" ventas");

    }
}