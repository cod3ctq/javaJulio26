import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //listas , mapas ,cojuntos
        //list vs Arraylist
        //list es una interface
        //Arraylist es una clase concreta implementacion de la interface list
        List<String> lista = new ArrayList<String>();

//        //agregar una lista
//        lista.add("hola");
//        lista.add("java");
//        lista.add("´-----");
//        lista.add("desde");
//        lista.add("puebla");
//        lista.add("texto");
//        lista.add("uno");
//        lista.add("dos");
//        lista.add("hola");
//        lista.add("III");
//
//        //tamaño de la lista
//        System.out.println(lista.size());
//
//        //monstrar la lista
//        System.out.println(lista);
//
//        //monstrar un elemnetyo especifico de la lista
//        System.out.println(lista.get(4));
//
//        //elimnar de la lista
//        lista.remove("texto");
//        lista.remove(6);
//        System.out.println(lista);
//
//        //existe dentro de la lista
//        System.out.println(lista.contains("java"));
//
//        //devuelve el indice donde aparece por primera vez de un elemento
//        System.out.println(lista.indexOf("hola"));
//
//        //devuelve el indice donde aparece por ultima vez
//        System.out.println(lista.lastIndexOf("hola"));
//
//        //Reamplazar
//        lista.set(2,"$$$$4");
//
//        //add agrega en indice que tu le indiques
//        lista.add(5,"@@@@@");
//
//
//        System.out.println(lista);

        List<Ciudad> citys = new ArrayList<Ciudad>();
        //creas primero el obejto despues lo añades al add
        Ciudad c1 = new Ciudad("9756564","leon",87765,"Guanajuato","textil","templado");

        citys.add(c1);
        //creas el objeto al mismo tiempo de añadirlo
        citys.add(new Ciudad("87491","coatzalcacos",67543,"Veracruz","petroleo","Tropical"));
        Ciudad c2 = new Ciudad("44100","Guadalajara",1385629, "Jalisco","Comercio","templado");
        Ciudad c3 = new Ciudad("64000","Monterrey",1142994, "Nuevo León","Industria manufacturera","seco");
        Ciudad c4 = new Ciudad("72000","Puebla",1692181, "Puebla","Industria automotriz","templado");
        Ciudad c5 = new Ciudad("76000","Querétaro",1044553, "Querétaro","Industria aeroespacial","semiárido");
        Ciudad c6 = new Ciudad("20000","Aguascalientes",948990, "Aguascalientes","Industria automotriz","semiárido");
        Ciudad c7 = new Ciudad("25000","Saltillo",879958, "Coahuila","Industria automotriz","seco");
        Ciudad c8 = new Ciudad("31000","Chihuahua",925762, "Chihuahua","Industria manufacturera","seco");
        Ciudad c9 = new Ciudad("80000","Culiacán",1003100, "Sinaloa","Agricultura","cálido");
        Ciudad c10 = new Ciudad("83200","Hermosillo",936263, "Sonora","Ganadería","desértico");
        Ciudad c11 = new Ciudad("86000","Villahermosa",402150, "Tabasco","Industria petrolera","tropical");
        Ciudad c12 = new Ciudad("29000","Tuxtla Gutiérrez",604147, "Chiapas","Comercio","tropical");
        Ciudad c13 = new Ciudad("97000","Merida",995129, "Yucatán","Turismo","cálido");
        Ciudad c14 = new Ciudad("77500","Cancún",934189, "Quintana Roo","Turismo","tropical");
        Ciudad c15 = new Ciudad("68000","Oaxaca",715061, "Oaxaca","Turismo","templado");
        Ciudad c16 = new Ciudad("39000","Chilpancingo",283354, "Guerrero","Comercio","cálido");
        Ciudad c17 = new Ciudad("91000","Xalapa",488531, "Veracruz","Servicios","templado húmedo");
        Ciudad c18 = new Ciudad("58000","Morelia",849053, "Michoacán","Servicios","templado");
        Ciudad c19 = new Ciudad("78000","San Luis Potosí",911908, "San Luis Potosí","Industria automotriz","semiárido");
        Ciudad c20 = new Ciudad("23000","La Paz",292241, "Baja California Sur","Turismo","desértico");

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

        //foreach por cada ekemento
        // verificar en q
        int index = 0;
        for (Ciudad c: citys){
            //determinar si el nombre de la ciudad actual coincide con las busca
            if(c.getNombre().equals("Merida")){
                index = citys.indexOf(c);
            }
        }
        //eliminar la ciudad ya con el indice
        citys.remove(index);

        //obtener una ciudad en el indice
        System.out.println(citys.get(8).getActividadEco());

        //existe la ciudad villa hermosa
        System.out.println("existe " + citys.contains(c11));

        //si el tamalo de las ciudades
        System.out.println(citys.size());

        //imprime  una lista antes de reaamplazar
        for (Ciudad c: citys){
            System.out.println(c);
        }
        System.out.println("despues de reamplazar la ciudad.....");
        //reamplazar un nuevo elemnto
        citys.set(14, new Ciudad());
        for (Ciudad c: citys){
            System.out.println(c);
        }

        //habitantes con mas de 600000
        int index1 = 0;
        for (Ciudad c: citys){
            //determinar si el nombre de la ciudad actual coincide con las busca
            if(c.getHabitantes()>=600000){
                index1 = citys.indexOf(c);
            }
        }

        //comercio
        int index2 = 0;
        for (Ciudad c: citys){
            //determinar si el nombre de la ciudad actual coincide con las busca
            if(c.getActividadEco().equals("Comercio")){
                index2 = citys.indexOf(c);
            }
        }

        //-----------------------------------------------------------------------------------

        Map<String, String> registro= new HashMap<String ,String >();
        //Map<String, Integer> edades = new HashMap<>();

        // agregar valores al mapa
        registro.put("24386018943","Alcatel OT557 Gris Telcel Prepago 800");
        registro.put("09234859383","Samsung Omnia Negro Movistar Pospago 1600");
        registro.put("84983972938","Sony Ericsson W995 Naranja Unefon Prepago 2000");
        registro.put("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
        registro.put("02938484622","Pantech GMV-S Gris Unefon Pospago 500");
        registro.put("90438702849","Nokia 5800 Negro Telcel Prepago 2500");
        registro.put("94852039483","Motorola Razr Azul Movistar Prepago 1500");
        registro.put("03894373734","LG Chocolate Negro Movistar Prepago  1600");

        //tamaño del mapa
        System.out.println(registro.size());

        //obtener un elemento del mapa
        System.out.println(registro.get("84983972938"));

        //eliminar  un elemento dell mapa
        for (String key:registro.keySet()){
            System.out.println(registro.get(key));
        }
        //eliminra el elemneto del map
        System.out.println(registro.remove("94852039483"));//recibe la llave
        //recibe la llave y un valos asociado
        //asi dicha  esta asociada al valor dado elimina el elemento
        //si no mo lo elimina
        registro.remove("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
        System.out.println("elementos en el mapa " + registro.size());

        //existe una llave
        System.out.println(registro.containsKey("90438702849"));

        //reamplazar un valor , solo si existe la llave
        registro.replace("09234859383" , "Nokia lumina640XL Azul Unefon Pospago 40000");

        String [] datos;

        for (String key :registro.keySet()){

           // datos=registro.get()
           // System.out.println(Equipos.get(key));
        }
//        Equipos.put("834590243984", new Equipos("Samsung", "A05", "Azul", "Telcel", "Pospago", 2000));
//        Equipos.put("012983472435", new Equipos("Motorola", "Flip", "Rojo", "Telcel", "Prepago", 500));
//        Equipos.put("289470292832", new Equipos("LG", "G9", "Blanco", "Telcel", "Prepago", 3600));
//        Equipos.put("092843298329", new Equipos("Sony Ericsson", "W200", "Morado", "Telcel", "Prepago", 1800));
//        Equipos.put("987249812736", new Equipos("Nokia", "N96", "Negro", "Telcel", "Pospago", 9000));
//        Equipos.put("219387492832", new Equipos("Huawei", "P30", "Dorado", "Telcel", "Prepago", 7000));


        Map<String, Map<String,List<Auto>>> catalogGeneral =
                new HashMap<String, Map<String,List<Auto>>>();
        //Mapa de chevrolet
        Map<String,List<Auto>>  catChevrolet = new HashMap<String,List<Auto>>();
        //Lista de suvs de chevrolet
        List<Auto> lista1 = new ArrayList<Auto>();
        //Objetos SUVs para la lista suvs de chevrolet
        lista1.add(new Auto("Equinox","Gris",400000,2019,
                "AUTOMATICO","837429875439"));
        lista1.add(new Auto("Captiva","Negro",300000,2020,
                "AUTOMATICO","564563454454"));
        lista1.add(new Auto("Traverse","Rojo",350000,2021,
                "AUTOMATICO","345634542563"));
        lista1.add(new Auto("Tahoe","Negro",500000,2022,
                "AUTOMATICO","937849274849"));
        //añade la lista al catalogo de la catgoria especifica
        catChevrolet.put("SUV",lista1);
        //añadir un elemento
        catalogGeneral.put("Chevrolet",catChevrolet);





    }
}