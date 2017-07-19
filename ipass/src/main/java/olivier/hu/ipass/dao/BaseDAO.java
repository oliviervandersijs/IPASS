package olivier.hu.ipass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAO {
	protected final Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		Connection result = null;
		try {
			result = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","IPASSDATABASE","IPASS");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return result;
	}
}

