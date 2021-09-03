/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ClaseDAO;
import ModeloVO.ClaseVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebas
 */
@WebServlet(name = "ClaseControlador", urlPatterns = {"/Clase"})
public class ClaseControlador extends HttpServlet {

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
       
        String idClase = request.getParameter("txtId");     
        String nombre = request.getParameter("txtNombre");
        String estado = request.getParameter("txtEstado");
        String cantidadSesiones = request.getParameter("txtcantidadSesiones");
        
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
          //paso 2- instanciar VO
          ClaseVO claVO = new ClaseVO(idClase,nombre,estado,cantidadSesiones);
          
          //instanciar DAO
         
        ClaseDAO claDAO = new ClaseDAO(claVO);
        
         switch (opcion) {
            case 1://Agregar Registro
                if (claDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "La clase se registro corectamente");
                } else {
                    request.setAttribute("mensajeError", "La clase no se registro corectamente");
                }
                request.getRequestDispatcher("registrarClase.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (claDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La clase se actualizo corectamente");
                } else {
                    request.setAttribute("mensajeError", "La clase no se actualizo corectamente");
                }
                request.getRequestDispatcher("actualizarClase.jsp").forward(request, response);
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
