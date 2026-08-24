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

    Connection con = null; //La conexion a la base, (puerta)
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de a base

    public Map<String, List<ReciboDTO>> cargarCacheServicios() {
        Map<String, List<ReciboDTO>> servicios = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO recibo = null;
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
                //YA EXISTE AL MENOS 1 RECIBO REGISTRADOEN EL MAPA(ya existe le convenio en el mapa)

                if (servicios.containsKey(rs.getString("CONVENIO"))) {
                    servicios.get(rs.getString("CONVENIO")).add(recibo);

                } else {//si no, apenas estamos por registrar el primer recibo al servicio que tambien apenas agregamos
                    //se registra la llave primero (el convenio) con una lista vacia

                    servicios.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    //se añade el recibo a lalista que justo apenas acabo de agregar
                    servicios.get(rs.getString("CONVENIO")).add(recibo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return servicios;
    }

    public void actualizarStatusRecibo(String referencia) {
        String query = "UPDATE RECIBOS SET STATUS= '0' WHERE REFERENCIA =?";
        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            ps.setString(1, referencia);
            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Recibo pagado OK");
            } else {
                System.out.println("Error");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        }
    }

