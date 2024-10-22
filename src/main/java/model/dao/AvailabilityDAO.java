package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Availability;

public class AvailabilityDAO {
    private Connection con;
    private PreparedStatement carFetchReadSt;

	public AvailabilityDAO(Connection connection) throws SQLException {
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(false);
		//preparing predetermined statement
        carFetchReadSt = connection.prepareStatement("SELECT Availability_ID, Car_ID, Order_ID, Availability_Start_Date, Availability_Finish_Date FROM Availability");
	}
    //Car fetch
	public ArrayList<Availability> fetchAllAvailability() throws SQLException {
		ResultSet rs = carFetchReadSt.executeQuery();
		ArrayList<Availability> availabilities = new ArrayList<Availability>();
		while (rs.next()) {
			int availabilityID = rs.getInt(1);
            int carID = rs.getInt(2);
			int orderID = rs.getInt(3);
			String aStartDate = rs.getString(4);			 
			String aFinishDate = rs.getString(5);			 
			//setting every product value to match the data base
			//all of these objects being created can be accessed through the array "products"
			Availability a = new Availability();
            a.setAvailabilityID(availabilityID);
            a.setCarID(carID);
            a.setOrderID(orderID);
            a.setStartDate(aStartDate);
            a.setFinishDate(aFinishDate);

			availabilities.add(a);
		}
		return availabilities;
	}
    //select specific car
	public Availability selectSpecificAvailability(Integer availabilityID) throws SQLException {
		// Integer product_ID = Integer.parseInt(product_IDs);
		PreparedStatement st = con.prepareStatement("SELECT * FROM Availability WHERE Availability_ID=?");
        st.setInt(1, availabilityID);
        ResultSet rs = st.executeQuery();
        if (rs.next()) { // Check if result set is not empty
            int availability_ID = rs.getInt("availability_id");
            int carID = rs.getInt("car_id");
            int orderID = rs.getInt("order_id");
            String aStartDate = rs.getString("Availability_Start_Date");			 
            String aFinishDate = rs.getString("Availability_Finish_Date");

            // Create and return Product object
            return new Availability(availability_ID, carID, orderID, aStartDate, aFinishDate);
        } 
        else {
            return null;
        }
	}
    public void updateAvailability(
		int AvailabilityID,
        int CarID,
        int OrderID,
        String startDate,
        String finishDate
	) throws SQLException {
		PreparedStatement st = con.prepareStatement("UPDATE Availability SET availability_id=?, car_id=?, order_id=?, Availability_Start_Date=?, Availability_Finish_Date=? WHERE availability_id=?");
		st.setInt(1, AvailabilityID);
		st.setInt(2, CarID);
        st.setInt(3, OrderID);
        st.setString(4, startDate);
        st.setString(5, finishDate);
		st.setInt(6, AvailabilityID);
	
		st.executeUpdate();
	}
    public void createAvailability(
		int AvailabilityID,
        int CarID,
        int OrderID,
        String startDate,
        String finishDate
	) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO Availability(availability_id, car_id, order_id, Availability_Start_Date, Availability_Finish_Date) \n" + //
						"VALUES (?, ?, ?, ?, ?);\n" + //
						"");
		st.setInt(1, AvailabilityID);
		st.setInt(2, CarID);
        st.setInt(3, OrderID);
        st.setString(4, startDate);
        st.setString(5, finishDate);
	
		st.executeUpdate();
	}
    public void deleteAvailability(Integer availability_id) throws SQLException {
		// Use correct column name and prepared statement
		String sql = "DELETE FROM Availability WHERE `Availability_ID` = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		// Set the availability_id parameter
		st.setInt(1, availability_id);
		
		// Execute the query
		st.executeUpdate();
	}
	
	

}
