<%-- 
    Document   : cliente-registro.jsp
    Created on : May 19, 2019, 6:30:32 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/MovimientoServlet" method="POST">
            <input type="hidden" name="operacion" value="newCliente">
            <input type="text" name="nombre" ><br/>
            <input type="text" name="apePat"><br/>
            <input type="text" name="apeMat" ><br/>
            <input type="text" name="dni" ><br/>
            <input type="text" name="ciudad" ><br/>
            <input type="text" name="direccion"><br/>
            <input type="text" name="telefono"><br/>
            <input type="text" name="email"><br/>
            <input type="submit" name="boton" value="grabar">
        </form>
    </body>
</html>
