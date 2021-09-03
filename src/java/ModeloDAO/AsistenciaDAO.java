/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.AsistenciaVO;
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
 * @author David
 */
public class AsistenciaDAO extends Conexion implements Crud{

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    
    private String sql;
    
     private String  idAsistencia = "", asistencia = "", fecha = "", idUsuario = "", idGrupo = "";
    
      public AsistenciaDAO(AsistenciaVO AsiVO){
    
         super();
        try {
            conexion = this.obtenerConexion();
            idAsistencia = AsiVO.getIdAsistencia();
            asistencia =AsiVO.getAsistencia();
            fecha =AsiVO.getFecha();
            idUsuario =AsiVO.getIdUsuario();
            idGrupo =AsiVO.getIdGrupo();
        } catch (Exception e) {
            Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into asistencia("
                    + "idAsistencia,"
                    + "asistencia,"
                    + "fecha,"
                    + "idUsuario,"
                    + "idGrupo)"
                    + " values(?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idAsistencia);
            puente.setString(2, asistencia);
            puente.setString(3, fecha);
            puente.setString(4, idUsuario);
            puente.setString(5, idGrupo);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, e);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cambiarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public  ArrayList<AsistenciaVO> listar(){
        
        ArrayList<AsistenciaVO>listaAsistencia = new ArrayList<>();
        
        
        try {
            conexion= this.obtenerConexion();
            sql="select * from asistencia";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                
                AsistenciaVO AsisVO= new AsistenciaVO(mensajero.getString(1),mensajero.getString(2),
                    mensajero.getString(3), mensajero.getString(4),mensajero.getString(5));
                
                   listaAsistencia.add(AsisVO);
            }
        
        } catch (Exception e) {
              Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
              Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaAsistencia;
        
    }
   }
