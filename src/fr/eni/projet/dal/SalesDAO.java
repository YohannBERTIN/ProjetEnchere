package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Sales;

public interface SalesDAO {

	Sales searchSales(String column, String colValue) throws BusinessException;
	
	
}
