public class Main {
    public static void main(String[] args) {

        //Inicializar un objeto
        Tablet t1 = new Tablet();
        Tablet t2 = new Tablet();
        System.out.println();
        //imprime el estado del objeto
        System.out.println(t1); // porque esta vacio??

        //Asignar valores individualmente a los atributos vacios
        //setters

        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GHIA");
        t1.setPrecio(500);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("Rectangulo");

        System.out.println(t1);

        //Extraer un valor especifico del objeto a travez de los
        //getters

        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());



        Coche c1 = new Coche();
        Coche c2 = new Coche();

        c1.setCategoria("suv");
        c1.setMotor("lineal 4 cilindros");
        c1.setConsumo(2.5);
        c1.setPeso(1.4);
        c1.setCapacidadCarga(60);
        c1.setPuertas(3);
        c1.setPasajeros(4);
        c1.setColor("rojo");

        System.out.println(c1);


        //objeto con composción
        Aplicacion a1 = new Aplicacion("Facebook","Redes Sociales", "1.15",50.6,true);
        Aplicacion a2 = new Aplicacion("Spotify","Streaming","60.6",200,false);

        String [] apps = {a1, a2,};
        Camara cam = new Camara("4K", "Macro",100,"optico",1,true);

        Tablet t3 = new Tablet(14.5,"Azul","Rectangular",800.00,apps,cam,4000.00,"Huawei",8,"Harmony OS");

        System.out.println(t3+"\n");




    }
}