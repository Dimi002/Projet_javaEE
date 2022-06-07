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

<!--  ajout epreuves-->

        <article class="droite">
            <div class="profil_epreuve">
                    <center><h2>AJOUTER UNE EPREUVE</h2></center> 

            

 <c:out value="${ message }" />
                    <form action="" method="post" enctype="multipart/form-data">
                        Nom: <input type="file"  name="fichier">
                        Classe: <select name="classes" id="">
                        
             <c:forEach var="item" items="${ listclassesetid }">
			 		<option value="${item.getId()}"> <c:out value="${ item.getClasse() }" /> </option>
             </c:forEach>
                        
               </select>
                        Matiere: <select name="matieres" id="">
             <c:forEach var="item" items="${ matieres }">
			         <option value="${item.getId()}"> <c:out value="${ item.getMatieres() }" /> </option>
             </c:forEach>
                            
                        
                     </select>
                        <input type="submit" value="ajouter">
                    </form>


            </div>



<!--  ajout cours-->

            

            <div class="profil_cour">
                <center><h2>AJOUTER UN COUR</h2></center>
                <form action="" method="post" enctype="multipart/form-data">
                        Nom: <input type="file"  name="nom" >
                        Classe: <select name="cours" id="">
                        <?php
                            while($item=$classes->fetch()){
                        ?>
                                    <option value="<?php echo  $item['id']; ?>"><?php echo  $item['nom']; ?></option>
                        <?php
                            }
                        ?>  
                                </select>
                        Matiere: <select name="matiere" id="">
                        <?php
                            while($item=$matieres->fetch()){
                        ?>
                                    <option value="<?php echo  $item['id']; ?>"><?php echo  $item['nom']; ?></option>
                        <?php
                            }
                        ?>
                                </select>
                        <input type="submit" value="ajouter">
                    </form>

                   
            </div>


<!--  ajout matieres-->
            
            <div class="profil_matiere">
            <center><h2>AJOUTER UNE MATIERE</h2></center>
                <form action="" method="post">

                     Nom : <input type="text" name="nom" id="p_nom" placeholder="nom de la matiere" required> 
                      <input type="submit" value="ajouter" id="btn">
                </form>

               
            </div>

<!--  ajout utilisateur-->
        <div class="profil_utilisateur">
            <center><h2>AJOUTER UN UTILISATEUR</h2></center>
                <form action="" method="post">

                     Nom : <input type="text" name="nom" id="" required> 
                     Prenom : <input type="text" name="prenom" id="" required> 
                     email : <input type="email" name="email" id="" required> 
            <br><br> mot de passe : <input type="password" name="pass" id="" required> 
                     telephone : <input type="text" name="telephone" id="" required> 
                     <select name="statut"> 
                         <option value="client">client</option>
                         <option value="admin"> admin</option>
                     </select>
                      <input type="submit" value="ajouter"> 
                </form>
                   
                   
            </div>

        </article>

    <c:import url="bas.jsp"/>
</body>
</html>