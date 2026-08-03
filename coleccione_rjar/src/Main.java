import javax.print.attribute.HashPrintJobAttributeSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        //Listas, mapas, conjuntos
        //List vs ArrayList
        //List es una interface
        //ArrayList es una clase que imlementa dicha interface

//        List<String> lista = new ArrayList<String>();
//
//        lista.add("hola");
//        lista.add("java");
//        lista.add("-----");
//        lista.add("desde");
//        lista.add("Puebla");
//        lista.add("texto");
//        lista.add("1");
//        lista.add("dos");
//        lista.add("hola");
//        lista.add("III");
//
//        //tamaño de la lista
//        System.out.println(lista.size());
//
//        //imprmir la lista
//        System.out.println(lista);
//
//        //ver un elemento especifico de la lista
//        System.out.println(lista.get(4));
//
//        //eliminar un elemento de la lista
//        lista.remove("texto");
//        lista.remove(6);
//        System.out.println(lista.size());
//
//        //devuelve el indice donde aparece por primera vez un determinado elemento
//        System.out.println("hola");
//        //devuelve el indice donde aparece por ultimma vez un determinado elemento
//        System.out.println(lista.lastIndexOf("hola"));
//
//        System.out.println(lista);
//
//        //reemplaza el elemento en la posicion indicada por otro elemnto
//        lista.set(2,"$$$$$");
//        System.out.println(lista);
//        //Agrega u elemento en la posicion indicada, reecorriendo los demas elemento
//        //hacia la derecha
//        lista.add(5,"@@@@@");
//        System.out.println(lista);

        //---------------

//        List<Ciudad> citys = new ArrayList<Ciudad>();
//        //Creas primero el objeto, despues o añades con add
//        Ciudad c1 = new Ciudad("9723", "Leon", 8739,
//                "Guanajuato", "Textil", "templado");
//        Ciudad c2 = new Ciudad("44100", "Guadalajara", 1385629,
//                "Jalisco", "Comercio", "templado");
//        Ciudad c3 = new Ciudad("64000", "Monterrey", 1142994,
//                "Nuevo León", "Industria manufacturera", "seco");
//        Ciudad c4 = new Ciudad("72000", "Puebla", 1692181,
//                "Puebla", "Industria automotriz", "templado");
//        Ciudad c5 = new Ciudad("76000", "Querétaro", 1044553,
//                "Querétaro", "Industria aeroespacial", "semiárido");
//        Ciudad c6 = new Ciudad("20000", "Aguascalientes", 948990,
//                "Aguascalientes", "Industria automotriz", "semiárido");
//        Ciudad c7 = new Ciudad("25000", "Saltillo", 879958,
//                "Coahuila", "Industria automotriz", "seco");
//        Ciudad c8 = new Ciudad("31000", "Chihuahua", 925762,
//                "Chihuahua", "Industria manufacturera", "seco");
//        Ciudad c9 = new Ciudad("80000", "Culiacán", 1003100,
//                "Sinaloa", "Agricultura", "cálido");
//        Ciudad c10 = new Ciudad("83200", "Hermosillo", 936263,
//                "Sonora", "Ganadería", "desértico");
//        Ciudad c11 = new Ciudad("86000", "Villahermosa", 402150,
//                "Tabasco", "Industria petrolera", "tropical");
//        Ciudad c12 = new Ciudad("29000", "Tuxtla Gutiérrez", 604147,
//                "Chiapas", "Comercio", "tropical");
//        Ciudad c13 = new Ciudad("97000", "Mérida", 995129,
//                "Yucatán", "Turismo", "cálido");
//        Ciudad c14 = new Ciudad("77500", "Cancún", 934189,
//                "Quintana Roo", "Turismo", "tropical");
//        Ciudad c15 = new Ciudad("68000", "Oaxaca", 715061,
//                "Oaxaca", "Turismo", "templado");
//        Ciudad c16 = new Ciudad("39000", "Chilpancingo", 283354,
//                "Guerrero", "Comercio", "cálido");
//        Ciudad c17 = new Ciudad("91000", "Xalapa", 488531,
//                "Veracruz", "Servicios", "templado húmedo");
//        Ciudad c18 = new Ciudad("58000", "Morelia", 849053,
//                "Michoacán", "Servicios", "templado");
//        Ciudad c19 = new Ciudad("78000", "San Luis Potosí", 911908,
//                "San Luis Potosí", "Industria automotriz", "semiárido");
//        Ciudad c20 = new Ciudad("23000", "La Paz", 292241,
//                "Baja California Sur", "Turismo", "desértico");
//        citys.add(c1);
//        citys.add(c2);
//        citys.add(c3);
//        citys.add(c4);
//        citys.add(c5);
//        citys.add(c6);
//        citys.add(c7);
//        citys.add(c8);
//        citys.add(c9);
//        citys.add(c10);
//        citys.add(c11);
//        citys.add(c12);
//        citys.add(c13);
//        citys.add(c14);
//        citys.add(c15);
//        citys.add(c16);
//        citys.add(c17);
//        citys.add(c18);
//        citys.add(c19);
//        citys.add(c20);
//        //foreach:por cada elemento de
//        int index=0;
//        for (Ciudad c : citys) {
//            //determnar si el nombre e la ciudad actual coincide con la bvuscada
//            if (c.getNombre().equals("Mérida")) {
//                index = citys.indexOf(c);
//            }
//            //Ciudades con mas de 600000 habs
//
//            if (c.getHabitantes()>600000){
//                System.out.println("Ciudades con mas de 600000: "+c.getNombre());
//            }
//
//
//            //Ciudada con acividad economica: Comercio
//
//            if (c.getActividadEco().equals("Comercio")){
//                System.out.println("Ciudades con actividad economica comercio: "+c.getNombre());
//            }
//
//            //Ciudades con clima templado o seco:
//
//            if (c.getClima().equals("templado")){
//                System.out.println("Ciudades con clima templado: "+c.getNombre());
//            }
//            if (c.getClima().equals("seco")){
//                    System.out.println("Ciudades con clima seco: "+c.getNombre());
//            }
//        }
//
////
//
//        //Eliminar una ciudad ya con el indice obtenido
//        citys.remove(index);
//        //Obtener una ciudad por indice
////        System.out.println(citys.get(8).getActividadEco());
//        //existe la ciudad Villahermosa?
//        System.out.println("Existe villa?: " + citys.contains(c11));
//        //Cuantas ciudades hay en la lista
//        System.out.println(citys.size());
//        //indice de la ciudad 'x'
//        //imprime el estado de la lista antes de reemplazar
//        for (Ciudad c : citys) {
//            System.out.println(c);
//        }
//
//
//        //reemplazar una ciudad por otra
//        citys.set(14, new Ciudad());
//        System.out.println("DESPUES DE REEMPLAZAR LA CIUDAD ...");
//
//        for (Ciudad c : citys) {
//            System.out.println(c);
//        }
//            //Crear el objeto al mismo tiemp de añadirlo
//            citys.add(new Ciudad("87491", "Coatzacoalcos", 45855,
//                    "Veracruz", "Petroleo", "Tropical"));
//
//
//
//    }

    //----------------------------------------------------------------------------------------------------------------------------

    Map<String, String> registro=new HashMap<String,String>();
    Map<String, Equipo> equipos= new HashMap<String, Equipo>();
