//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //LISTAS,  MAPAS,  CONJUNTOS
        //LIST VS ARRAYLIST:
        //list es una interface
        //ArrayList es una clase que implementa dicha interface
        List<String> lista = new ArrayList<String>();
//
//        lista.add("Hola");
//        lista.add("Java");
//        lista.add("----");
//        lista.add("desde");
//        lista.add("Puebla");
//        lista.add("texto");
//        lista.add("1");
//        lista.add("dos");
//        lista.add("Hola");
//        lista.add("III");

        //TAMAÑO DE LA LISTA
//        System.out.println(lista.size());
//
//        //IMPRIMIR LA LISTA
//        System.out.println(lista);
//
//        //VER UN ELEMENTO DE LA LISTA
//        System.out.println(lista.get(4));
//
//        //ELIMINAR UN ELEMENTO DE LA LISTA
//        lista.remove("texto");
//        lista.remove(6);
//        System.out.println(lista);
//        System.out.println(lista.size());
//
//        //EXISTE DENTRO DE LA LISTA
//        System.out.println(lista.contains("Java"));
//
//        //DEVUELVE EL INDICE DONDE APARECE POR PRIMERA VEZ UN DETERMINADO ELEMENTO
//        System.out.println(lista.indexOf("Hola"));
//
//        //DEVUELVE EL INDICE DONDE APARECE POR ULTIMA VEZ UN DETERMINADO TERMINO
//        System.out.println(lista.lastIndexOf("Hola"));
//        System.out.println(lista);
//
//        //REEMPLAZA EL ELEMENTO EN LA POSICION INDICADA POR OTRO ELEMENTO
//        lista.set(2, "$$$$$$");
//        System.out.println(lista);
//
//        //AGREGA ELEMENTOS EN LA LISTA, EN DETERMINADO INDICE, RECORRIENDO LOS DEMAS A LA DERECHA
//        lista.add(5, "@@@@");
//        System.out.println(lista);


        List<Ciudad> citys = new ArrayList<Ciudad>();

        //Crear primero el objeto, despues se añade con add.
        Ciudad c1 = new Ciudad("97223", "Leon", 87392, "Guanajuato", "textil", "templado");
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


        //Crear el objeto al mismo tiempo de añadirlo
        //citys.add(new Ciudad("Coatzacoalcos","87491",68787, "Veracruz","Petroleo","Tropical" ));
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

        System.out.println(citys);

        //foreach: por cada elemento de
//        int index = 0;
//        for (Ciudad c : citys) {
//            //Determinar si el nombre de la ciudad actual coincide con la buscada
//            if (c.getNombre().equals("Mérida")) {
//                index = citys.indexOf(c);
//            }
//        }
//        citys.remove(index);
        //System.out.println(c);

        //Obtener una ciudad por indice
        System.out.println(citys.get(8).getActividadEco());

        //Existe la ciudad villa hermosa
        System.out.println("¿Existe Villa hermosa?:" + citys.contains(c11));

        //indie de la ciudad 'x'
        System.out.println(citys.size());

        //IMPRIME LA LISTA DE CIUDAD ANTES DE REEMPLAZAR
        for (Ciudad c : citys) {
            System.out.println(c);
        }

//        //REEMPLAZAR UNA CIUDAD POR OTRA
//        citys.set(14, new Ciudad());
//        System.out.println("despues de reemplazar la ciudad ...");
//        for (Ciudad c : citys) {
//            System.out.println(c);
//        }

        //Ciudades con mas de 600,000 habitantes
        System.out.println("Las ciudades con mas de 600,000 habitantes, son: ");
        for (Ciudad c : citys) {
            //Determinar si el nombre de la ciudad actual coincide con la buscada
            if (c.getHabitantes()> 600000) {
                System.out.println(c.getNombre());
            }
        }
        //Ciudades con clima templado o seco:
        System.out.println("Las ciudades con clima templado o seco, son: ");
        for (Ciudad c: citys){
            if (c.clima.equals("templado")|| c.clima.equals("seco"))
                System.out.println(c.getNombre());
        }

        //ciudades con actividad economica: Comercio
        System.out.println("Las ciudades con actividad economica COMERCIO, son: ");
        for (Ciudad t: citys){
            if (t.getActividadEco().equals("Comercio")) {
                System.out.println(t.getNombre());
            }
        }

    }
}
