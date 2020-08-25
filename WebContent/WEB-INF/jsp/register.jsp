<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="./css/style.css" />
		<title>Mon profil</title>
	</head>
	<body>
		<div>
            <form method="get" action="<%=request.getContextPath()%>/Register">
                <fieldset>
                    <legend>Mon profil</legend>
                    
                    <label for="nomClient">Pseudo : <span class="required">*</span></label>
                    <input type="text" id="nomClient" name="userPseudo" value="" size="20" maxlength="20" />
    
                    <label for="nomClient">Nom : <span class="required">*</span></label>
                    <input type="text" id="nomClient" name="userLastName" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom : <span class="required">*</span></label>
                    <input type="text" id="prenomClient" name="userFirstName" value="" size="20" maxlength="20" />
                    
                    <label for="emailClient">Email : <span class="required">*</span></label>
                    <input type="email" id="emailClient" name="userEmail" value="" size="20" maxlength="60" />
                    <br />
    
                    <label for="telephoneClient">Téléphone : </label>
                    <input type="text" id="telephoneClient" name="userPhone" value="" size="20" maxlength="20" />
                    
                    <label for="adresseClient">Rue : <span class="required">*</span></label>
                    <input type="text" id="adresseClient" name="userAdress" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="adresseClient">Code postal : <span class="required">*</span></label>
                    <input type="text" id="adresseClient" name="userAdress" value="" size="20" maxlength="20" />

                    <label for="adresseClient">Ville : <span class="required">*</span></label>
                    <input type="text" id="adresseClient" name="userAdress" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="adresseClient">Mot de passe : <span class="required">*</span></label>
                    <input type="text" id="adresseClient" name="userAdress" value="" size="20" maxlength="20" />

                    <label for="adresseClient">Confirmation : <span class="required">*</span></label>
                    <input type="text" id="adresseClient" name="userAdress" value="" size="20" maxlength="20" />
                    <br />  
                </fieldset>
                <input type="submit" value="Créer"  />
                <a href="http://localhost:8080/ProjetEnchere/index"><button>Annuler</button></a><br />
            </form>
        </div>
	</body>
</html>