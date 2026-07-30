//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de la clase padre

        Empleado e = new Empleado("PDJUE3455","PEPE",3,"E1");

        //Objetos de las clases hijas
        //
        Rh rechu = new Rh("FERNA4565","fernanda",3,"E2","55544547037");

        TecnicoIT ti = new TecnicoIT("FERNA4565","fernanda",3,"E2","55544547037");

        //invoca el metodo heredado atravez de los hijos
        e.checarEntrada();
        rechu.checarEntrada();
        ti.checarEntrada();

        ITSoporteTecnico f1 = new TecnicoIT("Casma435363","ALAN",6,"E3","563535633");
        f1.configurar();
        f1.gertionarEquipos();
        f1.mantener();
        f1.generarReportesIncidencias();
    }
}