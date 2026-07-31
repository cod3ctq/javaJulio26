package paquete2;

import paquete1.ClaseUno;

public class ClaseDos extends ClaseUno{

    public ClaseDos(){

        ClaseUno c1=new ClaseUno("4",
                5,"7");

        //Accediendo de manera directa
//        c1.primerAtributo= "C#"; Error: private
        this.segundoAtributo=80; //Error proteced  solo se puede llamar con this
        c1.tercerAtributo="OK"; //ok: public

        c1.setPrimerAtributo("HOLA");
        c1.setSegundoAtributo(302);
        c1.setTercerAtributo("Yaba");

        c1.getPrimerAtributo();
        c1.getSegundoAtributo();
        c1.getTercerAtributo();

    }

}
