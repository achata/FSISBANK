<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.Cliente"%>
<%@page import="controller.ClienteServlet"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
        <form action="ClienteServlet" method="POST">
            <input type="hidden" name="operacion" value="clientes">
            <input type="text" name="nombre">
            <input type="submit" name="boton" value="listar">
         <table border="1">
            <thead>
                <tr>
                    <th>Nombre git</th>
                    <th>Dni</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${requestScope.listadoCliente}">
                <tr>
                    <td>${item.nombreCompleto}</td>
                    <td>${item.dni}</td>
                </tr>
                </c:forEach>
            </tbody>
            
        </table>
        </form>

        
    </body>
</html>
