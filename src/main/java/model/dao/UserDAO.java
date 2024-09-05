package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import model.*;



public class UserDAO {
    private Connection con;

	public UserDAO(Connection connection) throws SQLException {
		this.con = connection;
	}

	public boolean checkUserExists(String email) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE User_Email = ?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	public boolean checkLoginDetailsAreCorrect(String email, String password) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE User_email = ? AND User_Password = ?");
		ps.setString(1, email);
		ps.setString(2, DigestUtils.sha256Hex(password));
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	public int getUserID(String email, String password) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE User_email = ? AND User_Password = ?");
		ps.setString(1, email);
		ps.setString(2, DigestUtils.sha256Hex(password));
		ResultSet rs = ps.executeQuery();
		
		// user found
		if(rs.next()) {
			return rs.getInt("User_ID");
		}
		// no user found
		return -1;
	}

	public int getRoleID(int userID) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM User_Roles WHERE User_ID = ?");
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();

		// user found
		if(rs.next()) {
			return rs.getInt("Role_ID");
		}
		// no user found
		return -1;
	}

	// public User createInstanceOfUser(String email, String password) throws SQLException {

	// 	String hashedPassword = DigestUtils.sha256Hex(password);

	// 	PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE User_email = ? AND User_Password = ?");
	// 	ps.setString(1, email);
	// 	ps.setString(2, hashedPassword);
	// 	ResultSet rs = ps.executeQuery();

	// 	// user found
	// 	if(rs.next()) {
	// 		int id = rs.getInt("User_Email");
	// 		String firstName = rs.getString("User_FName");
	// 		String lastName = rs.getString("User_LName");
	// 		String preferredName = rs.getString("User_PrefName");
	// 		String phone = rs.getString("User_Phone");
	// 		String dateOfBirth = rs.getString("User_DOB");

	// 		return new User(id, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth);
	// 	}

	// 	// no user found
	// 	return null;
	// }

	public Customer createInstanceOfCustomer (String email, String password) throws SQLException {

		String hashedPassword = DigestUtils.sha256Hex(password);

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE User_email = ? AND User_Password = ?");
		ps.setString(1, email);
		ps.setString(2, hashedPassword);
		ResultSet rs = ps.executeQuery();

		// customer found
		if(rs.next()) {
			int id = rs.getInt("User_Email");
			String firstName = rs.getString("User_FName");
			String lastName = rs.getString("User_LName");
			String preferredName = rs.getString("User_PrefName");
			String phone = rs.getString("User_Phone");
			String dateOfBirth = rs.getString("User_DOB");

			return new Customer(id, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth);
		}

		// no customer found
		return null;
	}

	public Staff createInstanceOfStaff (String email, String password) throws SQLException {

		String hashedPassword = DigestUtils.sha256Hex(password);

		PreparedStatement ps = con.prepareStatement("SELECT Users.User_ID, User_FName, User_LName, User_PrefName, User_Email, User_Password, User_DOB, Roles.Role_ID, Role_Name, Role_Description FROM Users\n" +
						"INNER JOIN User_Roles\n" +
						"ON Users.user_id = User_Roles.User_ID\n" +
						"INNER JOIN Roles\n" +
						"ON User_Roles.Role_ID = Roles.Role_ID\n" + 
						"WHERE User_Email = ? AND User_Password = ?");
		ps.setString(1, email);
		ps.setString(2, hashedPassword);
		ResultSet rs = ps.executeQuery();

		// Staff found
		if(rs.next()) {
			int id = rs.getInt("User_Email");
			String firstName = rs.getString("User_FName");
			String lastName = rs.getString("User_LName");
			String preferredName = rs.getString("User_PrefName");
			String phone = rs.getString("User_Phone");
			String dateOfBirth = rs.getString("User_DOB");
			String roleName = rs.getString("Role_Name");
			String roleDescription = rs.getString("Role_Description");

			return new Staff(id, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth, roleName, roleDescription);
		}

		// no staff found
		return null;
	}

	public Staff createInstanceOfAdmin (String email, String password) throws SQLException {

		String hashedPassword = DigestUtils.sha256Hex(password);

		PreparedStatement ps = con.prepareStatement("SELECT Users.User_ID, User_FName, User_LName, User_PrefName, User_Email, User_Password, User_DOB, Roles.Role_ID, Role_Name, Role_Description FROM Users\n" +
						"INNER JOIN User_Roles\n" +
						"ON Users.user_id = User_Roles.User_ID\n" +
						"INNER JOIN Roles\n" +
						"ON User_Roles.Role_ID = Roles.Role_ID\n" + 
						"WHERE User_Email = ? AND User_Password = ?");
		ps.setString(1, email);
		ps.setString(2, hashedPassword);
		ResultSet rs = ps.executeQuery();

		// Admin found
		if(rs.next()) {
			int id = rs.getInt("User_Email");
			String firstName = rs.getString("User_FName");
			String lastName = rs.getString("User_LName");
			String preferredName = rs.getString("User_PrefName");
			String phone = rs.getString("User_Phone");
			String dateOfBirth = rs.getString("User_DOB");
			String roleName = rs.getString("Role_Name");
			String roleDescription = rs.getString("Role_Description");

			return new Admin(id, firstName, lastName, preferredName, email, phone, hashedPassword, dateOfBirth, roleName, roleDescription);
		}

		// no Admin found
		return null;
	}

	public void registerNewCustomer(String firstName, String surname, String email, String phone, String hashedPassword, String dateOfBirth) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO Users (User_FName, User_LName, User_Email, User_Phone, User_Password, User_DOB) VALUES (?, ?, ?, ?, ?, DATE(?))");
        ps.setString(1, firstName);
        ps.setString(2, surname);
        ps.setString(3, email);
        ps.setString(4, phone);
        ps.setString(5, hashedPassword);
        ps.setString(6, dateOfBirth);
        ps.executeUpdate();

		ResultSet rs = con.prepareStatement("SELECT LAST_INSERT_ID()").executeQuery();
		int userID = rs.getInt(1);

		ps = con.prepareStatement("INSERT INTO User_Roles VALUES (?, 1)");
		ps.setInt(1, userID);
		ps.executeUpdate();

	}

}
