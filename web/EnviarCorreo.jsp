<%-- 
    Document   : EnviarCorreo
    Created on : 28/08/2021, 03:43:47 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Correo con JAVA MAIL</h1>
        <form method="post" action="parametrosCorreo">
            <table>
                <tr>
                    <td>Destino</td>
                    <td><input type="text" name="destino"></td>
                </tr>
               
                <tr>
                    <td>Asunto</td>
                    <td><input type="text" name="asunto"></td>
                </tr>
                
                <tr>
                    <td>Contenido</td>
                    <td><textarea rows="10" name="contenido"></textarea></td>
                </tr>
                
                 <tr>
                    <td><input type="submit" name="Enviar"></td>
                </tr>
            </table>
             <h1><%=request.getAttribute("resultado")%> </h1>
        </form>
    </body>
</html>
