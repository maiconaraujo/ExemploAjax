<%-- 
    Document   : form
    Created on : 13/06/2019, 06:29:55
    Author     : MAICON
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        
    </head>
    <body>
        <form action="<c:url value="/cadastrar" />" method="post" >
            <label>Código</label>
            <input type="text" name="codigo" value=""/> 

            <c:forEach var="c" items="${lista}" varStatus="i">
            <br><br>
            <label>Categoria ${i.index}</label>
                <input type="text" name="categorias[${i.index}].descricao"/>
             </c:forEach>

     

            <br><br>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
