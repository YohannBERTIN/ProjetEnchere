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
	<form method="post" action="<c:url value="/New_Auction"/>">
		<fieldset>
			<legend>Nouvelle Vente</legend>
			<!-- Zone D'affichage du message d'erreur -->
			<p class="info">${ message }</p>
			<div class="form">
				<div class="form-box">
					<label for="auctionName">Article : <span class="required">*</span></label>
					<input type="text" id="auctionName" name="auctionName" size="30" maxlength="30" required/>
					<span class="erreur">${ form.errors['auctionName'] } </span>
					<br/>
					
					<label for="auctionDescription">Description : <span class="required">*</span></label>
					<textarea id="auctionDescription" name="auctionDescription" rows="5" cols="50" required></textarea>
					<span class="erreur">${ form.errors['auctionDescription'] } </span>
					<br/>
					
					<label for="auctionCategory">Catégorie : <span class="required">*</span></label>
					<select id="auctionCategory" name="auctionCategory" required>
					<option>àrenommer</option>
					<option>oubliepasderenommer</option>
					<option>attentionilfautrenommer</option>
					<option>avecdesdonnéesdelaBDD</option>
					</select>
					<span class="erreur">${ form.errors['auctionCategory'] } </span>
					<br/>
					
					<label for="auctionPhoto">Photo de l'article : <span class="required">*</span></label>
					<input type="file" id="auctionPhoto" name="auctionPhoto" multiple/>
					<span class="erreur">${ form.errors['auctionDescription'] } </span>
					<br/>
					
					<label for="auctionStartPrice">Mise à prix : <span class="required">*</span></label>
					<input type="text" id="auctionStartPrice" name="auctionStartPrice" value="1" size="5" maxlength="5" required/>
					<span class="erreur">${ form.errors['auctionStartPrice'] } </span>
					<br/>
					
					<label for="auctionStartDate">Début de l'enchère : </label>
  					<input type="date" id="auctionStartDate" name="auctionStartDate"/>
					<span class="erreur">${ form.errors['auctionStartDate'] } </span>
					<br/>
					
					<label for="auctionEndDate">Début de l'enchère : </label>
  					<input type="date" id="auctionEndDate" name="auctionEndDate"/>
					<span class="erreur">${ form.errors['auctionEndDate'] } </span>	
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
					<label for="userStreet">Rue : <span class="required">*</span></label>
					<input type="text" id="userStreet" name="userStreet" value="<c:out value="${sessionScope.sessionUser.street}"/>" size="30" maxlength="30" required/>
					<br/>
					
					 <label for="userZip">Code postal : <span class="required">*</span></label>
		             <input type="text" id="userZip" name="userZip" value="<c:out value="${sessionScope.sessionUser.zip}"/>" size="30" maxlength="30" />
		             <br />
					
					<label for="userCity">Ville : <span class="required">*</span></label>
					<input type="text" id="userCity" name="userCity" value="<c:out value="${sessionScope.sessionUser.city}"/>" size="5" maxlength="5" required/>
					<br/>
				</div>
			</div>
		</fieldset>
		<input type="submit" value="Enregistrer" class="sansLabel" />
		<input type="submit" value="Annuler" class="sansLabel" />
	</form>
</body>
</html>