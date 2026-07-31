package paquete2;

import paquete1.claseUno;

public class claseDos extends claseUno{

    public claseDos()
    {
        claseUno o1 = new claseUno("1",2,"3");
        //Accediendo de manera directa;
        //o1.primerAtributo = "C#";
        //o1.segundoAtributo = 80;
        o1.tercerAtributo = "Ok";
        this.tercerAtributo = "Ok";
        this.segundoAtributo = 1;//Si alcanzo al protected
        //this es mas relacionado a su origen por lo cual si puede hacer la excepcion con portected
        //Forma correcta
        o1.setPrimerAtributo("hola");
        o1.setSegundoAtributo(2);
        o1.setTercerAtributo("Yaba");
    }
}
