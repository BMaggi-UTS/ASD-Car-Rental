package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;

import model.Availability;
import model.dao.AvailabilityDAO;
import model.dao.DBConnector;
import model.dao.CarDAO;
import model.dao.orderDAO;

@DisplayName("Test class testing CarDAO read/write funcionality to DB.")
public class AvailabilityDAOTest {
    Connection conn;
    AvailabilityDAO availabilityDAO;
    CarDAO carDAO;
    orderDAO orderDAO;

    @BeforeEach
    public void initialize() {
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();

            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM Availability").executeUpdate();
            conn.prepareStatement("DELETE FROM Orders").executeUpdate();
            conn.prepareStatement("DELETE FROM Car").executeUpdate();
            
            availabilityDAO = new AvailabilityDAO(conn); 
            carDAO = new CarDAO(conn); 
            orderDAO = new orderDAO(conn);

            // creating fake order data for testing availability
            conn.prepareStatement("INSERT INTO Orders (User_ID, Car_ID, Order_Date_Time, Rental_Date_Start, Rental_Date_Finish, Odometer_Start, License_Number) VALUES (1, 1, '2008-11-11 13:23:44', '2024-10-10', '2024-10-15', 1000, 'aaa')").executeUpdate();
            conn.prepareStatement("INSERT INTO Orders (User_ID, Car_ID, Order_Date_Time, Rental_Date_Start, Rental_Date_Finish, Odometer_Start, License_Number) VALUES (1, 1, '2008-11-11 13:23:44', '2024-10-10', '2024-10-15', 1000, 'aaa')").executeUpdate();


            // creating fake order data for testing availability
            carDAO.createCar(99993, "TestMake", "TestModel", "TestTrim", "TestImageText", 123456, "M", "P", 5, "Hatch", "TestQuip", 123, 456, 2, 5, 1);
            carDAO.createCar(99994, "TestMakeTwo", "TestModelTwo", "TestTrimTwo", "TestImageTextTwo", 123456, "M", "P", 5, "Hatch", "TestQuipTwo", 123, 456, 2, 5, 1);

            availabilityDAO.createAvailability(99991, 99993, 1, "2024-08-10", "2024-08-11");
            availabilityDAO.createAvailability(99992, 99994, 2, "2024-08-20", "2024-08-20");

        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Creating a New Availability Booking.")
    public void testCreateNewCar() {
        try {
            availabilityDAO.createAvailability(99998, 99993, 1, "2024-12-20", "2024-12-25");
            ResultSet rs = conn.prepareStatement("SELECT * FROM Availability WHERE Availability_ID=99998").executeQuery();
            assertTrue(rs.next());
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Availability can be found using ID")
    public void testAvailabilityIDFetch() {
        try {
            assertNotNull(availabilityDAO.selectSpecificAvailability(99991));
            assertNull(availabilityDAO.selectSpecificAvailability(99999));
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Cars can be fetched")
    public void testCarsCanBeFetched() {
        try {
            ArrayList<Availability> cars = availabilityDAO.fetchAllAvailability();
            assertNotNull(cars);
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Test Availabilities Can Be Updated")
    public void testUpdateAvailability() {

        try {
            availabilityDAO.updateAvailability(99991, 99993, 1, "2025-10-08", "2025-11-08");
            Availability testAvailability = availabilityDAO.selectSpecificAvailability(99991);
            assertEquals(testAvailability.getStartDate(), "2025-10-08");
            
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    @Test
    @DisplayName("Delete Test Availability")
    public void testDeleteCar() {
        try {
            assertNotNull(availabilityDAO.selectSpecificAvailability(99991));
            assertNotNull(availabilityDAO.selectSpecificAvailability(99992));
            availabilityDAO.deleteAvailability(99991);
            availabilityDAO.deleteAvailability(99992);
            assertNull(availabilityDAO.selectSpecificAvailability(99991));
            assertNull(availabilityDAO.selectSpecificAvailability(99992));
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    @Test
    @DisplayName("Test retrival of car through availability")
    public void testRetrievalCar() {
        try {
            assertEquals("TestMake", carDAO.selectSpecificCar(availabilityDAO.selectSpecificAvailability(99991).getCarID()).getCarMake());
        }
        catch (SQLException ex) {
            Logger.getLogger(AvailabilityDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
}
