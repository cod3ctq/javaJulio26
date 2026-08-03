//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        //LISTAS,  MAPAS,  CONJUNTOS
//        //LIST VS ARRAYLIST:
//        //list es una interface
//        //ArrayList es una clase que implementa dicha interface
//        List<String> lista = new ArrayList<String>();
////
////        lista.add("Hola");
////        lista.add("Java");
////        lista.add("----");
////        lista.add("desde");
////        lista.add("Puebla");
////        lista.add("texto");
////        lista.add("1");
////        lista.add("dos");
////        lista.add("Hola");
////        lista.add("III");
//
//        //TAMAÑO DE LA LISTA
////        System.out.println(lista.size());
////
////        //IMPRIMIR LA LISTA
////        System.out.println(lista);
////
////        //VER UN ELEMENTO DE LA LISTA
////        System.out.println(lista.get(4));
////
////        //ELIMINAR UN ELEMENTO DE LA LISTA
////        lista.remove("texto");
////        lista.remove(6);
////        System.out.println(lista);
////        System.out.println(lista.size());
////
////        //EXISTE DENTRO DE LA LISTA
////        System.out.println(lista.contains("Java"));
////
////        //DEVUELVE EL INDICE DONDE APARECE POR PRIMERA VEZ UN DETERMINADO ELEMENTO
////        System.out.println(lista.indexOf("Hola"));
////
////        //DEVUELVE EL INDICE DONDE APARECE POR ULTIMA VEZ UN DETERMINADO TERMINO
////        System.out.println(lista.lastIndexOf("Hola"));
////        System.out.println(lista);
////
////        //REEMPLAZA EL ELEMENTO EN LA POSICION INDICADA POR OTRO ELEMENTO
////        lista.set(2, "$$$$$$");
////        System.out.println(lista);
////
////        //AGREGA ELEMENTOS EN LA LISTA, EN DETERMINADO INDICE, RECORRIENDO LOS DEMAS A LA DERECHA
////        lista.add(5, "@@@@");
////        System.out.println(lista);
//
//
//        List<Ciudad> citys = new ArrayList<Ciudad>();
//
//        //Crear primero el objeto, despues se añade con add.
//        Ciudad c1 = new Ciudad("97223", "Leon", 87392, "Guanajuato", "textil", "templado");
//        Ciudad c2 = new Ciudad("44100", "Guadalajara", 1385629, "Jalisco", "Comercio", "templado");
//        Ciudad c3 = new Ciudad("64000", "Monterrey", 1142994, "Nuevo León", "Industria manufacturera", "seco");
//        Ciudad c4 = new Ciudad("72000", "Puebla", 1692181, "Puebla", "Industria automotriz", "templado");
//        Ciudad c5 = new Ciudad("76000", "Querétaro", 1044553, "Querétaro", "Industria aeroespacial", "semiárido");
//        Ciudad c6 = new Ciudad("20000", "Aguascalientes", 948990, "Aguascalientes", "Industria automotriz", "semiárido");
//        Ciudad c7 = new Ciudad("25000", "Saltillo", 879958, "Coahuila", "Industria automotriz", "seco");
//        Ciudad c8 = new Ciudad("31000", "Chihuahua", 925762, "Chihuahua", "Industria manufacturera", "seco");
//        Ciudad c9 = new Ciudad("80000", "Culiacán", 1003100, "Sinaloa", "Agricultura", "cálido");
//        Ciudad c10 = new Ciudad("83200", "Hermosillo", 936263, "Sonora", "Ganadería", "desértico");
//        Ciudad c11 = new Ciudad("86000", "Villahermosa", 402150, "Tabasco", "Industria petrolera", "tropical");
//        Ciudad c12 = new Ciudad("29000", "Tuxtla Gutiérrez", 604147, "Chiapas", "Comercio", "tropical");
//        Ciudad c13 = new Ciudad("97000", "Mérida", 995129, "Yucatán", "Turismo", "cálido");
//        Ciudad c14 = new Ciudad("77500", "Cancún", 934189, "Quintana Roo", "Turismo", "tropical");
//        Ciudad c15 = new Ciudad("68000", "Oaxaca", 715061, "Oaxaca", "Turismo", "templado");
//        Ciudad c16 = new Ciudad("39000", "Chilpancingo", 283354, "Guerrero", "Comercio", "cálido");
//        Ciudad c17 = new Ciudad("91000", "Xalapa", 488531, "Veracruz", "Servicios", "templado húmedo");
//        Ciudad c18 = new Ciudad("58000", "Morelia", 849053, "Michoacán", "Servicios", "templado");
//        Ciudad c19 = new Ciudad("78000", "San Luis Potosí", 911908, "San Luis Potosí", "Industria automotriz", "semiárido");
//        Ciudad c20 = new Ciudad("23000", "La Paz", 292241, "Baja California Sur", "Turismo", "desértico");
//
//
//        //Crear el objeto al mismo tiempo de añadirlo
//        //citys.add(new Ciudad("Coatzacoalcos","87491",68787, "Veracruz","Petroleo","Tropical" ));
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
//
//        System.out.println(citys);
//
//        //foreach: por cada elemento de
////        int index = 0;
////        for (Ciudad c : citys) {
////            //Determinar si el nombre de la ciudad actual coincide con la buscada
////            if (c.getNombre().equals("Mérida")) {
////                index = citys.indexOf(c);
////            }
////        }
////        citys.remove(index);
//        //System.out.println(c);
//
//        //Obtener una ciudad por indice
//        System.out.println(citys.get(8).getActividadEco());
//
//        //Existe la ciudad villa hermosa
//        System.out.println("¿Existe Villa hermosa?:" + citys.contains(c11));
//
//        //indie de la ciudad 'x'
//        System.out.println(citys.size());
//
//        //IMPRIME LA LISTA DE CIUDAD ANTES DE REEMPLAZAR
//        for (Ciudad c : citys) {
//            System.out.println(c);
//        }
//
////        //REEMPLAZAR UNA CIUDAD POR OTRA
////        citys.set(14, new Ciudad());
////        System.out.println("despues de reemplazar la ciudad ...");
////        for (Ciudad c : citys) {
////            System.out.println(c);
////        }
//
//        //Ciudades con mas de 600,000 habitantes
//        System.out.println("Las ciudades con mas de 600,000 habitantes, son: ");
//        for (Ciudad c : citys) {
//            //Determinar si el nombre de la ciudad actual coincide con la buscada
//            if (c.getHabitantes()> 600000) {
//                System.out.println(c.getNombre());
//            }
//        }
//        //Ciudades con clima templado o seco:
//        System.out.println("Las ciudades con clima templado o seco, son: ");
//        for (Ciudad c: citys){
//            if (c.clima.equals("templado")|| c.clima.equals("seco"))
//                System.out.println(c.getNombre());
//        }
//
//        //ciudades con actividad economica: Comercio
//        System.out.println("Las ciudades con actividad economica COMERCIO, son: ");
//        for (Ciudad t: citys){
//            if (t.getActividadEco().equals("Comercio")) {
//                System.out.println(t.getNombre());
//            }
//        }


        // *********************************************MAPAS**************************************** 03/08/2026
        //DECLARAR EL MAPA:
        Map<String,String> registro= new HashMap<String,String>();
        Map<String,Equipo> equipos = new HashMap<String, Equipo>();

