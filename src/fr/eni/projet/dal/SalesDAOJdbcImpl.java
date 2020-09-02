package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Sales;

public class SalesDAOJdbcImpl implements SalesDAO {

	private static final String SEARCH_SALES = "SELECT"
			+ "no_article, "
			+ "nom_article, "
			+ "description, "
			+ "date_debut_encheres, "
			+ "date_fin_encheres, "
			+ "prix_initial, "
			+ "no_utilisateur, "
			+ "no_categorie FROM ARTICLES_VENDUS WHERE ";
	@Override
	public Sales searchSales(String column, String colValue) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
