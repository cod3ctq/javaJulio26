import java.util.ArrayList;
import java.util.List;

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
        System.out.println(lista.size());
        //imprimir la lista
        System.out.println(lista);
        //ver elemento especifico de la lista
        System.out.println(lista.get(4));
        //eliminar un elemento de la lista
        lista.remove("texto");
        System.out.println(lista.size());
        lista.remove(6);
        System.out.println(lista.size());
        System.out.println(lista);
        //Existira este elemento dentro de la lista
        System.out.println(lista.contains("hola"));
        //indexOf : devuelve el indice donde aparecio por primera vez un determinado elemento
        System.out.println(lista.indexOf("hola"));
        //lastIndexOf : devuelve el indice donde aprece por ultima vez un determinado elemento
        System.out.println(lista.lastIndexOf("hola"));
        //Sensible a mayusuculas y minusculas
        //Permite valores duplicados
        //set : reemplaza el elemento en la posicion indicada
        lista.set(2, "$$$$$$");
        System.out.println(lista);
        //Agrega un elemento en la posicion indicada, recorriendo los demas eleemntos hacia la derecha
        //add (n, v) : Asigna un valor a un n posicion y recorrere la lista
        lista.add(5, "@@@@@@");
        System.out.println(lista + "\n" + "========================================================");
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
        Ciudad c13 = new Ciudad("97000","Mérida",995129, "Yucatán","Turismo","cálido");
        Ciudad c14 = new Ciudad("77500","Cancún",934189, "Quintana Roo","Turismo","tropical");
        Ciudad c15 = new Ciudad("68000","Oaxaca",715061, "Oaxaca","Turismo","templado");
        Ciudad c16 = new Ciudad("39000","Chilpancingo",283354, "Guerrero","Comercio","cálido");
        Ciudad c17 = new Ciudad("91000","Xalapa",488531, "Veracruz","Servicios","templado húmedo");
        Ciudad c18 = new Ciudad("58000","Morelia",849053, "Michoacán","Servicios","templado");
        Ciudad c19 = new Ciudad("78000","San Luis Potosí",911908, "San Luis Potosí","Industria automotriz","semiárido");
        Ciudad c20 = new Ciudad("23000","La Paz",292241, "Baja California Sur","Turismo","desértico");

        Ciudad newCity = new Ciudad("69800","Tlaxiaco",20000, "Oaxaca","Agricultura","Templado");

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
            if(c.getHabitantes()>60000) {
                System.out.println("Ciudad con una poblacion mayor a 600,000: " + "{" +c.getNombre() + "}");
            }
            //ciudades con actividad economica : comercio
            if(c.getActividadEco().equals("Comercio")){
                System.out.println("Ciudad con actividad economica: " + "{" + c.getNombre() + "}");
            }
            //ciudades con clima templado o seco
            if(c.getClima().equals("Templado") || c.getClima().equals("seco")){
                System.out.println("Ciudad con clima templado o seco: " + "{" + c.getNombre() + "}");
            }
        }
        //System.out.println("=======================================================================");
        System.out.println(index);

        //Imprime el estado de la lista a antes de reemplazar
        for (Ciudad c : citys) {
            System.out.println(c);
        }
        //Obtener una ciudad por indice

        //eliminar una ciudad por nombre, o actividad economica
        citys.remove(index);
        //existe la ciudad tal
        System.out.println(citys.get(13));
        //cuantas ciudades hay en la lista?
        System.out.println(citys.size());
        //indice de la ciudad x
        System.out.println(citys.get(index));
        for (Ciudad c : citys) {
            System.out.println(c);
        }
        //reemplazar una ciudad por otra
        citys.set(14, new Ciudad());
        //Existe 'Villahermosa'
        System.out.println("Existe Villa?" + citys.contains(c11));
        System.out.println("========== FINAL ===========");
        //Imprime el estado de la lista de reemplazar
        for (Ciudad c : citys) {
            System.out.println(c);
        }
    }
}