//        //***********AGREGAR ELEMENTOS AL MAPA***********************
//        registro.put("24386018943","Alcatel OT557 Gris Telcel Prepago 800");
//        registro.put("09234859383","Samsung Omnia Negro Movistar Pospago 1600");
//        registro.put("84983972938","Sony Ericsson W995 Naranja Unefon Prepago 2000");
//        registro.put("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
//        registro.put("02938484622","Pantech GMV-S Gris Unefon Pospago 500");
//        registro.put("90438702849","Nokia 5800 Negro Telcel Prepago 2500");
//        registro.put("94852039483","Motorola Razr Azul Movistar Prepago 1500");
//        registro.put("03894373734","LG Chocolate Negro Movistar Prepago  1600");
//
//       //**********OTROS EQUIPOS PARA SEGUNDO MAPA *****************
//        equipos.put("876876188275",new Equipo("Nokia","N95 8GB", "Negro", "Telcel", "Prepago","8000"));
//        equipos.put("834590243984",new Equipo("Samsung","A05", "Azul", "Telcel", "Pospago", "2000"));
//        equipos.put("012983472435",new Equipo("Motorola","Flip", "Rojo", "Telcel", "Prepago", "500"));
//        equipos.put("289470292832",new Equipo("LG","G9", "Blanco", "Telcel", "Prepago", "3600"));
//        equipos.put("092843298329",new Equipo("Sony Ericsson","W200", "Morado", "Telcel", "Prepago", "1800"));
//        equipos.put("987249812736",new Equipo("Nokia","N96", "Negro", "Telcel", "Pospago", "9000"));
//        equipos.put("219387492832",new Equipo("Huawei","P30", "Dorado", "Telcel", "Prepago", "7000"));
//
//
//        //*************TAMAÑO DEL MAPA***********************************
//        System.out.println("ELEMENTOS DEL MAPA:" + registro.size());
//
//        //***********OBTENER UN ELEMENTO DEL MAPA********************
//        System.out.println(registro.get("84983972938"));
//        System.out.println(equipos.get("092843298329"));
//
//        //*********IMPRIMIR EL MAPA**********************************
//        for(String key: registro.keySet()){
//            System.out.println(registro.get(key));
//        }
//
//        //***********ELIMINAR ELEMENTOS DEL MAPA*********************
//        System.out.println(registro.remove("94852039483")); //solo recibe la llave
//        registro.remove("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
//        System.out.println("Elementos en el mapa:" + registro.size());
////        equipos.remove("219387492832");//elimina a huawei
////        System.out.println();
//
//        //*********************** ¿EXISTE LA LLAVE? *******************************
//        System.out.println(registro.containsKey("90438702849"));
//
//        //****************************¿EXISTE EL VALOR?*****************************
//        System.out.println(registro.containsValue("LG Chocolate Negro Movistar Prepago  1600"));
//
//        //*******************REGISTRAR UN NUEVO VALOR*************************
//        //Si al intentar  registrar un nuevo valor con el metodo PUT usas una llave que ya existia,
//        //no se crea un nuevo registro, sobreescribe el valor asociado o en caso de no existir la llave se crea un nuevo registro
//        registro.put("90438702849", "Nokia 808PV BLANCO TELCEL PREPAGO 800");//siempre se piden dos valores
//        System.out.println("Elementos en el mapa: " + registro.size());
//
//        //****************REEMPLAZAR UN VALOR,SOLO SI LA LLAVE EXISTE**************
//        //Primero comprueba si existe o no, a diferencia del put, este no va a proceder si la llave no existe
//        //ANTES DE REEMPLAZAR
//        System.out.println(registro.get("09234859383"));
//        //REEMPLAZAR UN VALOR
//        registro.replace("09234859399", "Nokia Lumia640XL Azul Unefon Pospago 4000");
//        //despues de reemplazar
//        System.out.println(registro.get("09234859383"));


        //*****************CICLO FOR PARA CONVERTIR LOS DATOS STRING EN UN ARRAY DE STRINGS******//
