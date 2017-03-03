<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

    <head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="utf-8" />

        <title>Smartphone</title>

        <link type="text/css" rel="stylesheet" href="accueil.css" />

    </head>

    <body>

        <form method="post" action="connect_smartphone">
	    <center>
	      <div id="bigimg">
		<img src="img/neoblik.png" alt="Neoblik"/>
	      </div>
	    </center>

            <fieldset>

              <legend>Smartphone</legend>

              <p>Veuillez entrer le même pseudo que pour votre tablette</p>
	      
              <label for="nom">Pseudo :</label>

	      <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />

	      <input type="submit" value="Valider" class="sansLabel" />
	      
	      
	      <br />

	    </fieldset>
	
        </form>
        ${requestScope.message }
        <c:choose>
        	<c:when test="${request.type == 'POST' }">
    		<br> 
    		Essayer un autre pseudo ou inscrivez vous via la page d'accueil
    		  <div id="accueil">
				<a href ="accueil"><strong>Page d'accueil</strong></a>
    		</div>
    		</c:when>
    		<c:when test="${requestScope.isCorrect}">    		
    		<div id="lobby">
				<a href ="lobby"><strong>Cliquez ici pour rejoindre le lobby</strong></a>
    		</div>
    		</c:when>

		</c:choose>

    </body>

</html>
