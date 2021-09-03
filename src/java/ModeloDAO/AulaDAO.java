/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.AulaVO;
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
public class AulaDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    
    private String sql;
    
    private String  idAula = "", nombre = "", capacidad  = "", estado = "";
     
    public AulaDAO(AulaVO AuVO){
     
         super();
        try {
            conexion = this.obtenerConexion();
            idAula = AuVO.getIdAula();
            nombre =AuVO.getNombre();
            capacidad =AuVO.getCapacidad();
            estado =AuVO.getEstado();
        } catch (Exception e) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
     }
   
    @Override
    public boolean agregarRegistro() {
    
        try {
            sql = "insert into aula("
                    + "idAula,"
                    + "nombre,"
                    + "capacidad,"
                    + "estado)"
                    + " values(?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idAula);
            puente.setString(2, nombre);
            puente.setString(3, capacidad);
            puente.setString(4, estado);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, e);
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
     public  ArrayList<AulaVO> listar(){
        
        ArrayList<AulaVO>listaAula = new ArrayList<>();
        
        
        try {
            conexion= this.obtenerConexion();
            sql="select * from aula";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                
                AulaVO AuVO= new AulaVO(mensajero.getString(1),mensajero.getString(2),
                    mensajero.getString(3), mensajero.getString(4));
                
                   listaAula.add(AuVO);
            }
        
        } catch (Exception e) {
              Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
              Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaAula;
        
    }
      
}
