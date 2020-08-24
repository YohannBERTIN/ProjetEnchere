package fr.eni.projet.bo;

public class Categories {

	private int noCategorie;
	private String libelle;
	
	/**
	 * Constructeur de classe Categories
	 * @param noCategorie
	 * @param libelle
	 * 
	 */
	public Categories(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}

	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categories [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	
	
}
