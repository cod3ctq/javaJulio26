package database;

import java.sql.Connection;
import java.sql.DriverManager;

//Patron Singleton : Limita la cantidad de objetos que se pueden hacer de una determinada clase
//Solo , garantiza el estado y consistencia de los datos.
public class ConexionOracle {

    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver=OracleProvider.DRIVER;
    private String url=OracleProvider.URL;
    private String user=OracleProvider.USER;
    private String password=OracleProvider.PASSWORD;

    //Este constructor privado no puede ser invocado por fuera de la propia clase
    //de modo que no puedes instanciar otra conexion en otro lugar
    private ConexionOracle(){
        try{
         Class.forName(driver);
         connection = DriverManager.getConnection(url,user,password);
         //Lit un autoguardado
         connection.setAutoCommit(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static ConexionOracle getInstance(){
        return instancia;
    }
    public Connection getCon(){
        return connection;
    }

}
