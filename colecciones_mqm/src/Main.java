import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //listas, mapas, conjuntos
//        List<String> lista = new ArrayList<String>();//declaracion de la lista
//
//        //agregar valores a la lista
//        lista.add("hola");
//        lista.add("java");
//        lista.add("---");
//        lista.add("desde");
//        lista.add("puebla");
//        lista.add("texto");
//        lista.add("1");
//        lista.add("dos");
//        lista.add("hola");
//        lista.add("III");
//
//        //tamaño de la lista
//        System.out.println(lista.size());
//
//        //imprimir los valores de la lista
//        System.out.println(lista);
//
//        //ver un elemento especifico de la lista
//        System.out.println(lista.get(4));
//
//        //eliminar un elemento de la lista
//        lista.remove("texto");//desde su valor
//        //System.out.println(lista.size());
//        lista.remove(6);//desde su posicion
//        System.out.println(lista);
//
//        //existe dentro de la lista
//        System.out.println(lista.contains("Java"));
//
//        //devulve el indice donde aparece por primera vez un determinado elemento
//        System.out.println(lista.indexOf("hola"));
//
//        //devulve el indice donde aparece por utlima vez un determinado elemento
//        System.out.println(lista.lastIndexOf("hola"));
//        //la lista permite la duplicacion de elementos
//        System.out.println(lista);
//
//        //reemplaza el elmento en la posicion indicada por otro elemento
//        lista.set(2,"$$$$$$");
//        System.out.println(lista);
//
//        //agrega nuevos valores dentro de ejecucion en la posicion indicada,
//        // recorriendo a los demas elementos hacia la derecha
//        lista.add(5,"@@@@@@");
//        System.out.println(lista);

        //List vs ArrayList
        //List es una interface
        //ArrayList es una clase que implementa dicha interface
//        List<Ciudad> citys = new ArrayList<>();
//
//        //instanciar objetos
//        //creas primero el objeto y despues se añade con add
//        Ciudad c1 = new Ciudad("97223","Leon",87392,
//                "Guanajuato","Textil","templado");
//        citys.add(c1);//forma 1
//
//        //crear el objeto al mismo tiempo de añadirlo
//        citys.add(new Ciudad("87491","Coatzacoalcos",97584,
//                "Veracruz","Petroleo","Tropical"));//forma 2
//        Ciudad c2 = new Ciudad("44100","Guadalajara",1385629,
//                "Jalisco","Comercio","templado");
//        Ciudad c3 = new Ciudad("64000","Monterrey",1142994,
//                "Nuevo León","Industria manufacturera","seco");
//        Ciudad c4 = new Ciudad("72000","Puebla",1692181,
//                "Puebla","Industria automotriz","templado");
//        Ciudad c5 = new Ciudad("76000","Querétaro",1044553,
//                "Querétaro","Industria aeroespacial","semiárido");
//        Ciudad c6 = new Ciudad("20000","Aguascalientes",948990,
//                "Aguascalientes","Industria automotriz","semiárido");
//        Ciudad c7 = new Ciudad("25000","Saltillo",879958,
//                "Coahuila","Industria automotriz","seco");
//        Ciudad c8 = new Ciudad("31000","Chihuahua",925762,
//                "Chihuahua","Industria manufacturera","seco");
//        Ciudad c9 = new Ciudad("80000","Culiacán",1003100,
//                "Sinaloa","Agricultura","cálido");
//        Ciudad c10 = new Ciudad("83200","Hermosillo",936263,
//                "Sonora","Ganadería","desértico");
//        Ciudad c11 = new Ciudad("86000","Villahermosa",402150,
//                "Tabasco","Industria petrolera","tropical");
//        Ciudad c12 = new Ciudad("29000","Tuxtla Gutiérrez",604147,
//                "Chiapas","Comercio","tropical");
//        Ciudad c13 = new Ciudad("97000","Mérida",995129,
//                "Yucatán","Turismo","cálido");
//        Ciudad c14 = new Ciudad("77500","Cancún",934189,
//                "Quintana Roo","Turismo","tropical");
//        Ciudad c15 = new Ciudad("68000","Oaxaca",715061,
//                "Oaxaca","Turismo","templado");
//        Ciudad c16 = new Ciudad("39000","Chilpancingo",283354,
//                "Guerrero","Comercio","cálido");
//        Ciudad c17 = new Ciudad("91000","Xalapa",488531,
//                "Veracruz","Servicios","templado húmedo");
//        Ciudad c18 = new Ciudad("58000","Morelia",849053,
//                "Michoacán","Servicios","templado");
//        Ciudad c19 = new Ciudad("78000","San Luis Potosí",911908,
//                "San Luis Potosí","Industria automotriz","semiárido");
//        Ciudad c20 = new Ciudad("23000","La Paz",292241,
//                "Baja California Sur","Turismo","desértico");
//
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

        //visibilidad de la lista
       //System.out.println(citys);//imprime una sola linea de toda la lista

        //foreach: por cada elemento que se enecuentre, realiza la accion
        //por cada clase (Ciudad) guarda la varible(c) :(-->dentro de) lista (citys)
