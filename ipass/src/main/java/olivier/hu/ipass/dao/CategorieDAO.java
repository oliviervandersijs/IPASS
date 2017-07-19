package olivier.hu.ipass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends BaseDAO {
	private List<Categorie> selectCategorie(String query) {
		List<Categorie> result = new ArrayList<Categorie>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				String oms = dbResultSet.getString("OMSCHRIJVING");
				int bud = dbResultSet.getInt("BUDGET");
				int catid = dbResultSet.getInt("CAT_ID");
				int userid = dbResultSet.getInt("USER_ID_F");
				
				result.add(new Categorie(catid, bud, oms, userid));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public List<Categorie> findAll() {
		return selectCategorie("SELECT * FROM CATEGORIE");
	}

	public Categorie findByID(int id) {
		return selectCategorie("SELECT * FROM CATEGORIE WHERE CAT_ID = " + id).get(0);
	}



	public boolean addCategorie(Categorie cat) {
		boolean result = false;

		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO CATEGORIE VALUES ("+cat.getOmschrijving()+")";
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
		CategorieDAO catdao = new CategorieDAO();
		System.out.println(catdao.findByID(2));
		
	}

}
