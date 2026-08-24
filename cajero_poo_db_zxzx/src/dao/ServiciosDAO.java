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

public class ServiciosDAO {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        public Map<String,List<ReciboDTO>> cargarCacheServicios() {
            Map<String, List<ReciboDTO>> servicios = new HashMap<String, List<ReciboDTO>>();
            ReciboDTO recibo = null;
            String query = "SELECT * FROM VW_SERVICIOS_RECIBOS";
            try{
                con = ConexionOracle.getInstance().getCon();
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                    recibo = new ReciboDTO(rs.getString("REFERENCIA"),
                            rs.getDate("FECHA_INICIO"),
                            rs.getDate("FECHA_FIN"),
                            rs.getDouble("MONTO"),
                            rs.getString("STATUS").charAt(0));
                    //¿Ya hiciste al menos un recibo registrado en el mapa? (Ya existe el convenio en le mapa)
                    if(servicios.containsKey(rs.getString("CONVENIO"))){
                        servicios.get(rs.getString("CONVENIO")).add(recibo);
                    }else{ //Si no, apenas estamos por registrar el primer recibo al servicio que también apenas agregamos
                        //Se registra la llave primero(el convenio) con una lista vacía
                        servicios.put(rs.getString("CONVENIO"),new ArrayList<ReciboDTO>());
                        //Se añade el recibo a la lista que justo apenas acabo de agregar
                        servicios.get(rs.getString("CONVENIO")).add(recibo);
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

            return servicios;
        }

        public void actualizarStatusRecibo(String referencia){
            String query = "UPDATE RECIBOS SET STATUS = '0' WHERE REFERENCIA = ?";
            try{
                con = ConexionOracle.getInstance().getCon();
                ps = con.prepareStatement(query);
                ps.setString(1,referencia);
                int x = ps.executeUpdate();
                if(x>0){
                    System.out.println("Recibo pagado OK");
                }else{
                    System.out.println("Error");
                }
            } catch (Exception ex) {

            }
        }

}
