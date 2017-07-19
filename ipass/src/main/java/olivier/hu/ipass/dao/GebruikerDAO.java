package olivier.hu.ipass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GebruikerDAO extends BaseDAO {

	private List<Gebruiker> selectGebruiker(String query) {
		List<Gebruiker> result = new ArrayList<Gebruiker>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int ID = dbResultSet.getInt("USER_ID");
				String naam = dbResultSet.getString("GEBRUIKERSNAAM");
				String ww = dbResultSet.getString("WACHTWOORD");
				String ema = dbResultSet.getString("EMAIL");
				int mi = dbResultSet.getInt("MAANDINKOMEN");

				result.add(new Gebruiker(ID, naam, ww, ema, mi));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public List<Gebruiker> findAll() {
		return selectGebruiker("SELECT * FROM GEBRUIKER");
	}

	public Gebruiker findByID(int id) {
		return selectGebruiker(
				"SELECT * FROM GEBRUIKER WHERE ID = " + id).get(0);
	}

	public Gebruiker findByUsername(String USname) {
		List<Gebruiker> temp = selectGebruiker("SELECT * FROM GEBRUIKER WHERE GEBRUIKERSNAAM = '" + USname + "'");
		if (temp.isEmpty()){
			return null;
		} else{
			return temp.get(0);
		}
	}

	public String findPassword(String USname) {
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt
					.executeQuery("SELECT WACHTWOORD FROM GEBRUIKER WHERE GEBRUIKERSNAAM = '" + USname + "'");
			if (dbResultSet.next()) {
				return dbResultSet.getString("WACHTWOORD");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public boolean addGebruiker(Gebruiker geb) {
		boolean result = false;

		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO GEBRUIKER VALUES (USER_ID_SEQ.nextval,'" + geb.getUsername() + "','"
					+ geb.getPassword() + "','" + geb.getEmail() + "','" + geb.getMaandinkomen() + "')";
			Statement stmt = con.createStatement();
			if (stmt.executeUpdate(query) == 1) {
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		GebruikerDAO dao = new GebruikerDAO();
		UitgaveDAO dao2 = new UitgaveDAO();
		System.out.println(dao.findAll());
		System.out.println(dao.findPassword("USER1"));
		System.out.println(dao2.findAll());
		Uitgave u1 = dao2.findByID(11);
		System.out.println(u1.getOmschrijving());
	}
}
