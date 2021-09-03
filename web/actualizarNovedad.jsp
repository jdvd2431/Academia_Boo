<%-- 
    Document   : ActualizarUsuario
    Created on : 24/07/2021, 11:28:01 AM
    Author     : David
--%>

<%@page import="ModeloVO.NovedadVO"%>
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
                String idGrupo = request.getParameter("idnovedad");
                String descripcion = request.getParameter("descripcion");    
                String fechaInicio = request.getParameter("fechainicio");
                String fechaFin = request.getParameter("fechafin");
                String idTipoNovedad = request.getParameter("idtiponovedad");
                String idAsistencia = request.getParameter("idasistencia");
            %>
            <section>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="entra"></div>
            <div class="box">
                <div class="container2">
                    <div class="form">
                        <div class="boton-volver">
                            <a class="boton-volver" href="consultarNovedad.jsp" style="font-size: 40px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
                        </div>
                        <h2 for="usu">Actualizar Novedad</h2>
                     <form class="row g-3" method="POST" action="Novedad">
                                    <input type="hidden" name="txtId" placeholder="Nombre" value="<%=idGrupo%>">
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Descripción</label>
                                        <input type="text"id="inputEmail4" name="txtDescripcion"class="form-control" placeholder="Nombre" value="<%=descripcion%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Fecha Inicio</label>
                                        <input type="date"class="form-control" id="inputPassword4" name="txtFechaInicio" placeholder="Fecha inicio" value="<%=fechaInicio%>" >
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Fecha fin</label>
                                        <input type="date" class="form-control" id="inputEmail4" name="txtFechaFin" placeholder="Fecha fin" value="<%=fechaFin%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail4" class="form-label">Tipo novedad</label>
                                        <input type="text"  class="form-control" id="inputEmail4" name="txtTipoNovedad"  placeholder="Tipo novedad" value="<%=idTipoNovedad%>">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputPassword4" class="form-label">Asistencia</label>
                                        <input type="text" class="form-control" id="inputPassword4" name="txtAsistencia"  placeholder="Asistencia" value="<%=idAsistencia%>">
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
                                        window.location = "actualizarNovedad.jsp";
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
                                        window.location = "consultarNovedad.jsp";
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
