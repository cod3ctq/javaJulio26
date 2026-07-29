//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tablet t1 = new Tablet();


        //instanciando el obejto lleno desde el inicio
        Tablet t2 = new Tablet(11.3 ,"negro","rectangulo",230.00,7500.00,"Samsung",8,"abdroid");
        Aplicacion a1 = new Aplicacion("Facebook", "Redes Sociales","1.15",50.6,true);
        Aplicacion a2 = new Aplicacion("Galeria", "Aplicacion de sistema","3.28",20.6,true);
        Aplicacion a3 = new Aplicacion("Spotify", "Streaming","60.15",200.6,false);

        Aplicacion[] apps = {a1, a2, a3};


        //System.out.println(t3);
        //imprime el estado del objeto
        System.out.println(t1);
        System.out.println(t2);

        
    }
}