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
            <div class="profil">
                <div class="profil1">
                    <a href="">    <div>  MODIFIER </div> </a>
                </div>

                <div class="profil2">
                    <div class="profil_name">
                        <p> <br> nom :</p>
                        <p> <br> <br> <br> prenom :</p>
                        <p> <br> <br> numero :</p>
                        <p> <br> <br> <br>email :</p>
                        <p><br> <br> <br> mot de passe :</p>
                    </div>
                    <div class="profil_input">
                        <p><input type="text" name="nom" value="dimi"></p>
                        <p><input type="text" name="prenom" value="loic"></p>
                        <p><input type="email" name="numero" value="5u5u5u45uu45"></p>
                        <p><input type="text"  name="email" value="ngwanodimitri@gmail.com"></p>
                        <p><input type="password" name="pass" value="saisir votre mot de passe"></p>
                    </div>
                </div>
            </div>
        </article>
    <c:import url="bas.jsp"/>
</body>
</html>