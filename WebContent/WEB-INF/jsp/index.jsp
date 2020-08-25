<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="./css/style.css" />
		<title>ENI-Enchères</title>
	</head>
	<body>
		<header>
		<h1>ENI-Enchère</h1>
		<a href="${pageContext.request.contextPath}/Register"><button>S'inscrire</button></a>
		<a href="${pageContext.request.contextPath}/Login"><button>Se connecter</button></a>
		</header>
		<main>
			<h2>Liste des enchères</h2>
			<br />
			<label for="filter">Filtres :</label><br />
			<input type="search" name="filter" value="Le nom de l'article contient">
			<button>Rechercher</button>
			<br />
			<br />
			<br />
			<button>Enchère 1</button>
			<button>Enchère 2</button>
			<br />
			<button>Enchère 3</button>
			<button>Enchère 4</button>
		</main>
	</body>
</html>