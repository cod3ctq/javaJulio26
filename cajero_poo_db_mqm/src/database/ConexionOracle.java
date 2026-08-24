package database;

import java.sql.Connection;
import java.sql.DriverManager;

//clase que implementa el patron Singleton
//patron Singleton: limita la cantidad de objetos que se pueden hacer de
// una determinada clase, limite solo a 1
//garantiza el estado y consistencia de los datos
public class ConexionOracle {

    public static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver=OracleProvider.DRIVER;
    private String url=OracleProvider.URL;
    private String user=OracleProvider.USER;
    private String password=OracleProvider.PASSWORD;

    //este constructor privado no puede ser invocado por fuera de la propia
    //clase de modo que no puedes instanciar otra conexion en otro lugar
    private ConexionOracle(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            connection.setAutoCommit(true); //se realiza el commit en la base automaticamente
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionOracle getInstance(){
        return instancia;
    }
    public Connection getCon(){
        return connection;
    }
}
