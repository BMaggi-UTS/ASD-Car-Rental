package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.order;
import model.dao.DBConnector;
import model.dao.UserDAO;
import model.dao.orderDAO;

@DisplayName("Test class testing orderDAO read/write functionality to DB.")
public class orderDAOTest {
    Connection conn;
    orderDAO orderDAO;
    UserDAO userDAO;

    @BeforeEach
    public void initialize() {
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();

            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM Orders").executeUpdate();  // Clear orders for test setup

            orderDAO = new orderDAO(conn); 

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Creating new order")
    public void testCreateOrder() {
        try {
            order newOrder = new order();
            newOrder.setUserID(3);  
            newOrder.setCarID(13);    
            newOrder.setOrderDateTime("2024-10-09 10:00:00");
            newOrder.setRentalDateStart("2024-10-10");
            newOrder.setRentalDateFinish("2024-10-15");
            newOrder.setOdometerStart(1000);
            newOrder.setOdometerFinish(1200);
            newOrder.setLicenseNumber(123456); 
            newOrder.settaxesFeesString("50.00");
            newOrder.setbasePriceString("200.00");
            newOrder.settotalPriceString("250.00");

            orderDAO.createOrder(newOrder);

            // Validate the order was created
            List<order> orders = orderDAO.getOrdersByUserID(3);
            assertFalse(orders.isEmpty());

            // Verify the details of the created order
            order createdOrder = orders.get(0);
            assertEquals(3, createdOrder.getUserID());
            assertEquals(13, createdOrder.getCarID());
            assertEquals("2024-10-09 10:00:00", createdOrder.getOrderDateTime());
            
        } catch (SQLException ex) {
            Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    // @Test
    // @DisplayName("Creating new order 2")
    // public void testCreateOrder2() {
    //     try {
    //         order newOrder = new order();
    //         newOrder.setUserID(3);  
    //         newOrder.setCarID(14);    
    //         newOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         newOrder.setRentalDateStart("2024-10-10");
    //         newOrder.setRentalDateFinish("2024-10-15");
    //         newOrder.setOdometerStart(1000);
    //         newOrder.setOdometerFinish(1200);
    //         newOrder.setLicenseNumber(123456); 
    //         newOrder.settaxesFeesString("50.00");
    //         newOrder.setbasePriceString("200.00");
    //         newOrder.settotalPriceString("250.00");

    //         orderDAO.createOrder(newOrder);

    //         // Validate the order was created
    //         List<order> orders = orderDAO.getOrdersByUserID(3);
    //         assertFalse(orders.isEmpty());

    //         // Verify the details of the created order
    //         order createdOrder = orders.get(0);
    //         assertEquals(3, createdOrder.getUserID());
    //         assertEquals(14, createdOrder.getCarID());
    //         assertEquals("2024-10-09 10:00:00", createdOrder.getOrderDateTime());
            
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //     }
    // }

    // @Test
    // @DisplayName("Test update function")
    // public void testUpdateDriver() {
    //     try {
    //         order newOrder = new order();
    //         newOrder.setUserID(3);  
    //         newOrder.setCarID(13);    
    //         newOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         newOrder.setRentalDateStart("2024-10-10");
    //         newOrder.setRentalDateFinish("2024-10-15");
    //         newOrder.setOdometerStart(1000);
    //         newOrder.setOdometerFinish(1200);
    //         newOrder.setLicenseNumber(123456); 
    //         newOrder.settaxesFeesString("50.00");
    //         newOrder.setbasePriceString("200.00");
    //         newOrder.settotalPriceString("250.00");

    //         orderDAO.createOrder(newOrder);

    //         // Update the license number
    //         int newLicenseNumber = 888888; // New license number to update
    //         String licenseNumberString = Integer.toString(newLicenseNumber);
    //         orderDAO.updateDriverDetails(3, licenseNumberString);

    //         // Retrieve the updated order to validate the change
    //         List<order> updatedOrders = orderDAO.getOrdersByUserID(3);
    //         assertEquals(newLicenseNumber, updatedOrders.get(updatedOrders.size()-1).getLicenseNumber());
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //         fail("Exception thrown while updating driver license: " + ex.getMessage());
    //     }
    // }

    // @Test
    // @DisplayName("Test updating function 2")
    // public void testUpdateDriver2() {
    //     try {
    //         order newOrder = new order();
    //         newOrder.setUserID(3);  
    //         newOrder.setCarID(14);    
    //         newOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         newOrder.setRentalDateStart("2024-10-10");
    //         newOrder.setRentalDateFinish("2024-10-15");
    //         newOrder.setOdometerStart(1000);
    //         newOrder.setOdometerFinish(1200);
    //         newOrder.setLicenseNumber(11111); 
    //         newOrder.settaxesFeesString("50.00");
    //         newOrder.setbasePriceString("200.00");
    //         newOrder.settotalPriceString("250.00");

    //         orderDAO.createOrder(newOrder);

    //         // Update the license number
    //         int newLicenseNumber = 555555; // New license number to update
    //         String licenseNumberString = Integer.toString(newLicenseNumber);
    //         orderDAO.updateDriverDetails(3, licenseNumberString);

    //         // Retrieve the updated order to validate the change
    //         List<order> updatedOrders = orderDAO.getOrdersByUserID(3);
    //         assertEquals(newLicenseNumber, updatedOrders.get(0).getLicenseNumber());
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //         fail("Exception thrown while updating driver license: " + ex.getMessage());
    //     }
    // }

    // @Test
    // @DisplayName("Test retrieving orders by user ID.")
    // public void testGetOrdersByUserID() {
    //     try {
    //         // Create a new order
    //         order newOrder = new order();
    //         newOrder.setUserID(3);  
    //         newOrder.setCarID(13);    
    //         newOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         newOrder.setRentalDateStart("2024-10-10");
    //         newOrder.setRentalDateFinish("2024-10-15");
    //         newOrder.setOdometerStart(1000);
    //         newOrder.setOdometerFinish(1200);
    //         newOrder.setLicenseNumber(123456); 
    //         newOrder.settaxesFeesString("50.00");
    //         newOrder.setbasePriceString("200.00");
    //         newOrder.settotalPriceString("250.00");

    //         // Insert the order into the database
    //         orderDAO.createOrder(newOrder);

    //         // Retrieve the order by user ID
    //         List<order> retrievedOrders = orderDAO.getOrdersByUserID(3);

    //         // Assert that the retrieved order matches the inserted order
    //         assertEquals(1, retrievedOrders.size());
    //         order retrievedOrder = retrievedOrders.get(0);
    //         assertEquals(newOrder.getUserID(), retrievedOrder.getUserID());
    //         assertEquals(newOrder.getCarID(), retrievedOrder.getCarID());
    //         assertEquals(newOrder.getOrderDateTime(), retrievedOrder.getOrderDateTime());
    //         assertEquals(newOrder.getRentalDateStart(), retrievedOrder.getRentalDateStart());
    //         assertEquals(newOrder.getRentalDateFinish(), retrievedOrder.getRentalDateFinish());
    //         assertEquals(newOrder.getOdometerStart(), retrievedOrder.getOdometerStart());
    //         assertEquals(newOrder.getOdometerFinish(), retrievedOrder.getOdometerFinish());
    //         assertEquals(newOrder.getLicenseNumber(), retrievedOrder.getLicenseNumber());
    //         assertEquals(newOrder.gettaxesFeesString(), retrievedOrder.gettaxesFeesString());
    //         assertEquals(newOrder.getbasePriceString(), retrievedOrder.getbasePriceString());
    //         assertEquals(newOrder.gettotalPriceString(), retrievedOrder.gettotalPriceString());
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //         fail("Exception thrown while retrieving orders by user ID: " + ex.getMessage());
    //     }
    // }

    // @Test
    // @DisplayName("Test fetching the most recent order by user ID.")
    // public void testGetMostRecentOrder() {
    //     try {
    //         // Create and insert multiple orders for the same user
    //         order firstOrder = new order();
    //         firstOrder.setUserID(3);
    //         firstOrder.setCarID(13);
    //         firstOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         firstOrder.setRentalDateStart("2024-10-10");
    //         firstOrder.setRentalDateFinish("2024-10-15");
    //         firstOrder.setOdometerStart(1000);
    //         firstOrder.setOdometerFinish(1200);
    //         firstOrder.setLicenseNumber(123456);
    //         firstOrder.settaxesFeesString("50.00");
    //         firstOrder.setbasePriceString("200.00");
    //         firstOrder.settotalPriceString("250.00");
    //         orderDAO.createOrder(firstOrder);

    //         order secondOrder = new order();
    //         secondOrder.setUserID(3);
    //         secondOrder.setCarID(14);
    //         secondOrder.setOrderDateTime("2024-11-09 10:00:00");
    //         secondOrder.setRentalDateStart("2024-11-10");
    //         secondOrder.setRentalDateFinish("2024-11-15");
    //         secondOrder.setOdometerStart(2000);
    //         secondOrder.setOdometerFinish(2200);
    //         secondOrder.setLicenseNumber(654321);
    //         secondOrder.settaxesFeesString("60.00");
    //         secondOrder.setbasePriceString("300.00");
    //         secondOrder.settotalPriceString("360.00");
    //         orderDAO.createOrder(secondOrder);

    //         // Retrieve the most recent order by user ID
    //         int mostRecentOrderID = orderDAO.getMostRecentOrder(3);

    //         //Retrieve OrderID - automatically set in database, not in project, thus needs to be retrieved manually.
    //         List<Integer> orderIDs = orderDAO.getOrderID(3);

    //         // Assert that the most recent order ID matches the last inserted order's ID
    //         assertEquals(orderIDs.get(orderIDs.size() - 1), mostRecentOrderID);
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);
    //         fail("Exception thrown while fetching the most recent order by user ID: " + ex.getMessage());
    //     }
    // }


    // @Test
    // @DisplayName("Test deleting an order.")
    // public void testDeleteOrder() {
    //     try {
    //         order newOrder = new order();
    //         newOrder.setUserID(3);  
    //         newOrder.setCarID(13);    
    //         newOrder.setOrderDateTime("2024-10-09 10:00:00");
    //         newOrder.setRentalDateStart("2024-10-10");
    //         newOrder.setRentalDateFinish("2024-10-15");
    //         newOrder.setOdometerStart(1000);
    //         newOrder.setOdometerFinish(1200);
    //         newOrder.setLicenseNumber(123456); 
    //         newOrder.settaxesFeesString("50.00");
    //         newOrder.setbasePriceString("200.00");
    //         newOrder.settotalPriceString("250.00");

    //         orderDAO.createOrder(newOrder);

    //         // Retrieve the created order ID
    //         List<Integer> orderIds = orderDAO.getOrderID(3);
    //         int orderIdToDelete = orderIds.get(0);

    //         // Delete the order
    //         orderDAO.deleteOrder(orderIdToDelete);

    //         // Validate the order was deleted
    //         List<order> orders = orderDAO.getOrdersByUserID(3);
    //         assertTrue(orders.stream().noneMatch(order -> order.getorderID() == orderIdToDelete));
    //     } catch (SQLException ex) {
    //         Logger.getLogger(orderDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //     }
    // }

}
