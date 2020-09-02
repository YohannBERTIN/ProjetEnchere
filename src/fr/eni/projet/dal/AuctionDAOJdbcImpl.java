package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.Item;

public class AuctionDAOJdbcImpl implements AuctionDAO {

		// Refaire les requêtes...
	
		private static final String INSERT_AUCTION="INSERT INTO ARTICLES_VENDUS("
				+ "nom_article, "
				+ "description, "
				+ "date_debut_encheres, "
				+ "date_fin_encheres, "
				+ "prix_initial, "
				+ "no_utilisateur, "
				+ "no_categorie) values(?,?,?,?,?,?,?);"
				+ "INSERT INTO RETRAIT("
				+ "rue, "
				+ "code_postal, "
				+ "ville) values(?,?,?);"
				+ "INSERT INTO ENCHERES("
				+ "date_enchere, "
				+ "montant_enchere) values(?,?);";
		private static final String DELETE_AUCTION="DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
		
		@Override
		public void insert(Item soldItem, Auctions auction, Pickup pickup) throws BusinessException {
		
		}

		@Override
		public void delete(Auctions auction) throws BusinessException {
		
			
		}
}
