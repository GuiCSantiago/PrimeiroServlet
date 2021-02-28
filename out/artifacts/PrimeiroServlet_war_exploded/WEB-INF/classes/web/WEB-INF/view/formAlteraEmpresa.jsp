<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/UnicaEntradaServlet?acao=EditarEmpresa" var="linkServletNovaEmpresa"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulário Cadastro</title>
</head>
    <body>
    <form action="${linkServletNovaEmpresa}" method="POST">

        Nome: <input type="text" name="name" value="${empresa.nome}"/>
        Data de Abertura: <input type="text"  name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
        <input type="hidden" name="id" value="${empresa.id}">
        <input type="submit" />

    </form>

    </body>
</html>