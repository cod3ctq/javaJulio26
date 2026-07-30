//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Instanciar un objeto(vacio) de la clase Tablet

        Tablet t1 = new Tablet();

        Tablet t2 = new Tablet(11.3,"Negro","Rectangulo",230.00,
                7500, "Samsung", 8, "Android");


        //Imprime el estado del objeto
        System.out.println(t1);

        //Asginar valores individuales a los atributos del objeto vacio
        //setters
        t1.setTamaño(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GUIA");
        t1.setPrecio(500.00);
        t1.setRam(4);
        t1.setSistemaOpertivo("Android 8");
        t1.setForma("Rectangular");
        System.out.println(t1);


        //Extraer un valor especifico del objeto a trves de los
        //getters

        System.out.println(t1.getPrecio());
        System.out.println(t1.getTamaño());
        System.out.println(t1.getMarca());

        he
        //Objeto con composicion
        String[] apps = {"Opera","Facebook","Whatsaap","Youtube",
                "Telegram","Galeria","Instagram", "Calendario"};

        Camara cam = new Camara("4K", "Macro",
                100, "Optico", 1, true);

        Tablet t3 = new Tablet(14.5, "Azul", "Rectangular", 800.00,
                apps, cam, 4000, "Huawei", 8, "Harmony OS");

        System.out.println(t3);



    }
}