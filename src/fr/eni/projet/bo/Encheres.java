package fr.eni.projet.bo;

import java.time.LocalDateTime;

/**
 * 
 * @author Kunkero
 *
 */
public class Encheres {
	
	private int noUtilisateur;
	private int noArticle;
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	
	/**
	 * @param noUtilisateur
	 * @param noArticle
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Encheres(int noUtilisateur, int noArticle, LocalDateTime dateEnchere, int montantEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the dateEnchere
	 */
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Encheres [noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle + ", dateEnchere=" + dateEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}
}
