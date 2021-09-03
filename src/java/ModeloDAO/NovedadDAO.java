/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.NovedadVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class NovedadDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    
    private String sql;
    
    private String  idNovedad = "", descripcion = "", fechaInicio  = "", fechaFin="", idTipoNovedad = "" ,idAsistencia = "";
     
    public NovedadDAO(NovedadVO NovVO){
     
         super();
        try {
            conexion = this.obtenerConexion();
            idNovedad = NovVO.getIdNovedad();
            descripcion =NovVO.getDescripcion();
            fechaInicio =NovVO.getFechaInicio();
            fechaFin =NovVO.getFechaFin();
            idTipoNovedad=NovVO.getIdTipoNovedad();
            idAsistencia=NovVO.getIdAsistencia();
        } catch (Exception e) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     }
   
    @Override
    public boolean agregarRegistro() {
    
        try {
            sql = "insert into Novedad("
                    + "idNovedad,"
                    + "descripcion,"
                    + "fechaInicio,"
                    + "fechaFin,"
                    + "idTipoNovedad,"
                    + "idAsistencia)"
                    + " values(?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idNovedad);
            puente.setString(2, descripcion);
            puente.setString(3, fechaInicio);
            puente.setString(4, fechaFin);
            puente.setString(5, idTipoNovedad);
            puente.setString(6, idAsistencia);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(NovedadDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update `novedad` set `descripcion`=?,`fechaInicio`=?,`fechaFin`=?,`idTipoNovedad`=?,`idAsistencia`=? WHERE idNovedad=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, descripcion);
            puente.setString(2, fechaInicio);
            puente.setString(3, fechaFin);
            puente.setString(4, idTipoNovedad);
            puente.setString(5, idAsistencia);
            puente.setString(6, idNovedad);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(NovedadDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    @Override
    public boolean cambiarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public  ArrayList<NovedadVO> listar(){
        
        ArrayList<NovedadVO>listaNovedad = new ArrayList<>();
        
        
        try {
            conexion= this.obtenerConexion();
            sql="select * from novedad";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                
                NovedadVO AuVO= new NovedadVO(mensajero.getString(1),mensajero.getString(2),
                    mensajero.getString(3), mensajero.getString(4),mensajero.getString(5),mensajero.getString(6));
                
                   listaNovedad.add(AuVO);
            }
        
        } catch (Exception e) {
              Logger.getLogger(NovedadDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
              Logger.getLogger(NovedadDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaNovedad;
        
    }
     
      
}
