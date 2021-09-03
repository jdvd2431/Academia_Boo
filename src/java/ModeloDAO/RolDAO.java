/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Conexion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author David
 */
public class RolDAO extends Conexion{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    public ArrayList<UsuarioVO> roles (String idTipoUsuario) {
        
        ArrayList<UsuarioVO> listaRoles = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.idUsuario, tipousuario.tipoUsuario from usuario INNER JOIN tipousuario on usuario.idTipoUsuario= tipousuario.idTipoUsuario where correo = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idTipoUsuario);
            mensajero = puente.executeQuery();
            
            while(mensajero.next()){
                UsuarioVO UsuVO = new UsuarioVO( mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(UsuVO);
                
            }
            
        } catch (SQLException e) {
        Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaRoles;
    }
    
}
