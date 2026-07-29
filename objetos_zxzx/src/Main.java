public class Main {
    public static void main(String[] args) {

        //Instanciar un objeto(vacio) de la clase Tablet
        Tablet t1 = new Tablet();

        //Instanciar un objeto lleno desde el inicio
        Tablet t2 = new Tablet(11.3,"Negro","Rectangulo",230.00,
                7500.00,"Samsung", 8,"Android");

        //imprime el estado del objeto
        System.out.println(t1); //POR QUE ESTA VACIO ?

        //Asigar valores individualmente a los atributos del objeto vacio
        //setters
        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GHIA");
        t1.setPrecio(500.00);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("Rectangular");
        System.out.println(t1);

        //Extraer un valor especifico del objeto a traves de los
        //getters
        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());
        //Objeto con composicion

        Aplicacion a1 = new Aplicacion("Facebook", "Redes Sociales","1.15",50.6,true);
        Aplicacion a2 = new Aplicacion("Galeria", "Aplicacion de sistema","3.28",20.6,true);
        Aplicacion a3 = new Aplicacion("Spotify", "Streaming","60.15",200.6,false);

        Aplicacion[] apps = {a1, a2, a3};

        Camara cam = new Camara("4K","Macro",
                100,"Optico",1, true);
        Tablet t3 = new Tablet(14.5,"Azul","Rectangular",
                800.00,apps,cam,4000.00, "Huawei",
                8,"Harmony OS");
        System.out.println(t3);
    }
}