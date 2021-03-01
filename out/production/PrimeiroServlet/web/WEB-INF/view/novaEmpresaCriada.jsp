<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

    <c:if test="${not empty empresa}">
        Empresa ${empresa} Cadastrada com sucesso!
    </c:if>
    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada! :(
    </c:if>
</body>
</html>