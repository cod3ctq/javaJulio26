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

public class ServicioDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //*******OBTIENE TODAS LAS CUENTAS ALMACENADAS EN LA BASE DE DATOS
    public Map<String, List<ReciboDTO>> cargarCacheServicios(){
        Map<String,List<ReciboDTO>> servicios = new HashMap<String,List<ReciboDTO>>();
        ReciboDTO recibo= null;
        String query = "SELECT * FROM WV_SERVICIOS_RECIBOS";

        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                recibo = new ReciboDTO(rs.getString("REFERENCIA"),
                        rs.getDate("FECHA_INICIO"),
                        rs.getDate("FECHA_FIN"),
                        rs.getDouble("MONTO"),
                        rs.getString("STATUS").charAt(0));
                //ya existe al menos 1 recibo registrado
                if (servicios.containsKey(rs.getString("CONVENIO"))) {
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                } else {//si no, a penas estamos por registrar el primer recibo al servicio que tambien agregamos
                    //se rgistra la llave primero (l convenio) con una lista vacia
                    servicios.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                }
            }
        }catch (Exception ex){
                ex.printStackTrace();
            }
        return  servicios;
        }
        public void actualizarStatusRecibido (String referencia) {
            String query = "UPDATE RECIBOS SET STATUS = '0' WHERE REFERENCIA= ?";
            try {
                con = ConexionOracle.getInstance().getCon();
                ps = con.prepareStatement(query);
                ps.setString(1, referencia);
                int x = ps.executeUpdate();
                if (x > 0) {

                    System.out.println("recibo pagado ok");
                } else {
                    System.out.println("error");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
