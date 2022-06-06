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

                <div class="membre_admin">

                            <h1>suprimer utilisateur</h1>
                            <table class="table" >
                                <tr class="thead"><th>numero</th><th>nom</th><th>prenom</th><th>email</th><th>telephone</th><th>statut</th><th>supression</th></tr>
                                
                                            <tr height="40px" ><td width="8%"><?php echo $cpt;  ?></td><td width="17%"><?php echo $elem['nom'];  ?></td><td width="17%"><?php echo $elem['prenom'];  ?></td><td width="20%"><?php echo $elem['email'];  ?></td><td width="25%"><?php echo $elem['telephone'];  ?></td><td  width="10%"><?php echo $elem['statut'];  ?></td><td width="15%"><form action="traitement_supression.php" method="post"> <input type="hidden" name="id" value="<?php echo $elem['id']; ?>"><input type="submit" value="supprimer"></form></td></tr>
                               
                            </table>
                 </div>

                 <div class="membre_admin">

                            <h1>suprimer matiere</h1>
                            <table class="table" >
                                <tr class="thead"><th>numero</th><th>nom</th><th>supression</th></tr>
                                
                                            <tr height="40px" ><td width="8%"><?php echo $cpt;  ?></td><td width="17%"><?php echo $elem['nom'];  ?></td><td width="15%"><form action="traitement_supresion_matiere.php" method="post"> <input type="hidden" name="id_a" value="<?php echo $elem['id']; ?>"><input type="submit" value="supprimer"></form></td></tr>
                                
                            </table>
                 </div>

                 <div class="membre_admin">

                            <h1>suprimer cour</h1>
                            <table class="table" >
                                <tr class="thead"><th>numero</th><th>nom</th><th>supression</th></tr>
                                
                                            <tr height="40px" ><td width="8%"><?php echo $cpt;  ?></td><td width="17%"><?php echo $elem['nom'];  ?></td><td width="15%"><form action="traitement_supresion_cour.php" method="post"> <input type="hidden" name="id_b" value="<?php echo $elem['id']; ?>"><input type="submit" value="supprimer"></form></td></tr>
                                
                            </table>
                 </div>

                 <div class="membre_admin">

                            <h1>suprimer epreuve</h1>
                            <table class="table" >
                                <tr class="thead"><th>numero</th><th>nom</th><th>supression</th></tr>
                                
                                            <tr height="40px" ><td width="8%"><?php echo $cpt;  ?></td><td width="17%"><?php echo $elem['nom'];  ?></td><td width="15%"><form action="traitement_supresion_epreuve.php" method="post"> <input type="hidden" name="id_c" value="<?php echo $elem['id']; ?>"><input type="submit" value="supprimer"></form></td></tr>
                                
                            </table>
                 </div>

     </article>
	<c:import url="bas.jsp"/>
</body>
</html>