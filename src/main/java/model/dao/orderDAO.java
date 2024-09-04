package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new order
    public void createOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (User_ID, Staff_ID, Car_ID, DateTime, Status, Rental_Date_Start, Rental_Date_Finish, Odometer_Start, Odometer_Finish, License_Number) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, order.getUserId());
        statement.setInt(2, order.getStaffId());
        statement.setInt(3, order.getCarId());
        statement.setString(4, order.getOrderDateTime());
        statement.setString(5, order.getStatus());
        statement.setString(6, order.getRentalDateStart());
        statement.setString(7, order.getRentalDateFinish());
        statement.setInt(8, order.getOdometerStart());
        statement.setInt(9, order.getOdometerFinish());
        statement.setString(10, order.getLicenseNumber());

        statement.executeUpdate();
    }

    // Method to get an order by ID
    public Order getOrderById(int orderId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE Order_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, orderId);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Order order = new Order();
            order.setUserId(resultSet.getInt("User_ID"));
            order.setStaffId(resultSet.getInt("Staff_ID"));
            order.setCarId(resultSet.getInt("Car_ID"));
            order.setOrderDateTime(resultSet.getString("DateTime"));
            order.setStatus(resultSet.getString("Status"));
            order.setRentalDateStart(resultSet.getString("Rental_Date_Start"));
            order.setRentalDateFinish(resultSet.getString("Rental_Date_Finish"));
            order.setOdometerStart(resultSet.getInt("Odometer_Start"));
            order.setOdometerFinish(resultSet.getInt("Odometer_Finish"));
            order.setLicenseNumber(resultSet.getString("License_Number"));
            return order;
        }
        return null;
    }

    // Method to update an existing order
    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET User_ID = ?, Staff_ID = ?, Car_ID = ?, DateTime = ?, Status = ?, Rental_Date_Start = ?, Rental_Date_Finish = ?, " +
                     "Odometer_Start = ?, Odometer_Finish = ?, License_Number = ? WHERE Order_ID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, order.getUserID());
        statement.setInt(2, order.getStaffID());
        statement.setInt(3, order.getCarID());
        statement.setString(4, order.getOrderDateTime());
        statement.setString(5, order.getStatus());
        statement.setString(6, order.getRentalDateStart());
        statement.setString(7, order.getRentalDateFinish());
        statement.setInt(8, order.getOdometerStart());
        statement.setInt(9, order.getOdometerFinish());
        statement.setString(10, order.getLicenseNumber());
        statement.setInt(11, orderID());

        statement.executeUpdate();
    }

    // Method to delete an order by ID
    public void deleteOrder(int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE Order_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, orderId);

        statement.executeUpdate();
    }
}