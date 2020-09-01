<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- @author Yohan SAINT-MARTIN -->
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html">
<link type="text/css" rel="stylesheet" href="<c:url value="./css/style.css"/>"/>
<title>Nouvelle vente</title>
</head>
<body>
	<header>
	<h1>ENI-Enchères</h1>
	</header>
	<!-- Formulaire de création d'une vente -->
	<form method="post" action="<c:url value="/New_auction"/>">
		<fieldset>
			<legend>Nouvelle Vente</legend>
			<!-- Zone D'affichage du message d'erreur -->
			<p class="info">${ message }</p>
			<div class="form">
				<div class="form-box">
					<label for="itemName">Article : <span class="required">*</span></label>
					<input type="text" id="itemName" name="itemName" size="30" maxlength="30" required/>
					<span class="erreur">${ form.errors['auctionName'] } </span>
					<br/>
					
					<label for="itemDescription">Description : <span class="required">*</span></label>
					<textarea id="itemDescription" name="itemDescription" rows="5" cols="50" required></textarea>
					<span class="erreur">${ form.errors['auctionDescription'] } </span>
					<br/>
					
					<label for="itemCategory">Catégorie : <span class="required">*</span></label>
					<select id="itemCategory" name="itemCategory" required>
					<option>Jouets</option>
					<option>Livres</option>
					<option>Meubles</option>
					<option>Vêtmements</option>
					</select>
					<span class="erreur">${ form.errors['auctionCategory'] } </span>
					<br/>
					
					<label for="itemPicture">Photo de l'article : <span class="required">*</span></label>
					<input type="file" id="itemPicture" name="itemPicture" multiple/>
					<span class="erreur">${ form.errors['auctionDescription'] } </span>
					<br/>
					
					<label for="itemInitPrice">Mise à prix : <span class="required">*</span></label>
					<input type="text" id="itemInitPrice" name="itemInitPrice" value="1" size="5" maxlength="5" required/>
					<span class="erreur">${ form.errors['auctionStartPrice'] } </span>
					<br/>
					
					<label for="itemStartDate">Début de l'enchère : </label>
  					<input type="date" id="itemStartDate" name="itemStartDate"/>
					<span class="erreur">${ form.errors['auctionStartDate'] } </span>
					<input type="time" name="timeStart" id="timeStart"/>
					<br/>
					
					<label for="itemEndDate">Fin de l'enchère : </label>
  					<input type="date" id="itemEndDate" name="itemEndDate"/>
					<span class="erreur">${ form.errors['auctionEndDate'] } </span>	
					<input type="time" name="itemEndtime" id="itemEndtime"/>
					<br/>	
				</div>
			</div>		
		</fieldset>
		<br/>
		<br/>
		<br/>
		<fieldset>
			<legend>Retrait</legend>
			<div class="form">
				<div class="form-box">
					<label for="pickupStreet">Rue : <span class="required">*</span></label>
					<input type="text" id="pickupStreet" name="pickupStreet" value="<c:out value="${sessionScope.sessionUser.street}"/>" size="30" maxlength="30" required/>
					<br/>
					
					 <label for="pickupZip">Code postal : <span class="required">*</span></label>
		             <input type="text" id="pickupZip" name="pickupZip" value="<c:out value="${sessionScope.sessionUser.zip}"/>" size="30" maxlength="30" />
		             <br />
					
					<label for="pickupCity">Ville : <span class="required">*</span></label>
					<input type="text" id="pickupCity" name="pickupCity" value="<c:out value="${sessionScope.sessionUser.city}"/>" size="5" maxlength="5" required/>
					<br/>
				</div>
			</div>
		</fieldset>
		<input type="submit" value="Enregistrer" class="sansLabel" />
		<input type="submit" value="Annuler" class="sansLabel" />
	</form>
</body>
</html>