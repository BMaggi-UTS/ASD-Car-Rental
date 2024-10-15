package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Location;

public class LocationDAO {
    private Connection con;
	private PreparedStatement carFetchReadSt;

	public LocationDAO(Connection connection) throws SQLException {
		//initiates connection to db
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(true);
		//preparing predetermined statement
//		carFetchReadSt = connection.prepareStatement("SELECT car_id, car_make, car_model, car_trim, car_odometer, car_image, car_transmission, car_fuel, car_seats, car_body_style, car_quip, car_purchase_price, car_current_price, car_price_km, car_location, car_rating  FROM CAR");
    carFetchReadSt = connection.prepareStatement("SELECT location_id, location_street_number, location_street_name, location_state, location_postcode, location_name FROM Location");

	}
	
	//Car fetch
	public ArrayList<Location> fetchLocations() throws SQLException {
		ResultSet rs = carFetchReadSt.executeQuery();
		ArrayList<Location> locations = new ArrayList<Location>();
		while (rs.next()) {
			int locationID = rs.getInt(1);
			int locationStreetNumber  = rs.getInt(2);
			String locationStreetName = rs.getString(3);
			String locationState = rs.getString(4);
			int locationPostcode = rs.getInt(5);
			String locationName  = rs.getString(6);
			
			Location l = new Location();
			l.setLocationID(locationID);
			l.setLocationStreetNumber(locationStreetNumber);
			l.setLocationStreetName(locationStreetName);
			l.setLocationState(locationState);
			l.setLocationPostcode(locationPostcode);
			l.setLocationName(locationName);

			locations.add(l);
		}
		return locations;
	}

	// //select specific car
	// public Car selectSpecificCar(Integer carID) throws SQLException {
	// 	// Integer product_ID = Integer.parseInt(product_IDs);
	// 	PreparedStatement st = con.prepareStatement("SELECT * FROM Car WHERE car_id=?");
    // st.setInt(1, carID);
    // ResultSet rs = st.executeQuery();
	// if (rs.next()) { // Check if result set is not empty
	// 	Integer car_ID = rs.getInt("car_id");
    //     String carMake= rs.getString("car_make");
    //     String carModel= rs.getString("car_model");
    //     String carTrim= rs.getString("car_trim");
    //     String carImage= rs.getString("car_image");
    //     Integer  carOdometer= rs.getInt("car_odometer");
	// 	String carTransmission= rs.getString("car_transmission");
    //     String carFuel = rs.getString("car_fuel");
	// 	Integer carSeats= rs.getInt("car_seats");
    //     String carBodyStyle = rs.getString("car_body_style");
	// 	String carQuip = rs.getString("car_quip");
	// 	Integer carPurchasePrice = rs.getInt("car_purchase_price");
	// 	Integer carCurrentPrice= rs.getInt("car_current_price");
	// 	Integer carPriceKM = rs.getInt ("car_price_km");
	// 	String carLocation = rs.getString("car_location");
	// 	Integer carRating = rs.getInt("car_rating");

    //     // Create and return Product object
    //     return new Car(car_ID, carMake, carModel, carTrim, carOdometer, carImage,carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carLocation, carRating);
	// 	} 
	// 	else {
	// 		return null;
	// 	}
	// }

}
