<%-- 
    Document   : novedades
    Created on : 25/07/2024, 10:21:58 p. m.
    Author     : Moreino

    Agregarmos una expresion langua con variable y argumentos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Novedades usuario</h1>
        <table border="1" width="80%"> 
            <thead>
                <tr>
                    <th>Nombres</th> 
                    <th>Correo</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="persona" items="${lista}">
                    <tr>
                        <td><c:out value="${persona.nom}"/></td>
                        <td><c:out value="${persona.correo}"/></td>
                        <td><a href="Controlador?accion=modificar&id=<c:out value="${persona.id}"/>">Modificar</a></td>
                        <td><a href="Controlador?accion=eliminado&id=<c:out value="${persona.id}"/>">Eliminar</a></td>
                    </tr>
                
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
