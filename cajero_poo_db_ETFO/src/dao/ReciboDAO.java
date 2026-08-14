package dao;

import database.ConexionOracle;
import dto.ReciboDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReciboDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Map<String, List<ReciboDTO>> cargarRecibos() {
        Map<String,List<ReciboDTO>> servicios = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO recibo = null;
        String query = "SELECT S.CONVENIO, R.REFERENCIA, R.FECHA_INICIO, R.FECHA_FIN, R.MONTO, R.STATUS "
                     + "FROM SERVICIOS S "
                     + "INNER JOIN RECIBOS R "
                     + "ON S.SERVICIO_ID = R.SERVICIO_ID";
        try {
            con = ConexionOracle.getInstancia().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                recibo = new ReciboDTO
                        (
                                rs.getString("REFERENCIA"),
                                rs.getDate("FECHA_INICIO"),
                                rs.getDate("FECHA_FIN"),
                                rs.getDouble("MONTO"),
                                rs.getString("STATUS").charAt(0)
                        );
                // Ya existe al menos un recibo registrado en el mapa? es decir ya existe el convenio en el mapa?
                if(servicios.containsKey(rs.getString("CONVENIO"))) {
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                } else { // Si no, apenas estamos por registrar el primer recibo al servicio que tambien agregamos
                    servicios.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return servicios;
    }

    public void actualizarStatusRecibo(String referencia) {
        String query = "UPDATE RECIBOS SET STATUS = '0' WHERE REFERENCIA = ?";
        try {
            con = ConexionOracle.getInstancia().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, referencia);
            int x =  ps.executeUpdate();
            if (x > 0) {
                System.out.println("Recibo actualizado correctamente");
            } else {
                System.out.println("Error al actualizar el recibo el recibo");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
