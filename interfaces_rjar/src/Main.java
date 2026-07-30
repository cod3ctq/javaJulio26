public class Main {
    public static void main(String[] args) {

        //objeto de la clase padre

        Empleado e=new Empleado("PDJUED3488","Pepe",3,"E1");

        //Objeto de las claseshijas
        Rh recHu= new Rh("FHSMW847","Fernanda",5,"E2","0987654321");

        TecnicoIT ti=new TecnicoIT("CD743JSDIA42","CARLOS",7,"E3","981732528737");

        //Invocar el metodo dela padre a traves de los hijos
        //************************************
//        e.checarEntrada();
//        recHu.checarEntrada();
//        ti.checarEntrada();

        //Metodos del contexto de este propio objeto
        recHu.capacitar();
        recHu.gestionarExpedientes();
        recHu.entrevistar();
        recHu.reclutar();

        ti.gestionarEquipos();
        ti.mantener();
        ti.configurar();
        ti.generarReportesIncidencias();

        //Invoca de su segunda interface, ya que en este punto es evidente que podria acceder a todos los metdodos
        //de cualquier interface que se haya implementado en esta clase
        ti.entrevistar();
        ti.capacitar();
        ti.gestionarExpedientes();


        //--------QUE acciones necesito, despues veo quien las ealiza---------------------
        //interface                  clase
        //Las acciones de esta interface las a implementado 1 solo sujeto(modelo)
        //entonces solo a traves de ese constructor podria instanciar un objeto para poder ejecutar estos metodos
        ISoporteTecnico f1= new TecnicoIT("AIURBFU","ALAN",5,"E5","758565555555");
        f1.configurar();
        f1.gestionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();

        //Las acciones de esta interface fueron implementadas en mas de 1 clase de modo que es
        //posible acceder a ellas a traves de diferentes sujetos(implementaciones)
        IRecursosHumanos f2 =  new Rh();
        IRecursosHumanos f3= new TecnicoIT();
        f2.capacitar();
        f3.capacitar();
        f2.gestionarExpedientes();
        f3.gestionarExpedientes();


    }
}