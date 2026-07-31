package paquete1;

public class Main {
    public static void main(String[] args) {

/*
Encapsulamiento:
controlar el acceso/visibilidad de los miembros de una
clase, a traves de 3 modificadores de acceso.

public      pasa            pasa            pasa

protected   pasa            pasa            pasa o no       *unicamente alcanzable en el nivel 3 aplicando herencia

private     pasa            no pasa         no pasa


                    ocultar

-> complejidad y exponer solo lo necesario;  -- Abstracción

o

->Proteger el estado del objeto y sus atributos;  -- Encapsulamiento



*/


    ClaseUno o1 = new ClaseUno("1",2,"3");

    //acceder de manera directa a un miebro de un objeto
    //o1.primerAtributo = "hola"; //error, porque es private

    //aunque no da error no es correcto de acceder de manera correcta
    // a los atributos de un objeto
    o1.segundoAtributo = 20; //no da error porque es protected
    o1.tercerAtributo = "java";


    /*
    siempre se debe acceder a los atributos de una clase mediante los
    getters y setters. porque son publicos.

    No importa que modificador de acceso tenga el atributo (pv,pr,pbl)
    siempre se debe acceder a traves de los gtr/str
     */
    o1.setPrimerAtributo("hola");
    o1.setSegundoAtributo(302);
    o1.setTercerAtributo("yaba");





    }
}