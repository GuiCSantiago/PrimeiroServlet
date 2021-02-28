<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/UnicaEntradaServlet?acao=CriarEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulário Cadastro</title>
</head>
    <body>
    <form action="${linkServletNovaEmpresa}" method="POST">

        Nome: <input type="text" name="name"/>
        Data de Abertura: <input type="text" name="data"/>

        <input type="submit" />

    </form>

    </body>
</html>