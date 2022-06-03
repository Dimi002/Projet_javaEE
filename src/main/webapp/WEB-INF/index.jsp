<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	<%@ include file="assets/css/index.css" %>
	<%@ include file="assets/css/nav.css" %>
</style>
<title>Etude Libre</title>
</head>
<body>

	<c:import url="inc/header.jsp"/>
	<c:import url="inc/nav.jsp"/>

	<div class="img">
        <div class="dim" id="qqq">
            <form action="" method="post">
                    <span>CONNEXION</span> 
                <p><input type="text" placeholder=" EMAIL OU TELEPHONE" class="input" name="username"></p>
                <p><input type="password" placeholder=" MOT DE PASSE " class="input" name="password"></p>
               
                <p><input type="submit" value="CONNEXION" class="button"></p>
                <p><input type="reset" value="EFFACER" class="button"></p>
            </form>
            <center>Vous n'avez pas de compte? <a href="?action=inscription" class="lien">incrivez-vous</a></center>
        </div>

    <div class="savoir"><h1>A SAVOIR</h1> </div>
    <section class="section1">
       
        <article class="art1">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum obcaecati est illo veritatis quas, facere dolorem odit voluptates expedita ipsa blanditiis molestias aliquam quidem quibusdam ut neque incidunt quo! Tempore.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum obcaecati est illo veritatis quas, facere dolorem odit voluptates expedita ipsa blanditiis molestias aliquam quidem quibusdam ut neque incidunt quo! Tempore.
        </article>
        <article class="art1">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum obcaecati est illo veritatis quas, facere dolorem odit voluptates expedita ipsa blanditiis molestias aliquam quidem quibusdam ut neque incidunt quo! Tempore.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum minima facilis odio dolorum. Facilis pariatur a dolores obcaecati iste neque numquam suscipit natus! Beatae reprehenderit, veniam soluta asperiores deserunt sit.
        </article>
        <article class="art1" >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum obcaecati est illo veritatis quas, facere dolorem odit voluptates expedita ipsa blanditiis molestias aliquam quidem quibusdam ut neque incidunt quo! Tempore.
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat quia adipisci reiciendis totam dolorum exercitationem maxime inventore voluptate, quisquam omnis at quod dicta dolor quis! Quis nulla nihil voluptatibus reprehenderit.
        </article>
    </section>
    
   <c:import url="inc/footer.jsp"/>
 
	 <script type="text/javascript">
			<%@ include file="assets/js/regexConnexion.js" %>
			<%@ include file="assets/js/scrollFix.js" %>
	</script>
   
</body>
</html>