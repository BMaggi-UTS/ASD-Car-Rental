package dao;

import model.Car;
import model.dao.CarDAO;
import model.dao.DBConnector;

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

