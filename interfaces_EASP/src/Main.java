public class Main {
    public static void main(String[] args) {

        //Con las interfaces heredamos solo el COMO (las acciones), dejando atras el QUE.
        //Una interface es un contrato o coleccion de metodos abstractos, donde todos TIENEN que cumplirse.
        //No hay atributos y por consecuencia, tampoco getter/setter, constructores, toString() (el QUE), pues NO es un modelo.
        //Una interface no se hereda, se implementa "implements".

        //Clase Padre
        Empleado e = new Empleado("PDJUED3488", "Pepe", 3, "E1");

        //Objetos de las clases hijas
        Rh recHu= new Rh("ABCDEF1234", "Fernanda", 5, "E2", "0987654321");

        TecnicoIT ti= new TecnicoIT("DEFGHI5678", "Carlos", 7, "E3", "56473829105");

        //Metodo propio de la clase padre
        e.checarEntrada();
        //Invoca el metodo heredado de la clase padre, a traves de los hijos
        recHu.checarEntrada();//Heredado de la clase Empleado, sin modificar
        ti.checarEntrada();

        //Metodos del contexto de este propio objeto, implementadas de la interfaz
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();

        //No esta implementada la interfaz que contiene este metodo en la clase correspondiente, por lo que no lo puede invocar
        //recHu.configurar();

        //Implementados de la interfaz ISoporteTecnico a la Clase TecnicoIt
        ti.gestionar();
        ti.mantener();
        ti.configurar();
        ti.generarReportes();

        //Implementados de la interfazIRecursosHumanos a la Clase TecnicoIT
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();


        //-----QUE acciones necesito, despues vemos quien la realiza-----

        //Declaramos un objeto de la interfaz con las acciones que deseamos realizar
        //Despues, a travez de quien vamos a realizar estas acciones, Quien es capaz de realizarlas
        ISoporteTecnico f1= new TecnicoIT("AEIOU098765", "Alan", 4, "E5", "10293847561" );
        f1.configurar();
        f1.gestionar();
        f1.generarReportes();
        f1.mantener();

        //Ya que la interfaz "IRecursosHumanos" esta implementada en ambas clases,
        //se puede acceder a los metodos a traves de diferentes sujetos
        IRecursosHumanos f2 = new Rh();
        IRecursosHumanos f3 = new TecnicoIT();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();








    }
}