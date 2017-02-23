
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<link type="text/css" rel="stylesheet" href="accueil.css" />-->
<link rel="stylesheet" href="style_poker_main_page.css" />
<title>Lobby ${requestScope.game}</title>
</head>
<body>
<div id='poker'>
  	<center><h1>Bienvenue sur le Poker !</h1>
  	</center>
    <fieldset>
      <legend> Liste des joueurs dans le lobby :</legend>
      <p> ${applicationScope.players.toString()}</p>
    </fieldset>
  </div>
  
  <p> salut </p>
</body>
  <script src="jquery-3.1.1.min.js"></script>
  
  <script type="text/javascript">
  	var url = "http://localhost:8080/neoblik/lobby";
  	var my_div = $('#poker');
    setInterval(function () {my_div.load(url);},5000);
  	
  </script>
</html>
