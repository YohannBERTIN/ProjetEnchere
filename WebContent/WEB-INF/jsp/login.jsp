<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connectez-vous à votre compte.</title>
</head>
<body>
	<header>
		<h1>ENI-Enchères</h1>
	</header>
	<main>
		<form>
			<label for="login"></label>
			<input type="text" name="login">
			<label for="mdp"></label>
			<input type="text" name="mdp">
			<input type="submit" value="Connexion">
			<input type="checkbox" name="remember">
  			<label for="remember">Se souvenir de moi</label>
			<a href>Mot de passe oublié</a>
			<a href=""><button>Créer un compte</button></a>
		</form>
	</main>
</body>
</html>