<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENI-Enchères / Modifier le profil</title>
	</head>
	<body>
	 	<div>
			<!-- Formulaire de création de compte utilisateur -->
			<form method="post" action="<c:url value="/Modify_profil"/>">
				<fieldset>
					<legend>Mon profil</legend>
					
					<!-- Zone d'affichage du message d'erreur -->
					<p class="info">${ message }</p>
					
					<div class="form">
						<div class="form-box">
						 	<label for="userPseudo">Pseudo : <span class="required">*</span></label>
						 	<input type="text" id="userPseudo" name="userPseudo" value="<c:out value="${sessionScope.sessionUser.pseudo}"/>" size="30" maxlength="30" />
							<span class="erreur">${form.errors['userPseudo']}</span>
							<br />
							
							<label for="userFirstName">Prénom : <span class="required">*</span></label>
							<input type="text" id="userFirstName" name="userFirstName" value="<c:out value="${sessionScope.sessionUser.firstName}"/>" size="30" maxlength="30" />
							<br />
							
							<label for="userPhone">Téléphone : </label>
							<input type="text" id="userPhone" name="userPhone" value="<c:out value="${sessionScope.sessionUser.phone}"/>" size="30" maxlength="30" />
							<br />
							
							<label for="userZip">Code postal : <span class="required">*</span></label>
							<input type="text" id="userZip" name="userZip" value="<c:out value="${sessionScope.sessionUser.zip}"/>" size="30" maxlength="30" />
							<br />
							 
							<label for="userPassword">Mot de passe actuel : <span class="required">*</span></label>
							<input type="password" id="userPassword" name="userPassword" value="" size="30" maxlength="30" />
							<br />
							
							<label for="userNewPassword">Nouveau mot de passe : <span class="required">*</span></label>
							<input type="password" id="userNewPassword" name="userNewPassword" value="" size="30" maxlength="30" />
						</div>
						
						<div class="form-box">
							<label for="userLastName">Nom : <span class="required">*</span></label>
							<input type="text" id="userLastName" name="userLastName" value="<c:out value="${sessionScope.sessionUser.lastName}"/>" size="30" maxlength="30" />
							<br />
							
							<label for="userEmail">Email : <span class="required">*</span></label>
							<input type="email" id="userEmail" name="userEmail" value="<c:out value="${sessionScope.sessionUser.email}"/>" size="30" maxlength="30" />
							<span class="erreur">${form.errors['userEmail']}</span>
							<br />
							
							<label for="userStreet">Rue : <span class="required">*</span></label>
							<input type="text" id="userStreet" name="userStreet" value="<c:out value="${sessionScope.sessionUser.street}"/>" size="30" maxlength="30" />
							<br />
							
							<label for="userCity">Ville : <span class="required">*</span></label>
							<input type="text" id="userCity" name="userCity" value="<c:out value="${sessionScope.sessionUser.city}"/>" size="30" maxlength="30" />
							<br />
							
							<br />
							<br />
							
							<label for="userConfirmation">Confirmation : <span class="required">*</span></label>
							<input type="password" id="userConfirmation" name="userConfirmation" value="" size="30" maxlength="30" />
							<span class="erreur">${form.errors['userPassword']}</span>
						</div>
					</div>
				</fieldset>
	            <input type="submit" value="Enregistrer" class="sansLabel" />
			</form>
	            
			<!-- Zone d'affichage du résultat du formulaire -->
			<p class="${empty form.errors ? 'succes' : 'erreur'}">${form.result}</p>
			<p class="erreur">${form.result}</p>
	            
			<!-- Annuler renvoie l'utilisateur vers l'index du site -->
			<a href="<c:url value="/Delete_user"/>"><button class="sansLabel">Supprimer mon compte</button></a><br />
			<fieldset class="warning">
				<legend>Attention</legend>
				<p>En cliquant sur le bouton <strong>"Supprimer mon compte"</strong> vous serez renvoyé à l'accueil du site,<br />
				<span class="underline">vous perdrez tous vos crédits accumilés</span> et vous devrez créer un nouveau compte pour faire de nouvelles enchères !</p>
			</fieldset>
		</div>
	</body>
</html>