package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO: Data Access Object
//este componente se encarga de centralizar las consultas hacia base de datos

public class CuentaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //obtiene todas las cuentas almacenadas en base de datos
    public List<CuentaDTO> cargarCuentas() {
        String query ="SELECT * FROM CUENTAS C " +
                "INNER JOIN TARJETAS T " +
                "ON C.CUENTA_ID  = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON C.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        //variable temporal que se estara sobreescribiendo por cada insercion nueva
        CuentaDTO cuenta = null;
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();

        try {
            //Class.forName("oracle.jdbc.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//                    "db1","admin");
            con = ConexionOracle.getInstance().getCon();
            System.out.println("===========cargarcuentas=========="+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                cuenta = new CuentaDTO(rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getInt("TIPO_CUENTA_ID"),
                        rs.getString("NUM_CUENTA"),
                        rs.getString("CLABE"),
                        rs.getDouble("SALDO"),
                        rs.getDate("FECHA_AP"),
                        rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"),
                        rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO_MAX"));
                cuentas.add(cuenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuentas;
    }

    public void actualizarSaldo (String numCuenta, double nuevoSaldo){
        //signo ? es un marcador de posicion, reserva el espacio para llenarlo con otro valor
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";

        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//                    "db1","admin");
            con= ConexionOracle.getInstance().getCon();
            System.out.println("###########actualizarsaldo############"+con);
            ps = con.prepareStatement(query);
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2,numCuenta);
            int x = ps.executeUpdate(); //ejecuta la operacion

            if (x>0){
                System.out.println("Saldo actualizado correctamente \n"+nuevoSaldo);
            }else {
                System.out.println("Error al actualizar el saldo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
