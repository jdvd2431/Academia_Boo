<%-- 
    Document   : index
    Created on : 10-may-2021, 9:32:21
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link href="Css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="Js/sweetalert.js" type="text/javascript"></script>
        <script src="Js/sweetalert.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/login.css">
        <title>Iniciar Sesión</title>
    </head>
    <body style="overflow: hidden;"> 
        <section>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="box">
                <div class="square" style="--i:0;"></div>
                <div class="square" style="--i:1;"></div>
                <div class="square" style="--i:2;"></div>
                <div class="square" style="--i:3;"></div>
                <div class="square" style="--i:4;"></div>
                <div class="container">
                    <div class="form">
                        <h2>Login</h2>
                        <form method="POST" action="Usuario">
                            <div class="inputb">
                                <input type="text" name="txtCorreo" placeholder="Usuario">
                            </div>
                            <div class="inputb">
                                <input type="password" name="txtClave" placeholder="Contraseña"  id="pass">
                            </div>
                            <ul class="error" id="error"></ul>
                            <div class="inputb">
                                <center><input type="submit" id="btn" value="Entrar"></center>

                                <input type="hidden" value="3" name="opcion">
                            </div>
                        </form>
                    </div>
                    <% if (request.getAttribute("mensajeError") != null) {%>
                    <script  type="text/javascript">
                        
                        swal({
                            title: "Error",
                            text: "${mensajeError}",
                            type: 'error',
                            confirmButtonClass: "btn-primary",
                            confirmButtonText: "OK",
                            closeOnConfirm: false
                        },
                                function () {
                                    window.location = "login.jsp";
                                });
                    </script>

                    <%}%>
                </div>
            </div>
        </div>
    </section>


</body>
</html>
