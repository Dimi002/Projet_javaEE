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
	
	
	
	<section class="section_cours">
		<section class="section_gauche_cours">
			<article class="section_nom_classe">
			<c:out value="${ classe }" />
			</article>
			
			<article class="section_nom_matieres">
			 <c:forEach var="item" items="${ matieres }">
			  <a href="?action=cours&&classe=${classe}&&matiere=${item.getId()}"> <div class="section_titre_matiere"> <c:out value="${ item.getMatieres() }" /> </div></a>
				
             </c:forEach>
			 
               
             
				
			</article>
		
	     </section> 
		
		
		<section class="section_droite_cours">
			<article class="section_recherche">
				<input type="search" placeholder="rechercher" class="section_input_recherche" /><div><a href="">rechercher</a></div>
			</article>
			
			<article class="section_liste_cours">
				<table>
					
			 <c:forEach var="item" items="${ cours }">
			 <tr>
                        <td width="15%"> <img src="<c:url value="eleve.jpg"/>" /> </td>
						<td width="38%"> ${item.getNom()} </td>
						<td width="35%"> ${item.getDate()} </td>
						<td width="12%"> 
						<c:if test="${!empty sessionScope.nom }">
						<a href="" download="C:/JAVA EE/Projet_javaEE/src/main/webapp/documents/${item.getLien()}" class="telechager"><div>telecharger</div></a> 
						</c:if>
						 <c:if test="${empty sessionScope.nom }">
                        <a href="?action=index" class="I_btn">telecharger</a>
                          </c:if>
						
						</td>
		     </tr>		
             </c:forEach>
						
					 
				</table>
			</article>
		</section>
	
	
	</section>
	
	
	<c:import url="inc/footer.jsp"/>
</body>
</html>