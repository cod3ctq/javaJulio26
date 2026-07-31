public class Main {
    public static void main(String[] args) {

        String [] apps = {"Whatsapp","Instagram","FaceTime","Safari","Youtube", "Apple Music", "Apple TV"};
        Iphone o1 = new Iphone
                (
                        "11",
                        "Lightning",
                        64,
                        apps,
                        15
                );
        Iphone o2 = new Iphone
                (
                        "15 Pro Max",
                        "USB C",
                        256,
                        apps,
                        26
                );
        Iphone o3 = new Iphone
                (
                        "13 pro",
                        "Lightning",
                        256,
                        apps,
                        26
                );
        Iphone o4 = new Iphone
                (
                        "X",
                        "Lightning",
                        128,
                        apps,
                        18
                );
        //Verificar el valor del fabricante y sistema operativo en cualquiera de los objetos
        /*System.out.println
                (
                                o1.getModelo() + o1.getSistemaOperativo() + "\n" +
                                o2.getSistemaOperativo() + "\n" +
                                o3.getSistemaOperativo() + "\n" +
                                o4.getSistemaOperativo() + "\n" +
                                o1.getFabricante() + "\n" +
                                o2.getFabricante() + "\n" +
                                o3.getFabricante() + "\n" +
                                o4.getFabricante()
                );*/
        //Alterar el valor estatico de una instancia en particular
        /*o3.setSistemaOperativo("Maemo");
        o3.setFabricante("Sony");

        System.out.println
                (
                                o3.getSistemaOperativo() + "\n" +
                                o3.getFabricante()
                );*/
        //final: ¿Cuales son sus 3 niveles de accion y que hacen?
        /*
        1.- Atributo : crea CONSTANTES
        2.- Metodo : Impedir la sobreescritura
        3.- Clase : Bloquear al herencia
        */
        //Ahora como llamar a SO y fabricante
        //Se debe llamar a traves de la clase
        System.out.println(Iphone.SISTEMA_OPERATIVO);
        //Se puede hacer asi pero no se recomienda -> System.out.println(o1.SISTEMA_OPERATIVO); -> desde un objeto
        //Alterar el valor estatico de una instancia en particular
        //ya no es posible si se ha declarado como CONSTANTE (final) <> o1.SISTEMA_OPERATIVO = "iOS" -> XX
        //-----------------------------------------------------------------------------------------

        CajaCobro c1 = new CajaCobro(1, "Luis", 0.0, 0);
        CajaCobro c2 = new CajaCobro(2, "Sara", 0.0, 0);
        CajaCobro c3 = new CajaCobro(3, "Gabriela", 0.0, 0);

        c1.registrarVenta(500);
        c2.registrarVenta(120);
        c3.registrarVenta(900);
        c1.registrarVenta(854);
        c2.registrarVenta(132);
        c3.registrarVenta(80);
        c1.registrarVenta(1000);
        c2.registrarVenta(3000);
        c3.registrarVenta(534);
        c1.registrarVenta(578);
        c2.registrarVenta(800);
        c3.registrarVenta(652);
        c1.registrarVenta(1357);
        c2.registrarVenta(5000);
        c3.registrarVenta(6521);
        c1.registrarVenta(8923);
        c2.registrarVenta(5000);
        c3.registrarVenta(67);
        c1.registrarVenta(951);
        c2.registrarVenta(56);
        c3.registrarVenta(300);
        c1.registrarVenta(200);
        c2.registrarVenta(400);
        c3.registrarVenta(301);
        c1.registrarVenta(2132);
        c2.registrarVenta(132);
        c3.registrarVenta(341);
        c1.registrarVenta(451);
        c2.registrarVenta(621);
        c3.registrarVenta(412);
        //Compartidos
        c1.registrarVenta(500);
        c2.registrarVenta(120);
        c1.registrarVenta(900);
        c3.registrarVenta(123);
        c1.registrarVenta(983);
        c3.registrarVenta(2300);
        c1.registrarVenta(290);
        c2.registrarVenta(134);
        c2.registrarVenta(985);
        c1.registrarVenta(2354);
        c3.registrarVenta(847);
        c2.registrarVenta(436);
        c2.registrarVenta(384);
        c1.registrarVenta(500);
        c1.registrarVenta(500);
        c3.registrarVenta(9482);
        c2.registrarVenta(500);
        c2.registrarVenta(500);
        c1.registrarVenta(843);
        c3.registrarVenta(362);
        c1.registrarVenta(746);
        c3.registrarVenta(535);
        c2.registrarVenta(200);
        c1.registrarVenta(853);
        c3.registrarVenta(500);
        c1.registrarVenta(380);
        c3.registrarVenta(472);
        c1.registrarVenta(500);
        c3.registrarVenta(884);
        c2.registrarVenta(845);
        c1.registrarVenta(484);
        c2.registrarVenta(894);

        //CajaCobro.getTotalGlobal() -> invocando al metodo a partir nde la clase directamente
        //c1 c2 c3 getTotalPorCaja() -> Invocando a un metodo de instancia, necesito hacerlo a partir de una instancia en particular
        System.out.println
                (
                                "Total ($$) global: " + CajaCobro.getTotalGlobal() + "\n" +
                                "Total ($$) Caja 1: " + c1.getTotalPorCaja() + " en: " + c1.getVentasCobradas() + "\n" +
                                "Total ($$) Caja 2: " + c2.getTotalPorCaja() + " en: " + c2.getVentasCobradas() + "\n" +
                                "Total ($$) Caja 3: " + c3.getTotalPorCaja() + " en: " + c3.getVentasCobradas()
                );
    }
}