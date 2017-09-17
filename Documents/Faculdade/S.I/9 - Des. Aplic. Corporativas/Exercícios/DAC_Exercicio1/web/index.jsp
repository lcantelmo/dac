<%-- 
    Document   : index
    Created on : 13/09/2017, 19:05:13
    Author     : leo_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pessoa</title>
    </head>
    <body>
        <h1>Cadastro:</h1>
        <form action="cadastroPessoaServlet" method="post">
            Nome:<input type="text" name="nome" id="nome"/>
            <input type="submit"/>
        </form>
        <p id="mensagemDeRetorno" name="mensagemDeRetorno"></p>
    </body>
</html>
