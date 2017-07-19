package olivier.hu.ipass.services;

import olivier.hu.ipass.dao.*;
import olivier.hu.ipass.dao.GebruikerDAO;

public class ServiceProvider {
	private static GebruikerDAO daoGebruiker = new GebruikerDAO();
	private static CategorieDAO daoCategorie = new CategorieDAO();
	private static UitgaveDAO daoUitgave = new UitgaveDAO();

	public static GebruikerDAO getGebruikerDAO() {
		return daoGebruiker;
	}
	
	public static CategorieDAO getCategorieDAO() {
		return daoCategorie;
	}
	
	public static UitgaveDAO getUitgaveDAOO() {
		return daoUitgave;
	}
}