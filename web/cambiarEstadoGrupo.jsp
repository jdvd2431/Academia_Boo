<%-- 
    Document   : cambiarEstadoGrupo
    Created on : Aug 12, 2021, 9:39:39 PM
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
        <title></title>
    </head>
    <body>
        <nav>
            <ul>

        </nav>

        <section>
                <%
                    String idgrupo = request.getParameter("idgrupo");
                    String estado = request.getParameter("estado");
                %>
                <div class="container2">
                    <div class="form">
                        <div class="boton-volver">
                            <a class="boton-volver" href="consultarGrupo.jsp" style="font-size: 40px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
                        </div>
                        <h2 for="usu">Cambiar Estado</h2>
                        <form method="POST" action="Grupo">
                            <div class="row">
                                <div class="col">
                                    <input type="hidden" name="txtId" placeholder="Nombre" value="<%=idgrupo%>">
                                    <select class="custom-select" name="txtEstado">
                                        <option selected>Seleciona el nuevo estado</option>
                                        <option value="Activo">Activo</option>
                                        <option value="Inactivo">Inactivo</option>
                                    </select>
                                    <center>
                                        <div class="inputb">
                                            <button class="btn btn-primary mt-3" type="submit" id="btn" >Cambiar</button>
                                            <input type="hidden" value="3" name="opcion">
                                        </div></center>
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
                                        window.location = "cambiarEstadoGrupo.jsp";
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
                        </form>
                    </div>
                </div>
        </section>
    </body>
</html>
