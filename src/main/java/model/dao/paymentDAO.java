<<<<<<< HEAD
=======

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;
=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

import model.payment;

public class paymentDAO {

    private Connection connection;

    public paymentDAO(Connection connection) {
        this.connection = connection;
    }

<<<<<<< HEAD
    // Method to create new payment details
    public void createPayment(payment payment) throws SQLException {
        String sql = "INSERT INTO payments (Order_ID, Card_Number, Expiry_Date, CVC, Status, Date, Currency) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getOrderID());
            statement.setInt(2, payment.getCardNumber());
            statement.setString(3, payment.getExpiry().toString()); // This is IF expiry is stored as a string "YYYY-MM". Remember to change.)
            statement.setString(4, payment.getCvc());
            statement.setString(5, payment.getStatus());
            statement.setDate(6, java.sql.Date.valueOf(payment.getDate())); // used to convert LocalDate to SQL Date
            statement.setString(7, payment.getCurrency());

=======
    // Method to create a new payment detail set
    public void createPayment(payment payment) throws SQLException {

        String sql = "INSERT INTO Payments (Order_ID, User_ID, Name_on_Card, "
               + "Card_Number, Expiry_Date, CVV) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getOrderID());
            statement.setInt(2, payment.getUserID());
            statement.setString(3, payment.getCardName());
            statement.setString(4, payment.getCardNumber());
            statement.setString(5, payment.getExpiryAsString());
            statement.setString(6, payment.getCvc());
            
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
            statement.executeUpdate();
        }
    }

    // Method to update an existing payment
<<<<<<< HEAD
    public void updatePaymentDetails(payment payment) throws SQLException {
        String sql = "UPDATE payments SET Card_Number = ?, Expiry_Date = ?, CVC = ?, Status = ?, Date = ?, Currency = ? WHERE Order_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getCardNumber());
            statement.setString(2, payment.getExpiry().toString()); // This is IF expiry is stored as a string "YYYY-MM". Remember to change.)
            statement.setString(3, payment.getCvc());
            statement.setString(4, payment.getStatus());
            statement.setDate(5, java.sql.Date.valueOf(payment.getDate())); // used to convert LocalDate to SQL Date
            statement.setString(6, payment.getCurrency());
            statement.setInt(7, payment.getOrderID());

            statement.executeUpdate();
=======
    public void updatePaymentDetails(int paymentID, String cardName, String cardNumber, String expiry, String cvc) throws SQLException {
        String sql = "UPDATE Payments SET Name_on_Card = ?, Card_Number = ?, Expiry_Date = ?, CVV = ? WHERE Payment_ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cardName);      
            pstmt.setString(2, cardNumber);  
            pstmt.setString(3, expiry);   
            pstmt.setString(4, cvc);          
            pstmt.setInt(5, paymentID);        

            pstmt.executeUpdate();          
        } catch (SQLException e) {
            throw new SQLException("Error updating payment details: " + e.getMessage());
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        }
    }

    // Method to delete payment details by Order ID
<<<<<<< HEAD
    public void deletePayment(int orderID) throws SQLException {
        String sql = "DELETE FROM payments WHERE Order_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderID);
=======
    public void deletePayment(int paymentID) throws SQLException {
        String sql = "DELETE FROM Payments WHERE Payment_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentID);
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

            statement.executeUpdate();
        }
    }
<<<<<<< HEAD
=======

    //Retrieve paymentID - automatically set in database, not in project, thus needs to be retrieved manually.
    public List<Integer> getPaymentID(int userId) throws SQLException {
        String sql = "SELECT Payment_ID FROM Payments WHERE User_ID = ?";
        List<Integer> paymentIds = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId); // Set User_ID parameter
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                paymentIds.add(resultSet.getInt("Payment_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log exception for debugging
            throw new SQLException("Error retrieving Payment IDs: " + e.getMessage());
        }

        return paymentIds; // Return the list of PaymentIDs
    }

    // Method to fetch the most recent payment details entered by user ID
    public int getMostRecentPayment(int userID) throws SQLException {
        String sql = "SELECT * FROM Payments WHERE User_ID = ? ORDER BY Payment_ID DESC LIMIT 1";
        int paymentID = 0;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paymentID = resultSet.getInt("Payment_ID");
            }
        }

        System.out.println("Most recent payment:" + paymentID);

        return paymentID;
    }


    public payment getPaymentById(int PaymentID) throws SQLException {

        System.out.println("Fetching payment with ID: " + PaymentID);
    
        String sql = "SELECT * FROM Payments WHERE Payment_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, PaymentID);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    // Extract data from result set
                    int paymentID = rs.getInt("Payment_ID");
                    int orderID = rs.getInt("Order_ID");
                    int userID = rs.getInt("User_ID");
                    String cardName = rs.getString("Name_on_Card");
                    String cardNumber = rs.getString("Card_Number");
                    String expiry = rs.getString("Expiry_Date");
                    String cvv = rs.getString("CVV");

                    YearMonth expiryYearMonth = YearMonth.parse(expiry, DateTimeFormatter.ofPattern("yyyy-MM"));
                    
                    // Create and return a Payment object
                    return new payment(paymentID, orderID, userID, cardName, cardNumber, expiryYearMonth, cvv);
                }
            }
        }
        return null;
    }
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
}
