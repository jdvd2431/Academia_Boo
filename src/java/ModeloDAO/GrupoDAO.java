/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import ModeloVO.GrupoVO;
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
 * @author Julian
 */
public class GrupoDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    private String idGrupo="", nombre="";
    private String estado="",  fechaInicio="",  fechaFin="";
    
        public GrupoDAO(GrupoVO grupoVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            idGrupo = grupoVO.getIdGrupo();
            nombre =grupoVO.getNombre();
            estado =grupoVO.getEstado();
            fechaInicio =grupoVO.getFechaInicio();
            fechaFin =grupoVO.getFechaFin();
           
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    @Override
    public boolean agregarRegistro() {
         try {
           sql ="INSERT INTO `grupo` (`idGrupo`,`nombre`, `estado`, `fechaInicio`, `fechaFin` ) VALUES (?,?,?,?,?)";
           puente = conexion.prepareStatement(sql);
            puente.setString(1, idGrupo);
            puente.setString(2, nombre);
            puente.setString(3, estado);
            puente.setString(4, fechaInicio);
            puente.setString(5, fechaFin);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, e);
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
        try {
            sql = "UPDATE `grupo` SET `estado`=? WHERE `idGrupo`=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, estado);
            puente.setString(2, idGrupo);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, e);
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
            sql = "UPDATE `grupo` SET `nombre`=?,`estado`=?,`fechaInicio`=?,`fechaFin`=? WHERE `idGrupo`=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, estado);
            puente.setString(3, fechaInicio);
            puente.setString(4, fechaFin);
            puente.setString(5, idGrupo);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    
    
    public  ArrayList<GrupoVO> listar(){
        
        ArrayList<GrupoVO>listaGrupo = new ArrayList<>();
        
        
        try {
            conexion= this.obtenerConexion();
            sql="SELECT * FROM `grupo`";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                
                GrupoVO GruVO= new GrupoVO(mensajero.getString(1),mensajero.getString(2),
                    mensajero.getString(3), mensajero.getString(4),mensajero.getString(5));
                
                   listaGrupo.add(GruVO);
            }
        
        } catch (Exception e) {
              Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
              Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaGrupo;
          
    }
}
