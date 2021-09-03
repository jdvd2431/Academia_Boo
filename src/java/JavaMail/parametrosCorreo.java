/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(urlPatterns = {"/parametrosCorreo"})
public class parametrosCorreo extends HttpServlet {

    private String host;
    private String puerto;
    private String usuario;
    private String clave;
    
    public void init(){
    
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        puerto = context.getInitParameter("puerto");
        usuario = context.getInitParameter("usuario");
        clave = context.getInitParameter("clave");
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String destino = request.getParameter("destino");
        String asunto = request.getParameter("asunto");
        String contenido = request.getParameter("contenido");
        
        String resultadoEnvio = "";
        
        try {
            PropiedadesCorreo.enviarCorreo(host, puerto, usuario, clave, destino, asunto, contenido);
            resultadoEnvio = "El mensaje se envió correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            resultadoEnvio = "Error al envíar el mensaje " + e.getMessage();
        }finally{
            request.setAttribute("resultado", resultadoEnvio);
            getServletContext().getRequestDispatcher("/Correo.jsp").forward(request, response);
        }
    }

   
}
