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

                    <h1>membres administrateurs</h1>
                    
                    <table class="table" >
                        <tr class="thead"><th>numero</th><th>nom</th><th>prenom</th><th>email</th><th>telephone</th></tr>
                        
                              <tr height="40px" ><td width="10%"><?php echo $cpt;  ?></td><td width="28%"><?php echo $elem['nom'];  ?></td><td width="28%"><?php echo $elem['prenom'];  ?></td><td width="30%"><?php echo $elem['email'];  ?></td><td width="25%"><?php echo $elem['telephone'];  ?></td></tr>
                       
                    </table>
            </div>

            <div class="membre_utilisateur">

                    <h1>membres utilisateur</h1>
                    <table class="table" >
                        <tr class="thead"><th>numero</th><th>nom</th><th>prenom</th><th>email</th><th>telephone</th></tr>
                        
                               <tr height="40px" ><td width="10%"><?php echo $cpt;  ?></td><td width="28%"><?php echo $elem['nom'];  ?></td><td width="28%"><?php echo $elem['prenom'];  ?></td><td width="30%"><?php echo $elem['email'];  ?></td><td width="25%"><?php echo $elem['telephone'];  ?></td></tr>
                        
                    </table>
            </div>
    </article>
    <c:import url="bas.jsp"/>
</body>
</html>