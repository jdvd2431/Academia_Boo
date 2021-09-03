/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.TipoNovedadVO;
import Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
   
    public class TipoNovedadDAO extends Conexion{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    public ArrayList<TipoNovedadVO> listar() {

        ArrayList<TipoNovedadVO> listaTipoNovedad = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM tiponovedad";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                TipoNovedadVO NovVO= new TipoNovedadVO(
                        mensajero.getString(1),
                        mensajero.getString(2));
                listaTipoNovedad.add(NovVO);

            }
        } catch (SQLException e) {
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return listaTipoNovedad;
    }
}
