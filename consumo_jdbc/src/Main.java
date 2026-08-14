import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Clases comunes de JDBC
        Connection con = null; //ENFUCHE, LA CONEXION A LA BASE
        PreparedStatement ps = null; //Entrada de las sentencias a la base
        ResultSet rs = null; //Salida de los resultados

        String query = "SELECT * FROM MOVIMIENTOS";


        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db2","admin");
            ps = con.prepareStatement(query); //Precompila o traduce el stringi a SQL nativo
            rs = ps.executeQuery(); //Play, ejecutas la sentencia

            while (rs.next()){
                System.out.println(rs.getInt("MOV_ID")+":"
                        +rs.getInt("CUENTA_ID")+":"
                +rs.getString("TIPO")+":"
                +rs.getDate("FECHA")+":"
                +rs.getDouble("MONTO"));
            }

        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }





    }
}