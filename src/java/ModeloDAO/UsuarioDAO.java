/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
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
public class UsuarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String usuId = "", correo = "", clave = "";
    private String nombre = "", apellido = "", tipoDocumento = "", numDocumento = "", celular = "", telefono = "", estado = "", idTipoUsuario = "";

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            usuId = usuVO.getUsuId();
            nombre = usuVO.getNombre();
            apellido = usuVO.getApellido();
            tipoDocumento = usuVO.getTipoDocumento();
            numDocumento = usuVO.getNumDocumento();
            celular = usuVO.getCelular();
            telefono = usuVO.getTelefono();
            estado = usuVO.getEstado();
            correo = usuVO.getCorreo();
            clave = usuVO.getClave();
            idTipoUsuario = usuVO.getIdTipoUsuario();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into usuario("
                    + "idUsuario,"
                    + "nombre,"
                    + "apellido,"
                    + "tipoDocumento,"
                    + "documento,"
                    + "celular,"
                    + "telefono,"
                    + "estado,"
                    + "correo,"
                    + "clave,"
                    + "idTipoUsuario)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.setString(2, nombre);
            puente.setString(3, apellido);
            puente.setString(4, tipoDocumento);
            puente.setString(5, numDocumento);
            puente.setString(6, celular);
            puente.setString(7, telefono);
            puente.setString(8, estado);
            puente.setString(9, correo);
            puente.setString(10, clave);
            puente.setString(11, idTipoUsuario);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
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
            sql = "update `usuario` set `nombre`=?,`apellido`=?,`tipoDocumento`=?,`documento`=?,`celular`=?,`telefono`=?,`estado`=?,`correo`=?,`clave`=?,`idTipoUsuario`=? WHERE idUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            puente.setString(2, apellido);
            puente.setString(3, tipoDocumento);
            puente.setString(4, numDocumento);
            puente.setString(5, celular);
            puente.setString(6, telefono);
            puente.setString(7, estado);
            puente.setString(8, correo);
            puente.setString(9, clave);
            puente.setString(10, idTipoUsuario);
            puente.setString(11, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
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
            sql = "UPDATE `usuario` SET `estado`=? WHERE `idUsuario`=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, estado);
            puente.setString(2, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    public boolean iniciarSesion(String correo, String clave) {

        try {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM usuario WHERE correo=? AND clave=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    public boolean SelecionarIdAula(String correo, String clave) {

        try {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM usuario WHERE correo=? AND clave=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
            }
        }
        return operacion;
    }

    public UsuarioVO ConsultarId(String usuId) {

        UsuarioVO UsuVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where idUsuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                UsuVO = new UsuarioVO(usuId, mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8),
                        mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));

            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return UsuVO;

    }

    public ArrayList<UsuarioVO> listar() {

        ArrayList<UsuarioVO> listaUsuario = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {

                UsuarioVO UsuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10),
                        mensajero.getString(11));

                listaUsuario.add(UsuVO);
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuario;
    }

    public ArrayList<UsuarioVO> roles() {
        ArrayList<UsuarioVO> listaRoles = new ArrayList<>();
        try {
            sql = "SELECT usuario.nombre,usuario.apellido,usuario.idTipoUsuario from usuario INNER join grupo_usuario on usuario.idUsuario=grupo_usuario.idUsuario INNER JOIN grupo on grupo_usuario.idGrupo=grupo.idGrupo where idTipoUsuario=idTipoUsuario";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idTipoUsuario);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(usuVO);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaRoles;

    }

}
