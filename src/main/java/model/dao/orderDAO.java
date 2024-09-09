package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.order;

public class orderDAO {

    private Connection connection;

    public orderDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new order
    public void createOrder(order order) throws SQLException {
        String sql = "INSERT INTO orders (User_ID, Staff_ID, Car_ID, DateTime, Status, Rental_Date_Start, Rental_Date_Finish, Odometer_Start, Odometer_Finish, License_Number) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getUserID());
            statement.setInt(2, order.getStaffID());
            statement.setInt(3, order.getCarID());
            statement.setString(4, order.getOrderDateTime());
            statement.setString(5, order.getStatus());
            statement.setString(6, order.getRentalDateStart());
            statement.setString(7, order.getRentalDateFinish());
            statement.setInt(8, order.getOdometerStart());
            statement.setInt(9, order.getOdometerFinish());
            statement.setInt(10, order.getLicenseNumber());

            statement.executeUpdate();
        }
    }

    // Method to get an order by ID for search purposes
    public order getOrderById(int orderId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE Order_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    order order = new order();
                    order.setUserID(resultSet.getInt("User_ID"));
                    order.setStaffID(resultSet.getInt("Staff_ID"));
                    order.setCarID(resultSet.getInt("Car_ID"));
                    order.setOrderDateTime(resultSet.getString("DateTime"));
                    order.setStatus(resultSet.getString("Status"));
                    order.setRentalDateStart(resultSet.getString("Rental_Date_Start"));
                    order.setRentalDateFinish(resultSet.getString("Rental_Date_Finish"));
                    order.setOdometerStart(resultSet.getInt("Odometer_Start"));
                    order.setOdometerFinish(resultSet.getInt("Odometer_Finish"));
                    order.setLicenseNumber(resultSet.getInt("License_Number"));
                    return order;
                }
            }
        }
        return null;
    }

    // Method to update an existing order
    public void updateOrderDetails(order order) throws SQLException {
        String sql = "UPDATE orders SET User_ID = ?, Staff_ID = ?, Car_ID = ?, DateTime = ?, Status = ?, Rental_Date_Start = ?, Rental_Date_Finish = ?, " +
                     "Odometer_Start = ?, Odometer_Finish = ?, License_Number = ? WHERE Order_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getUserID());
            statement.setInt(2, order.getStaffID());
            statement.setInt(3, order.getCarID());
            statement.setString(4, order.getOrderDateTime());
            statement.setString(5, order.getStatus());
            statement.setString(6, order.getRentalDateStart());
            statement.setString(7, order.getRentalDateFinish());
            statement.setInt(8, order.getOdometerStart());
            statement.setInt(9, order.getOdometerFinish());
            statement.setInt(10, order.getLicenseNumber());

            //Unsure. Change if needed.
            //statement.setInt(11, order.getOrderID());

            statement.executeUpdate();
        }
    }

    // Method to delete an order by ID
    public void deleteOrder(int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE Order_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);

            statement.executeUpdate();
        }
    }
}
