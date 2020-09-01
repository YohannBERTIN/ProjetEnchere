package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;

public class UserDAOJdbcImpl implements UserDAO {

	private static final String INSERT_USER="INSERT into UTILISATEURS("
			+ "pseudo, "
			+ "nom, "
			+ "prenom, "
			+ "email, "
			+ "telephone, "
			+ "rue, "
			+ "code_postal, "
			+ "ville, "
			+ "mot_de_passe, "
			+ "credit, "
			+ "administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SEARCH_USER="SELECT "
			+ "no_utilisateur, "
			+ "pseudo, "
			+ "nom, "
			+ "prenom, "
			+ "email, "
			+ "telephone, "
			+ "rue, "
			+ "code_postal, "
			+ "ville, "
			+ "mot_de_passe, "
			+ "credit, "
			+ "administrateur FROM UTILISATEURS WHERE ? = ?";
	private static final String MODIFY_MAIL="SELECT "
			+ "no_utilisateur, "
			+ "pseudo, "
			+ "nom, "
			+ "prenom, "
			+ "email, "
			+ "telephone, "
			+ "rue, "
			+ "code_postal, "
			+ "ville, "
			+ "mot_de_passe, "
			+ "credit, "
			+ "administrateur FROM UTILISATEURS WHERE ? = ? and ? != ?";
	private static final String UPDATE_USER="UPDATE UTILISATEURS SET " 
			+ "pseudo = ?, "
			+ "nom = ?, "
			+ "prenom = ?, "
			+ "email = ?, "
			+ "telephone = ?, "
			+ "rue = ?, "
			+ "code_postal = ?, "
			+ "ville = ?, "
			+ "mot_de_passe = ? WHERE no_utilisateur = ?";
	private static final String DELETE_USER="DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	@Override
	public void insert(User user) throws BusinessException {
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getLastName());
				pstmt.setString(3, user.getFirstName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getStreet());
				pstmt.setString(7, user.getZip());
				pstmt.setString(8, user.getCity());
				pstmt.setString(9, user.getPassword());
				pstmt.setInt(10, user.getCredit());
				pstmt.setByte(11, (byte) user.getAdministrator());
				
				pstmt.executeUpdate();
				
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					user.setUserID(rs.getLong(1));
				}
				
				rs.close();
				pstmt.close();
				
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	/**
	 * Search method for user table on database
	 * @param column = no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur
	 * @param colValue = value to test
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public User search(String column, String colValue) throws BusinessException {
		User user = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
	
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(SEARCH_USER);
				pstmt.setString(1, column);
				pstmt.setString(2, colValue);
				
				ResultSet rs = pstmt.executeQuery();
				
				user = new User();
				while(rs.next()) {
					user = userBuilder(rs);
				}
				
				rs.close();
				pstmt.close();
				
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
		return user;
	}
	
	@Override
	public User validMail(String column1, String colValue1, String column2, Long colValue2) throws BusinessException {
		User user = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
	
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(MODIFY_MAIL);
				pstmt.setString(1, column1);
				pstmt.setString(2, colValue1);
				pstmt.setString(1, column2);
				pstmt.setLong(2, colValue2);
				
				ResultSet rs = pstmt.executeQuery();
				
				user = new User();
				while(rs.next()) {
					user = userBuilder(rs);
				}
				
				rs.close();
				pstmt.close();
				
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
		return user;
	}
	
	@Override
	public void updateUser(User user) throws BusinessException {
		if(user==null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_USER);
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getLastName());
				pstmt.setString(3, user.getFirstName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getStreet());
				pstmt.setString(7, user.getZip());
				pstmt.setString(8, user.getCity());
				pstmt.setString(9, user.getPassword());
				pstmt.setLong(10, user.getUserId());
				
				pstmt.executeUpdate();
				
				pstmt.close();
				
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}
	
	@Override
	public void deleteUser(String userID) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
				pstmt.setString(1, userID);
				
				pstmt.close();
				
				cnx.commit();
				
			} catch(Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}	
		} catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	
	}
	
	private User userBuilder(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserID(rs.getLong("no_utilisateur"));
		user.setPseudo(rs.getString("pseudo"));
		user.setLastName(rs.getString("nom"));
		user.setFirstName(rs.getString("prenom"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("telephone"));
		user.setStreet(rs.getString("rue"));
		user.setZip(rs.getString("code_postal"));
		user.setCity(rs.getString("ville"));
		user.setPassword(rs.getString("mot_de_passe"));
		user.setCredit(rs.getInt("credit"));
		user.setAdministrator((int)rs.getByte("administrateur"));
		return user;
	}
}
