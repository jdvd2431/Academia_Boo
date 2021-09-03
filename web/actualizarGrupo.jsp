<%-- 
    Document   : actualizarGrupo
    Created on : Aug 12, 2021, 9:28:22 PM
    Author     : Julian
--%>

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
            String idgrupo = request.getParameter("idgrupo");
            String nombre = request.getParameter("nombre");
            String estado = request.getParameter("estado");
            String inicio = request.getParameter("inicio");
            String fin = request.getParameter("fin");


        %>
        <section>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="box">
                <div class="container2">
                    <div class="form">
                        <div class="boton-volver">
                            <a class="boton-volver" href="consultarGrupo.jsp" style="font-size: 40px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
                        </div>
                        <h2 for="usu">Actualizar Grupo</h2>
                        <form class="row g-2" method="POST" action="Grupo">
                            <input type="hidden" name="txtId" placeholder="Nombre" value="<%=idgrupo%>">
                            <div class="col-md-6">
                                <label for="inputEmail4" class="form-label">Nombre</label>
                                <input type="text"id="inputEmail4" name="txtNombre"class="form-control" placeholder="Nombre" value="<%=nombre%>">
                            </div>
                            <div class="col-md-6">
                                <input type="hidden"class="form-control" id="inputPassword4" name="txtEstado" placeholder="Apellido" value="<%=estado%>" >
                            </div>
                            <div class="col-md-6">
                                <label for="inputEmail4" class="form-label">Fecha inicio</label>
                                <input type="date" name="txtFechaInicio" id="pass"
                                       value="<%=inicio%>"
                                       min="2021-01-01" max="2021-12-31">   
                            </div>
                            <div class="col-md-6">
                                <label for="inputPassword4" class="form-label">Fecha fin</label>
                                <input type="date" name="txtFechaFin" id="pass"
                                       value="<%=fin%>"
                                       min="2021-01-01" max="2021-12-31"> 
                            </div>

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
                                            window.location = "actualizarGrupo.jsp";
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
                                            window.location = "consultarGrupo.jsp";
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

