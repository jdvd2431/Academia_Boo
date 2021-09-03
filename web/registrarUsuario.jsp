<%-- 
    Document   : registrarUsuario
    Created on : 18/06/2021, 08:41:45 PM
    Author     : Julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/registrarUsu.css" rel="stylesheet" type="text/css"/>
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
        <title>Registrar Usuario</title>
    </head>
    <body>
        <nav>
            <ul>

        </nav>
        <section>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="box">

                <div class="container2">
                    <div class="form">
                        <div class="boton-volver">
                            <a class="boton-volver" href="menu.jsp" style="font-size: 40px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
                        </div>
                        <h2 for="usu">Registrar Usuario</h2>
                        <form method="POST" action="Usuario">
                            <div class="inputb">
                                <p class="cuenta" for="usu">Nombre</p>
                                <input type="text" name="txtNombre" placeholder="Nombre" id="usu">
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Apellido</p>
                                <input type="text" name="txtApellido" placeholder="Apellido"  id="pass">
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Tipo Documento</p>
                                <select name="txtTipoDocumento">
                                    <option value="C.C">Cedula Ciudadana</option>
                                    <option value="T.I">Tarjeta Identidad</option>
                                    <option value="C.E">Cedula Extranjero</option>
                                </select>
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Numero Documento</p>
                                <input type="number" class="form-control" name="txtNumeroDocumento"  placeholder="Numero de Documento" >
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Celular</p>
                                <input type="text" class="form-control" name="txtCelular"  placeholder="Celular" >
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Telefono</p>
                                <input type="text" class="form-control" name="txtTelefono"  placeholder="Telefono" >
                            </div>

                            <div class="inputb">
                                <input type="hidden" name="txtEstado" value="Activo">
                            </div>

                            <div class="inputb">
                                <p class="cuenta" for="usu">Correo</p>
                                <input type="text" class="form-control" name="txtCorreo" placeholder="Correo" >
                            </div>
                            <div class="inputb">
                                <p class="cuenta" for="usu">Clave</p>
                                <input type="password" class="form-control" name="txtClave" placeholder="Clave" >
                            </div>

                            <div class="inputb">
                                <p class="cuenta" for="usu">Tipo usuario</p>
                                <select name="txtRol">
                                    <option value="1">Profesor</option>
                                    <option value="2">Estudiante</option>
                                </select>

                            </div>
                            <ul class="error" id="error"></ul>
                            <center>
                                <div class="inputb">
                                    <input type="submit" id="btn" value="Registrar">
                                    <input type="hidden" value="1" name="opcion">
                                </div></center>
                        </form>
                    </div>
                    <div>
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
                                        window.location = "registrarUsuario.jsp";
                                    });
                        </script>

                        <%} else if (request.getAttribute("mensajeExito") != null) {%>
                        <script  type="text/javascript">

                            swal({
                                title: "Correcto",
                                text: "${mensajeExito}",
                                type: 'success',
                                confirmButtonClass: "btn-primary",
                                confirmButtonText: "OK",
                                closeOnConfirm: false
                            },
                                    function () {
                                        window.location = "registrarUsuario.jsp";
                                    });
                        </script>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
