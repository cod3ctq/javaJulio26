package paquete2;

import paquete1.ClaseUno;

public class ClaseDos extends ClaseUno{

    public ClaseDos(){
        ClaseUno c1 = new ClaseUno("4",5,"7");

        //Accendiendo de manera directa
        //c1.primerAtributo = "c#"; //ERROR: private
        //this.segundoAtributo = 80; // ERROR: protected
        this.tercerAtributo = "ok";   //ok: public


        c1.setPrimerAtributo("Hola");
        c1.setSegundoAtributo(302);
        c1.setTercerAtributo("yaba");

        c1.getPrimerAtributo();
        c1.getSegundoAtributo();
        c1.getSegundoAtributo();




    }




}
