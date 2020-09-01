package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.SoldItems;

public class AuctionDAOJdbcImpl implements AuctionDAO {

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
		public void insert(SoldItems soldItem, Auctions auction, Pickup pickup) throws BusinessException {
			if(soldItem==null || auction==null || pickup==null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}
			
			try(Connection cnx = ConnectionProvider.getConnection()) {
				
				try {
					cnx.setAutoCommit(false);
					
					PreparedStatement pstmt = cnx.prepareStatement(INSERT_AUCTION, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, soldItem.getNomArticle());
					pstmt.setString(2, soldItem.getDescription());
					pstmt.setString(3, soldItem.getDateDebutEnchere().toString());
					pstmt.setString(3, soldItem.getDateFinEnchere().toString());
					pstmt.setInt(5, soldItem.getPrixInitial());
					pstmt.setString(6, soldItem.getNoUtilisateur().toString());
					pstmt.setString(7, soldItem.getNoCategorie().toString());
					
					pstmt.setString(8, pickup.getRue());
					pstmt.setString(9, pickup.getCodePostal());
					pstmt.setString(10, pickup.getVille());
					
					pstmt.setString(11, auction.getDateEnchere().toString());
					pstmt.setInt(12, auction.getMontantEnchere());
					
					pstmt.executeUpdate();
					
					ResultSet rs = pstmt.getGeneratedKeys();
					if(rs.next()) {
						soldItem.setNoArticle(rs.getInt(1));
					}
					
					rs.close();
					pstmt.close();
					
					cnx.commit();
					
					
					
				} catch(Exception e) {
					e.printStackTrace();
					cnx.rollback();
					throw e;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
				throw businessException;
			}
		}

		@Override
		public void delete(Auctions auction) throws BusinessException {
			// TODO Auto-generated method stub
			
		}
}
