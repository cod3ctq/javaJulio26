package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//*********************DAO : DATA ACCES OBJECT
//ESTE COMPONENTE SE ENCARGA DE CENTRALIZAR LAS CONSULTAS HACIA LA BASE DE DATOS
public class CuentaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //*******OBTIENE TODAS LAS CUENTAS ALMACENADAS EN LA BASE DE DATOS
    public List<CuentaDTO> cargarCuentas() {
        String query = "SELECT * FROM " +
                "CUENTAS C INNER JOIN TARJETAS T " +
                "ON C.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON C.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        CuentaDTO cuenta = null;
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();

        try {
            con = ConexionOracle.getInstance().getCon();
            System.out.println("=========="+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); //ejecucion, como boton de play

            while (rs.next()) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo){ //actualiza el saldo de las cuentas
        String query="UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ? ";

        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2,numCuenta);
            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("saldo actualizado correctamente");
            }else{
                System.out.println("error al actualizar saldo");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
