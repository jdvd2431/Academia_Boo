/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.GrupoDAO;
import ModeloVO.GrupoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julian
 */
@WebServlet(name = "GrupoControlador", urlPatterns = {"/Grupo"})
public class GrupoControlador extends HttpServlet {

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
        String idGrupo = request.getParameter("txtId");
        String nombre = request.getParameter("txtNombre"); 
        String estado = request.getParameter("txtEstado");     
        String fechaInicio = request.getParameter("txtFechaInicio");
        String fechaFin = request.getParameter("txtFechaFin");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        GrupoVO grupoVO= new GrupoVO(idGrupo,nombre, estado, fechaInicio, fechaFin);
        GrupoDAO grupoDAO = new GrupoDAO(grupoVO);
        switch (opcion) {
            case 1://Agregar Registro
                if (grupoDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El Grupo se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "El Grupo no se registro corectamente");
                }
                request.getRequestDispatcher("consultarGrupo.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (grupoDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Grupo se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "El Grupo no se actualizo corectamente");
                }
                request.getRequestDispatcher("actualizarGrupo.jsp").forward(request, response);
                break;
                case 3://Actualizar Estado
                if (grupoDAO.cambiarEstado()) {
                    request.setAttribute("mensajeExito", "El estado se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se actualizo corectamente");
                }
                request.getRequestDispatcher("cambiarEstadoGrupo.jsp").forward(request, response);
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
