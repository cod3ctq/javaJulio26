package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClaseUno o1 = new ClaseUno("1",2,"3");

        //acceder de manera sirecta a un miembro de objeto
       // o1.primerAtributo   = "hola";//error es privadode manera

        //aunque no marque el error acceder de manera a los atributos
        o1.segundoatributo =20;
        o1.terceratributo="2";

        //forma correcta siempre debe de acceder a los atributos de una clase
         //a travez dde los geters setter
        //no importa que modificador de acceso tenfga (pv pb pt)
        //siempre debes accedeer con geter y seter

        o1.setPrimeratributo("hola");
        o1.setSegundoatributo(3);
        o1.setTerceratributo("yaba");
    }
}