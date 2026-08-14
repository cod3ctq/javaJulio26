package dao;

import database.ConexionOracle;
import dto.RecibosDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecibosDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Map<String, List<RecibosDTO>> cargarRecibos(){
        String query = "SELECT * FROM SERVICIOS SR " +
                "INNER JOIN RECIBOS RC " +
                "ON SR.SERVICIO_ID = RC.SERVICIO_ID " +
                "WHERE STATUS = '1' ";
        RecibosDTO recibo = null;
        Map<String, List<RecibosDTO>> recibos = new HashMap<String, List<RecibosDTO>>();

        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                recibo = new RecibosDTO(rs.getString("REFERENCIA"),
                        rs.getDate("FECHA_INICIO"),
                        rs.getDate("FECHA_FIN"),
                        rs.getDouble("MONTO"),
                        rs.getString("STATUS").charAt(0));
                if (recibos.containsKey(rs.getString("CONVENIO"))){
                    recibos.get(rs.getString("CONVENIO")).add(recibo);
                }else {
                    recibos.put(rs.getString("CONVENIO"), new ArrayList<RecibosDTO>());
                    recibos.get(rs.getString("CONVENIO")).add(recibo);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return recibos;
    }

    public void actualizarStatus (String referencia){
        String query = "UPDATE RECIBOS SET STATUS = 0 WHERE REFERENCIA = ?";

        try{

            con= ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            ps.setString(1, referencia);
            int x = ps.executeUpdate();

            if(x>0){
                System.out.println("RECIBO PAGADO: OK");
            }else{
                System.out.println("Error");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}