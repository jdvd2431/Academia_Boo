<%-- 
    Document   : Menu
    Created on : 16/06/2021, 09:22:07 PM
    Author     : Julian
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>

<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">

    <head>
        <meta charset="utf-8">
        <title>Menu Profesor</title>
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
        <link href="Css/templatemo-style.css" rel="stylesheet" type="text/css"/>
        <link href="Css/lightbox.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="Css/menu.css">

    </head>

    <body>
        <input type="checkbox" id="check">
        <label for="check">
            <i class="fas fa-bars" id="btn"></i>
            <i class="fa fa-chevron-circle-left" id="cancel"></i>
        </label>
        <div class="sidebar">
            <header>
                <p id="titulo" class="animation">Academia Bottischool</p>
            </header>
            <ul >
                <li><a href="#"><i class="fas fa-users"></i>Modificar Datos</a></li>
                <li><a href="#"><i class="fa fa-user-plus"></i>Consultar horario</a></li>

                <li class="animation">
                    <form method="post" action="Sesiones">
                        <input class="cerrar" type="submit" value="Cerrar Sesion">
                    </form>
                </li>
            </ul>
        </div>
        <section class="section my-services" data-section="section2">
            <div class="container">
                <div class="section-heading">
                    <h2>Academia de baile Bottie School</h2>
                    <div class="line-dec"></div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="service-item" id="1">
                            <div class="first-service-icon service-icon"></div>
                            <h4>Misión</h4>
                            <p>
                                Somos una escuela de baile dedicada a la formación integral de personas, haciendo uso de la danza como una herramienta de bienestar para fortalecer las áreas física, social y emocional de nuestra comunidad, a través de la creación de espacios que permitan la diversión y el sano entretenimiento.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="service-item" id="segundo">
                            <div class="second-service-icon service-icon"></div>
                            <h4>Visión</h4>
                            <p>
                                Ser reconocidos como la mejor escuela de baile en Bogotá, no solo por la participación de nuestros bailarines en eventos locales y nacionales, sino también por la calidad, excelencia y compromiso en el servicio de enseñanza dirigido a todos nuestros usuarios.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="service-item" id="tercero">
                            <div class="third-service-icon service-icon"></div>
                            <h4>Beneficios</h4>
                            <p>
                                Con el baile se obtienen beneficios mejorando nuestra calidad de vida y salud, relacionado como la actividad física más completa, cuando bailamos se ejercita todo nuestro cuerpo desarrollando energía y vitalidad, logrando así un buen nivel físico.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="service-item" id="4">
                            <div class="fourth-service-icon service-icon"></div>
                            <h4>Clases</h4>
                            <p>
                                Curso dirigido para todas las edades y en especial para los niños entre 4 y 10 años de edad que hacen uso del baile como medio fundamental para potencializar habilidades y cualidades para la vida, promoviendo el desarrollo motriz, social y cognitivo, con el fin de mejorar su calidad de vida.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <% if (request.getAttribute("mensajeBienvenida") != null) {%>
        <script  type="text/javascript">
            swal({
                title: "${mensajeBienvenida}",
                type: 'success',
                confirmButtonClass: "btn-primary",
                confirmButtonText: "OK",
                closeOnConfirm: false
            },
                    function () {
                        window.location = "menu.jsp";
                    });
        </script>
        <%}%>
    </body>
    <script src="Js/app.js" type="text/javascript"></script>
</html>

