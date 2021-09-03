/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloDAO.AsistenciaDAO;
import ModeloDAO.RolDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String usuId = request.getParameter("txtId");
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String tipoDocumento = request.getParameter("txtTipoDocumento");
        String numDocumento = request.getParameter("txtNumeroDocumento");
        String celular = request.getParameter("txtCelular");
        String telefono = request.getParameter("txtTelefono");
        String estado = request.getParameter("txtEstado");
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave");
        String idTipoUsuario = request.getParameter("txtRol");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //paso 2- instanciar VO
        UsuarioVO UsuVO = new UsuarioVO(usuId, nombre, apellido, tipoDocumento, numDocumento, celular, telefono, estado, correo, clave, idTipoUsuario);

        //instanciar DAO
        UsuarioDAO UsuDAO = new UsuarioDAO(UsuVO);

        switch (opcion) {
            case 1://Agregar Registro
                if (UsuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se registro corectamente");
                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (UsuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se actualizo corectamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;
            case 3://Iniciar Session
                if (UsuDAO.iniciarSesion(correo, clave)) {

                    HttpSession miSesion = request.getSession(true);
                    RolDAO rolDAO = new RolDAO();
                    ArrayList<UsuarioVO> listaRoles = rolDAO.roles(correo);
                    
                    UsuVO = new UsuarioVO(UsuVO.getUsuId(),correo,clave, UsuVO.getIdTipoUsuario());
                    miSesion.setAttribute("datos", UsuVO);
                    
                    for (int i = 0; i < listaRoles.size(); i++) {
                        UsuVO= listaRoles.get(i);   
                    }
                    miSesion.setAttribute("roles", listaRoles);
                    if (listaRoles.size()>=1) {
                         request.setAttribute("mensajeBienvenida", "Bienvenido");
                         request.getRequestDispatcher("menu.jsp").forward(request, response);
                    }else {
                    request.setAttribute("mensajeError", "Datos incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                    
                    /*request.setAttribute("mensajeBienvenida", "Bienvenido");
                    request.getRequestDispatcher("menu.jsp").forward(request, response);*/
                } else {
                    request.setAttribute("mensajeError", "Datos incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
                case 4://Actualizar Estado
                UsuVO = UsuDAO.ConsultarId(usuId);
                if (UsuVO !=null) {
                    
                    request.setAttribute("id", UsuVO);
                    request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                } else {
                     request.setAttribute("mensajeExito", "El Usuario no existe");
                     request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                }
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
                break;
                
               case 5://Actualizar Estado
                if (UsuDAO.cambiarEstado()) {
                    request.setAttribute("mensajeExito", "El estado se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se actualizo corectamente");
                }
                request.getRequestDispatcher("cambiarEstado.jsp").forward(request, response);
                break;
                
               
                         
        }

        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
