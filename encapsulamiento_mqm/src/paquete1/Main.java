package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClaseUno o1 = new ClaseUno("1",2,"3");

        //acceder de manera directa a un miembro del objeto
        //o1.primerAtributo = "hola";//error, porque es private

        //aunque no marquen error, acceder de manera directa
        //a los atrbutos de un objeto es incorrecto
        o1.segundoAtributo = 20;//x protected
        o1.tercerAtributo = "java";//x public

        //forma correcta: siempre se debe acceder a los atributos de una clase
        //a traves de los getters y setters
        //porq? porque son PUBLICOS
        //los getters y setters siempre van a ser PUBLICOS asi sea el atributo privado
        //no importa que modificador de acceso tenga el atributo (private, protected, public)
        //siempre debes acceder a traves de los getters y setters
        o1.setPrimerAtributo("Hola");
        o1.setSegundoAtributo(302);
        o1.setTercerAtributo("Java");
    }
}