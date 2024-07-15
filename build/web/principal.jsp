<%-- 
    Document   : principal
    Created on : 9/07/2024, 11:18:55 a. m.
    Author     : Moreino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a style="color: white" class="navbar-toggler">
                <span class="navbar-toggler-icon"></span> 
                Inicio
            </a>
            <div class="nav-item dropdown">
                <a style="color: white" href="#" class="nav-link dropdown-toggle" 
                   id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                   Cerrar Sesión</a>
                <div class="dropdown-menu text-center">
                    <a><img src="${pageContext.request.contextPath}/img/user.png" height="80" width="80"></a>
                    <a class="dropdown-item">${nom}</a>   
                    <a class="dropdown-item">${correo}</a> 
                    <a class="dropdown-item">Desea Salir?</a>
                    <div class="dropdown-divider"></div>
                    <a href="Controlador?accion=Salir" class="dropdown-item">Salir</a>   <%--  <a href="index.jsp" class="dropdown-item"   --%>
                </div>
            </div>
        </nav>

        <div class="container mt-4">
            <h1> Bienvenido al Sistema...
                <strong> Usuario: ${nom}</strong>
            </h1>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
