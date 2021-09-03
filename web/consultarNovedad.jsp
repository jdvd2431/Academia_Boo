<%-- 
    Document   : conultarClase.jsp
    Created on : 25/06/2021, 02:40:36 PM
    Author     : Sebas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.NovedadDAO"%>
<%@page import="ModeloVO.NovedadVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css"/>
        <link rel="stylesheet" href="Css/consultarNovedad.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
        <script src="https://cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Novedad</title>
    </head>
    <body >
        <style>
            .contenedor{
                width: 80%;
                max-width: 85%;
                display: flex;
                justify-content: center;
                margin: auto;
                background:#fefefe;
                padding: 15px;
                margin-radius:5px; 
            }
            body{
                background:#ECECEC;
            }
            h2{
                width:100%;
                max-width: 300px;
                display: flex;
                justify-content: center;
                margin: auto;
                text-align: center;
                background: #007bff;
                border-radius:7px;
                padding: 5px;
                margin-bottom: 15px;
                color: white;
            }
            h2:hover{
                background: #4CA3FF;
                color: white;
            }
            .verde{
                background: green;
                color: white;
                border-radius:5px; 
            }
            .rojo{
                background:brown;
                color: white;
            }
        </style>
        <h2 class="text-center mt-20">Gestion de las Novedades</h2>
        <div class="contenedor">
            <table id="usuario" class="table table-striped" style="width:150%">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Descripcion</th>
                        <th>Fecha Inicio</th>
                        <th>Fecha Fin</th>
                        <th>Tipo de Novedad</th>
                        <th>Asistencia</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        NovedadVO NovVO = new NovedadVO();
                        NovedadDAO NovDAO = new NovedadDAO(NovVO);
                        ArrayList<NovedadVO> listaNovedad = NovDAO.listar();
                        for (int i = 0; i < listaNovedad.size(); i++) {

                            NovVO = listaNovedad.get(i);
                    %>               
                    <tr>
                        <td><%=NovVO.getIdNovedad()%></td>
                        <td><%=NovVO.getDescripcion()%></td>
                        <td><%=NovVO.getFechaInicio()%></td>
                        <td><%=NovVO.getFechaFin()%></td>
                        <td><%=NovVO.getIdTipoNovedad().equals("1") ? "Problema personal" : "Cita medica" %></td>
                        <td><%=NovVO.getIdAsistencia()%></td>
                         <td>
                            <a class="btn btn-primary edit"href="actualizarNovedad.jsp?idnovedad=<%=NovVO.getIdNovedad()%>&descripcion=<%=NovVO.getDescripcion()%>&fechainicio=<%=NovVO.getFechaInicio()%>&fechafin=<%=NovVO.getFechaFin()%>&idtiponovedad=<%=NovVO.getIdTipoNovedad()%>&idasistencia=<%=NovVO.getIdAsistencia()%>"><i class="fas fa-pen"></i></a>
                        </td>
                    </tr>
                   
                    <%}%>  
                    
                </tbody>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Descripcion</th>
                        <th>Fecha Inicio</th>
                        <th>Fecha Fin</th>
                        <th>Tipo de Novedad</th>
                        <th>Asistencia</th>
                    </tr>
                </tfoot>
            </table>
        </div>

        <script>
            $(document).ready(function () {
                $('#usuario').DataTable({
                    scrollY: 400,
                    language: {
                        "sProcessing": "Procesando...",
                        "sLengthMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "No se encontraron resultados",
                        "sEmptyTable": "NingÃºn dato disponible en esta tabla",
                        "sInfo": "Mostrando usuarios del _START_ al _END_ de un total de _TOTAL_ usuarios",
                        "sInfoEmpty": "Mostrando usuarios del 0 al 0 de un total de 0 usuarios",
                        "sInfoFiltered": "(filtrado de un total de _MAX_ usuarios)",
                        "sInfoPostFix": "",
                        "sSearch": "Buscar:",
                        "sUrl": "",
                        "sInfoThousands": ",",
                        "sLoadingRecords": "Cargando...",
                        "oPaginate": {
                            "sFirst": "Primero",
                            "sLast": "Ãšltimo",
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior"
                        },
                        "oAria": {
                            "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                        },
                        "buttons": {
                            "copy": "Copiar",
                            "colvis": "Visibilidad"
                        }
                    }
                });
            });
        </script>
        <button class="abrir-registrar btn btn-primary" id="abrir-registrar">Registrar</button>
        <div class="overlay " id="overlay">
            <form method="POST" action="Novedad" class="form-registro">
                <div class="tituloR">
                    <a href="#" class="cerrar-registro" id="cerrar-registro"><i class="fas fa-times"></i></a>
                    <h2>Registrar Novedad</h2>
                </div>
                <div class="cuerpo">
                    <div class="formulario">
                        <input type="text" name="txtDescripcion" class="descripcion" placeholder="Descripcion">
                        <input type="date" name="txtFechaInicio" class="input-50">
                        <input type="date" name="txtFechaFin" class="input-50">
                        <div class="selector">
                            <select name="txtTipoNovedad" class="estilo-selector">
                                <option selected>Tipo de Novedad</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </div>
                        <div class="selector">
                            <select name="txtAsistencia" class="estilo-selector">
                                <option selected>Id Asistencia</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                            </select>
                        </div>
                        <div class="boton">
                            <input type="submit" id="btn" value="Registrar" class="btn">
                            <input type="hidden" value="1" name="opcion">
                        </div>
                    </div>
                </div>
                
            </form>
        </div>
        <script src="Js/consutarUsuario.js" type="text/javascript"></script>
    </body>
</html>

