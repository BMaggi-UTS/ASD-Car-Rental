package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Shipment;

public class ShipmentDAO {
    private Connection con;
    private PreparedStatement shipmentFetchReadSt;

    public ShipmentDAO(Connection connection) throws SQLException {
        // Initiates connection to the database
        this.con = connection;
        connection.setAutoCommit(true);
        // Prepares the SQL statement to fetch shipments
        shipmentFetchReadSt = connection.prepareStatement("SELECT shipment_id, order_id, shipment_status, shipment_date FROM Shipments");
    }

    // Fetch all shipments
    public ArrayList<Shipment> fetchShipments() throws SQLException {
        ResultSet rs = shipmentFetchReadSt.executeQuery();
        ArrayList<Shipment> shipments = new ArrayList<>();
        while (rs.next()) {
            int shipmentID = rs.getInt(1);
            int orderID = rs.getInt(2);
            String shipmentStatus = rs.getString(3);
            String shipmentDate = rs.getString(4);

            // Create Shipment object and add to the list
            Shipment shipment = new Shipment();
            shipment.setShipmentID(shipmentID);
            shipment.setOrderID(orderID);
            shipment.setShipmentStatus(shipmentStatus);
            shipment.setShipmentDate(shipmentDate);

            shipments.add(shipment);
        }
        return shipments;
    }

    // Insert a new shipment
    public void insertShipment(Shipment shipment) throws SQLException {
        PreparedStatement st = con.prepareStatement("INSERT INTO Shipments(order_id, shipment_status, shipment_date) VALUES (?, ?, ?)");
        st.setInt(1, shipment.getOrderID());
        st.setString(2, shipment.getShipmentStatus());
        st.setString(3, shipment.getShipmentDate());
        st.executeUpdate();
    }

    // Select a specific shipment by order ID
    public Shipment selectSpecificShipment(Integer orderID) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT * FROM Shipments WHERE order_id=?");
        st.setInt(1, orderID);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            int shipmentID = rs.getInt("shipment_id");
            String shipmentStatus = rs.getString("shipment_status");
            String shipmentDate = rs.getString("shipment_date");
            String shipmentAddress = rs.getString("shipment_Address");
            String estimatedDeliveryDate = rs.getString("estimated_Delivery_Date");
            String trackingNumber = rs.getString("tracking_number");

            return new Shipment(shipmentID, shipmentStatus, shipmentDate, shipmentAddress, orderID, estimatedDeliveryDate, trackingNumber);

        } else {
            return null;
        }
    }
}
