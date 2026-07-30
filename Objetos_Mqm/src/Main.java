//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Instanciar un objeto vacio de la clase tablet
        //clase objeto = operador(new vacio) constructor
        Tablet t1 = new Tablet();
        //instanciar un objeto lleno desde el inicio
        Tablet t2 = new Tablet(11.5,"Negro","Rectangular",230.00,7500,
                "Samsung",8,"Android");

        //imprime el estado del objeto
        //System.out.println(t1);
        //imprime el estado del objeto lleno
        //System.out.println(t2);

        //asignar valores individualmentea los atributos del objeto vacio
        //setters
        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GHIA");
        t1.setPrecio(500.00);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("rectangular");
        System.out.println(t1);

        //extraer un valor especificodel objeto a traves de los getters
        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());

        //objeto con composicion
        //se declara el array con sus atributos antes de llamarlo en el objeto t3
        String[]apps ={"Opera","Facebook","Whatsapp","Youtube",
                "Telegram","Galeria","Instargam","Calendario"};
        //al igual que camara, las aplicaciones contienen atributos propios por
        // cada aplicacion por lo que se define como una clase
        Aplicacion a1 = new Aplicacion("Facebook", "Redes Sociales","1.15",50.6,true);
        Aplicacion a2 = new Aplicacion("Galeria", "Aplicacion de sistema","3.28",20.6,true);
        Aplicacion a3 = new Aplicacion("Spotify", "Streaming","60.15",200.6,false);

        Aplicacion[] apps = {a1, a2, a3};

        //de igual forma para el objeto / clase camara
        Camara cam = new Camara("4k","Macro",100,
                "Optico",1,true);
        Tablet t3 = new Tablet(14.5,"Azul","Rectangular",
                800.00,apps,cam,4000.00, "Huawei",8,"Harmony Os");
        System.out.println(t3);
    }
}