package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

import model.Car;
import model.order;

<<<<<<< HEAD
public class orderDAO {
=======
public class orderDAO { 
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

    private Connection connection;

    public orderDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new order
    public void createOrder(order order) throws SQLException {
<<<<<<< HEAD
        // order newOrder;
        String sql = "INSERT INTO orders (User_ID, Staff_ID, Car_ID, Order_Date_Time, Status, "
               + "Rental_Date_Start, Rental_Date_Finish, Odometer_Start, Odometer_Finish, "
               + "License_Number, First_Name, Middle_Name, Last_Name, License_Expiry_Date, "
               + "DOB, State) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            statement.setString(11, order.getfirstName()); 
            statement.setString(12, order.getmiddleName()); 
            statement.setString(13, order.getlastName()); 

            // Create and format the expiration date from the form input
            String licenseExpiryDate = "2025-10-10";
            statement.setString(14, licenseExpiryDate); // Expiration Date

            statement.setString(15, "2002-09-10"); // Date of Birth
            statement.setString(16, "nsw"); // State
=======

        String sql = "INSERT INTO Orders (User_ID, Car_ID, Order_Date_Time, "
               + "Rental_Date_Start, Rental_Date_Finish, Odometer_Start, Odometer_Finish, "
               + "License_Number, Tax_Price, Base_Price, Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getUserID());
            statement.setInt(2, order.getCarID());
            statement.setString(3, order.getOrderDateTime());
            statement.setString(4, order.getRentalDateStart());
            statement.setString(5, order.getRentalDateFinish());
            statement.setInt(6, order.getOdometerStart());
            statement.setInt(7, order.getOdometerFinish());
            statement.setInt(8, order.getLicenseNumber());
            statement.setString(9, order.gettaxesFeesString()); 
            statement.setString(10, order.getbasePriceString()); 
            statement.setString(11, order.gettotalPriceString()); 
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

            statement.executeUpdate();
        }
    }

<<<<<<< HEAD
=======
    //Retrieve orders based on UserID
    public List<order> getOrdersByUserID(int userID) throws SQLException {
        List<order> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE User_ID = ?";
    
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, userID); // Set the userID parameter

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                order ord = new order();
                ord.setUserID(resultSet.getInt("User_ID"));
                ord.setCarID(resultSet.getInt("Car_ID"));
                ord.setOrderDateTime(resultSet.getString("Order_Date_Time"));
                ord.setRentalDateStart(resultSet.getString("Rental_Date_Start"));
                ord.setRentalDateFinish(resultSet.getString("Rental_Date_Finish"));
                ord.setOdometerStart(resultSet.getInt("Odometer_Start"));
                ord.setOdometerFinish(resultSet.getInt("Odometer_Finish"));
                ord.setLicenseNumber(Integer.parseInt(resultSet.getString("License_Number")));
                ord.settaxesFeesString(resultSet.getString("Tax_Price"));
                ord.setbasePriceString(resultSet.getString("Base_Price"));
                ord.settotalPriceString(resultSet.getString("Total_Price"));
                // Add the order to the list
                orders.add(ord);
            }
        }
    }
    return orders;
    }

    //Retrieve OrderID - automatically set in database, not in project, thus needs to be retrieved manually.
    public List<Integer> getOrderID(int userId) throws SQLException {
        String sql = "SELECT Order_ID FROM Orders WHERE User_ID = ?";
        List<Integer> orderIds = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId); // Set User_ID parameter
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Assuming OrderID is of type Integer in the database
                orderIds.add(resultSet.getInt("Order_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log exception for debugging
            throw new SQLException("Error retrieving Order IDs: " + e.getMessage());
        }

        return orderIds; // Return the list of OrderIDs
    }

    public void updateDriverDetails(int userID, String licenseNumber) throws SQLException {
    String sql = "UPDATE Orders SET License_Number = ? WHERE User_ID = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, licenseNumber); // Set the license number
        pstmt.setInt(2, userID);           // Set the user ID
        pstmt.executeUpdate();             // Execute the update
    } catch (SQLException e) {
        throw new SQLException("Error updating driver details: " + e.getMessage());
    }
}






