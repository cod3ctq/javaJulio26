//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//            Zapato z1=new Zapato();
//
//            z1.setTalla(4.5);
//            z1.setColor("Lila");
//            z1.setGenero("Dama");
//            z1.setTipo("Zapatilla");
//            z1.setPrecio(500.00);
//            z1.setMarca("Sarah");
//
//        System.out.println(z1.getTalla());
//        System.out.println(z1.getColor());
//        System.out.println(z1.getGenero());
//        System.out.println(z1.getTipo());
//        System.out.println(z1.getPrecio());
//        System.out.println(z1.getMarca());

        //Instancias un objeto vacio de la clase tablet
        Tablet t1= new Tablet();
        //Instanciar un objeto lleno desde el inicio
        Tablet t2= new Tablet(11.3,"Negro", "Rectangulo",230.00, 7500.00,"Samsung", 8, "Android");

        //imprime el estado del objeto
        System.out.println(t1); //¿POR QUE ESTA VACIO?

        //Asignar valores individualmente a los atributos del objrto vacio
        //setters
        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("Ghia");
        t1.setPrecio(500);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("Rectangular");
        System.out.println(t2);//objeto lleno

        //Extraer un valor espcifico del objeto a traves de lo sgetters
        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());

        //Objero con composicion
        String[]apps={"Opera","Facebook","Whatsapp","Youube"};
        Camara cam=new Camara("4k","MACRO",100,"OPTICO", 1,true);
        Tablet t3=new Tablet(14.5, "Azul", "Rectangular", 4000.00,"Huawei",8,"Harmony OS",apps,cam,);

            //copiado
        Aplicacion a1 = new Aplicacion("Facebook", "Redes Sociales","1.15",50.6,true);
        Aplicacion a2 = new Aplicacion("Galeria", "Aplicacion de sistema","3.28",20.6,true);
        Aplicacion a3 = new Aplicacion("Spotify", "Streaming","60.15",200.6,false);

        Aplicacion[] apps = {a1, a2, a3};

        Camara c = new Camara("4K","Macro",
                100,"Optico",1, true);
        Tablet t4 = new Tablet(14.5,"Azul","Rectangular",
                800.00,apps,cam,4000.00, "Huawei",
                8,"Harmony OS");
        System.out.println(t4);
        
    }
}