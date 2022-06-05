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
	<%@ include file="assets/css/courEpreuve.css" %>
</style>
</head>
<body>

	<c:import url="inc/header.jsp"/>
	<c:import url="inc/nav.jsp"/>
	
	<c:if test="${!empty sessionScope.nom }">
<p> bienvenue ${ sessionScope.nom }  ${ sessionScope.prenom }</p>
    </c:if>
	
	<section class="section_cours">
		<section class="section_gauche_cours">
			<article class="section_nom_classe">
			<c:out value="${ classe }" />
			</article>
			
			<article class="section_nom_matieres">
			
			 <c:forEach var="item" items="${ matieres }">
                <a><div class="section_titre_matiere">   <c:out value="${ item }" /> </div></a>
             </c:forEach>
				
			</article>
		
		</section>
		
		
		<section class="section_droite_cours">
			<article class="section_recherche">
				<input type="search" placeholder="rechercher" class="section_input_recherche" /><div><a href="">rechercher</a></div>
			</article>
			
			<article class="section_liste_cours">
				<table>
					<tr>
						<td width="10%"> image </td>
						<td width="38%"> nom </td>
						<td width="25%"> date </td>
						<td width="12%"> <a href="" class="telechager"><div>voir</div></a> </td>
						<td width="12%"> <a href="" class="telechager"><div>telecharger</div></a> </td>
					</tr>
				</table>
			</article>
		</section>
	
	
	</section>
	
	
	<c:import url="inc/footer.jsp"/>
</body>
</html>