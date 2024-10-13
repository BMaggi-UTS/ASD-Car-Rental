
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.payment;

public class paymentDAO {

    private Connection connection;

    public paymentDAO(Connection connection) {
        this.connection = connection;
    }

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
            
            statement.executeUpdate();
        }
    }

    // Method to update an existing payment
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
        }
    }

    // Method to delete payment details by Order ID
    public void deletePayment(int paymentID) throws SQLException {
        String sql = "DELETE FROM Payments WHERE Payment_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentID);

            statement.executeUpdate();
        }
    }

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
}
