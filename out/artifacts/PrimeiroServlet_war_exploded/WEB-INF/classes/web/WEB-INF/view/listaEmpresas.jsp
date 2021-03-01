<%@ page import="java.util.List" %>
<%@ page import="com.newti.gui.modelo.Empresa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>ListaEmpresas</title>
</head>
<body>
    <c:import url="logout-parcial.jsp"/>

    <c:if test="${not empty empresa}">
         Empresa ${empresa} Cadastrada com sucesso!
    </c:if>
    <br>
    Usuário: ${usuariologado.login}
    <br>
    Lista de empresas:
    <br>
    <ul>
        <c:forEach items="${empresas}" var="emp">
            <li>
                    ${emp.nome} - <fmt:formatDate value="${emp.dataAbertura}" pattern="dd/MM/yyyy"/>
                        <a href="/PrimeiroServlet/UnicaEntradaServlet?acao=MostrarEmpresa&id=${emp.id}">editar</a>
                    <a href="/PrimeiroServlet/UnicaEntradaServlet?acao=RemoverEmpresa&id=${emp.id}">remover</a>
            </li>
            </c:forEach>
    </ul>
    <br>
        <a href="/PrimeiroServlet/UnicaEntradaServlet?acao=NovaEmpresaForm">Criar empresa</a>
    <br>
</body>
</html>
