package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.payment;
import model.dao.DBConnector;
import model.dao.UserDAO;
import model.dao.orderDAO;
import model.dao.paymentDAO;

@DisplayName("Test class testing paymentDAO read/write functionality to DB.")
public class paymentDAOTest {
    Connection conn;
    orderDAO orderDAO;
    paymentDAO paymentDAO;
    UserDAO userDAO;

    @BeforeEach
    public void initialize() {
        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();

            conn.setAutoCommit(false);
            conn.prepareStatement("DELETE FROM Payments").executeUpdate();  // Clear orders for test setup

            paymentDAO = new paymentDAO(conn); 

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @Test
    @DisplayName("Creating new payment")
    public void testCreatePayment() {
        try {
            payment newPayment = new payment();
            newPayment.setOrderID(13);   
            newPayment.setUserID(3);  
            newPayment.setCardName("John Doe");
            newPayment.setCardNumber("4111111111111111");
            newPayment.setCvc("123");

            // Convert the expiry date string to YearMonth
            YearMonth expiryDate = YearMonth.parse("2025-10", DateTimeFormatter.ofPattern("yyyy-MM"));
            newPayment.setExpiry(expiryDate);     
            
            newPayment.setCvc("123");

            paymentDAO.createPayment(newPayment);

            // Fetch most recent payment for user with ID 3 and payment details
            int recentPaymentID = paymentDAO.getMostRecentPayment(3);  
            payment createdPayment = paymentDAO.getPaymentById(recentPaymentID);  

            // Verify the payment is not null
            assertNotNull(createdPayment);  

            // Verify correct data
            assertEquals(13, createdPayment.getOrderID());  
            assertEquals(3, createdPayment.getUserID());  
            assertEquals("John Doe", createdPayment.getCardName());  
            assertEquals("4111111111111111", createdPayment.getCardNumber());  
            assertEquals("2025-10", createdPayment.getExpiryAsString());  
            assertEquals("123", createdPayment.getCvc());  
            
        } catch (SQLException ex) {
        Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);  // Log any exceptions
        fail("SQLException thrown: " + ex.getMessage());  // Mark test as failed if exception occurs
        }
    }



    // @Test
    // @DisplayName("Creating new payment 2")
    // public void testCreatePayment2() {
    //     try {
    //         payment newPayment = new payment();
    //         newPayment.setOrderID(14);   
    //         newPayment.setUserID(2);  
    //         newPayment.setCardName("Maggie Smith");
    //         newPayment.setCardNumber("8111111111111111");
    //         newPayment.setCvc("123");

    //         // Convert the expiry date string to YearMonth
    //         YearMonth expiryDate = YearMonth.parse("2026-10", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         newPayment.setExpiry(expiryDate);     
            
    //         newPayment.setCvc("123");

    //         paymentDAO.createPayment(newPayment);

    //         // Retrieve most recent payment for user with ID 3 and payment details
    //         int recentPaymentID = paymentDAO.getMostRecentPayment(2);  
    //         payment createdPayment = paymentDAO.getPaymentById(recentPaymentID);  

    //         // Verify the payment is not null
    //         assertNotNull(createdPayment);  

    //         // Verify correct data
    //         assertEquals(14, createdPayment.getOrderID());  
    //         assertEquals(2, createdPayment.getUserID());  
    //         assertEquals("Maggie Smith", createdPayment.getCardName());  
    //         assertEquals("8111111111111111", createdPayment.getCardNumber());  
    //         assertEquals("2026-10", createdPayment.getExpiryAsString());  
    //         assertEquals("123", createdPayment.getCvc());  
            
    //     } catch (SQLException ex) {
    //     Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //     fail("SQLException thrown: " + ex.getMessage());  // Mark test as failed if exception occurs
    //     }
    // }



    // @Test
    // @DisplayName("Update existing payment details")
    // public void testUpdatePaymentDetails() {
    //     try {
    //         // Create a new payment
    //         payment newPayment = new payment();
    //         newPayment.setOrderID(15);
    //         newPayment.setUserID(4);
    //         newPayment.setCardName("Alice Johnson");
    //         newPayment.setCardNumber("5222222222222222");
    //         newPayment.setCvc("321");

    //         // Set the expiry date
    //         YearMonth expiryDate = YearMonth.parse("2027-08", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         newPayment.setExpiry(expiryDate);

    //         paymentDAO.createPayment(newPayment);

    //         // Retrieve most recent payment for the user to get its ID
    //         int recentPaymentID = paymentDAO.getMostRecentPayment(4);
    //         payment createdPayment = paymentDAO.getPaymentById(recentPaymentID);

