package database;

import java.sql.Connection;
import java.sql.DriverManager;
// Patron Singleton : limita la cantidad de objetos que se pueden hacer de una determinada clase
// Solo uno, garantiza el estado y consistencia de los datos
public class ConexionOracle {

    private static ConexionOracle instancia = new ConexionOracle();

    private Connection connection;

    private String driver = OracleProvider.DRIVER;
    private String url = OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;
    // Este constructor privado no puede ser invocado por fuera de la propia clase de modo que no puedes instanciar otro u otra conexion en otro lugar
    private ConexionOracle() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(true); // Persiste las operaciones del INSERT, UPDATE, DELETE
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ConexionOracle getInstancia() {
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }

}
