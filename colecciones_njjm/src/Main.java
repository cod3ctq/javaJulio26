import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Listas, mapas, conjuntos

        /*
        List vs ArrayList

        List es una interface
        ArrayList es una clase que implementa dicha interface
         */

        List<String> lista = new ArrayList<>();



        lista.add("hola");
        lista.add("Java");
        lista.add("-----");
        lista.add("desde");
        lista.add("Puebla");
        lista.add("texto");
        lista.add("1");
        lista.add("dos");
        lista.add("hola");
        lista.add("III");

        //tamaño de la lista
        System.out.println(lista.size());

        //imprimir la lista
        System.out.println(lista);

        //ver un elemento espefícico de la lista
        System.out.println(lista.get(4));

        //eliminar un elemento de la lsita
        lista.remove("texto");
        lista.remove(6);
        System.out.println(lista);

        //existe dentro de la lista?
        System.out.println(lista.contains("Java"));

        //devuelve el índice donde aparece por primera vez un determinado elemento
        System.out.println(lista.indexOf("hola"));

        //devuelve el índice donde aparece por última vez un determinado elemento
        System.out.println(lista.lastIndexOf("hola"));

        System.out.println(lista);

        //reemplazar un elemento en la posición indicada por otro elemento
        lista.set(2,"$$$$$$$");

        //Agregar un elemento en la posición indicada, recorriendo los demás elementos hacia la derecha
        lista.add(5,"@@@@@@");
        System.out.println(lista);

        //------------------------------------------------------------------------------------------------------------

        List<Ciudad> citys = new ArrayList<Ciudad>();

        //Creas primero el objeto, después lo añades con add
        Ciudad c1 = new Ciudad("97223","León",87392,"Guanajuato",
                "Textil","templado");
        Ciudad c2 = new Ciudad("44100","Guadalajara",1385629, "Jalisco",
                "Comercio","templado");
        Ciudad c3 = new Ciudad("64000","Monterrey",1142994, "Nuevo León",
                "Industria manufacturera","seco");
        Ciudad c4 = new Ciudad("72000","Puebla",1692181, "Puebla",
                "Industria automotriz","templado");
        Ciudad c5 = new Ciudad("76000","Querétaro",1044553, "Querétaro",
                "Industria aeroespacial","semiárido");
        Ciudad c6 = new Ciudad("20000","Aguascalientes",948990, "Aguascalientes",
                "Industria automotriz","semiárido");
        Ciudad c7 = new Ciudad("25000","Saltillo",879958, "Coahuila",
                "Industria automotriz","seco");
        Ciudad c8 = new Ciudad("31000","Chihuahua",925762, "Chihuahua",
                "Industria manufacturera","seco");
        Ciudad c9 = new Ciudad("80000","Culiacán",1003100, "Sinaloa",
                "Agricultura","cálido");
        Ciudad c10 = new Ciudad("83200","Hermosillo",936263, "Sonora",
                "Ganadería","desértico");
        Ciudad c11 = new Ciudad("86000","Villahermosa",402150, "Tabasco",
                "Industria petrolera","tropical");
        Ciudad c12 = new Ciudad("29000","Tuxtla Gutiérrez",604147, "Chiapas",
                "Comercio","tropical");
        Ciudad c13 = new Ciudad("97000","Mérida",995129, "Yucatán",
                "Turismo","cálido");
        Ciudad c14 = new Ciudad("77500","Cancún",934189, "Quintana Roo",
                "Turismo","tropical");
        Ciudad c15 = new Ciudad("68000","Oaxaca",715061, "Oaxaca",
                "Turismo","templado");
        Ciudad c16 = new Ciudad("39000","Chilpancingo",283354, "Guerrero",
                "Comercio","cálido");
        Ciudad c17 = new Ciudad("91000","Xalapa",488531, "Veracruz",
                "Servicios","templado húmedo");
        Ciudad c18 = new Ciudad("58000","Morelia",849053, "Michoacán",
                "Servicios","templado");
        Ciudad c19 = new Ciudad("78000","San Luis Potosí",911908, "San Luis Potosí",
                "Industria automotriz","semiárido");
        Ciudad c20 = new Ciudad("23000","La Paz",292241, "Baja California Sur",
                "Turismo","desértico");

        //Crear el objeto al mismo tiempo de añadirlo
        citys.add(new Ciudad("87491","Coatzacoalcos",34392,"Veracruz",
                "Petróleo","tropical"));

        citys.add(c1);
        citys.add(c2);
        citys.add(c3);
        citys.add(c4);
        citys.add(c5);
        citys.add(c6);
        citys.add(c7);
        citys.add(c8);
        citys.add(c9);
        citys.add(c10);
        citys.add(c11);
        citys.add(c12);
        citys.add(c13);
        citys.add(c14);
        citys.add(c15);
        citys.add(c16);
        citys.add(c17);
        citys.add(c18);
        citys.add(c19);
        citys.add(c20);

        //for each: por cada elemento de
        for(Ciudad c:citys){
            System.out.println(c);
        }

        //Obtener una ciudad por índice
        System.out.println("\n"+citys.get(8).getActividadEco());

        //Eliminar una ciudad por nombre, o actividad Económica
        int index=0;
        for(Ciudad c:citys){
            //Determinar si el mombre de la ciudad actual coincide con la buscada
            if(c.getNombre().equals("Mérida")){
                index =citys.indexOf(c);
            }

            //ciudades con más de 600000 habs
            System.out.println("\n");
            if(c.getHabitantes() > 600000){
                System.out.println("Ciudad con mayor 600,000 habitantes o más: "+c.getNombre());
            }

            //ciudades con actividad económica: Comercio
            if(c.getActividadEco().equals("Comercio")){
                System.out.println("Ciudad con actividad económica Comercio: "+c.getNombre());
            }

            //Ciudades con clima templado o seco:
            if(c.getClima().equals("templado") || c.getClima().equals("seco")){
                System.out.println("Ciudad con clima templado o seco: "+c.getNombre());
            }

        }
        //Eliminar la ciudad ya con el índice obtenido
        citys.remove(index);


        //Existe la ciudad Villaherosa?
        System.out.println("Existe Villa? "+citys.contains(c11));

        //¿Cu´ntas ciudades hay e la lista?
        System.out.println(citys.size());

        //Imprime la lista después de eliminar
        System.out.println("\nLISTA DESPUÉS DE ELIMINAR");
        for(Ciudad c:citys){
            System.out.println(c);
        }

        //Índice de la ciudad 'Puebla'
        int index2=0;
        for(Ciudad c:citys){
            //Determinar si el mombre de la ciudad actual coincide con la buscada
            if(c.getNombre().equals("Puebla")){
                index2 =citys.indexOf(c);
                System.out.println(index2);
            }
        }


        //Reemplazar una ciudad por otra
        citys.set(14,new Ciudad());
        System.out.println("DESPUES DE REEMPLAZAR LA CIUDAD...");
        for(Ciudad c:citys){
            System.out.println(c);
        }

        //-------------------------------MAPAS---------------------------------------------------------------

        System.out.println("\n////////////////////////////////////MAPAS/////////////////////////////////////////////");

        Map<String,String> registro = new HashMap<String,String>();
        Map<String,Equipo> equipos = new HashMap<String,Equipo>();

        //Agregar elementos al mapa
        System.out.println("\n=Agregar elementos al mapa=");
        registro.put("24386018943","Alcatel OT557 Gris Telcel Prepago 800");
        registro.put("09234859383","Samsung Omnia Negro Movistar Pospago 1600");
        registro.put("84983972938","Sony Ericsson W995 Naranja Unefon Prepago 2000");
        registro.put("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
        registro.put("02938484622","Pantech GMV-S Gris Unefon Pospago 500");
        registro.put("90438702849","Nokia 5800 Negro Telcel Prepago 2500");
        registro.put("94852039483","Motorola Razr Azul Movistar Prepago 1500");
        registro.put("03894373734","LG Chocolate Negro Movistar Prepago  1600");

        equipos.put("876876188275",new Equipo("Nokia","N95 8GB", "Negro", "Telcel", "Prepago", 8000));
        equipos.put("834590243984",new Equipo("Samsung","A05", "Azul", "Telcel", "Pospago", 2000));
        equipos.put("012983472435",new Equipo("Motorola","Flip", "Rojo", "Telcel", "Prepago", 500));
        equipos.put("289470292832",new Equipo("LG","G9", "Blanco", "Telcel", "Prepago", 3600));
        equipos.put("092843298329",new Equipo("Sony Ericsson","W200", "Morado", "Telcel", "Prepago", 1800));
        equipos.put("987249812736",new Equipo("Nokia","N96", "Negro", "Telcel", "Pospago", 9000));
        equipos.put("219387492832",new Equipo("Huawei","P30", "Dorado", "Telcel", "Prepago", 7000));


        //tamaño del mapa
        System.out.println("\nElementos en el mapa: "+registro.size());

        //Obtener un elemento del mapa
        System.out.println("\n=Obtener un elemento del mapa=");
        System.out.println(registro.get("84983972938"));
        System.out.println(equipos.get("092843298329"));

        //Imprimir los elementos del mapa
        System.out.println("\n=Imprimir los elementos del mapa=");
        for(String key:equipos.keySet()){
            System.out.println(equipos.get(key));
        }
        //Eliminar elementos del mapa
        System.out.println("\n=Eliminar elementos del mapa=");
        System.out.println(registro.remove("94852039483"));//Recibe la llave
        equipos.remove("219387492832"); //Elimina al Huawei
        System.out.println(equipos.get("219387492832"));
        //Recibe la llave y un valor asociado. Si dichallave está asociada al valor dado, elimina el elemento, si no
        //no lo elimina.
        registro.remove("02984379383","Kiocera K1 Rojo Telcel Pospago 110");
        System.out.println("Elementos en el mapa: "+registro.size());

        //¿Existe la llave?
        System.out.println("\n=¿Existe la llave?=");
        System.out.println(registro.containsKey("90438702849"));

        //¿Existe el valor?
        System.out.println("\n=¿Existe el valor?=");
        System.out.println(registro.containsValue("LG Chocolate Negro Movistar Prepago  1600"));

        //Si al intentar un nuevo valor con el método put, usas una llave que ya existe, no crea un nuevo registro,
        //sobreescribe el valor asociado a la llave.
        System.out.println("\n=Sobreescribiendo el valor a una llave existente con .put()=");
        registro.put("90438702849","Nokia 808PV Blanco Telcel Prepago 8000");
        System.out.println("Elementos en el mapa: "+registro.size());

        //Antes de reemplazar
        System.out.println("=Antes de reemplazar=");
        System.out.println(registro.get("09234859383"));
        //Reemplazar un valor, solo si la llave existe
        System.out.println("=Reemplazar un valor, solo si la llave existe=");
        registro.replace("09234859383","Nokia Lumia640XL Azul Pospago 4000");
        //Después de reemplazar
        System.out.println("=Después de reemplazar=");
        System.out.println(registro.get("09234859383"));

        //Para encontrar un valor específico en el mapa
        String[] datos;
        System.out.println("\n=Para encontrar un valor específico en el mapa=");
        System.out.println("\n=Por Modalidad=");
        for(String key:equipos.keySet()){
            //datos = registro.get(key).split(""); //[Nokia, Lumia640XL, Azul, Pospago, 4000]

            if(equipos.get(key).getModalidad().equals("Pospago")){
                System.out.println(equipos.get(key));
            }
        }
        System.out.println("\n=Por Compañía=");
        for(String key:equipos.keySet()){
            //datos = registro.get(key).split(""); //[Nokia, Lumia640XL, Azul, Pospago, 4000]

            if(equipos.get(key).getCompañia().equals("Telcel")){
                System.out.println(equipos.get(key));
            }
        }

        //--------------------------------------EJERCICIO----------------------------------------------
        System.out.println("\n==========================EJERCICIO CATALOGO======================================");

        /*
        Crear un catálogo donde se puedan consultar los datos de los autos (modelo, color, precio, año,
         transmisión) separando por Marca y por tipo de auto (SEDAN, SUV'S, HATCHBACK, PICKUP).
         Tener en cuenta que cada marca tiene distinta cantidad de autos y diferentes categorías.
         */

        Map<String,Map<String,List<Auto>>> catalogoGeneral = new HashMap<String,Map<String,List<Auto>>>();
        //Mapa de Chevrolet
        Map<String,List<Auto>> catalogoChevrolet = new HashMap<String,List<Auto>>();
        //Lista de SUV'S de Chevrolet
        List<Auto> lista1 = new ArrayList<Auto>();
        //Objetos SUV'S para la lista SUV'S de Chevrolet
        lista1.add(new Auto("Equinox","Gris",400000,2019,"AUTOMATICO",
                "837429875439"));
        lista1.add(new Auto("Captiva","Negros",300000,2020,"AUTOMATICO",
                "564563454454"));
        lista1.add(new Auto("Traverse","Rojo",350000,2021,"AUTOMATICO",
                "345634542563"));
        lista1.add(new Auto("Thaoe","Negro",500000,2022,"AUTOMATICO",
                "937849274849"));

        //Añade la lista al catalogo de la categoría específica
        catalogoChevrolet.put("SUV",lista1);
        //anadir un elemento
        catalogoGeneral.put("Chevrolet",catalogoChevrolet);

    }
}
