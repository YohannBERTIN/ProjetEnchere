package fr.eni.projet.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 
 * @author Yohan SAINT-MARTIN
 *
 */
public class Item {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private LocalTime itemStartTime;
	private LocalTime itemEndTime;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private List<Auctions> auctions;
	private Pickup pickup;

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
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebutEnchere
	 */
	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	/**
	 * @param dateDebutEnchere the dateDebutEnchere to set
	 */
	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	/**
	 * @return the dateFinEnchere
	 */
	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	/**
	 * @param dateFinEnchere the dateFinEnchere to set
	 */
	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	/**
	 * @return the prixInitial
	 */
	public int getPrixInitial() {
		return prixInitial;
	}

	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArticlesVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + "]";
	}

	/**
	 * @return the auctions
	 */
	public List<Auctions> getAuctions() {
		return auctions;
	}

	/**
	 * @param auctions the auctions to set
	 */
	public void setAuctions(List<Auctions> auctions) {
		this.auctions = auctions;
	}

	/**
	 * @return the pickup
	 */
	public Pickup getPickup() {
		return pickup;
	}

	/**
	 * @param pickup the pickup to set
	 */
	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}

	/**
	 * @return the timeStart
	 */
	public LocalTime getTimeStart() {
		return itemStartTime;
	}

	/**
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(LocalTime itemStartTime) {
		this.itemStartTime = itemStartTime;
	}

	/**
	 * @return the timeEnd
	 */
	public LocalTime getTimeEnd() {
		return itemEndTime;
	}

	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(LocalTime itemEndTime) {
		this.itemEndTime = itemEndTime;
	}
	
	
	
}
