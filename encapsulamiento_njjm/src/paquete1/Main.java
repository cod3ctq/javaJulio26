package paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

         ClaseUno o1 = new ClaseUno("1",2,"3");

         //Acceder de manera directa a un miembro del objeto
        //o1.primerAtributo = "hola"; //error, porque es private

        //Aunque no marque error, acceder de manera directa a los atributos de un objeto es incorrecto
        o1.segundoAtributo = 20; //No me da error porque es protected
        o1.tercerAtributo = "Java";


        //Forma correcta; Siempre se debe acceder a os atributos de una clase a través de los getters y setters.
        //¿Por qué? Porque son PÚBLICOS
        //No importa qué modificar de acceso tenga el atributo (pv,pr,pl), siempre debes acceder a través de los
        //getters y setters

        o1.setPrimerAtributo("Hola");
        o1.setSegundoAtributo(302);
        o1.setTercerAtributo("Yaba");

    }
}