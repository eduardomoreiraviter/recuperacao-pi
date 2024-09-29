<%-- 
    Document   : livros
    Created on : 28 de set. de 2024, 19:12:15
    Author     : Eduardo
--%>
<%@page import="dao.LivrosDAO"%>
<%@page import="entidade.Livros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário Simples</title>
        <style>
            body {
                background-color: black;
                color: white;
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            form {
                background-color: #333;
                padding: 65px;
                border-radius: 20px;
                width: 350px;
            }
            input, textarea {
                width: 100%;
                padding: 5px;
                margin: 10px 0;
                border: none;
                border-radius: 5px;
            }
            input[type="submit"] {
                background-color: #555;
                color: white;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #777;
            }
        </style>
    </head>
    <%@include file="menu.jsp" %>
    
    <% 
        Livros vr = (Livros) request.getAttribute("livros");
        
        if (vr == null){
            vr = new Livros();
        }
        
    %>
    
    <body>

        <!-- <form action="paginadois.jsp" method="post"> -->
        <form action="acao?a=salvarCateg" method="post">    

            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="<%= vr.getId() %>">

            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" value=" <%= vr.getTitulo() %>">

            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" value="<%= vr.getAutor() %>">

            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao" value="<%= vr.getDescricao() %>"></textarea>

            <label for="publicacao">Publicação:</label>
            <input type="date" id="publicacao" name="publicacao" value="<%= vr.getPublicacai() %>">

            <label for="avaliacao">Avaliação:</label>
            <input type="number" id="avaliacao" name="avaliacao" min="1" max="5" value="<%= vr.getAvaliacao()%>">

            <input type="submit" name="salvar" value="Enviar">

        </form>

        <!-- <h3>Lista de Pessoas</h3> -->

        <%
            ArrayList<Livros> liv = new LivrosDAO().consultar();
        %>

        <!-- <h4><%= liv.size()%></h4> -->
        
        <table>
            <th>Id</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Descrição</th>
            <th>Publicação</th>
            <th>Avaliação</th>
            <th>Editar</th>
            <th>Excluir</th>

            <%
                for (int i = 0; i < liv.size(); i++) {
            %>

            <tr>
                <td><%= liv.get(i).getId()%></td>
                <td><%= liv.get(i).getTitulo()%></td>
                <td><%= liv.get(i).getAutor()%></td>
                <td><%= liv.get(i).getDescricao()%></td>
                <td><%= liv.get(i).getPublicacai()%></td>
                <td><%= liv.get(i).getAvaliacao()%></td>
                <td><a href="acao?a=editarCateg&id=<%= liv.get(i).getId()%>"class="">Editar</a></td>
                <td><a href="acao?a=excluirCateg&id=<%= liv.get(i).getId()%>"class="">Excluir</a></td>
            </tr>
            
            <%
                }
            %>

        </table>    

    </body>

</html>