package paquete1;

public class Main {
    public static void main(String[] args) {

        claseUno o1 = new claseUno("1",2,"3");

        //acceder de manera directa a un miembro del objeto
        //o1.primerAtributo = "hola";//error, porque es private
        //Aunque no masquen error, acceder de manera directa a los atributos de un objeto es incorrecto
        o1.segundoAtributo = 20; //es protected
        o1.tercerAtributo = "Java";

        //forma correcta: Siempre se debe de acceder a los atributos de una clase a traves de los getters
        // y setters. ¿Por que? porque son publicos
        //No importa que modificador de acceso tenga el atributo (private, portected, public) siempre debes acceder por los setters y getters
        o1.setPrimerAtributo("hola");
        o1.setSegundoAtributo(6);
        o1.setTercerAtributo("hola");
    }
}