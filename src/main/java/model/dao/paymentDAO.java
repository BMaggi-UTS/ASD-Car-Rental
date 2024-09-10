package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.payment;

public class paymentDAO {

    private Connection connection;

    public paymentDAO(Connection connection) {
        this.connection = connection;
    }

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

            statement.executeUpdate();
        }
    }

    // Method to update an existing payment
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
        }
    }

    // Method to delete payment details by Order ID
    public void deletePayment(int orderID) throws SQLException {
        String sql = "DELETE FROM payments WHERE Order_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderID);

            statement.executeUpdate();
        }
    }
}
