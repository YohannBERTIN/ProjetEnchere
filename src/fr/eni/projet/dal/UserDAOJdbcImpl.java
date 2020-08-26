package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;

public class UserDAOJdbcImpl implements UserDAO {

	private static final String INSERT_USER="insert into utilisateurs("
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
				pstmt.setString(1, user.getLastName());
				pstmt.setString(1, user.getFirstName());
				pstmt.setString(1, user.getEmail());
				pstmt.setString(1, user.getPhone());
				pstmt.setString(1, user.getStreet());
				pstmt.setString(1, user.getZip());
				pstmt.setString(1, user.getCity());
				pstmt.setString(1, user.getPassword());
				pstmt.setInt(1, user.getCredit());
				pstmt.setByte(1, (byte) user.getAdministrator());
				
				pstmt.executeUpdate();
				
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					user.setUserID(rs.getInt(1));
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
}
