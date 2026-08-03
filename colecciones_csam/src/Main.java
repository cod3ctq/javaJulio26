import java.util.ArrayList;
import java.util.List;

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




    }
}