import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Array vs ArrayList
        //El array es estatico, no puede redimensionarse.
        //La ArrayList es dinamica, puede crecer o reducirse en ejecucion.

        //List vs ArrayList
        //List es una interface
        //ArrayList es un clase que implementa dicha interface

        //Listas, mapas, conjuntos
        List<String> lista = new ArrayList<String>();

        //Agregar elementos a una lista en la ultima posicion
        lista.add("hola");
        lista.add("java");
        lista.add("----");
        lista.add("desde");
        lista.add("puebla");
        lista.add("texto");
        lista.add("1");
        lista.add("dos");
        lista.add("hola");
        lista.add("III");

        //Tamaño de la lista
        System.out.println(lista.size());

        //Imprimir y ver los valores de la lista
        System.out.println(lista);

        //Ver un elemento especifico de la lista
        System.out.println(lista.get(4));

        //Eliminar un elemento de la lista a travez de dos opciones:
        //Especificando el elemento a eliminar
        lista.remove("texto");
        System.out.println(lista.size());
        //Especificando la posicion que se desea eliminar
        lista.remove(6);
        System.out.println(lista.size());
        System.out.println(lista);

        //Existe dentro de la lista
        System.out.println(lista.contains("java"));

        //Devuelve el indice donde se encuentra por PRIMERA vez un determinado elemento
        System.out.println(lista.indexOf("hola"));

        //Devuelve el indice dodne aparece por ULTIMA vez un elemento
        System.out.println(lista.lastIndexOf("hola"));

        //Reemplaza un elemento en la posicion indicada por otro elemento
        System.out.println(lista.set(2, "$$$$"));
        System.out.println(lista);

        //.add se puede usar ademas para agregar un elemento en una posicion indicada y recorrer el resto
        lista.add(5, "@@@");
        System.out.println(lista);

        //--------------------------------------------------------------------------------------------------------------

        List<Ciudad> cities = new ArrayList<>();

        //List<Integer> eliminar = new ArrayList<>();

        //Para agregar un objeto a una lista se puede:

        //Crear primero el objeto y despues se añade a la lista
        Ciudad c1 = new Ciudad("97223", "Leon", 87392, "Guanajuado", "Textil", "Templado");
        cities.add(c1);

        //Agregar el objeto al mismo tiempo que se añade
        cities.add(new Ciudad("87491", "Coatzacoalcos", 93282, "Veracruz", "Petroleo", "Tropical"));
        //System.out.println(cities);

        Ciudad c2 = new Ciudad("44100", "Guadalajara", 1385629, "Jalisco", "Comercio", "templado");
        Ciudad c3 = new Ciudad("64000", "Monterrey", 1142994, "Nuevo León", "Industria manufacturera", "seco");
        Ciudad c4 = new Ciudad("72000", "Puebla", 1692181, "Puebla", "Industria automotriz", "templado");
        Ciudad c5 = new Ciudad("76000", "Querétaro", 1044553, "Querétaro", "Industria aeroespacial", "semiárido");
        Ciudad c6 = new Ciudad("20000", "Aguascalientes", 948990, "Aguascalientes", "Industria automotriz", "semiárido");
        Ciudad c7 = new Ciudad("25000", "Saltillo", 879958, "Coahuila", "Industria automotriz", "seco");
        Ciudad c8 = new Ciudad("31000", "Chihuahua", 925762, "Chihuahua", "Industria manufacturera", "seco");
        Ciudad c9 = new Ciudad("80000", "Culiacán", 1003100, "Sinaloa", "Agricultura", "cálido");
        Ciudad c10 = new Ciudad("83200", "Hermosillo", 936263, "Sonora", "Ganadería", "desértico");
        Ciudad c11 = new Ciudad("86000", "Villahermosa", 402150, "Tabasco", "Industria petrolera", "tropical");
        Ciudad c12 = new Ciudad("29000", "Tuxtla Gutiérrez", 604147, "Chiapas", "Comercio", "tropical");
        Ciudad c13 = new Ciudad("97000", "Mérida", 995129, "Yucatán", "Turismo", "cálido");
        Ciudad c14 = new Ciudad("77500", "Cancún", 934189, "Quintana Roo", "Turismo", "tropical");
        Ciudad c15 = new Ciudad("68000", "Oaxaca", 715061, "Oaxaca", "Turismo", "templado");
        Ciudad c16 = new Ciudad("39000", "Chilpancingo", 283354, "Guerrero", "Comercio", "cálido");
        Ciudad c17 = new Ciudad("91000", "Xalapa", 488531, "Veracruz", "Servicios", "templado húmedo");
        Ciudad c18 = new Ciudad("58000", "Morelia", 849053, "Michoacán", "Servicios", "templado");
        Ciudad c19 = new Ciudad("78000", "San Luis Potosí", 911908, "San Luis Potosí", "Industria automotriz", "semiárido");
        Ciudad c20 = new Ciudad("23000", "La Paz", 292241, "Baja California Sur", "Turismo", "desértico");

        cities.add(c2);
        cities.add(c3);
        cities.add(c4);
        cities.add(c5);
        cities.add(c6);
        cities.add(c7);
        cities.add(c8);
        cities.add(c9);
        cities.add(c10);
        cities.add(c11);
        cities.add(c12);
        cities.add(c13);
        cities.add(c14);
        cities.add(c15);
        cities.add(c16);
        cities.add(c17);
        cities.add(c18);
        cities.add(c19);
        cities.add(c20);

        List<Integer> habitantes = new ArrayList<>();
        List<Integer> comercio = new ArrayList<>();
        List<Integer> clima = new ArrayList<>();


        int index = 0;
        //foreach: Por cada elemento de "x", en la lista "y"
        for (Ciudad c : cities) {
            //System.out.println(c);

            //Verificar en que indice se encuentra la ciudad 'x'
            if (c.getNombre().equals("Mérida")) { //Indice de la ciudad 'x'
                index = cities.indexOf(c);

            }
            //Ciudades con mas de 600000 habitantes
            if (c.getHabitantes() > 600000) {
                habitantes.add(cities.indexOf(c));

                //System.out.println("Ciudades con mas de 600000 habitantes:");
                //System.out.println(c);
            }

            //Ciudades con actividad economica: Comercio
            if (c.getActividadEconomica().equals("Comercio")) {
                comercio.add(cities.indexOf(c));

                //System.out.println("Ciudades con Actividad economica Comercio:");
                //System.out.println(c);
            }

            //Ciudades con clima templado o seco:
            if (c.getClima().equals("templado") || c.getClima().equals("seco")) ;
            {
                clima.add(cities.indexOf(c));

                //System.out.println("Ciudades con clima Templado o Seco");
                //System.out.println(c + c.getClima());
            }

            //System.out.println(c);

        }
        System.out.println();
        System.out.println(habitantes);
        System.out.println(comercio);
        System.out.println(clima);
        System.out.println();
        System.out.println(cities.size());
        //System.out.println(eliminar);

        System.out.println("Ciudades con mas de 600000 habitantes:");
        for (Integer h : habitantes) {
            System.out.println(cities.get(h));
        }

        System.out.println("Ciudades con Actividad economica Comercio:");
        for (Integer cm : comercio) {
            System.out.println(cities.get(cm));
        }

        System.out.println("Ciudades con clima Templado o Seco");
        for (Integer cl : clima) {
            System.out.println(cities.get(cl));
        }

        System.out.println();


        //Eliminar la ciudad ya que sabemos en que indice se encuentra
        cities.remove(index);

        //Obtener una ciudad por indice
        System.out.println(cities.get(8).getActividadEconomica());

        //Exite la ciudad tal?
        System.out.println("Existe villa hermosa): " + cities.contains(c11));

        //Cuantas ciudades hay en la lista
        System.out.println(cities.size());

        System.out.println("----------LISTA DESPUES DE ELIMINAR----------");
        //Reemplazar una ciudad por otra
        //Imprime el estado de la lista antes de reemplazarla
        for (Ciudad c : cities) {
            System.out.println(c);

        }

        System.out.println("\n----------LISTA DESPUES DE REEMPLAZAR----------");
        cities.set(10, new Ciudad());

        for (Ciudad c : cities) {
            System.out.println(c);

        }

        System.out.println(cities.size());

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        //--------------------------------------------------------------------------------------------------------------

        Map<String, String> registro = new HashMap<String, String>();

        //Agregar elementos al mapa
        //Agrega siempre y cuando no se repita el key
        //Si se repite va a reemplazar el value
        registro.put("24386018943", "Alcatel OT557 Gris Telcel Prepago 800");
        registro.put("09234859383", "Samsung Omnia Negro Movistar Pospago 1600");
        registro.put("84983972938", "Sony Ericsson W995 Naranja Unefon Prepago 2000");
        registro.put("02984379383", "Kiocera K1 Rojo Telcel Pospago 1100");
        registro.put("02938484622", "Pantech GMV-S Gris Unefon Pospago 500");
        registro.put("90438702849", "Nokia 5800 Negro Telcel Prepago 2500");
        registro.put("94852039483", "Motorola Razr Azul Movistar Prepago 1500");
        registro.put("03894373734", "LG Chocolate Negro Movistar Prepago 1600");

        //Tamaño del mapa
        System.out.println("Elementos el mapa: " + registro.size());

        //Obtener un elemento del mapa
        //Le pedimos un key y nos da el value asociado a ese key
        System.out.println(registro.get("84983972938"));

        //Imprimir los elementos del mapa
        //key.Set() Da una matriz del contenido en "Key", en el for, key.Set() itera dandole a la variable key el valor contenido en cada Key
        for (String key : registro.keySet()) {
            System.out.println(registro.get(key));
        }

        //Eliminar elementos del mapa
        //Cuando se elimina, se elimina el key y el valor
        //Remove usando el Key
        registro.remove("94852039483");
        //Remove usando la llave y un valor asociado
        //Si dicha llave esta asociada al valor dado, elimina el elemento, si no, no lo elimina
        registro.remove("03894373734", "Kiocera K1 Rojo Telcel Pospago 1100"); //en este caso no coincide la key con su value
        System.out.println("Elementos en el mapa: " + registro.size());

        //Existe la llave?
        System.out.println(registro.containsKey("90438702849"));

        //Existe el valor?
        System.out.println(registro.containsValue("LG Chocolate Negro Movistar Prepago 1600"));

        //Si al intentar registrar un nuevo valor con el metodo put, usas una key que ya existe,
        //No crea un nuevo registro, Sobreescribe el value de la key asociada
        registro.put("90438702849", "Nokia 808PV Blanco Telcel Prepago 8000");
        System.out.println("Elementos en el mapa: " + registro.size());

        //Antes de reemplazar
        System.out.println(registro.get("09234859383"));

        //reemplazar un valor, solo si la llave existe. Si no existe no hace nada
        registro.replace("09234859383", "Nokia Lumia640XL Azul Unefon Pospago 4000");
        System.out.println(registro.get("09234859383"));

        //--------------------------------------------------------------------------------------------------------------------------------------------
        //Mapas donde los values son objetos, funcionan igual y los metodos tambien
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

        Map<String, Equipo> equipos = new HashMap<String, Equipo>();

        equipos.put("876876188275", new Equipo("Nokia", "N95 8GB", "Negro", "Telcel", "Prepago", 8000));
        equipos.put("834590243984", new Equipo("Samsung", "A05", "Azul", "Telcel", "Pospago", 2000));
        equipos.put("012983472435", new Equipo("Motorola", "Flip", "Rojo", "Telcel", "Prepago", 500));
        equipos.put("289470292832", new Equipo("LG", "G9", "Blanco", "Telcel", "Prepago", 3600));
        equipos.put("092843298329", new Equipo("Sony Ericsson", "W200", "Morado", "Telcel", "Prepago", 1800));
        equipos.put("987249812736", new Equipo("Nokia", "N96", "Negro", "Telcel", "Pospago", 9000));
        equipos.put("219387492832", new Equipo("Huawei", "P30", "Dorado", "Telcel", "Prepago", 7000));

        for (String key : equipos.keySet()) {
            System.out.println(equipos.get(key));
        }

        equipos.remove("219387492832");
        System.out.println(equipos.get("219387492832"));

        System.out.println("-----MODALIDAD-----");
        for (String key : equipos.keySet()) {
            if (equipos.get(key).getModalidad().equals("Pospago")) {
                System.out.println(equipos.get(key));
            }
        }

        System.out.println("-----COMPAÑIA-----");
        for (String key: equipos.keySet()) {
            if (equipos.get(key).getCompañia().equals("Telcel")){
                System.out.println(equipos.get(key));
            }
        }

        //---------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        //Crear un catalogo donde se puedan consultar los datos de los autos (modelo, color, $$, año, transmision)
        //Separandolos por Marca y por tipo de auto (SEDAN, SUV'S, HATCHBACK, PICKUP)
        //Tener en cuenta que cada marca tiene distinta cantidad de autos y diferentes categorias

        //Mapa de Mapa de Lista de Objetos
        Map<String, Map<String, List<Auto>>> catalogoGeneral = new HashMap<String, Map<String, List<Auto>>>();

        //Mapa de Lista de Objetos para el catalogo Chevrolet
        Map<String, List<Auto>> catChevrolet = new HashMap<String, List<Auto>>();

        //Lista de Objetos Auto
        List<Auto> lista1 = new ArrayList<Auto>();
        //Llenado de la lista
        lista1.add(new Auto("Equinox","Gris",400000,2019,
                "AUTOMATICO","837429875439"));
        lista1.add(new Auto("Captiva","Negro",300000,2020,
                "AUTOMATICO","564563454454"));
        lista1.add(new Auto("Traverse","Rojo",350000,2021,
                "AUTOMATICO","345634542563"));
        lista1.add(new Auto("Tahoe","Negro",500000,2022,
                "AUTOMATICO","937849274849"));

        //Llenado del mapa de Suvs de Chevrolet
        catChevrolet.put("SUV", lista1);

        //Llenado del mapa de Chevrlet
        catalogoGeneral.put("Cevrolet", catChevrolet);






    }
}