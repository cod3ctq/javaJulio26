public class Main {
    public static void main(String[] args) {

        //Instanciar un objeto(vacio) de la clase Tablet

        Tablet t1 = new Tablet(); // --> Constructor vacio
        //double tamanio, String color, String forma, double peso, double precio, String marca, int ram, String sistemaOperativo
        //Instanciar un objeto desde el inicio
        Tablet t2 = new Tablet(11.3, "Rojo", "Rectangular", 1, 9999, "Apple", 8, "iOS");
        //Forma de los objetos: Clases, Objetos y metodos.
        //Imprimir el estado del objeto
        System.out.println(t1); // Por que esta vacio?
        //Asignar valores individualmente a los atributos del objeto vacio
        t1.setTamanio(7.5);
        t1.setColor("Rojo");
        t1.setPeso(750.00);
        t1.setMarca("GHIA");
        t1.setPrecio(500.00);
        t1.setRam(4);
        t1.setSistemaOperativo("Android 8");
        t1.setForma("Rectangulo");
        System.out.println(t1);
        System.out.println(t2);

        //Extraer un objeto especifico del objeto a tarves de los getters
        System.out.println(t1.getPrecio() + "\n" +
                           t2.getTamanio() + "\n" +
                           t1.getMarca() + "\n");
        //Objeto con composicion
        Aplicacion ap1 = new Aplicacion("Apple Music", "Multimedia", "1.1.0", 500, false);
        Aplicacion ap2 = new Aplicacion("Apple TV", "Multimedia", "1.1.7", 500, true);
        Aplicacion[] apps = {ap1, ap2};

        Camara cam = new Camara("4K", "Macro", 100, "Optico", 1, true);

        Tablet t3 = new Tablet(14.5, "Azul", "Rectangular", 800.00, apps, 4000, cam,"Huawei", 8, "Harmony OS");
        System.out.println(t3);
        /** ===== OBJETO VIDEOGAMES ===== **/

        Videogames vg1 = new  Videogames();
        /*
            String nombre, String fechaLanzamiento, String descripcion,
            double peso, String plataformas, String desarroladora,
            String genero, String clasificacion, String idioma,
            String motorGrafico

            "The Elder Scrolls IV: Oblivion Remastered";
            "22/04/2025";
            "Version remasterizada del RPG de mundo abierto de 2006, donde el jugador debe cerrar las puertas de Oblivion que amenazan con destruir Tamriel, explorando la provincia de Cyrodiil.";
            130.0;  GB aproximados
            "PC, PlayStation 5, Xbox Series X/S, Nintendo Switch 2";
            "Bethesda Game Studios, Virtuos";
            "RPG de accion, Fantasia";
            "PEGI 18 / ESRB M";
            "Textos en español, voces en ingles";
            "Unreal Engine 5 (con elementos de Creation Engine para fisica y combate)";
        */
        Videogames vg2 = new  Videogames
                (
                        "The Elder Scrolls IV: Oblivion Remaster", "22/04/2025", "Version remasterizada del juego de 2006",
                        130, "PC, X BOX Series X/S, Playstation 5, Nintendo Switch 2", "Bethesda Game Studios", "RPG", "PEGI 18",
                        "Ingles, Español, Aleman", "Unreal Engine 5"
                );

        vg1.setNombre("Metal Gear Solid 4: Guns of the Patriots");
        vg1.setFechaLanzamiento("12/06/2008");
        vg1.setDescripcion("Solid Snake, ya envejecido, debe enfrentarse una ultima vez a Liquid Ocelot");
        vg1.setPeso(8.0);
        vg1.setPlataformas("PlayStation 3");
        vg1.setDesarroladora("Kojima Productions");
        vg1.setGenero("Accion, Sigilo (Stealth)");
        vg1.setClasificacion("PEGI 18");
        vg1.setIdioma("Ingles, Español, Japones");
        vg1.motorGrafico = "MGS4 Engine";

        System.out.println(vg1 + "\n" +
                           vg2 + "\n" +
                           "Nombre de videojuego: " + vg1.getNombre() + "\n" +
                           "Desarolladora: " + vg1.getDesarroladora());
    }
}