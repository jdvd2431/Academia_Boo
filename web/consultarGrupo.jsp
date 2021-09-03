<%-- 
    Document   : conultarClase.jsp
    Created on : 25/06/2021, 02:40:36 PM
    Author     : Sebas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.GrupoDAO"%>
<%@page import="ModeloVO.GrupoVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="Css/consultarGrupo.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
         <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css"/>
         <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
        <link href="Css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="Js/sweetalert.js" type="text/javascript"></script>
        <script src="Js/sweetalert.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Grupo</title>
    </head>
    <body >
        <style>
            .contenedor{
                width: 60%;
                max-width: 1400px;
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
        
        <h2 class="text-center mt-3">Gestion de los Grupos</h2>
        <div class="boton-volver">
            <a class="boton-volver" href="menu.jsp" style="font-size: 40px; margin-left: 50px;"><i class="fa fa-chevron-circle-left" id="cancel"></i></a>
        </div>
        <form method="post">
        </form>
        <div class="contenedor">
            <table id="usuario" class=" table table-striped" style="width:100%">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Estado</th>
                        <th>Fecha de Inicio</th>
                        <th>Fecha de Fin</th>
                        <th>Estado</th>
                        <th>Actualizar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        GrupoVO GruVO = new GrupoVO();
                        GrupoDAO GruDAO = new GrupoDAO(GruVO);
                        ArrayList<GrupoVO> listaGrupo = GruDAO.listar();
                        for (int i = 0; i < listaGrupo.size(); i++) {

                            GruVO = listaGrupo.get(i);
                    %>               
                    <tr>
                        <td><%=GruVO.getIdGrupo()%></td>
                        <td><%=GruVO.getNombre()%></td>
                        <td>
                            <a class="<%=GruVO.getEstado().equals("Activo") ? "btn btn-success  m-3": "btn btn-danger  m-3" %>" style="padding-right: 50px;">
                                <%=GruVO.getEstado()%>
                            </a>
                        </td>
                        <td class="text-center"><%=GruVO.getFechaInicio()%></td> 
                        <td class="text-center"><%=GruVO.getFechaFin()%></td> 
                        <td>
                            <a  class="btn btn-primary edit m-2 p-2"href="cambiarEstadoGrupo.jsp?idgrupo=<%=GruVO.getIdGrupo()%>&estado=<%=GruVO.getEstado()%>"><i class="fas fa-pen"></i></a>

                        </td>

                        <td>
                            <a class="btn btn-info edit m-2 p-2"href="actualizarGrupo.jsp?idgrupo=<%=GruVO.getIdGrupo()%>&nombre=<%=GruVO.getNombre()%>&estado=<%=GruVO.getEstado()%>&inicio=<%=GruVO.getFechaInicio()%>&fin=<%=GruVO.getFechaFin()%>"><i class="fas fa-pen"></i></a>
                        </td>
                    </tr>
                    <%}%>  
                </tbody>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Estado</th>
                        <th>Fecha de Inicio</th>
                        <th>Fecha de Fin</th>
                        <th>Estado</th>
                        <th>Actualizar</th>
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
        <div class="overlay" id="overlay">
            <form method="POST" action="Grupo" class="form-registro">
                <div class="tituloR">
                    <a href="#" class="cerrar-registro" id="cerrar-registro"><i class="fas fa-times"></i></a>
                    <h2>Registrar Grupo</h2>
                </div>
                <div class="cuerpo">
                    <div class="formulario">
                        <input type="text" name="txtNombre" placeholder="Nombre" required class="input-50">
                        <input type="hidden" name="txtEstado" value="Activo">
                        <input type="date" name="txtFechaInicio" placeholder="Fecha de Inicio" required class="input-50">
                        <input type="date" name="txtFechaFin" placeholder="Fecha de Fin" required class="input-50">
                        <div class="selector">
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

