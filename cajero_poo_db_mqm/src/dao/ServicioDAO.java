package dao;

import database.ConexionOracle;
import dto.ServicioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

//    public List<ServicioDTO> cargarServicios() {
//
//        String query = "SELECT * FROM WV_SERVICIOS_RECIBOS";
//        ServicioDTO servicio = null;
//        List<ServicioDTO> servicios = new ArrayList<ServicioDTO>();
//
//        try {
//            con = ConexionOracle.getInstance().getCon();
//            System.out.println("////cargarservicios////" + con);
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                servicio = new ServicioDTO(rs.getString("CONVENIO"),
//                        rs.getString("REFERENCIA"),
//                        rs.getDate("FECHA_INICIO"),
//                        rs.getDate("FECHA_FIN"),
//                        rs.getDouble("MONTO"),
//                        rs.getString("STATUS").charAt(0));
//                servicios.add(servicio);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return servicios;
//    }

    public void actualizarMonto(String referencia) {
        String query = "UPDATE RECIBOS SET STATUS = '0' WHERE REFERENCIA = ?";
        try {
            con = ConexionOracle.getInstance().getCon();
            System.out.println("/////actualizarmonto////" + con);
            ps = con.prepareStatement(query);
            ps.setString(1, referencia);
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Recibo pagado OK");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<ServicioDTO>> cachePagoServicios(){
        Map<String,List<ServicioDTO>> servicios = new HashMap<String,List<ServicioDTO>>();
        ServicioDTO recibo = null;
        String query="SELECT * FROM WV_SERVICIOS_RECIBOS";

        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                recibo = new ServicioDTO(rs.getString("CONVENIO"),
                        rs.getString("REFERENCIA"),
                        rs.getDate("FECHA_INICIO"),
                        rs.getDate("FECHA_FIN"),
                        rs.getDouble("MONTO"),
                        rs.getString("STATUS").charAt(0));
                //ya existe al menos 1 recibo registrado en el mapa (ya existe el convenio en el mapa)
                if(servicios.containsKey(rs.getString("CONVENIO"))){
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                }else{ //si no, apenas estamos por registrar el primer recibo al servicio que tambien apenas agregamos
                    //se registra la llave primero(el convenio) con una lista vacia
                    servicios.put(rs.getString("CONVENIO"),new ArrayList<ServicioDTO>());
                    //se añade el recibo a la lista que justo apenas acabo de agregar
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return servicios;

    }
}

