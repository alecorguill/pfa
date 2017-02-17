<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<link type="text/css" rel="stylesheet" href="accueil.css" />-->
<link rel="stylesheet" href="style_poker_main_page.css" />
<title>Lobby ${requestScope.game}</title>
</head>
<body>
  <center><h1>Bienvenue sur le Poker !</h1>
  </center>
  <div id="poker">
    <fieldset>
      <legend> Liste des joueurs dans le lobby :</legend>
      <p> ${applicationScope.players.toString()}</p>
    </fieldset>
  </div>
</body>
</html>
