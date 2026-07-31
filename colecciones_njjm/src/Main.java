import java.util.ArrayList;
import java.util.List;

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

    }
}