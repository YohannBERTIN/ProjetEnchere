package fr.eni.projet.bo;

import java.util.List;

public class Sales {

	private List<Item> ItemList;
	private int amount;
	private Categorie categorie;
	/**
	 * @return the itemList
	 */
	public List<Item> getItemList() {
		return ItemList;
	}
	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Sales [ItemList=" + ItemList + ", amount=" + amount + ", categorie=" + categorie + "]";
	}
	
	
}
