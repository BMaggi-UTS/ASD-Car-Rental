package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.*;

import model.Admin;
import model.Customer;
import model.Staff;
import model.dao.UserDAO;
import model.dao.DBConnector;

@DisplayName("Test class testing UserDAO read/write funcionality to DB.")
public class UserDAOTest {
    Connection conn;
    UserDAO userDAO;

    @BeforeEach
    public void initialize() {
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();

            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM User_Roles").executeUpdate();
            conn.prepareStatement("DELETE FROM Users").executeUpdate();

            userDAO = new UserDAO(conn); 

            userDAO.registerNewCustomer("Initial", "Customer", "customer@mail.com", "0403111222", DigestUtils.sha256Hex("password"), "2000-09-10");
            userDAO.registerNewStaff("Initial", "Staff", "staff@mail.com", "0403111223", DigestUtils.sha256Hex("password"), "2000-09-11");
            userDAO.registerNewAdmin("Initial", "Admin", "admin@mail.com", "0403111224", DigestUtils.sha256Hex("password"), "2000-09-12");

        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test registering a new customer.")
    public void testRegisterNewCustomer() {
        try {
            // DBConnector db = new DBConnector();
            // conn = db.openConnection();
            // conn.setAutoCommit(false);
            // userDAO = new UserDAO(conn);
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
            // DBConnector db = new DBConnector();
            // conn = db.openConnection();
            // userDAO = new UserDAO(conn);
            userDAO.registerNewStaff("Staff", "Test", "newstaff@mail.com", "0400111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs.next());

            ResultSet rs2 = conn.prepareStatement("SELECT * FROM User_Roles WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs2.next());
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
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            userDAO.registerNewAdmin("Admin", "Test", "newadmin@mail.com", "0400111222", DigestUtils.sha256Hex("password"), "2000-09-09");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Users WHERE User_ID=last_insert_id()").executeQuery();
            assertTrue(rs.next());

            ResultSet rs2 = conn.prepareStatement("SELECT * FROM User_Roles WHERE User_ID=last_insert_id()").executeQuery();
            assert(rs2.next());
            assertEquals(rs2.getInt("Role_ID"), 3);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test user can be found in database by email")
    public void testUserExists() {
        
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            assertTrue(userDAO.checkUserExists("customer@mail.com"));
            assertFalse(userDAO.checkUserExists("false@mail.com"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test accepting correct user login details")
    public void testLoginDetailsAreCorrectForCorrectLogin() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            assertTrue(userDAO.checkLoginDetailsAreCorrect("customer@mail.com", "password"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test rejecting user login details for incorrect login info")
    public void testLoginDetailsAreCorrectForIncorrectLogin() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            assertFalse(userDAO.checkLoginDetailsAreCorrect("customer@mail.com", "wrong-password"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test retrieving user ID with correct login info")
    public void testGetUserIDWithCorrectInfo() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            ResultSet rs = conn.prepareStatement("SELECT last_insert_id() FROM Users").executeQuery();
            rs.next();

            int userID = userDAO.getUserID("admin@mail.com", "password");

            assertEquals(userID, rs.getInt(1));
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test retrieving user ID with correct login info")
    public void testGetUserIDWithIncorrectInfo() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            int userID = userDAO.getUserID("admin@mail.com", "wrong-password");

            assertEquals(userID, -1);
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test retrieving correct role ID with user id")
    public void testGetRoleID() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            int userID = userDAO.getUserID("admin@mail.com", "password");
            int roleID = userDAO.getRoleID(userID);

            assertEquals(roleID, 3);
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test returning instance of a customer given correct login info")
    public void testCreateInstanceOfCustomer() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            Customer customer = userDAO.createInstanceOfCustomer("customer@mail.com", "password");
            assertTrue(customer instanceof Customer);
            assertTrue(customer.getLastName().equals("Customer"));
            assertTrue(customer.getPhone().equals("0403111222"));

        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Test
    @DisplayName("Test returning instance of a staff member given correct login info")
    public void testCreateInstanceOfStaff() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            Staff staff = userDAO.createInstanceOfStaff("staff@mail.com", "password");
            assertTrue(staff instanceof Staff);
            assertTrue(staff.getLastName().equals("Staff"));
            assertTrue(staff.getPhone().equals("0403111223"));
            assertTrue(staff.getRoleName().equals("Staff"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Test
    @DisplayName("Test returning instance of a admin given correct login info")
    public void testCreateInstanceOfAdmin() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            userDAO = new UserDAO(conn);
            Admin admin = (Admin) userDAO.createInstanceOfAdmin("admin@mail.com", "password");
            assertTrue(admin instanceof Admin);
            assertTrue(admin.getLastName().equals("Admin"));
            assertTrue(admin.getPhone().equals("0403111224"));
            assertTrue(admin.getRoleName().equals("Admin"));
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
