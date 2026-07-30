//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //OBJETO DE LA CLASE PADRE
        Empleado e= new Empleado("PDJUED3488","Pepe",3,"E1");

        //OBJETOS DE LAS CLASES HIJAS
        Rh recHu= new Rh("FHSMW847", "Fernanda", 5, "E2", "0987654321");

        TecnicoIT ti = new TecnicoIT("CD743JSDIA42","Carlos", 7,"E3", "98732528737");

       //INVOCAR EL METODO HEREDADO DE LA CLASE PADRE, A TRAVES DE LOS HIJOS
        e.checarEntrada();
        recHu.checarEntrada();
        ti.checarEntrada();


       //METODOS DEL CONTEXTO DE ESTE PROPIO OBJETO
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();

        //METODOS DEL CONTEXTO
        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();

        //Invoca metodos de su segunda interface, ya en este punto es evidente que podria acceder a todos los metodos
        // de cualquier interface que se haya implementado en esta clase
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();

        //************  Que acciones necesito, despues veo quien las realiza  *************
        //Las acciones de esta interface las ha implementad 1 solo sujeto (mode), entonces, solo a traves de este constructor
        ISoporteTecnico f1 = new TecnicoIT("hdgshchcj", "ALAN", 3,"E5", "HSGDHEJDJ" );
        f1.configurar();
        f1.gestionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();

        //Las acciones de esta interface fueron implementadas en mas de 1 clase, de modo que es posible acceder a ellas
        //a traves de diferentes sujetos (implementaciones)

        IRecursosHumanos f2 = new Rh();
        IRecursosHumanos f3 = new TecnicoIT();
        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();



    }
}