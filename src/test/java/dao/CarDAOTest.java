package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;

import model.Car;
import model.dao.CarDAO;
import model.dao.DBConnector;

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