//        String [] datos;
//        for(String key: registro.keySet()){
//            datos = registro.get(key).split(" ");
//        }

        //SEGUNDA FORMA DE HACERLO, AHORA CON UN OBJETO DE LA CLASE EQUIPO
//        System.out.println("POSPAGO");
//        for(String key: equipos.keySet()){
//           if (equipos.get(key).getModalidad().equals("Pospago")){
//               System.out.println(equipos.get(key));
//           }
//       }
//        System.out.println("COMPAÑIA");
//        for(String key: equipos.keySet()){
//            if (equipos.get(key).getCompañia().equals("Telcel")){
//                System.out.println(equipos.get(key));
//            }
//        }

        //------------------------------------------NUEVO EJERCICIO/MAPAS-----------------------------------------------
        // CREAR UN CATALOGO DONDE SE PUEDAN CONSULTAR LOS DATOS DE LOS AUTOS (MODELO, COLOR, $$, AÑO, TRANSMISION)
        // SEPARANDOLOS POR MARCA Y POR TIPO DE AUTO (SEDAN, SUV'S, HATCHBACK, PICKUP).
        // TENER EN CUENTA QUE CADA MARCA TIENE DISTINTA CANTIDAD DE AUTOS Y DIFERENTES CATEGORIAS.

        Map<String, Map<String,List<Auto>>> catalogGeneral = new HashMap <String, Map<String,List<Auto>>>();
        Map<String,List<Auto>> catChevrolet = new HashMap<String,List<Auto>>();// MAPA CHEVROLET

        //LISTA DE SUVS DE CHEVROLET
        List<Auto> lista1= new ArrayList<Auto>();
        //OBJETOS SUVS PARA LA LISTA DE CHEVROLET
        lista1.add(new Auto("Equinox","Gris",400000,2019, "AUTOMATICO","837429875439"));
        lista1.add(new Auto("Captiva","Negro",300000,2020, "AUTOMATICO","564563454454"));
        lista1.add(new Auto("Traverse","Rojo",350000,2021, "AUTOMATICO","345634542563"));
        lista1.add(new Auto("Tahoe","Negro",500000,2022, "AUTOMATICO","937849274849"));

        //AÑADE LA LISTA AL CATALOGO DE LA CATEGORIA ESPECIFICA
        catChevrolet.put("SUV",lista1);

        //AÑADIR UN ELEMENTO
        catalogGeneral.put("Chevrolet",catChevrolet);



    }
}
