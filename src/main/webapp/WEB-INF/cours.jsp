<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	<%@ include file="assets/css/index.css" %>
	<%@ include file="assets/css/nav.css" %>
</style>
</head>
<body>

	<c:import url="inc/header.jsp"/>
	<c:import url="inc/nav.jsp"/>
	
	<c:if test="${!empty sessionScope.nom }">
<p> bienvenue ${ sessionScope.nom }  ${ sessionScope.prenom }</p>
    </c:if>
	
	code cours ici
	
	
	<c:import url="inc/footer.jsp"/>
</body>
</html>