package paquete2;

import paquete1.ClaseUno;

public class ClaseDos extends ClaseUno{

    public ClaseDos(){
        ClaseUno c1 = new ClaseUno("4",5,"6");

        //Accediendo de manera directa
//        c1.primerAtributo = "C"; Error: private
//        c1.segundoAtributo =34; Error: protected
        c1.tercerAtributo = "#$"; //OK. public

        //c1.primerAtributo = "C"; Error: private
        this.segundoAtributo =34; //OK: protected (Por la herencia extends)
        this.tercerAtributo = "#$"; //OK. public

        c1.setPrimerAtributo("2");
        c1.setSegundoAtributo(3);
        c1.setTercerAtributo("$");



    }



}
