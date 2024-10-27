package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DBConnector extends DB {

	public DBConnector() throws ClassNotFoundException, SQLException {
	Class.forName(driver);

	Properties dbProperties = new Properties();
		dbProperties.put("user", dbuser);
		dbProperties.put("password", dbpass);
		dbProperties.put("allowPublicKeyRetrieval", "true");
		dbProperties.put("useSSL", "false");

		try {
			conn = DriverManager.getConnection(URL + db, dbProperties);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex);
      		throw ex;
		}
	}

	public Connection openConnection(){
		return this.conn;
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}
}
