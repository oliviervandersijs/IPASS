package olivier.hu.ipass.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UitgaveDAO extends BaseDAO {

	private List<Uitgave> selectUitgave(String query) {
		List<Uitgave> result = new ArrayList<Uitgave>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				String oms = dbResultSet.getString("OMSCHRIJVING");
				String date = dbResultSet.getString("DATUM");
				int pr = dbResultSet.getInt("PRIJS");
				int id = dbResultSet.getInt("UITGAVE_ID");
				int userid = dbResultSet.getInt("USER_ID_F");
				int catid = dbResultSet.getInt("CAT_ID_F");
				
				
				result.add(new Uitgave(id,pr,date,oms,catid,userid));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public List<Uitgave> findAll() {
		return selectUitgave("SELECT * FROM UITGAVE");
	}

	public Uitgave findByID(int id) {
		return selectUitgave("SELECT * FROM UITGAVE WHERE UITGAVE_ID = " + id).get(0);
	}


	public boolean addUitgave(Uitgave uit) {
		boolean result = false;

		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO UITGAVE VALUES ('" + uit.getOmschrijving() + "','"+ uit.getDate()+ "','" + uit.getPrijs() + "',UITGAVE_ID_SEQ.nextval)";
			Statement stmt = con.createStatement();
			if (stmt.executeUpdate(query) == 1) {
				result = true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
}
