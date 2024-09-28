<%-- 
    Document   : paginadois
    Created on : 28 de set. de 2024, 11:15:20
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Dois</h1>

        <%
            String id = request.getParameter("id");
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String descricao = request.getParameter("descricao");
            String publicacao = request.getParameter("publicacao");
            String avaliacao = request.getParameter("avaliacao");
        %>

        <p> id = <%= id%></p>
        <p> titulo = <%= titulo%></p>
        <p> autor = <%= autor%></p>
        <p> descricao = <%= descricao%></p>
        <p> publicacao = <%= publicacao%></p>
        <p> avaliacao = <%= avaliacao%></p>

    </body>
</html>
