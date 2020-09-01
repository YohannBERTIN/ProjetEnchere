package fr.eni.projet.dal;

public abstract class DAOFactory {
	
	public static UserDAO getUserDAO()
	{
		return new UserDAOJdbcImpl();
	}
	
	public static AuctionDAO getAuctionDAO() {
		return new AuctionDAOJdbcImpl();
	}
}
	