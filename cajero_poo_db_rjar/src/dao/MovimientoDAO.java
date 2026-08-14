package dao;

import database.ConexionOracle;
import dto.MovimientoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientoDAO {

    //Clases de JDBC (TEMPORALENTE ESTARAN AQUI, despues se ubicaran en su lugar correcto)
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public void registrarMovimiento(MovimientoDTO dto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA,MONTO)VALUES(?,?,?,?)";
        try {

            con = ConexionOracle.getInstance().getCon();//CONEXION singleton
            System.out.println("<<<<<<<>>>>>>>"+con);
            ps = con.prepareStatement(query);
            ps.setInt(1, dto.getCuentaId());
            ps.setString(2, dto.getTipo());
            ps.setDate(3, dto.getFechaOp());
            ps.setDouble(4, dto.getMonto());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Saldo actualizado correctamente");
            } else {
                System.out.println("Error al actualizar saldo");
            }
        } catch (Exception ex) {

        }
    }
}
