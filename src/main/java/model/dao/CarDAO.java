package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Car;

public class CarDAO {
    private Connection con;
	private PreparedStatement carFetchReadSt;

	public CarDAO(Connection connection) throws SQLException {
		//initiates connection to db
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(true);
		//preparing predetermined statement
//		carFetchReadSt = connection.prepareStatement("SELECT car_id, car_make, car_model, car_trim, car_odometer, car_image, car_transmission, car_fuel, car_seats, car_body_style, car_quip, car_purchase_price, car_current_price, car_price_km, car_location, car_rating  FROM CAR");
    carFetchReadSt = connection.prepareStatement("SELECT Car_ID, Car_Make, Car_Model, Car_Trim, Car_Odometer, Car_Image, Car_Transmission, Car_Fuel, Car_Seats, Car_Body_Style, Car_Quip, Car_Purchase_Price, Car_Current_Price, Car_Price_KM, Car_Location, Car_Rating FROM Car");

	}
	
	//Car fetch
	public ArrayList<Car> fetchCars() throws SQLException {
		ResultSet rs = carFetchReadSt.executeQuery();
		ArrayList<Car> cars = new ArrayList<Car>();
		while (rs.next()) {
			int carID = rs.getInt(1);
			String carMake = rs.getString(2);
			String carModel = rs.getString(3);
			String carTrim  = rs.getString(4);
			int carOdometer  = rs.getInt(5);
			String carImage = rs.getString(6);
			String carTransmission = rs.getString(7);
			String carFuel = rs.getString(8);
			int carSeats = rs.getInt(9);
			String carBodyStyle = rs.getString(10);
			String carQuip = rs.getString(11);
			int carPurchasePrice = rs.getInt(12);
			int carCurrentPrice = rs.getInt(13);
			int carPriceKM = rs.getInt(14);
			String carLocation = rs.getString(15);
			int carRating =rs.getInt(15);
			 
			
			//setting every product value to match the data base
			//all of these objects being created can be accessed through the array "products"
			Car c = new Car();
			c.setCarID(carID);
			c.setCarMake(carMake);
			c.setCarModel(carModel);
			c.setCarTrim(carTrim);
			c.setCarOdometer(carOdometer);
			c.setCarImage(carImage);
			c.setCarTransmission(carTransmission);
			c.setCarFuel(carFuel);
			c.setCarSeats(carSeats);
            c.setCarBodyStyle(carBodyStyle);
            c.setCarQuip(carQuip);
			c.setCarPurchasePrice(carPurchasePrice);
			c.setCarCurrentPrice(carCurrentPrice);
			c.setCarPriceKM(carPriceKM);
			c.setCarLocation(carLocation);
			c.setCarRating(carRating);

			// System.out.println(p.getProductName());
			//adding the just set up product (p) to the list products.
			cars.add(c);
		}
		return cars;
	}

	//select specific car
	public Car selectSpecificCar(Integer carID) throws SQLException {
		// Integer product_ID = Integer.parseInt(product_IDs);
		PreparedStatement st = con.prepareStatement("SELECT * FROM car WHERE car_id=?");
    st.setInt(1, carID);
    ResultSet rs = st.executeQuery();
	if (rs.next()) { // Check if result set is not empty
		Integer car_ID = rs.getInt("car_id");
        String carMake= rs.getString("car_make");
        String carModel= rs.getString("car_model");
        String carTrim= rs.getString("car_trim");
        String carImage= rs.getString("car_image");
        Integer  carOdometer= rs.getInt("car_odometer");
		String carTransmission= rs.getString("car_transmission");
        String carFuel = rs.getString("car_fuel");
		Integer carSeats= rs.getInt("car_seats");
        String carBodyStyle = rs.getString("car_body_style");
		String carQuip = rs.getString("car_quip");
		Integer carPurchasePrice = rs.getInt("car_purchase_price");
		Integer carCurrentPrice= rs.getInt("car_current_price");
		Integer carPriceKM = rs.getInt ("car_price_km");
		String carLocation = rs.getString("car_location");
		Integer carRating = rs.getInt("car_rating");

        // Create and return Product object
        return new Car(car_ID, carMake, carModel, carTrim, carOdometer, carImage,carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carLocation, carRating);
		} 
		else {
			return null;
		}
	}

}
