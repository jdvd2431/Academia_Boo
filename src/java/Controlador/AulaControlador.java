/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AulaDAO;
import ModeloVO.AulaVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebas
 */
@WebServlet(name = "AulaControlador", urlPatterns = {"/Aula"})
public class AulaControlador extends HttpServlet {

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
       
        String idAula = request.getParameter("txtId");     
        String nombre = request.getParameter("txtNomAula");
        String capacidad = request.getParameter("txtCapacidad");
        String estado = request.getParameter("txtEstado");
        
        
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
          //paso 2- instanciar VO
          AulaVO auVO = new AulaVO(idAula,nombre,capacidad,estado);
          
          //instanciar DAO
         
        AulaDAO auDAO = new AulaDAO(auVO);
        
         switch (opcion) {
            case 1://Agregar Registro
                if (auDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El Aula se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "El Aula no se registro corectamente");
                }
                request.getRequestDispatcher("registrarAula.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (auDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Aula se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "El Aula no se actualizo corectamente");
                }
                request.getRequestDispatcher("actualizarAula.jsp").forward(request, response);
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
