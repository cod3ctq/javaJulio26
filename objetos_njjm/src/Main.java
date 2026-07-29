//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Instanciar un objeto (vacío) de la clase Tablet
        Tablet t1 = new Tablet();

        // Instanciar un objeto lleno desde el inicio
        Tablet t2 = new Tablet(11.3,"Negro","Rectángulo",230.00,7500.00,"Samsung",
                8,"Android");

        //Imprime el estado del objeto
        System.out.println(t1); //¿Por qué está vacío?

        //Asignar valores individualmente a los atributos del objeto vacío
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

        //Extraer un valor específico del objeto a través de los getters
        System.out.println(t1.getPrecio());
        System.out.println(t2.getTamaño());
        System.out.println(t1.getMarca());

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Instanciar un objeto (vacío) de la clase Auto
        Auto a1 = new Auto();

        // Instanciar un objeto lleno desde el inicio
        Auto a2 = new Auto("Azul","Chevrolet","Groove",2022,350000.00,1.5,"Gasolina","Automático","SUV Compacto");

        //Imprime el estado del objeto
        System.out.println(a1); //¿Por qué está vacío?

        //Asignar valores individualmente a los atributos del objeto vacío
        //setters
        a1.setAño(2016);
        a1.setCarroceria("Sedán 4 puertas");
        a1.setCilindrada(2.0);
        a1.setColor("Rojo");
        a1.setMarca("Toyota");
        a1.setModelo("Sienna");
        a1.setPrecio(401000.00);
        a1.setTransmision("Automático");
        System.out.println("\nCaracterísticas auto 1:"+a1);
        System.out.println("\nCaracterísticas auto 1:"+a2);

        //Extraer un valor específico del objeto a través de los getters
        System.out.println(a1.getAño()+" / "+a2.getAño());
        System.out.println(a1.getCarroceria()+" / "+a2.getCarroceria());
        System.out.println(a1.getMarca()+" / "+a2.getMarca());

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Objeto con composición

        Aplicacion ap1 = new Aplicacion("Facebook","Red Social","1.2.3",35.6,true);
        Aplicacion ap2 = new Aplicacion("Instagram","Red Social","4.3.2",34.2,true);
        Aplicacion ap3 = new Aplicacion("Spotify","Música","34.3",234.2,false);


        Aplicacion[] apps = {ap1,ap2,ap3};
        Camara cam = new Camara("4K","Macro",100,"Optico",1,true);

        Tablet t3 = new Tablet(14.5,"Azul","Rectangular",800.00,apps,cam,4000.00,
                "Huawei",8,"Harmony OS");

        System.out.println(t3);

    }
}