//        for (Ciudad c:citys){
//            System.out.println(c);
//        }

        //obtener una ciudad por indice
        //System.out.println(citys.get(8));//imprime todo el objeto
        //System.out.println(citys.get(8).getActividadEco());//imprime un dato especifico
        // dentro de la lista con su getter,
        //cada objeto tiene sus getters y setters a disposicion

        //eliminar una ciudad por nombre o actividad economica
        //citys.remove("Pachuca");//no es posible porque no hay un metodo que se llame nombre
        //hay que iterar dentro de la lista para buscar lo que se va a eliminar
//        int index=0;
//        for (Ciudad c:citys){
//            if(c.getNombre().equals("Mérida")){
//                index=citys.indexOf(c);
//            }
//        }
//        citys.remove(index);
//
//        int index2=0;
//        for (Ciudad c:citys){
//            if(c.getActividadEco().equals("Agricultura")){
//                index2=citys.indexOf(c);
//            }
//        }
//        citys.remove(index2);

        //existe la ciudad Villahermosa
        //el metodo contains pide un objeto completo, refiriendose a el con su nombre de variable
//        System.out.println("Existe la ciudad Villahermosa: "+citys.contains(c11));
//
//        //cuantas ciudades hay en la lista
//        System.out.println(citys.size());
//
//        //indice de la ciudad x
//       int indice=0;
//        for (Ciudad b:citys){
//            if(b.getNombre().equals("Aguscalientes")){
//                indice=citys.indexOf(b);
//            }
//        }
//        System.out.println("El indice de Aguscalientes es: "+indice);

        //reemplazar una ciudad por otra
        //imprime el estado de la lista antes de reemplazar
//        System.out.println("Lista despues de eliminar");
//        for (Ciudad c:citys){
//            System.out.println(c);
//        }
//        //reemplazando
//        citys.set(14, new Ciudad());
//
//        System.out.println("\n despues de reemplazar la ciudad");
//        for (Ciudad c:citys){
//            System.out.println(c);
//        }

        //ciudades con mas de 600000 habs
//        int habs=0;
//        for (Ciudad h:citys){
//            if(h.getHabitantes()>600000){
//                habs=citys.indexOf(h);
//            }
//        }
//        System.out.println("Las ciudades con mas de 600'000 habitantes son: "+habs);
//
//        //ciudades con actvidad economica: comercio
//        int comercio=0;
//        for (Ciudad c:citys){
//            if(c.getActividadEco().equals("Comercio")){
//                comercio=citys.indexOf(c);
//            }
//        }
//        System.out.println("Las ciudades con actividad economica de comercio son: "+comercio);
//
//        //ciudades con clima templado o seco
//        int clima=0;
//        for (Ciudad t:citys){
//            if((t.getClima().equals("templado")) || (t.getClima().equals("seco"))){
//                clima=citys.indexOf(t);
//            }
//        }
//        System.out.println("Las ciudades con clima templado o seco son: "+clima);

        //------------------------------------------------------------------

