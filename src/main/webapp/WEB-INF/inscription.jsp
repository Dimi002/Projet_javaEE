    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<style>

	<%@ include file="assets/css/nav.css" %>
		<%@ include file="assets/css/index.css" %>
	
</style>
</head>
<body>

	<c:import url="inc/header.jsp"/>
	
	
	<div class="container">
        <form id="form" class="form" action="?action=new" method="POST">
            <div class="form-control">
             <h2>INSCRIPTION</h2>
                <label for="nom">Nom:</label>
                <input type="text" placeholder="veillez entrer votre nom" id="nom" name="nom" />
            </div>
            <div class="form-control">
                <label for="prenom">Prenom:</label>
                <input type="text" placeholder="veillez entrer votre prenom" id="prenom" name="prenom" />
            </div>
            <div class="form-control">
                <label for="telephone">Telephone:</label>
                <input type="text" placeholder="veillez entrer votre numero" id="telephone" name="telephone" />
            </div>
            <div class="form-control">
                <label for="email">E-mail:</label>
                <input type="email" placeholder="veillez entrer votre adresse e-mail" id="email" name="email" />
            </div>
            <div class="form-control">
                <label for="mot_de_passe">Mot de passe:</label>
          		<input type="password" placeholder="veillez entrer votre mot de passe" id="mot_de_passe" name="mot_de_passe" />
            </div>
            <div class="form-control">
                <label for="passwordconfirm">Confirmer:</label>
          		<input type="password" placeholder="veillez confirmer votre mot de passe" id="passwordconfirm" name="passwordconfirm" />
            </div>
            <center>Vous avez un  compte? connectez vous <a href="?action=index" class="lien">incrivez-vous</a></center>
            
            <input type="submit" value="Enregistrer">
            <input type="reset" value="Annuler">
        </form>
    </div>
    </div>
	
	
	<c:import url="inc/footer.jsp"/>
</body>
</html>