    //         assertNotNull(createdPayment); 

    //         // Update the payment details
    //         String updatedCardName = "Alice Walker";
    //         String updatedCardNumber = "5333333333333333";
    //         String updatedExpiry = "2028-12";
    //         String updatedCvc = "456";

    //         // Call the updatePaymentDetails method
    //         paymentDAO.updatePaymentDetails(recentPaymentID, updatedCardName, updatedCardNumber, updatedExpiry, updatedCvc);

    //         // Retrieve the updated payment details
    //         payment updatedPayment = paymentDAO.getPaymentById(recentPaymentID);

    //         // Assert the updated details
    //         assertNotNull(updatedPayment); 
    //         assertEquals(updatedCardName, updatedPayment.getCardName()); 
    //         assertEquals(updatedCardNumber, updatedPayment.getCardNumber()); 
    //         assertEquals(updatedExpiry, updatedPayment.getExpiryAsString()); 
    //         assertEquals(updatedCvc, updatedPayment.getCvc()); 

    //     } catch (SQLException ex) {
    //         Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
    //         fail("SQLException thrown: " + ex.getMessage()); // Mark test as failed if exception occurs
    //     }
    // }

    // @Test
    // @DisplayName("Update existing payment details 2")
    // public void testUpdatePaymentDetails2() {
    //     try {
    //         // Create a new payment
    //         payment newPayment = new payment();
    //         newPayment.setOrderID(14);
    //         newPayment.setUserID(4);  // Ensure the User ID matches the one you use in the retrieval step
    //         newPayment.setCardName("Maggie Smith");
    //         newPayment.setCardNumber("8111111111111111");
    //         newPayment.setCvc("123");

    //         // Set the expiry date
    //         YearMonth expiryDate = YearMonth.parse("2027-08", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         newPayment.setExpiry(expiryDate);

    //         // Insert the payment into the database
    //         paymentDAO.createPayment(newPayment);

    //         // Retrieve most recent payment for the user to get its ID
    //         int recentPaymentID = paymentDAO.getMostRecentPayment(4);  // Match the User ID here
    //         payment createdPayment = paymentDAO.getPaymentById(recentPaymentID);

    //         // Ensure that the payment was successfully created
    //         assertNotNull(createdPayment, "The created payment should not be null");

    //         // Update the payment details
    //         String updatedCardName = "Alice Walker";
    //         String updatedCardNumber = "5333333333333333";
    //         YearMonth updatedExpiryDate = YearMonth.parse("2028-12", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         String updatedCvc = "456";

    //         // Call the updatePaymentDetails method
    //         paymentDAO.updatePaymentDetails(recentPaymentID, updatedCardName, updatedCardNumber, updatedExpiryDate.toString(), updatedCvc);

    //         // Retrieve the updated payment details
    //         payment updatedPayment = paymentDAO.getPaymentById(recentPaymentID);

    //         // Assert the updated details
    //         assertNotNull(updatedPayment, "The updated payment should not be null");
    //         assertEquals(updatedCardName, updatedPayment.getCardName(), "The card name should be updated");
    //         assertEquals(updatedCardNumber, updatedPayment.getCardNumber(), "The card number should be updated");
    //         assertEquals(updatedExpiryDate, updatedPayment.getExpiry(), "The expiry date should be updated");
    //         assertEquals(updatedCvc, updatedPayment.getCvc(), "The CVC should be updated");

    //     } catch (SQLException ex) {
    //         Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
    //         fail("SQLException thrown: " + ex.getMessage()); // Mark test as failed if exception occurs
    //     }
    // }


    // @Test
    // @DisplayName("Test retrieving payment by PaymentID")
    // public void testGetPaymentById() {
    //     try {
    //         // Create a new payment
    //         payment newPayment = new payment();
    //         newPayment.setOrderID(15);
    //         newPayment.setUserID(3);
    //         newPayment.setCardName("Alice Johnson");
    //         newPayment.setCardNumber("4444444444444444");
    //         newPayment.setCvc("321");

    //         // Set the expiry date
    //         YearMonth expiryDate = YearMonth.parse("2028-10", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         newPayment.setExpiry(expiryDate);

    //         // Insert the payment into the database
    //         paymentDAO.createPayment(newPayment);

    //         // Retrieve the most recent payment by user ID
    //         int mostRecentPaymentID = paymentDAO.getMostRecentPayment(3);

