import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Listas, mapas, conjuntos
        //List vs ArrayList
        //List es una interface
        //ArrayList es una clase que implementa dicha interface
        List<String> lista = new ArrayList<String>();

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

        //tamanio de la lista
        //System.out.println(lista.size());
        //imprimir la lista
        //System.out.println(lista);
        //ver elemento especifico de la lista
        //System.out.println(lista.get(4));
        //eliminar un elemento de la lista
        lista.remove("texto");
        //System.out.println(lista.size());
        lista.remove(6);
        //System.out.println(lista.size());
        //System.out.println(lista);
        //Existira este elemento dentro de la lista
        //System.out.println(lista.contains("hola"));
        //indexOf : devuelve el indice donde aparecio por primera vez un determinado elemento
        //System.out.println(lista.indexOf("hola"));
        //lastIndexOf : devuelve el indice donde aprece por ultima vez un determinado elemento
        //System.out.println(lista.lastIndexOf("hola"));
        //Sensible a mayusuculas y minusculas
        //Permite valores duplicados
        //set : reemplaza el elemento en la posicion indicada
        lista.set(2, "$$$$$$");
        //System.out.println(lista);
        //Agrega un elemento en la posicion indicada, recorriendo los demas eleemntos hacia la derecha
        //add (n, v) : Asigna un valor a un n posicion y recorrere la lista
        lista.add(5, "@@@@@@");
        //System.out.println(lista + "\n" + "========================================================");
        List<Ciudad> citys = new ArrayList<Ciudad>();

        //Instancear un objeto en la lista
        Ciudad c1 = new Ciudad
                (
                        "97223",
                        "Leon",
                        87392,
                        "Guanajuato",
                        "Textil",
                        "Templado"
                );
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

        Ciudad newCity = new Ciudad("69800", "Tlaxiaco", 20000, "Oaxaca", "Agricultura", "Templado");

        //Forma 1 : Creas primero el objeto, despues lo añades con add
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
        //Forma 2 : Crear el objeto al mismo tiempo que añadirlo
        /*citys.add
                (
                        new Ciudad
                                (
                                        "87491",
                                        "Coatzacoalcos",
                                        93282,
                                        "Petroleo",
                                        "Veracruz",
                                        "Tropical"
                                )
                );*/
        //foreach : por cada elemento de
        String ciudad = "Mérida";
        int index = 0;
        for (Ciudad c : citys) {
            //Determinar si el nombre de la ciudad actual coincide con la buscada
            //System.out.println(c);
            if (c.getNombre().equals(ciudad)) {
                index = citys.indexOf(c);
            }
            //ciudades con mas de 600000 habs
            if (c.getHabitantes() > 60000) {
                //System.out.println("Ciudad con una poblacion mayor a 600,000: " + "{" +c.getNombre() + "}");
            }
            //ciudades con actividad economica : comercio
            if (c.getActividadEco().equals("Comercio")) {
                //System.out.println("Ciudad con actividad economica: " + "{" + c.getNombre() + "}");
            }
            //ciudades con clima templado o seco
            if (c.getClima().equals("Templado") || c.getClima().equals("seco")) {
                //System.out.println("Ciudad con clima templado o seco: " + "{" + c.getNombre() + "}");
            }
        }
        //System.out.println("=======================================================================");
        //System.out.println(index);

        //Imprime el estado de la lista a antes de reemplazar
        for (Ciudad c : citys) {
            //System.out.println(c);
        }
        //Obtener una ciudad por indice

        //eliminar una ciudad por nombre, o actividad economica
        citys.remove(index);
        //existe la ciudad tal
        //System.out.println(citys.get(13));
        //cuantas ciudades hay en la lista?
        //System.out.println(citys.size());
        //indice de la ciudad x
        //System.out.println(citys.get(index));
        for (Ciudad c : citys) {
            //System.out.println(c);
        }
        //reemplazar una ciudad por otra
        citys.set(14, new Ciudad());
        //Existe 'Villahermosa'
        //System.out.println("Existe Villa?" + citys.contains(c11));
        //System.out.println("========== FINAL ===========");
        //Imprime el estado de la lista de reemplazar
        for (Ciudad c : citys) {
            //System.out.println(c);
        }

        System.out.println("//==========================================================================");

        Map<String, Equipo> registro = new HashMap<String, Equipo>();
        Map<String, Equipo> equipos = new HashMap<String, Equipo>();
        //Agregar elementos al mapa
        /*registro.put("24386018943",new Equipo("Alcatel", "OT557", "Gris", "Telcel", "Prepago", 800));
        registro.put("09234859383",new Equipo("Samsung", "Omnia", "Negro", "Movistar", "Pospago", 1600));
        registro.put("84983972938",new Equipo("Sony Ericsson", "W995", "Naranja", "Unefon", "Prepago", 2000));
        registro.put("02984379383",new Equipo("Kiocera", "K1", "Rojo", "Telcel", "Pospago", 1100));
        registro.put("02938484622",new Equipo("Pantech", "GMV-S", "Gris", "Unefon", "Pospago", 500));
        registro.put("90438702849",new Equipo("Nokia", "5800", "Negro", "Telcel", "Prepago", 2500));
        registro.put("94852039483",new Equipo("Motorola", "Razr", "Azul", "Movistar", "Prepago", 1500));
        registro.put("03894373734",new Equipo("LG", "Chocolate", "Negro", "Movistar", "Prepago", 1600));*/
        equipos.put("876876188275", new Equipo("Nokia", "N95 8GB", "Negro", "Telcel", "Prepago", 8000));
        equipos.put("834590243984", new Equipo("Samsung", "A05", "Azul", "Telcel", "Pospago", 2000));
        equipos.put("012983472435", new Equipo("Motorola", "Flip", "Rojo", "Telcel", "Prepago", 500));
        equipos.put("289470292832", new Equipo("LG", "G9", "Blanco", "Telcel", "Prepago", 3600));
        equipos.put("092843298329", new Equipo("Sony Ericsson", "W200", "Morado", "Telcel", "Prepago", 1800));
        equipos.put("987249812736", new Equipo("Nokia", "N96", "Negro", "Telcel", "Pospago", 9000));
        equipos.put("219387492832", new Equipo("Huawei", "P30", "Dorado", "Telcel", "Prepago", 7000));

        //tamanio del mapa
        System.out.println("Elementos en el mapa: " + registro.size());
        //Obtener un elemento del mapa
        System.out.println(registro.get("84983972938"));
        //Imprimir el mapa
        String[] datos;
        for (String key : equipos.keySet()) {
            System.out.println(equipos.get(key));
        }
        /**Eliminar elementos del mapa**/
        //System.out.println(registro.remove("94852039483"));//recibe la llave
        System.out.println(equipos.size());
        equipos.remove("219387492832");
        System.out.println(equipos.size());
        //Recibe la llave y un valor asociado si dicha llave asociada al valor, dado, elimina
        //el elemento si no, no lo elimina
        //registro.remove("02984379383","Kiocera K1 Rojo Telcel Pospago 1100");
        System.out.println(registro.size());
        /**Existe la llave ?**/
        System.out.println(registro.containsKey("90438702849"));
        /**Existe el valor ?**/
        System.out.println(registro.containsValue("LG Chocolate Negro Movistar Prepago  1600"));
        //Si al intentar registrar un nuevo valor con el metodo put usas una lllave que ya existe,
        //no crea un nuevo registro, sobreescribe el valor asociado a la llave
        //registro.put("90438702849","Nokia 808PV Blanco Telcel Prepago 8000");
        //Antes de reemplazar
        System.out.println(registro.get("09234859383"));
        /**Reemplazar un valor, solo si la llave existe**/
        //registro.replace("09234859383","Nokia Lumia640XL Azul Unefon Pospago 4000");
        //Despues de reemplazar
        System.out.println(registro.get("09234859383"));
        for (String key : equipos.keySet()) {
            if (equipos.get(key).getModalidad().equals("Pospago")) {
                System.out.println(equipos.get(key));
            }
        }
        for (String key : equipos.keySet()) {
            if (equipos.get(key).getCompania().equals("Telcel")) {
                System.out.println(equipos.get(key));
            }
        }
        System.out.println("//====================================================================");

        //Map<String, Map<String, List<Auto>>> catalogoGeneral = new HashMap<String, Map<String, List<Auto>>>();
        //Map<String, List<Auto>> catChevrolet = new HashMap<String, List<Auto>>();
        //List<Auto> listaUno = new ArrayList();

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

        for (String key : catalogGeneral.keySet()) {
            System.out.println(catalogGeneral.get(key));
        }
    }
}
