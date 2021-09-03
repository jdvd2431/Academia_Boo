/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.NovedadDAO;
import ModeloVO.NovedadVO;
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
 * @author Sebas
 */
@WebServlet(name = "NovedadControlador", urlPatterns = {"/Novedad"})
public class NovedadControlador extends HttpServlet {

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
        String descripcion = request.getParameter("txtDescripcion");    
        String fechaInicio = request.getParameter("txtFechaInicio");
        String fechaFin = request.getParameter("txtFechaFin");
        String idTipoNovedad = request.getParameter("txtTipoNovedad");
        String idAsistencia = request.getParameter("txtAsistencia");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        NovedadVO NovVO= new NovedadVO(idGrupo,descripcion, fechaInicio, fechaFin, idTipoNovedad,idAsistencia);
        
        NovedadDAO NovDAO = new NovedadDAO(NovVO);
        switch (opcion) {
            case 1://Agregar Registro
                if (NovDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La Novedad se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "La novedad no se registro corectamente");
                }
                request.getRequestDispatcher("consultarNovedad.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (NovDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La Novedad se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "La NOvedad no se actualizo corectamente");
                }
                request.getRequestDispatcher("actualizarNovedad.jsp").forward(request, response);
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
