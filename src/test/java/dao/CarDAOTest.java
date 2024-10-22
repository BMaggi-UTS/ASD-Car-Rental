package dao;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;

=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
import model.Car;
import model.dao.CarDAO;
import model.dao.DBConnector;

<<<<<<< HEAD
@DisplayName("Test class testing CarDAO read/write funcionality to DB.")
public class CarDAOTest {
    Connection conn;
    CarDAO carDAO;

    @BeforeEach
    public void initialize() {
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();

            conn.setAutoCommit(false);
            // conn.prepareStatement("DELETE FROM Availability").executeUpdate();
            conn.prepareStatement("DELETE FROM Car").executeUpdate();

            carDAO = new CarDAO(conn); 

            carDAO.createCar(99991, "TestMake", "TestModel", "TestTrim", "TestImageText", 123456, "M", "P", 5, "Hatch", "TestQuip", 123, 456, 2, 5, 1);
            carDAO.createCar(99992, "TestMakeTwo", "TestModelTwo", "TestTrimTwo", "TestImageTextTwo", 123456, "M", "P", 5, "Hatch", "TestQuipTwo", 123, 456, 2, 5, 1);

        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Creating a New Car.")
    public void testCreateNewCar() {
        try {
            carDAO.createCar(99993, "TestMake", "TestModel", "TestTrim", "TestImageText", 123456, "M", "P", 5, "Hatch", "TestQuip", 123, 456, 2, 5, 1);
            ResultSet rs = conn.prepareStatement("SELECT * FROM Car WHERE Car_ID=99993").executeQuery();
            assertTrue(rs.next());
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Car can be found using ID")
    public void testCarExists() {
        try {
            assertNotNull(carDAO.selectSpecificCar(99991));
            assertNull(carDAO.selectSpecificCar(99999));
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Cars can be fetched")
    public void testCarsCanBeFetched() {
        try {
            ArrayList<Car> cars = carDAO.fetchCars();
            assertNotNull(cars);
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test car array can be selected")
    public void testCarArrayCanBeSelected() {

        try {
            ArrayList<Integer> carIDs = new ArrayList<Integer>();
            carIDs.add(99991);
            carIDs.add(99992);
            assertNotNull(carDAO.selectArrayCar(carIDs));
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @Test
    @DisplayName("Test Cars Can Be Updated")
    public void testUpdateCar() {

        try {
            
            carDAO.updateCar(99991, "TestMakeUpdated", "TestModel", "TestTrim", "TestImageText", 123456, "M", "P", 5, "Hatch", "TestQuip", 123, 456, 2, 5, 1);
            Car testCar = carDAO.selectSpecificCar(99991);
            assertEquals(testCar.getCarMake(), "TestMakeUpdated");
            
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @Test
    @DisplayName("Delete Test Cars")
    public void testDeleteCar() {
        try {
            assertNotNull(carDAO.selectSpecificCar(99991));
            assertNotNull(carDAO.selectSpecificCar(99992));
            carDAO.deleteCar(99991);
            carDAO.deleteCar(99992);
            assertNull(carDAO.selectSpecificCar(99991));
            assertNull(carDAO.selectSpecificCar(99992));
        }
        catch (SQLException ex) {
            Logger.getLogger(CarDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
}
=======
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarDAOTest {

    private DBConnector dbConnector;
    private Connection connection;
    private CarDAO carDAO;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        // Initialize the DB connection
        dbConnector = new DBConnector();
        connection = dbConnector.openConnection();
        carDAO = new CarDAO(connection);
    }

    @After
    public void tearDown() throws SQLException {
        // Close DB connection
        dbConnector.closeConnection();
    }

    @Test
    public void testFetchCars() throws SQLException {
        // Test fetching all cars
        ArrayList<Car> cars = carDAO.fetchCars();
        assertNotNull(cars);
        assertTrue(cars.size() > 0);
    }

    @Test
    public void testSelectSpecificCar() throws SQLException {
        // Test fetching a specific car by ID
        int carID = 14; // Example ID
        Car car = carDAO.selectSpecificCar(carID);
        assertNotNull(car);
        assertEquals("Toyota", car.getCarMake());
    }

    @Test
    public void testAddAndDeleteCar() throws SQLException {
        // Adding a new car
        String insertSQL = "INSERT INTO Car (Car_Make, Car_Model, Car_Trim, Car_Odometer, Car_Image, Car_Transmission, Car_Fuel, Car_Seats, Car_Body_Style, Car_Quip, Car_Purchase_Price, Car_Current_Price, Car_Price_KM, Car_Rating, Location_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertSt = connection.prepareStatement(insertSQL);
        insertSt.setString(1, "TestMake");
        insertSt.setString(2, "TestModel");
        insertSt.setString(3, "TestTrim");
        insertSt.setInt(4, 10000);
        insertSt.setString(5, "TestImageURL");
        insertSt.setString(6, "A");
        insertSt.setString(7, "P");
        insertSt.setInt(8, 5);
        insertSt.setString(9, "Sedan");
        insertSt.setString(10, "TestQuip");
        insertSt.setInt(11, 20000);
        insertSt.setInt(12, 18000);
        insertSt.setInt(13, 10);
        insertSt.setInt(14, 5);
        insertSt.setInt(15, 1);

        int rowsAffected = insertSt.executeUpdate();
        assertEquals(1, rowsAffected);

        // Now, delete the added car
        String deleteSQL = "DELETE FROM Car WHERE Car_Make = 'TestMake' AND Car_Model = 'TestModel'";
        PreparedStatement deleteSt = connection.prepareStatement(deleteSQL);
        int rowsDeleted = deleteSt.executeUpdate();
        assertEquals(1, rowsDeleted);
    }
}

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
