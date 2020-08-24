package fr.eni.projet.bo;

public class ArticlesVendus {

	private int numArticle;
	private String nomArticle;
	private String description;
	private String dateDebutEnchere;
	private String dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private Utilisateurs numUtilisateur;
	private Categories numCategorie;
	
<<<<<<< HEAD
	
=======
>>>>>>> bac055da33cc4ee60bf80dd6de4f8fc2493a8b23
	/**
	 * 
	 * Constructeur de Classe ArticleVendus
	 * @param numArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param numUtilisateur
	 * @param numCategorie
	 * 
	 */
	public ArticlesVendus(int numArticle, String nomArticle, String description, String dateDebutEnchere,
			String dateFinEnchere, int prixInitial, int prixVente, Utilisateurs numUtilisateur,
			Categories numCategorie) {
		this.numArticle = numArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.numUtilisateur = numUtilisateur;
		this.numCategorie = numCategorie;
	}
	
	
	
}
