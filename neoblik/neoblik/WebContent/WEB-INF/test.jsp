<!DOCTYPE html>

<html>

    <head>

	    <meta charset="utf-8" />

        <title>Accueil</title>
		<style type="text/css">
  			div { width: 400px; height: 300px; float: left; margin: 5px; }
  			#premier { background-color: #F6E497; }
  			#troisieme { background-color: #CAF1EC; }
  			#quatrieme { background-color: #F1DBCA; }
		</style>
</head>

<body>
<div id='premier'>
  	<center><h1>Bienvenue sur le Poker !</h1>
  	</center>
    <fieldset>
      <legend> Liste des joueurs dans le lobby :</legend>
    </fieldset>
  </div>

	<p> Salut </p>
</body>
<script src="jquery-3.1.1.min.js"></script>
<script>
      setInterval(function () {$('#premier').load('http://localhost:8080/neoblik/test');}, 5000);

</script>

</html>