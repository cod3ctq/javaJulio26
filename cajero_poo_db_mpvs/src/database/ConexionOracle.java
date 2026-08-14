package database;

import java.sql.Connection;
import java.sql.DriverManager;

//PATRON SINGLETON: LIMITA LA CANTIDAD DE OBJETOS QUE SE PUEDEN HACER DE UNA DETERMINADA CLASE.
//SOLO 1, ESTO GARANTIZA EL ESTADO Y CONSISTENCIA DE LOS DATOS

public class ConexionOracle {

    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection ;

    private String driver= OracleProvider.DRIVER;
    private String url= OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;

    //********ESTE CONSTRUCTOR PRIVADO NO PUEDE SER INVOCADO POR FUERA DE LA PROPIA CLASE, DE MODO QUE NO PUEDES
    //INSTANCIAR OTRA CONEXION EN OTRO LUGAR
    private ConexionOracle(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
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
