import java.util.ArrayList;
import java.util.List;

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
        List<Ciudad> citys = new ArrayList<>();

        //instanciar objetos
        //creas primero el objeto y despues se añade con add
        Ciudad c1 = new Ciudad("97223","Leon",87392,
                "Guanajuato","Textil","templado");
        citys.add(c1);//forma 1

        //crear el objeto al mismo tiempo de añadirlo
        citys.add(new Ciudad("87491","Coatzacoalcos",97584,
                "Veracruz","Petroleo","Tropical"));//forma 2
        Ciudad c2 = new Ciudad("44100","Guadalajara",1385629,
                "Jalisco","Comercio","templado");
        Ciudad c3 = new Ciudad("64000","Monterrey",1142994,
                "Nuevo León","Industria manufacturera","seco");
        Ciudad c4 = new Ciudad("72000","Puebla",1692181,
                "Puebla","Industria automotriz","templado");
        Ciudad c5 = new Ciudad("76000","Querétaro",1044553,
                "Querétaro","Industria aeroespacial","semiárido");
        Ciudad c6 = new Ciudad("20000","Aguascalientes",948990,
                "Aguascalientes","Industria automotriz","semiárido");
        Ciudad c7 = new Ciudad("25000","Saltillo",879958,
                "Coahuila","Industria automotriz","seco");
        Ciudad c8 = new Ciudad("31000","Chihuahua",925762,
                "Chihuahua","Industria manufacturera","seco");
        Ciudad c9 = new Ciudad("80000","Culiacán",1003100,
                "Sinaloa","Agricultura","cálido");
        Ciudad c10 = new Ciudad("83200","Hermosillo",936263,
                "Sonora","Ganadería","desértico");
        Ciudad c11 = new Ciudad("86000","Villahermosa",402150,
                "Tabasco","Industria petrolera","tropical");
        Ciudad c12 = new Ciudad("29000","Tuxtla Gutiérrez",604147,
                "Chiapas","Comercio","tropical");
        Ciudad c13 = new Ciudad("97000","Mérida",995129,
                "Yucatán","Turismo","cálido");
        Ciudad c14 = new Ciudad("77500","Cancún",934189,
                "Quintana Roo","Turismo","tropical");
        Ciudad c15 = new Ciudad("68000","Oaxaca",715061,
                "Oaxaca","Turismo","templado");
        Ciudad c16 = new Ciudad("39000","Chilpancingo",283354,
                "Guerrero","Comercio","cálido");
        Ciudad c17 = new Ciudad("91000","Xalapa",488531,
                "Veracruz","Servicios","templado húmedo");
        Ciudad c18 = new Ciudad("58000","Morelia",849053,
                "Michoacán","Servicios","templado");
        Ciudad c19 = new Ciudad("78000","San Luis Potosí",911908,
                "San Luis Potosí","Industria automotriz","semiárido");
        Ciudad c20 = new Ciudad("23000","La Paz",292241,
                "Baja California Sur","Turismo","desértico");

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
        int habs=0;
        for (Ciudad h:citys){
            if(h.getHabitantes()>600000){
                habs=citys.indexOf(h);
            }
        }
        System.out.println("Las ciudades con mas de 600'000 habitantes son: "+habs);

        //ciudades con actvidad economica: comercio
        int comercio=0;
        for (Ciudad c:citys){
            if(c.getActividadEco().equals("Comercio")){
                comercio=citys.indexOf(c);
            }
        }
        System.out.println("Las ciudades con actividad economica de comercio son: "+comercio);

        //ciudades con clima templado o seco
        int clima=0;
        for (Ciudad t:citys){
            if((t.getClima().equals("templado")) || (t.getClima().equals("seco"))){
                clima=citys.indexOf(t);
            }
        }
        System.out.println("Las ciudades con clima templado o seco son: "+clima);
    }
}