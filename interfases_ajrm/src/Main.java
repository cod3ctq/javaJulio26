//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

          /*Interface: Es un contrato/coleccion de metodos abstractos,
        donde todos tienen que cumplirse.
        No hay atributos y por consecuencia, tampoco
        getter/setters, constructores, toString()
        NO ES UN MODELO, ES UN CONTRATO

                            */
        //Clase Padre
        Empleado e = new Empleado("PDKFJS45", "Pepe", 3, "E1");

        //Objetos de las clases Hijas
        RH recHu = new RH("FDCDC45D", "Fernanda",
                5, "E2", "0945712036");

        TecnicoIT ti = new TecnicoIT("EDFAS45", "Carlos",
                7, "E3", "98457120");

        //Invoca el metodo heredado de la clase padre, a traves de los hijos
            e.checarEntrada();
            recHu.checarEntrada();
            ti.checarEntrada();

        //Metodos del contexto de este propio objeto
            recHu.capacitar();
            recHu.gestionarExpedientes();
            recHu.entrevistar();
            recHu.reclutar();

            //Metodos del contexto de este propio objeto
            ti.gestionarEquipos();
            ti.mantener();
            ti.configurar();
            ti.generaReportesIncidencias();

            //Invoca metodos de su segunda interface, ya en este punto
            //es evidente que podria acceder a todos los metodos de cualquier
            //interface que se haya implementado en esta clase
            ti.entrevistar();
            ti.capacitar();
            ti.gestionarExpedientes();

            //-----QUE ACCIONES NECESITO, DESPUES VEO QUIEN LAS REALIZA----

            //Las acciones de esta interface als ha implementado 1 solo sujeto
            //Entonces, solo a traves de ese constructor podria instanciar un objeto
            //para poder ejecutar estos modelos
            ISoporteTecnico f1 = new TecnicoIT("ADFDFDVFD", "Alan", 6,
                    "E5", "7456156451");
            f1.configurar();
            f1.gestionarEquipos();
            f1.generaReportesIncidencias();
            f1.generaReportesIncidencias();


            //Las acciones de esta interface fueron implementadas en mas de 1 clase
            //de modo que es posible acceder a ellas a traves de diferentes sujetos
            //(implementados)
            IRecursosHumanos f2 = new RH();
            IRecursosHumanos f3 = new TecnicoIT();
            f2.capacitar();
            f3.capacitar();
            f2.gestionarExpedientes();
            f3.gestionarExpedientes();

    }
}