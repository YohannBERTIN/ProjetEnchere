package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fr.eni.projet.BusinessException;

import fr.eni.projet.bo.Item;
import fr.eni.projet.bo.Pickup;

public class ItemDAOJdbcImpl implements ItemDAO {

	// Refaire les requêtes...
	
			private static final String INSERT_ITEM="INSERT INTO ARTICLES_VENDUS("
					+ "nom_article, "
					+ "description, "
					+ "date_debut_encheres, "
					+ "date_fin_encheres, "
					+ "prix_initial, "
					+ "no_utilisateur, "
					+ "no_categorie) values(?,?,?,?,?,?,?);";
			private static final String INSERT_PICKUP="INSERT INTO RETRAIT("
					+ "no_article, "
					+ "rue, "
					+ "code_postal, "
					+ "ville) values(?,?,?,?);";
			
			private static final String DELETE_AUCTION="DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
			
			@Override
			public void insert(Item item, Pickup pickup) throws BusinessException {
				if(item==null) {
					BusinessException businessException = new BusinessException();
					businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
					throw businessException;
				}
				
				try(Connection cnx = ConnectionProvider.getConnection()) {
					
					try {
						cnx.setAutoCommit(false);
						
						PreparedStatement pstmt = cnx.prepareStatement(INSERT_ITEM, PreparedStatement.RETURN_GENERATED_KEYS);
						//Item
						pstmt.setString(1, item.getNomArticle());
						pstmt.setString(2, item.getDescription());
						pstmt.setDate(3, java.sql.Date.valueOf(item.getDateDebutEnchere()));
						pstmt.setDate(3, java.sql.Date.valueOf(item.getDateFinEnchere()));
						pstmt.setInt(5, item.getPrixInitial());
						pstmt.setInt(6, item.getNoUtilisateur());
						pstmt.setInt(7, item.getNoCategorie());

						pstmt.executeUpdate();
						
						ResultSet rs = pstmt.getGeneratedKeys();
						if(rs.next()) {
							item.setNoArticle(rs.getInt(1));
						}
						
						//Pickup
						PreparedStatement pstmt2 = cnx.prepareStatement(INSERT_PICKUP);
						
						pstmt2.setInt(1, item.getNoArticle());
						pstmt2.setString(2, pickup.getRue());
						pstmt2.setNString(3, pickup.getCodePostal());
						pstmt2.setNString(4, pickup.getVille());
						
						pstmt2.executeUpdate();
						
						rs.close();
						pstmt.close();
						pstmt2.close();
						
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
			public void delete(Item item) throws BusinessException {
				// TODO Auto-generated method stub
				
			}
	}
 
