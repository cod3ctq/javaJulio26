//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Las clases tambien sirven para declarar objetos personalizados

        //Instanciar un objeto (vacio) de la clase Tablet
        Tablet t1 = new Tablet();

        //Instanciar un objeto (lleno) desde el inicio, se deben colocar los datos en orden y respetando el tipo de dato que son)
        Tablet t2 = new Tablet(11.3, "Negro", "Rectangulo", 230.00, 7500.00, "Samsung", 8, "Android");

        Tablet t3 = new Tablet(); //Esta vez vamos a asignarle atributos a un objeto vacio
        System.out.println("T3: "+t3);

        //Asignamos atributos llamando los metodos Setter
        t3.setTamaño(7.5);
        t3.setColor("Rojo");
        t3.setPeso(750.00);
        t3.setMarca("GHIA");
        t3.setPrecio(500);
        t3.setSistemaOperativo("Android 8");
        t3.setForma("Rectangulo");
        t3.setRam(4);

//        //Imprimir el estado del objeto
//        System.out.println("T1: "+t1); //Permite ver el estado del objeto
//        System.out.println("T2: "+t2);
//        System.out.println();
//        System.out.println("T3: ");
//        //Extraemos un valor especifico a traves de los metodos Getter
//        System.out.println(t3.getPrecio());
//        System.out.println(t3.getTamaño());
//        System.out.println(t3.getColor());
//        System.out.println(t3.getSistemaOperativo());
//        System.out.println(t3.getRam());
//        System.out.println(t3.getPeso());
//        System.out.println(t3.getMarca());
//        System.out.println(t3.getForma());

        EquiposF1 ferrari = new EquiposF1();
        ferrari.setEquipo("Ferrari");
        ferrari.setPiloto1("Charles Leclerc");
        ferrari.setPiloto2("Lewis Hamilton");
        ferrari.setSede("Italia");
        ferrari.setPuntos(307);
        ferrari.setVictoria(true);
        ferrari.setPrimerCarrera(1950);

        EquiposF1 mercedes = new EquiposF1("Mercedes", "Kimi Antonelli", "George Russell", "Alemania", 379, 1954, true);

        System.out.println(ferrari.getEquipo());
        System.out.println(ferrari.getPiloto1());
        System.out.println(ferrari.getPiloto2());
        System.out.println(ferrari.getSede());
        System.out.println(ferrari.getPuntos());
        System.out.println(ferrari.getPrimerCarrera());
        System.out.println(ferrari.isVictoria());
        System.out.println("\n"+mercedes);

        //Objeto con composicion
        //Se deben inicializar los atributos que son otros objetos para despues usarlos como atributo en su objeto mas grande
        String [] apps = {"Opera", "Facebook", "Whatsapp", "YouTube", "Telegram", "Galeria", "Instagram", "Calendario"};
        Camara cam = new Camara("4K", "Macro", 100, "Optico", 1, true);
        Tablet t4 = new Tablet(14.5, "azul", "rectangular", 800.00, apps, 4000, cam, "Huawei", 8, "Harmony OS");

        System.out.println("\n"+t4);





    }
}