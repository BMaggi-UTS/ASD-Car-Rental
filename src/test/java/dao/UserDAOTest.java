package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.*;

import model.dao.UserDAO;

@DisplayName("Test class testing UserDAO read/write funcionality to DB.")
public class UserDAOTest {
    Connection conn;
    UserDAO userDAO;

    @BeforeEach
    public void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://13.55.60.202:3306/CarRental-ASD", "root", "password");
            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM User_Roles").executeUpdate();
            conn.prepareStatement("DELETE FROM Users").executeUpdate();

            userDAO = new UserDAO(conn); 

            userDAO.registerNewCustomer("Initial", "Customer", "customer@mail.com", "0403111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            userDAO.registerNewStaff("Initial", "Staff", "staff@mail.com", "0403111223", DigestUtils.sha256Hex("password"), "2000-09-09");
            userDAO.registerNewAdmin("Initial", "Admin", "admin@mail.com", "0403111224", DigestUtils.sha256Hex("password"), "2000-09-09");

        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test registering a new customer.")
    public void testRegisterNewCustomer() {

        try {
            userDAO.registerNewCustomer("Customer", "Test", "newcustomer@mail.com", "0400111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs.next());

            ResultSet rs2 = conn.prepareStatement("SELECT * FROM User_Roles WHERE User_ID=last_insert_id()").executeQuery();
            assert(rs2.next());
            assertEquals(rs2.getInt("Role_ID"), 1);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test registering a new staff.")
    public void testRegisterNewStaff() {

        try {
            userDAO.registerNewStaff("Staff", "Test", "newstaff@mail.com", "0400111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs.next());

            ResultSet rs2 = conn.prepareStatement("SELECT * FROM User_Roles WHERE User_ID=last_insert_id()").executeQuery();
            assert(rs2.next());
            assertEquals(rs2.getInt("Role_ID"), 2);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test registering a new admin.")
    public void testRegisterNewAdmin() {

        try {
            userDAO.registerNewAdmin("Admin", "Test", "newadmin@mail.com", "0400111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs.next());

            ResultSet rs2 = conn.prepareStatement("SELECT * FROM User_Roles WHERE User_ID=last_insert_id()").executeQuery();
            assert(rs2.next());
            assertEquals(rs2.getInt("Role_ID"), 3);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test user can be found in database by email")
    public void testUserExists() {
        
        try {
            assertTrue(userDAO.checkUserExists("customer@mail.com"));
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test accepting correct user login details")
    public void testLoginDetailsAreCorrectForCorrectLogin() {

        try {
            assertTrue(userDAO.checkLoginDetailsAreCorrect("customer@mail.com", "password"));
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test rejecting user login details for incorrect login info")
    public void testLoginDetailsAreCorrectForIncorrectLogin() {

        try {
            assertFalse(userDAO.checkLoginDetailsAreCorrect("customer@mail.com", "wrong-password"));
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test retrieving user ID with correct login info")
    public void testGetUserID() {

        try {
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id() FROM Users").executeQuery();
            rs.next();

            int userID = userDAO.getUserID("admin@mail.com", "password");

            assertEquals(userID, rs.getInt(1));
            
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test retrieving correct role ID with user id")
    public void testGetRoleID() {

        try {
            int userID = userDAO.getUserID("admin@mail.com", "password");
            int roleID = userDAO.getRoleID(userID);

            assertEquals(roleID, 3);
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

}
