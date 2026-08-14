package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    //DAO : DATA ACCESS OBJECT
    //Este componente se encarga de centralizar las consultas hacia base de datos

public class CuentaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<CuentaDTO> cargarCuentas() {
        String query = "SELECT * FROM " +
                "CUENTAS C INNER JOIN TARJETAS T " +
                "ON C.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON C.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        CuentaDTO cuenta = null;
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();

        try {
            con = ConexionOracle.getInstance().getCon(); //Conexion Sigleton
            System.out.println("======= "+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

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
                        rs.getDouble("SALDO_MAX")
                );
                cuentas.add(cuenta);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ? ";

        try{
            con = ConexionOracle.getInstance().getCon(); //Conexion Sigleton
            System.out.println("> > > > > > > "+con);
            ps = con.prepareStatement(query);
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2,numCuenta);
            int x = ps.executeUpdate();

            if(x>0){
                System.out.println("SALDO ACTUALIZADO CORRECTAMENTE");
            }else{
                System.out.println("ERRO AL ACTUALIZAR SALDO");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
