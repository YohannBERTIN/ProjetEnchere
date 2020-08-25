<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="<c:url value="./css/style.css"/>" />
		<title>Mon profil</title>
	</head>
	<body>
		<div>
            <form method="post" action="<c:url value="/Register"/>">
                <fieldset>
                    <legend>Mon profil</legend>
                    <p class="info">${ message }</p>
                    <div class="form">
	                    <div class="form-box">
		                    <label for="userPseudo">Pseudo : <span class="required">*</span></label>
		                    <input type="text" id="userPseudo" name="userPseudo" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userFirstName">Prénom : <span class="required">*</span></label>
		                    <input type="text" id="userFirstName" name="userFirstName" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userPhone">Téléphone : </label>
		                    <input type="text" id="userPhone" name="userPhone" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userZip">Code postal : <span class="required">*</span></label>
		                    <input type="text" id="userZip" name="userZip" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userPassword">Mot de passe : <span class="required">*</span></label>
		                    <input type="text" id="userPassword" name="userPassword" value="" size="20" maxlength="20" />
	                    </div>
	                    <div class="form-box">
		                    <label for="userLastName">Nom : <span class="required">*</span></label>
		                    <input type="text" id="userLastName" name="userLastName" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userEmail">Email : <span class="required">*</span></label>
		                    <input type="email" id="userEmail" name="userEmail" value="" size="20" maxlength="60" />
		                    <br />
		                    <label for="userStreet">Rue : <span class="required">*</span></label>
		                    <input type="text" id="userStreet" name="userStreet" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userCity">Ville : <span class="required">*</span></label>
		                    <input type="text" id="userCity" name="userCity" value="" size="20" maxlength="20" />
		                    <br />
		                    <label for="userConfirmation">Confirmation : <span class="required">*</span></label>
		                    <input type="text" id="userConfirmation" name="userConfirmation" value="" size="20" maxlength="20" />
	                    </div>
                    </div>
                </fieldset>
                <input type="submit" value="Créer"  />
            </form>
            <a href="<c:url value="/Index"/>"><button>Annuler</button></a><br />
        </div>
	</body>
</html>