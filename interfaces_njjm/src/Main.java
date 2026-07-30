//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto de la clase padre
        Empleado e = new Empleado("JUDH348DJ","Pepe",3,"E1");

        //Objetos de la clases hijas
        Rh recHu = new Rh("QWERT345","Fernanda",5,"E2","1234567890");
        TecnicoIT ti = new TecnicoIT("JUFNF78R","Carlos",4,"E3","84669");
        
        //Invoca el método heredado de la clase padre a través de los hijos
        e.checarEntrada();
        recHu.checarEntrada();
        ti.checarEntrada();

        //Métodos del contexto de este propio objeto
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();

        //Métodos de contexto de este propio objeto
        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();

        //Invoca métodos de su segunda interface, ya en este punto es evidente que podría acceder a todos los métodos
        //de cualquier interface que se haya implementado en esta clase.
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();

        //--------------------------------------------------------------------------------------------
        /*
        ¿Qué acciones necesito, después veo quién las realiza
         */

        //Las acciones de esta interface las ha implementado un solo sujeto o modelo. Entonces, sólo a través de ese
        //constructor podré instanciar un objeto para poder ejecutar esos métodos
        ISoporteTecnico f1 = new TecnicoIT("SDR435DF","Alan",3,"E5",23543);

        f1.configurar();
        f1.gestionarEquipos();
        f1.generarReportesIncidencias();
        f1.mantener();

        //Las acciones de esta interface fueron implementadas en más de 1 clase, de modo que es posible acceder a ellas
        //a través de diferentes sujetos (implementaciones)
        IRecursosHumanos f2 = new Rh();
        IRecursosHumanos f3 = new TecnicoIT();

        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();

    }
}