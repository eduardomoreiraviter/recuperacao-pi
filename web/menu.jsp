<%-- 
    Document   : menu
    Created on : 28 de set. de 2024, 22:51:48
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu Simples</title>
        <style>
            body {
                background-color: black;
                color: white;
                margin: 0;
                font-family: Arial, sans-serif;
            }
            nav {
                background-color: #333;
                padding: 10px;
                text-align: center;
            }
            nav a {
                color: white;
                margin: 15px;
                text-decoration: none;
            }
            nav a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <nav>
            <a href="index.jsp">Início</a>
            <a href="livros.jsp">Cadastro de Livros</a>
        </nav>
    </body>
</html>
