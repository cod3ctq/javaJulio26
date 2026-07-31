package paquete1;

import paquete2.ClaseDos;

public class Main {
    public static void main(String[] args) {

        ClaseUno o1= new ClaseUno("1",2,"3");

        //acceder de anera dirceta a un membro del objeto
       // o1.primerAtributo="hola"; //error, porque es private

        //Anque no marquen error , acceder de manera directa a los atributos de un objeto es incorrecto
        o1.segundoAtributo= 20; //es protected
        o1.tercerAtributo="java";


        //forma correcta: Siempre se debe de acceder a los atributos de una clase a traves
        //de los getters y setters. Por que? Pporque son PUBLICOS
        //No importa que moificador de escceso tenga el atributo (pv pr, pbl)
        //siempre debes acceder a traves de los gtr/str
        o1.setPrimerAtributo("hOLA");
        o1.setSegundoAtributo(302);
        o1.setTercerAtributo("Yaba");


    }
}