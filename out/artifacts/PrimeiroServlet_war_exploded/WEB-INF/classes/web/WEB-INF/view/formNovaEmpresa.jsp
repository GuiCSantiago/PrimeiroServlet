<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/UnicaEntradaServlet" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulário Cadastro</title>
</head>
    <body>
    <form action="${linkServletNovaEmpresa}" method="POST">
        <c:import url="logout-parcial.jsp"/>

        Nome: <input type="text" name="name"/>
        Data de Abertura: <input type="text" name="data"/>
        <input type="hidden" name="acao" value="NovaEmpresa"/>

        <input type="submit" />

    </form>

    </body>
</html>