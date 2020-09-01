package fr.eni.projet;

/**
 * Group all constant for BDD in one source.
 * @author Yohann BERTIN
 *
 */
public final class Bdd {

		// BDD user's fields
	
		public static String userID = "no_utilisateur";
		public static String userPseudo = "pseudo";
		public static String userLastName = "nom";
		public static String userFirstName = "prenom";
		public static String userEmail = "email";
		public static String userPhone = "telephone";
		public static String userStreet = "rue";
		public static String userZipCode = "code_postal";
		public static String userCity = "ville";
		public static String userPassword = "mot_de_passe";
		public static String userCredit = "credit";
		public static String userAdmin = "administrateur";
		
		// BDD item's fields
		
		public static String itemID = "no_article";
		public static String itemName = "nom_article";
		public static String itemDescription = "description";
		public static String itemSellStart = "date_debut_encheres";
		public static String itemSellEnd = "date_fin_encheres";
		public static String itemInitPrice = "prix_initial";
		public static String itemSellPrice = "prix_vente";
		public static String itemUserID = "no_utilisateur";
		public static String itemCategoryID = "no_categorie";
		
		// BDD auction's fields
		
		public static String auctionUserID = "no_utilisateur";
		public static String auctionItemID = "no_article";
		public static String auctionDate = "date_enchere";
		public static String auctionAmont = "montant_enchere";
		
		// BDD category's fields
		
		public static String categoryID = "no_categorie";
		public static String categoryLabel = "libelle";
		
		// BDD pickup's fields
		
		public static String pickupItemID = "no_article";
		public static String pickupStreet = "rue";
		public static String pickupZipCode = "code_postal";
		public static String pickupCity = "ville";
}
