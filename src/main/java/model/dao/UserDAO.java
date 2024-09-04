package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Car;

public class UserDAO {
    private Connection con;

	public UserDAO(Connection connection) throws SQLException {
		this.con = connection;
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

}
