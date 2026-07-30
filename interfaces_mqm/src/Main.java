//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de clase padre
        Empleado e = new Empleado("PDJUED3488","PEPE",3,"E1");

        //objetos de las clases hijas
        Rh recHu = new Rh("FHSMW847","FERNANDA",5,
                "E2","0987456123");
        TecnicoIT ti = new TecnicoIT("","",7,
                "","");

        //invoca el metodo heredado de la clase padre a traves de los hijos
        e.checarEntrada();
        recHu.checarEntrada();
        ti.checarEntrada();

        //metodos del contexto de este propio objeto
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();

        //metodos del contexto de este propio objeto
        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();

        //invoca metodos de su segunda interface ya en este punto
        //es evidencte que podria acceder a todos los metodos de cualquier interface
        //que se haya implementado en esta clase
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();

        //Que acciones necesito -- despues veo quien las realiza
        //interface = quien las realiza
        //las acciones de esta interface las ha implementado 1 solo sujeto
        //entonces solo atraves de este constructor podria instanciar un objeto
        //para poder ejecutar estos metodos
        ISoporteTecnico f1 = new TecnicoIT("AIURBFU83477","ALAN",
                5,"E5","76542376824");
        f1.configurar();
        f1.gestionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();

        //las acciones de esta interface fueron implementadas en mas de 1 clase
        //de modo que es posible acceder a ellas a traves de diferentes sujetos
        //(implementaciones)
        IRecursosHumanos f2 = new Rh();
        IRecursosHumanos f3 = new TecnicoIT();

        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();
    }
}