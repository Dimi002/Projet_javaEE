<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@ include file="admin.css" %>
</style>
</head>
<body>
	<c:import url="haut.jsp"/>
        <article class="droite">
            <div class="div1"> 
                <a href="?action=profil" class="champ1"> <div >  <h1 class="h1">profil</h1> <br> Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit, modi! Deserunt culpa modi provident. Tempora rem quos illo error saepe atque, illum omnis quasi porro deserunt nihil similique adipisci. Reprehenderit? </div></a>
                <a href="?action=membre" class="champ1"> <div > <h1 class="h1">membres</h1><br> Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit, modi! Deserunt culpa modi provident. Tempora rem quos illo error saepe atque, illum omnis quasi porro deserunt nihil similique adipisci. Reprehenderit?</div></a>
            </div>
            <div class="div2">
                <a href="?action=ajout" class="champ2"> <div >  <h1 class="h1"> Ajout </h1> <br> Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit, modi! Deserunt culpa modi provident. Tempora rem quos illo error saepe atque, illum omnis quasi porro deserunt nihil similique adipisci. Reprehenderit?</div></a>
                <a href="?action=supression" class="champ2"><div > <h1 class="h1">Suppression</h1> <br> Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit, modi! Deserunt culpa modi provident. Tempora rem quos illo error saepe atque, illum omnis quasi porro deserunt nihil similique adipisci. Reprehenderit?</div></a>
            </div>
            
            
        </article>
    <c:import url="bas.jsp"/>
</body>
</html>