package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Car;
import model.order;

public class orderDAO {

    private Connection connection;

    public orderDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new order
    public void createOrder(order order) throws SQLException {
        String sql = "INSERT INTO Orders (Order_ID, User_ID, Car_ID, Order_Date_Time, Status, "
               + "Rental_Date_Start, Rental_Date_Finish, Odometer_Start, Odometer_Finish, "
               + "License_Number, First_Name, Middle_Name, Last_Name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getorderID());
            statement.setInt(2, order.getUserID());
            statement.setInt(3, order.getCarID());
            statement.setString(4, order.getOrderDateTime());
            statement.setString(5, order.getRentalDateStart());
            statement.setString(6, order.getRentalDateFinish());
            statement.setInt(7, order.getOdometerStart());
            statement.setInt(8, order.getOdometerFinish());
            statement.setInt(9, order.getLicenseNumber());
            statement.setString(10, order.getfirstName()); 
            statement.setString(11, order.getmiddleName()); 
            statement.setString(12, order.getlastName()); 

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
                    order.setCarID(resultSet.getInt("Car_ID"));
                    order.setOrderDateTime(resultSet.getString("DateTime"));
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
            statement.setInt(3, order.getCarID());
            statement.setString(4, order.getOrderDateTime());
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

    public Car getCarById(int carId) throws SQLException {

        System.out.println("Fetching car with ID: " + carId);
    
        String sql = "SELECT * FROM Car WHERE car_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    // Extract data from result set
                    int carID = rs.getInt("car_id");
                    String carMake = rs.getString("car_make");
                    String carModel = rs.getString("car_model");
                    String carTrim = rs.getString("car_trim");
                    int carOdometer = rs.getInt("car_odometer");
                    String carImage = rs.getString("car_image");
                    String carTransmission = rs.getString("car_transmission");
                    String carFuel = rs.getString("car_fuel");
                    int carSeats = rs.getInt("car_seats");
                    String carBodyStyle = rs.getString("car_body_style");
                    String carQuip = rs.getString("car_quip");
                    int carPurchasePrice = rs.getInt("car_purchase_price");
                    int carCurrentPrice = rs.getInt("car_current_price");
                    int carPriceKM = rs.getInt("car_price_km");
                    int carRating = rs.getInt("car_rating");
                    int locationID = rs.getInt("location_id");
    
                    // Create and return a Car object
                    return new Car(carID, carMake, carModel, carTrim, carOdometer, carImage,
                                   carTransmission, carFuel, carSeats, carBodyStyle, carQuip, 
                                   carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
                }
            }
        }
        return null;
    }
    


}
