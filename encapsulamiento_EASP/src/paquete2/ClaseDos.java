package paquete2;

import paquete1.Clase1;

public class ClaseDos extends Clase1{

    public ClaseDos(){
        Clase1 c1 = new Clase1 ("4", 5, "6");

        //c1.primerAtributo = "C#"; //No tiene acceso pues esta en otra clase (private)
        //c1.segundoAtributo = 20; //No tiene acceso pues esta en otro paquete (protected).
        this.segundoAtributo = 80; //Pero si se vuelve en un hijo de la clase,
                                   //Entonces si tiene acceso pues tiene acceso heredado.
        c1.tercerAtributo = "OK"; //Tiene acceso pues es "public", pero no es la forma correcta de acceder a este

        //Forma correcta: A travez de los getter Y setter
        c1.setPrimerAtributo("CeGato");
        c1.setSegundoAtributo(70);
        c1.setTercerAtributo("Palabra Ok");






    }

}
