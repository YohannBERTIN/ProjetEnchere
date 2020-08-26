<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- @author Yohann BERTIN -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="<c:url value="./css/style.css"/>" />
		<title>Mon profil</title>
	</head>
	<body>
		<div>
		
		<!-- Formulaire de création de compte utilisateur -->
            <form method="post" action="<c:url value="/Register"/>">
                <fieldset>
                    <legend>Mon profil</legend>
                    
                    <!-- Zone d'affichage du message d'erreur -->
                    <p class="info">${ message }</p>
                    
                    <div class="form">
	                    <div class="form-box">
		                    <label for="userPseudo">Pseudo : <span class="required">*</span></label>
		                    <input type="text" id="userPseudo" name="userPseudo" value="<c:out value="${param.userPseudo}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userPseudo']}</span>	<!-- ATTENTION : form.erreur est le nom de la class.la variable erreur -->
		                    <br />
		                    
		                    <label for="userFirstName">Prénom : <span class="required">*</span></label>
		                    <input type="text" id="userFirstName" name="userFirstName" value="<c:out value="${param.userFirstName}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userFirstName']}</span>
		                    <br />
		                    
		                    <label for="userPhone">Téléphone : </label>
		                    <input type="text" id="userPhone" name="userPhone" value="<c:out value="${param.userPhone}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userPhone']}</span>
		                    <br />
		                    
		                    <label for="userZip">Code postal : <span class="required">*</span></label>
		                    <input type="text" id="userZip" name="userZip" value="<c:out value="${param.userZip}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userZip']}</span>
		                    <br />
		                    
		                    <label for="userPassword">Mot de passe : <span class="required">*</span></label>
		                    <input type="password" id="userPassword" name="userPassword" value="" size="30" maxlength="30" />
	                    </div>
	                    
	                    <div class="form-box">
		                    <label for="userLastName">Nom : <span class="required">*</span></label>
		                    <input type="text" id="userLastName" name="userLastName" value="<c:out value="${param.userLastName}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userLastName']}</span>
		                    <br />
		                    
		                    <label for="userEmail">Email : <span class="required">*</span></label>
		                    <input type="email" id="userEmail" name="userEmail" value="<c:out value="${param.userEmail}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userEmail']}</span>
		                    <br />
		                    
		                    <label for="userStreet">Rue : <span class="required">*</span></label>
		                    <input type="text" id="userStreet" name="userStreet" value="<c:out value="${param.userStreet}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userStreet']}</span>
		                    <br />
		                    
		                    <label for="userCity">Ville : <span class="required">*</span></label>
		                    <input type="text" id="userCity" name="userCity" value="<c:out value="${param.userCity}"/>" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userCity']}</span>
		                    <br />
		                    
		                    <label for="userConfirmation">Confirmation : <span class="required">*</span></label>
		                    <input type="password" id="userConfirmation" name="userConfirmation" value="" size="30" maxlength="30" />
		                    <span class="erreur">${form.erreurs['userPassword']}</span>
	                    </div>
                    </div>
                </fieldset>
                <input type="submit" value="Créer" class="sansLabel" />
            </form>
            
            <!-- Annuler renvoie l'utilisateur vers l'index du site -->
            <a href="<c:url value="/Index"/>"><button class="sansLabel">Annuler</button></a><br />
        </div>
	</body>
</html>