<%-- 
    Document   : index
    Created on : 28 de set. de 2024, 11:07:47
    Author     : Eduardo
--%>

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
    <body>

        <!-- <form action="paginadois.jsp" method="post"> -->
        <form action="/acao" method="post">    
            
            <label for="id">ID:</label>
            <input type="text" id="id" name="id">

            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo">

            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor">

            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao" rows="3"></textarea>

            <label for="publicacao">Publicação:</label>
            <input type="date" id="publicacao" name="publicacao">

            <label for="avaliacao">Avaliação:</label>
            <input type="number" id="avaliacao" name="avaliacao" min="1" max="5">

            <input type="submit" value="Enviar">
            
        </form>

    </body>
</html>
