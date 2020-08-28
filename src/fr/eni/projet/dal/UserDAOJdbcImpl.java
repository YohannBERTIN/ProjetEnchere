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
			+ "administrateur FROM UTILISATEURS WHERE pseudo = ?";
	private static final String SEARCH_EMAIL="SELECT "
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
			+ "administrateur FROM UTILISATEURS WHERE email = ?";
	
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

	@Override
	public User search(String userPseudo) throws BusinessException {
		User user = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
	
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(SEARCH_USER);
				pstmt.setString(1, userPseudo);
				
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
	public User searchEmail(String userEmail) throws BusinessException {
		User user = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
	
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(SEARCH_EMAIL);
				pstmt.setString(1, userEmail);
				
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
