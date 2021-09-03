<%-- 
    Document   : ActualizarUsuario
    Created on : 24/07/2021, 11:28:01 AM
    Author     : David
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
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
        <title>Actualizar Usuario</title>
    </head>
    <body>
            <%
                String usuid = request.getParameter("usuid");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String tipodoc = request.getParameter("tipodoc");
                String numdoc = request.getParameter("numdoc");
                String celular = request.getParameter("celular");
                String telefono = request.getParameter("telefono");
                String estado = request.getParameter("estado");
                String correo = request.getParameter("correo");
                String clave = request.getParameter("clave");
                String tipousu = request.getParameter("tipousu");
                
            %>
            <section>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="box">
                <div class="container2">
                    <div class="form">
                        <div class="boton-volver">
                            <a class="boton-volver" href="consultarUsuario.jsp" style="font-size: 40px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
                        </div>
                        <h2 for="usu">Actualizar Usuario</h2>
                     <form class="row g-3" method="POST" action="Usuario">
                                    <input type="hidden" name="txtId" placeholder="Nombre" value="<%=usuid%>">
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Nombre</label>
                                        <input type="text"id="inputEmail4" name="txtNombre"class="form-control" placeholder="Nombre" value="<%=nombre%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Apellido</label>
                                        <input type="text"class="form-control" id="inputPassword4" name="txtApellido" placeholder="Apellido" value="<%=apellido%>" >
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Tipo Docuemento</label>
                                        <input type="text" class="form-control" id="inputEmail4" name="txtTipoDocumento" placeholder="Apellido" value="<%=tipodoc%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Numero Documento</label>
                                        <input type="text"  class="form-control" id="inputPassword4" name="txtNumeroDocumento" placeholder="Tipo Usuario"  value="<%=numdoc%>" >
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Celular</label>
                                        <input type="text"  class="form-control" id="inputEmail4" name="txtCelular"  placeholder="Celular" value="<%=celular%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Telefono</label>
                                        <input type="text" class="form-control" id="inputPassword4" name="txtTelefono"  placeholder="Telefono" value="<%=telefono%>">
                                    </div>
                                    <input type="hidden" name="txtEstado" value="Activo" value="<%=estado%>"> 
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Correo</label>
                                        <input type="text" class="form-control" id="inputEmail4" name="txtCorreo"  placeholder="Correo" value="<%=correo%>">
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <label for="inputPassword4" class="form-label">Clave</label>
                                        <input type="password"class="form-control" id="inputPassword4" name="txtClave" placeholder="Clave" value="<%=clave%>">
                                    </div>
                                    <input type="hidden" class="form-control" name="txtRol" placeholder="Clave" value="<%=tipousu%>">
                                    <div class="col-12">
                                        <input type="submit" class="btn btn-primary  d-flex justify-conted-center m-auto" id="btn" value="Actualizar">
                                        <input type="hidden" value="2" name="opcion">
                                    </div>
                                </form>
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
                                        window.location = "actualizarUsuario.jsp";
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
                                        window.location = "consultarUsuario.jsp";
                                    });
                        </script>
                        <%}%>
                    </div>
                    </div>
                </div>
            </div>
            </div>
            </section>

    </body>
</html>
