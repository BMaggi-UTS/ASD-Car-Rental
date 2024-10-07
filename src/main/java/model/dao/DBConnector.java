package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector extends DB {

	Connection conn;

	public DBConnector() throws ClassNotFoundException, SQLException {
		Class.forName(driver);

		Properties dbProperties = new Properties();
		dbProperties.put("user", dbuser);
		dbProperties.put("password", dbpass);
		dbProperties.put("allowPublicKeyRetrieval", "true");
		dbProperties.put("useSSL", "false");

		conn = DriverManager.getConnection(URL + db, dbProperties);
	}
	

	public Connection openConnection(){
		return this.conn;
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}
}
