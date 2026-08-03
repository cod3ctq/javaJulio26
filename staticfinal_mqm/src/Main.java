//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] apps = {"Whatsapp","Instagram","FaceTime","Safari",
                "Youtube","Apple Music","Apple Tv"};
        //multiples objetos de la misma clase
        Iphone o1 =new Iphone("11","Lightninin",64,apps,15);
        Iphone o2 =new Iphone("15 Pro Max","USB C",256,apps,26);
        Iphone o3 =new Iphone("13 Pro","Lightninin",256,apps,26);
        Iphone o4 =new Iphone("X","Lightninin",128,apps,18);

        //verificar el valor del fabricante y sistema operativo en cualquiera de los objetos
//        System.out.println(o1.getSistemaOperativo());
//        System.out.println(o2.getSistemaOperativo());
//        System.out.println(o3.getSistemaOperativo());
//        System.out.println(o4.getSistemaOperativo());
//
//        System.out.println(o1.getFabricante());
//        System.out.println(o2.getFabricante());
//        System.out.println(o3.getFabricante());
//        System.out.println(o4.getFabricante());

        //alterar el valor estatico de una instancia en particular
//        o3.setSistemaOperativo("Maemo");
//        o3.setFabricante("Sony");
//
//        System.out.println(o3.getSistemaOperativo());
//        System.out.println(o3.getFabricante());

        //final: cual son sus 3 niveles de accion, que hacen
        /*
        1-atributo: crea CONSTANTES
        2-metodo: impedir sobreescritura
        3-clase: bloquea la herencia
         */

        System.out.println(o3.SISTEMA_OPERATIVO);//invocando a traves de una instancia
        //invocando directamente desde la clase (manera correcta)
        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //alterar el valor estatico de una instancia en particular
        //ya no es posible si se ha declarado como constante (ya es final)
//        o3.setSistemaOperativo("Maemo");
//        o3.setFabricante("Sony");



        //----------------------------------------------------------
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

        //invocando al metodo estatico a partir de la clase directamente
//        System.out.println("Total ($$) global: "+CajaCobro.getTotalGlobal());
//
//        //invocando a un metodo de instancia, necesito hacerlo a partir de
//        //una instancia en particular
//        System.out.println("Total ($$) caja 1: "+c1.getTotalPorCaja()+" en: "
//                +c1.getVentasCobradas());
//        System.out.println("Total ($$) caja 1: "+c2.getTotalPorCaja()+" en: "
//                +c2.getVentasCobradas());
//        System.out.println("Total ($$) caja 1: "+c3.getTotalPorCaja()+" en: "
//                +c3.getVentasCobradas());
    }
}