//        //MAPAS
//
//        //crear un mapa
//        Map<String, String> registro = new HashMap<String, String>();
//        Map<String, Equipo> equipos = new HashMap<String, Equipo>();
//
//        //agregar elementos al mapa
//        registro.put("24386018943","Alcatel OT557 Gris Telcel Prepago 800");
//        registro.put("09234859383","Samsung Omnia Negro Movistar Pospago 1600");
//        registro.put("84983972938","Sony Ericsson W995 Naranja Unefon Prepago 2000");
//        registro.put("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
//        registro.put("02938484622","Pantech GMV-S Gris Unefon Pospago 500");
//        registro.put("90438702849","Nokia 5800 Negro Telcel Prepago 2500");
//        registro.put("94852039483","Motorola Razr Azul Movistar Prepago 1500");
//        registro.put("03894373734","LG Chocolate Negro Movistar Prepago  1600");
//
//
//        equipos.put("876876188275",new Equipo("Nokia","N95 8GB", "Negro",
//                "Telcel", "Prepago", 8000));
//        equipos.put("834590243984",new Equipo("Samsung","A05", "Azul",
//                "Telcel", "Pospago", 2000));
//        equipos.put("012983472435",new Equipo("Motorola","Flip", "Rojo",
//                "Telcel", "Prepago", 500));
//        equipos.put("289470292832",new Equipo("LG","G9", "Blanco",
//                "Telcel", "Prepago", 3600));
//        equipos.put("092843298329",new Equipo("Sony Ericsson","W200",
//                "Morado", "Telcel", "Prepago", 1800));
//        equipos.put("987249812736",new Equipo("Nokia","N96", "Negro",
//                "Telcel", "Pospago", 9000));
//        equipos.put("219387492832",new Equipo("Huawei","P30", "Dorado",
//                "Telcel", "Prepago", 7000));
//
//        //tamaño del mapa
//        System.out.println("Tamaño del mapa: "+registro.size());
//
//        //obtener un elemento del mapa
//        System.out.println(registro.get("1234567890"));
//
//        System.out.println(equipos.get("092843298329"));
//
//        //imprimir los elementos del mapa (con foreach para no verlos en una sola linea)
//        //por cada elemento de obten el valor de
//        //keyset conjunto de llaves
//        for (String key:registro.keySet()){
//            System.out.println(registro.get(key));
//        }
//
//
//        for (String key:equipos.keySet()){
//            System.out.println(equipos.get(key));
//        }
//
//        //eliminar elementos del mapa
//        //remove es un metodo polimorfico
//        registro.remove("94852039483");//pide la llave
//        //pide la llave y un valor asociado, si dicha llave esta asociada al valor dado
//        //elimina el elemento si no, no lo elimina
//        registro.remove("02984379383","Motorola Razr Azul Movistar Prepago 1500");
//        System.out.println("Tamaño del mapa despues de eliminar: "+registro.size());
//
//
//        equipos.remove("219387492832");
//        System.out.println(equipos.get("219387492832"));
//
//
//        //existe la llave?
//        System.out.println(registro.containsKey("90438702849"));
//
//        //existe el valor?
//        System.out.println(registro.containsValue("LG Chocolate Negro Movistar Prepago  1600"));
//
//        //si al intentar registrar un nuevo valor con el metodo put, en una llave que ya existe
//        //reemplaza el valor existente, no crea un nuevo registro lo sobreescribe
//        registro.put("90438702849","Nokia 808PV Blanco Telcel Prepago 8000");
//        System.out.println("Nuevos elementos del mapa: "+registro.size());
//
//        //antes de reemplazar, que me devuelve el registro?
//        System.out.println("Antes de reemplazar: "+(registro.get("09234859383")));
//        //reemplazar un valor, solo si la llave existe
//        registro.replace("09234859383","Nokia Lumia640XL Azul Unefon Pospago 4000");
//        //despues de reemplazar
//        System.out.println("Despues de reemplazar: "+(registro.get("09234859383")));
//
//        //obtener de un valor
//        for (String key:equipos.keySet()){//solo se mueve entre los datos
//            if (equipos.get(key).getModalidad().equals("Pospago")){
//                System.out.println(equipos.get(key));
//            }
//        }
//
//        System.out.println("COMPAÑIA");
//        for (String key:equipos.keySet()){//solo se mueve entre los datos
//            if (equipos.get(key).getCompañia().equals("Telcel")){
//                System.out.println(equipos.get(key));
//            }
//        }

        //-----------------------------------------------------------------------
        //autos

        //mapa autos
        Map<String, Map<String,List<Auto>>> catalogoGeneral =
                new HashMap<String, Map<String, List<Auto>>>();

        //mapa chevrolet
        Map<String,List<Auto>> catChevrolet = new HashMap<String, List<Auto>>();

        //lista de suvs de chevrolet
        List<Auto> lista1= new ArrayList<Auto>();

        //añadir valores a la lista
        lista1.add(new Auto("Equinox","Gris",400000,
                2019,"Automatico","837429875439"));
        lista1.add(new Auto("Captiva","Negro",300000,
                2020,"Automatico","564563454454"));
        lista1.add(new Auto("Traverse","Rojo",350000,2021,
                "AUTOMATICO","345634542563"));
        lista1.add(new Auto("Tahoe","Negro",500000,2022,
                "AUTOMATICO","937849274849"));

        //añade la lista al catalogo de la catgoria especifica
        catChevrolet.put("SUV",lista1);

        //añadir un elemento
        catalogoGeneral.put("Chevrolet",catChevrolet);
    }
}