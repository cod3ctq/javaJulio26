public class Main {
    public static void main(String[] args) {

        // Unca interfaz no se hereda, se implementa, funcion implements

        Empleado e = new Empleado("PDJUED3488","Pepe",3,"E1");


        //OBJETOS DE LAS CLASES HIJAS

        Rh recHu = new Rh("FHSMW847","Fernanda",5,"E2","0987654321");

        TecnicoIT ti = new TecnicoIT("CD743JSDIA42","Carlos",7,"E3","1234567890");

        //invoca el metodo heredado de la clase padre atraves de los hijos


        // metodos del contexto de este propio objeto

        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.Entrevistar();
        recHu.reclutar();

        //metodos del contecto de este proporio objeto
        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();
        ti.Entrevistar();

/*
        ---- Que acciones necesito, despues veo quien las realiza ----

        las acciones de esta interface las ha implementado un solo sujeto (modelo)
        solo a traves de ese constructor podría instanciar un objeto
        para poder ejecutar estos metodos
*/

        ISoporteTecnico f1 = new TecnicoIT("AIURBFU83477","Alan",5,"E3","ASDEFS5654");
        f1.configurar();
        f1.gestionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();

        /*
        Las acciones de esta interface fueron implementadas en mas de una clase
        de modo que es posible acceder a ellas a traves de diferentes sujetos
         */

        IRecursosHumanos f2 = new Rh();
        IRecursosHumanos f3 = new TecnicoIT();

        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();





    }
}