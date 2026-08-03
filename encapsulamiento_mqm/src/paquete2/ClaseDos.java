package paquete2;

import paquete1.ClaseUno;

public class ClaseDos extends ClaseUno{

    public ClaseDos (){

        ClaseUno c1 = new ClaseUno("4",5,"7");

        //Accediendo de manera directa
        //c1.primerAtributo = "c#";//error: private
        //c1.segundoAtributo = 80;//error: protected
        c1.tercerAtributo = "Ok";//ok: public

        //forma correcta: con getter y setters
        c1.setPrimerAtributo("Hola");
        c1.setSegundoAtributo(302);
        c1.setTercerAtributo("Java");

        c1.getPrimerAtributo();
        c1.getSegundoAtributo();
        c1.getTercerAtributo();

        //extendiendo la visibilidad de un miebro protegido de la clase de otro paquete
        //alcanzando herencia excepto el privado
        //this.primerAtributo = "C#";
        this.segundoAtributo = 80;
        this.tercerAtributo = "OK";
    }

}
