//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    //Instanciar un objeto (vacio) de la calse Tablet
    Tablet t1 = new Tablet();
    //Instanciar un objeto lleno desde el principio
    Tablet t2 = new Tablet(11.3, "negro", "Rectangular", 230.00,7500.00,
            "Samsung", 8, "Android" );

    //imprime el estado del objeto
        System.out.println(t1);// POR QUE ESTA VACIO?
        //asignar valores individualmente a los atributos del objeto vacio ////usando los SETTERS/////
        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GHIA");
        t1.setPrecio(500.00);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("Rectangular");
        System.out.println(t1);

        //Extraer un valor especifico del objeto a traves de los getters
        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());
        //System.out.println(t2);

        Sudadera s1 = new Sudadera();
        Sudadera s2 = new Sudadera("negro","XCH","ADIDAS","CARITA FELIZ",1200,"CORTA",false, "DEPORTIVA");
        System.out.println(s1);
        System.out.println(s2);

        s1.setMarca("Nike");
        System.out.println(s1);

        //OBJETO CON COMPOSICION: YA QUE AGREGAMOS EN EL OBJETO DE CAMARA Y EL ARRAY DE APLICACIONES
        String[] apps = {"Opera","Facebook","Whatsapp","YouTube", "Telegram", "Galeria", "Instagram", "Calendario"};
        Camara cam = new Camara("4K","Macro",100,"Optico",1, true);
        Tablet t3 = new Tablet(14.5,"azul","rectangular",800.00,apps,cam,4000,"Huawei",8, "Harmony OS");
        System.out.println(t3);
    }
}