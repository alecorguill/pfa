
<!DOCTYPE html >
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<link type="text/css" rel="stylesheet" href="accueil.css" />-->
<link rel="stylesheet" href="style_poker_main_page.css" />
<title>Lobby ${requestScope.game}</title>
</head>
<body>
<div id='list_player'>
	${applicationScope.players.ready()}
	 <center><h1>Bienvenue sur le Poker !</h1>
  	</center>
	<c:forEach items="${applicationScope.players.players}" var="current" begin="0" end="${applicationScope.players.nbPlayers()}">
   		<br>
   		${current.pseudo} ${current.hasSmartphone ? 'Smartphone OK' : 'Smartphone non connect�' }
	</c:forEach>
</div>

  <c:if test="${sessionScope.player.isAdmin}" >
    <div id="lancer_jeu">
		<a href="maj1.html" >
		<strong>Lancer</strong>
		</a>
    </div>
</c:if>

</body>
  <script src="jquery-3.1.1.min.js"></script>
  
  <script type="text/javascript">
  	//Refresh the players 
  	var list_player_url = "http://localhost:8080/neoblik/lobby #list_player";
  	//var launch_url = "http://localhost:8080/neoblik/lobby #lancer_jeu";
  	var list_player = $('#list_player');
  	//var launch = $('#lancer_jeu');
  	setInterval(function() {
  		list_player.load(list_player_url);}, 1000);
  	

    
  </script>
</html>
