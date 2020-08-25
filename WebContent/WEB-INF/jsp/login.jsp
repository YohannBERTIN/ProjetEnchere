<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="<c:url value="./css/style.css"/>" />
		<title>Connectez-vous à votre compte.</title>
	</head>
	<body>
		<header>
			<h1>ENI-Enchères</h1>
		</header>
		<main>
			<form method="post" action="<c:url value="/Login"/>">
				<label for="login">Identifiant : </label><br>
				<input type="text" name="login"><br>
				<label for="mdp">Mot de passe : </label><br>
				<input type="text" name="mdp"><br>
				<input type="submit" value="Connexion"><br>
				<input type="checkbox" name="remember">
	  			<label for="remember">Se souvenir de moi</label><br>
				<a href="">Mot de passe oublié</a><br>
			</form>
			<a href="<c:url value="/Register"/>"><button>Créer un compte</button></a><br>
		</main>
	</body>
</html>