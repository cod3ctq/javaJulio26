public class Main {
    public static void main(String[] args) {

        Empleado e = new Empleado("PDJUED3488","Pepe",3,"E1");

        RH recHu = new RH("FHSMW847","Fernanda",5,"E2","0987654");

        TecnicoIT ti = new TecnicoIT("CD743JSDIA42","Carlos",7,"E3","98732528737");
        //Invoca el metodo heredado de la clase padre, a traves de los hijos
        e.checarEntrada();
        recHu.checarEntrada();
        ti.checarEntrada();
        //Metodos del contexto de este propio objeto
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();
        //metodos del cobtexto de este propio objeto
        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();
        //Invoca metodos de la segunda interface, ya en este punto
        //es evidete que posria acceder a todos los metodos de cualquier interface
        //que se haya implementado en esta clase
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();
        //-------- QUE acciones necesito, despues veo quien las realiza --------
        //Las acciones de esta interface las ha implementado un solo sujeto (modelo)
        //entonces solo a traves de ese constructor podria instanciar para poder ejecutar estos metodos
        ISoporteTecnico f1 = new TecnicoIT("AIURBFU83477","Alan",6,"E5","76542376824");
        f1.configurar();
        f1.gestionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();
        //Las acciones de esta interface fueron implementadas en mas de 1 clase
        IRecursosHumanos f2 = new RH();
        IRecursosHumanos f3 = new TecnicoIT();
        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();

    }
}