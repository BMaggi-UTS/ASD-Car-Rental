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
    carFetchReadSt = connection.prepareStatement("SELECT Car_ID, Car_Make, Car_Model, Car_Trim, Car_Odometer, Car_Image, Car_Transmission, Car_Fuel, Car_Seats, Car_Body_Style, Car_Quip, Car_Purchase_Price, Car_Current_Price, Car_Price_KM, Car_Rating, Location_ID FROM Car");

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
			int carRating = rs.getInt(15);
			int locationID = rs.getInt(16);
			 
			
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
			c.setCarRating(carRating);
			c.setLocationID(locationID);

			// System.out.println(p.getProductName());
			//adding the just set up product (p) to the list products.
			cars.add(c);
		}
		return cars;
	}

	//select specific car
	public Car selectSpecificCar(Integer carID) throws SQLException {
		// Integer product_ID = Integer.parseInt(product_IDs);
		PreparedStatement st = con.prepareStatement("SELECT * FROM Car WHERE car_id=?");
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
		Integer carRating = rs.getInt("car_rating");
		Integer locationID = rs.getInt("location_id");

        // Create and return Product object
        return new Car(car_ID, carMake, carModel, carTrim, carOdometer, carImage,carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
		} 
		else {
			return null;
		}
	}

	public ArrayList<Car> selectArrayCar(ArrayList<Integer> carIDList) throws SQLException {
		ArrayList<Car> cars = new ArrayList<>();
		for(Integer carID : carIDList) {
			PreparedStatement st = con.prepareStatement("SELECT * FROM Car WHERE car_id=?");
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
			Integer carRating = rs.getInt("car_rating");
			Integer locationID = rs.getInt("location_id");
			Car c = new Car(car_ID, carMake, carModel, carTrim, carOdometer, carImage,carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
			cars.add(c);
			} 
			else {
				cars.add(null);
			}
		}
		return cars;

	}
	//update product
	public void updateProduct(
		Integer car_ID,
		String carMake,
		String carModel,
		String carTrim,
		String carImage,
		Integer carOdometer,
		String carTransmission,
		String carFuel,
		Integer carSeats,
		String carBodyStyle,
		String carQuip,
		Integer carPurchasePrice,
		Integer carCurrentPrice,
		Integer carPriceKM,
		Integer carRating,
		Integer locationID
	) throws SQLException {
		PreparedStatement st = con.prepareStatement("UPDATE Car SET Car_ID=?, Car_Make=?, Car_Model=?, Car_Trim=?, Car_Odometer=?, Car_Image=?, Car_Transmission=?, Car_Fuel=?, Car_Seats=?, Car_Body_Style=?, Car_Quip=?, Car_Purchase_Price=?, Car_Current_Price=?, Car_Price_KM=?, Car_Rating=?, location_id=? WHERE car_id=?");
		st.setInt(1, car_ID);
		st.setString(2, carMake);
		st.setString(3, carModel);
		st.setString(4, carTrim);
		st.setInt(5, carOdometer);
		st.setString(6, carImage);
		st.setString(7, carTransmission);
		st.setString(8, carFuel);
		st.setInt(9, carSeats);
		st.setString(10, carBodyStyle);
		st.setString(11, carQuip);
		st.setInt(12, carPurchasePrice);
		st.setInt(13, carCurrentPrice);
		st.setInt(14, carPriceKM);
		st.setInt(15, carRating);
		st.setInt(16, locationID);
		st.setInt(17, car_ID);
	
		st.executeUpdate();
	}

}
