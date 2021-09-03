/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AsistenciaDAO;
import ModeloDAO.AulaDAO;
import ModeloVO.AsistenciaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "AsistenciaControlador", urlPatterns = {"/Asistencia"})
public class AsistenciaControlador extends HttpServlet {

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
        
        String idAsistencia = request.getParameter("txtId");     
        String asistencia = request.getParameter("txtAsistencia");
        String fecha = request.getParameter("txtFecha");
        String idUsuario = request.getParameter("txtIdUsuario");
        String idGrupo = request.getParameter("txtIdGrupo");
        
          int opcion = Integer.parseInt(request.getParameter("opcion"));
        
          //paso 2- instanciar VO
          AsistenciaVO AsiVO = new AsistenciaVO(idAsistencia, asistencia, fecha, idUsuario, idGrupo);
          
          //instanciar DAO
          
          AsistenciaDAO AsisDAO = new AsistenciaDAO(AsiVO);
         
          
            switch (opcion) {
            case 1://Agregar Registro
                if (AsisDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La Asistencia se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "La Asistencia no se registro corectamente");
                }
                request.getRequestDispatcher("registrarAsistencia.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (AsisDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La Asistencia se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "La Asistencia no se actualizo corectamente");
                }
                request.getRequestDispatcher("registrarAsistencia.jsp").forward(request, response);
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
