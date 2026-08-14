package database;

import java.sql.Connection;
import java.sql.DriverManager;

//Patron de diseño Singleton: Limita la cantidad de objetos que se pueden hacer de una determinada clase
//Solo permite 1. Esto garantiza el estado y consistencia de los datos
//De esta forma solo se usa una direccion de memoria para la conexion a la base de datos, en vez de ocupar
//una direccion de memoria para cada conexion
public class ConexionOracle {
    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver = OracleProvider.DRIVER;
    private String url = OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;

    //Este constructor privado no puede ser invocado por fuera de la propia clase
    //De modo que no puedes instanciar otra conexion en otro lugar
    private ConexionOracle(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
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