>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    // // Method to get an order by ID for search purposes
    // public order getOrderById(int orderId) throws SQLException {
    //     String sql = "SELECT * FROM orders WHERE Order_ID = ?";
    //     try (PreparedStatement statement = connection.prepareStatement(sql)) {
    //         statement.setInt(1, orderId);

    //         try (ResultSet resultSet = statement.executeQuery()) {
    //             if (resultSet.next()) {
    //                 order order = new order();
    //                 order.setUserID(resultSet.getInt("User_ID"));
<<<<<<< HEAD
    //                 order.setStaffID(resultSet.getInt("Staff_ID"));
    //                 order.setCarID(resultSet.getInt("Car_ID"));
    //                 order.setOrderDateTime(resultSet.getString("DateTime"));
    //                 order.setStatus(resultSet.getString("Status"));
=======
    //                 order.setCarID(resultSet.getInt("Car_ID"));
    //                 order.setOrderDateTime(resultSet.getString("DateTime"));
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    //                 order.setRentalDateStart(resultSet.getString("Rental_Date_Start"));
    //                 order.setRentalDateFinish(resultSet.getString("Rental_Date_Finish"));
    //                 order.setOdometerStart(resultSet.getInt("Odometer_Start"));
    //                 order.setOdometerFinish(resultSet.getInt("Odometer_Finish"));
    //                 order.setLicenseNumber(resultSet.getInt("License_Number"));
    //                 return order;
    //             }
    //         }
    //     }
    //     return null;
    // }

    // // Method to update an existing order
    // public void updateOrderDetails(order order) throws SQLException {
    //     String sql = "UPDATE orders SET User_ID = ?, Staff_ID = ?, Car_ID = ?, DateTime = ?, Status = ?, Rental_Date_Start = ?, Rental_Date_Finish = ?, " +
    //                  "Odometer_Start = ?, Odometer_Finish = ?, License_Number = ? WHERE Order_ID = ?";

    //     try (PreparedStatement statement = connection.prepareStatement(sql)) {
    //         statement.setInt(1, order.getUserID());
<<<<<<< HEAD
    //         statement.setInt(2, order.getStaffID());
    //         statement.setInt(3, order.getCarID());
    //         statement.setString(4, order.getOrderDateTime());
    //         statement.setString(5, order.getStatus());
=======
    //         statement.setInt(3, order.getCarID());
    //         statement.setString(4, order.getOrderDateTime());
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    //         statement.setString(6, order.getRentalDateStart());
    //         statement.setString(7, order.getRentalDateFinish());
    //         statement.setInt(8, order.getOdometerStart());
    //         statement.setInt(9, order.getOdometerFinish());
    //         statement.setInt(10, order.getLicenseNumber());

    //         //Unsure. Change if needed.
    //         //statement.setInt(11, order.getOrderID());

    //         statement.executeUpdate();
    //     }
    // }

    // Method to delete an order by ID
    public void deleteOrder(int orderId) throws SQLException {
<<<<<<< HEAD
        String sql = "DELETE FROM orders WHERE Order_ID = ?";
=======
        String sql = "DELETE FROM Orders WHERE Order_ID = ?";
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);

            statement.executeUpdate();
        }
    }

<<<<<<< HEAD
=======
    // Method to fetch the most recent order by user ID
    public int getMostRecentOrder(int userID) throws SQLException {
        String sql = "SELECT * FROM Orders WHERE User_ID = ? ORDER BY Order_ID DESC LIMIT 1";
        int orderID = 0;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                orderID = resultSet.getInt("Order_ID");
            }
        }

        System.out.println("Most recent order:" + orderID);

        return orderID;
    }





>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
=======

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    


}