    //         //Retrieve PaymentID - automatically set in database, not in project, thus needs to be retrieved manually.
    //         List<Integer> paymentIDs = paymentDAO.getPaymentID(3);

    //         // Assert that the most recent payment ID matches the last inserted payment's ID
    //         assertEquals(paymentIDs.get(paymentIDs.size() - 1), mostRecentPaymentID);


    //     } catch (SQLException ex) {
    //         Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
    //         fail("SQLException thrown: " + ex.getMessage());  // Mark test as failed if exception occurs
    //     }
    // }


    // @Test
    // @DisplayName("Test retrieving the most recent payment for a user")
    // public void testGetMostRecentPayment() {
    //     try {
    //         // Create multiple payments for the user (userID = 2)
    //         payment firstPayment = new payment();
    //         firstPayment.setOrderID(10);
    //         firstPayment.setUserID(2);
    //         firstPayment.setCardName("John Smith");
    //         firstPayment.setCardNumber("4111111111111111");
    //         firstPayment.setCvc("123");
    //         firstPayment.setExpiry(YearMonth.parse("2025-07", DateTimeFormatter.ofPattern("yyyy-MM")));
    //         paymentDAO.createPayment(firstPayment);

    //         payment secondPayment = new payment();
    //         secondPayment.setOrderID(11);
    //         secondPayment.setUserID(2);
    //         secondPayment.setCardName("John Smith");
    //         secondPayment.setCardNumber("4222222222222222");
    //         secondPayment.setCvc("456");
    //         secondPayment.setExpiry(YearMonth.parse("2026-08", DateTimeFormatter.ofPattern("yyyy-MM")));
    //         paymentDAO.createPayment(secondPayment);

    //         payment thirdPayment = new payment();
    //         thirdPayment.setOrderID(12);
    //         thirdPayment.setUserID(2);
    //         thirdPayment.setCardName("John Smith");
    //         thirdPayment.setCardNumber("4333333333333333");
    //         thirdPayment.setCvc("789");
    //         thirdPayment.setExpiry(YearMonth.parse("2027-09", DateTimeFormatter.ofPattern("yyyy-MM")));
    //         paymentDAO.createPayment(thirdPayment);

    //         // Retrieve the most recent payment for user with ID 2
    //         int mostRecentPaymentID = paymentDAO.getMostRecentPayment(2);
    //         assertNotNull(mostRecentPaymentID, "Most recent payment ID should not be null");

    //         // Verify that the most recent payment is the third one created
    //         payment recentPayment = paymentDAO.getPaymentById(mostRecentPaymentID);
    //         assertNotNull(recentPayment, "The recent payment should not be null");
    //         assertEquals("4333333333333333", recentPayment.getCardNumber(), "Most recent payment card number should match");
    //         assertEquals(12, recentPayment.getOrderID(), "Order ID of the most recent payment should match");
    //         assertEquals("789", recentPayment.getCvc(), "CVC of the most recent payment should match");

    //     } catch (SQLException ex) {
    //         Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);
    //         fail("SQLException thrown: " + ex.getMessage());  // Mark test as failed if exception occurs
    //     }
    // }


    // @Test
    // @DisplayName("Test deleting a payment method")
    // public void testDeletePayment() {
    //     try {
    //         payment newPayment = new payment();
    //         newPayment.setOrderID(14);   
    //         newPayment.setUserID(2);  
    //         newPayment.setCardName("Maggie Smith");
    //         newPayment.setCardNumber("8111111111111111");
    //         newPayment.setCvc("123");

    //         // Set the expiry date
    //         YearMonth expiryDate = YearMonth.parse("2027-08", DateTimeFormatter.ofPattern("yyyy-MM"));
    //         newPayment.setExpiry(expiryDate);

    //         paymentDAO.createPayment(newPayment);

    //         // Retrieve the most recent payment ID for the user 
    //         int recentPaymentID = paymentDAO.getMostRecentPayment(2);
    //         assertNotNull(recentPaymentID, "Payment should exist in the database before deletion");

    //         // Delete the payment by the payment ID
    //         paymentDAO.deletePayment(recentPaymentID);

    //         // Fetch the deleted payment and ensure it's no longer in the database
    //         payment deletedPayment = paymentDAO.getPaymentById(recentPaymentID);
    //         assertEquals(null, deletedPayment, "Payment should be null after deletion");

    //     } catch (SQLException ex) {
    //         Logger.getLogger(paymentDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
    //         fail("SQLException thrown: " + ex.getMessage());  // Mark test as failed if an exception occurs
    //     }
    // }

}