//.......
        //------------------------------------------------------------------------------------------------
        //........
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




        //********************************************

    //agregar elementos al mapa
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

    System.out.println("Eelemntos en el mapa: "+registro.size());
    //obtener un elemento del mapa
        System.out.println(registro.get("02938484622"));
        System.out.println(equipos.get("092843298329"));

    //imprimir los elementos del mapa
    for(String key:equipos.keySet()){
    System.out.println(equipos.get(key));
}
        //eleimnar elementos del mapa
        registro.remove("03894373734");//recibe la llave
        equipos.remove("219387492832");// elimina al huawei
        System.out.println(equipos.get("219387492832")); //debera aparecer null ya que es elemento ya no sirve se elimino en a linea de arriba
        //recibe la llave y un vlor asociado
        //si dicha llave esta asociada al valor dado, elimina el elemento
        //sino, no lo elimina
        registro.remove("02938484622","Pantech GMV-S Gris Unefon Pospago 500");
        System.out.println("Elementos en el mapa: "+registro.size());
    //existe la llave?
        System.out.println(registro.containsKey("84983972938"));
    //existe el valor?
        System.out.println(registro.containsValue("Pantech GMV-S Gris Telcel Prepago 800"));
        //Si al intentar registrar un nuevo valor con el metodo put
        //usas una llave que ya existe, no crea un nuevo registro,
        //sobreescribe el valor sociado a la llave
        registro.put("90438702849","Nokia 5800 Negro Telcel Prepago 2500");
        System.out.println("Elementos en el mapa: "+registro.size());
        //Antes de reemplazar
        System.out.println(registro.get("09234859383"));
        //reemplazar un valor, solo si la llave existe
        registro.replace("09234859383","Nokia Lumia640XL Azul Unefon Pospago 4000");
        //despues de reemplazar
        System.out.println(registro.get("09234859383"));
        //--------------------------------------------------------------------------------------------
        //

        for (String key:equipos.keySet()) { //
            //datos=registro.get(key).split("");
            if (equipos.get(key).getModalidad().equals("Pospago")) {
                System.out.println(equipos.get(key));
            }
            System.out.println("COMPAÑIA");
            if (equipos.get(key).getModalidad().equals("Telcel")) {
                System.out.println(equipos.get(key));
            }

        }
    }
    /*
    Crear un catalogo dondese puedan consultar los datos de los autos(modelo, color,$$, año,transmision)
    separandolos por marca y por tipo de auto(SEDAN, SUV'S,HATCHBACK,PICKUP)
    Tener en cuenta que cada marca tiene distinta cantidad de autos y diferentes categorias
    */

    }