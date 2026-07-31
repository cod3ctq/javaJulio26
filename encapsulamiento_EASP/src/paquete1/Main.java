package paquete1; //Esto indica que esta dentro del paquete

public class Main {
    public static void main(String[] args) {

        Clase1 o1 = new Clase1("1", 2, "3");

        //Acceder de manera directa a un miembro del objeto
        //o1.primerAtributo = "hola"; //No tiene acceso, es "private". Ya no es la misma clase

        //Aunque no marquen error, acceder de manera directa a los atributos de un objeto es incorrecto
        o1.segundoAtributo = 20; //Si tiene acceso, es "protected". Estan en el mismo paquete
        o1.tercerAtributo = "30"; //Si tiene acceso, es "public". Estan en el mismo paquete

        //Forma correcta: Siempre se debe acceder a los atributos de una clase a traves de los getters y setters.
        //Pues son publicos
        //No importa que modificador de acceso tenga el atrivuto (pv, pr, pbl)
        //Siempre se debe acceder a traves de los getters y setters
        o1.setPrimerAtributo("Diez");
        o1.setSegundoAtributo(302);
        o1.setTercerAtributo("Java");




    }
}