<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="<c:url value="./css/style.css"/>" />
		<title>ENI-Enchères / Mon profil</title>
	</head>
	<body>
		<main>
			<div class="identity">
				<fieldset>
	            	<legend>Identité</legend>
					<p>Pseudo : ${sessionScope.sessionUser.pseudo}</p>
					<p>Nom : ${sessionScope.sessionUser.lastName}</p>
					<p>Prénom : ${sessionScope.sessionUser.firstName}</p>
				</fieldset>
			</div>
			<div class="Contact">
				<fieldset>
	            	<legend>Adresse</legend>
					<p>Email : ${sessionScope.sessionUser.email}</p>
					<p>Téléphone : ${sessionScope.sessionUser.phone}</p>
					<br />
					<p>Rue : ${sessionScope.sessionUser.street}</p>
					<p>Code postal : ${sessionScope.sessionUser.zip}</p>
					<p>Ville : ${sessionScope.sessionUser.city}</p>
				</fieldset>
			</div>
			<div class="credit">
				<fieldset>
	            	<legend>Crédits</legend>
					<p>Solde : ${sessionScope.sessionUser.credit}</p>
				</fieldset>
			</div>
			<div class="button_profil">
				<a href="<c:url value="/Index_login"/>"><button>Retour</button></a>
				<a href="<c:url value="/Modify_profil"/>"><button>Modifier</button></a>
			</div>
		</main>
	</body>
</html>