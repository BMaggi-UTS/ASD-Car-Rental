package model.dao;

import static org.junit.jupiter.api.Assumptions.abort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import model.Supplier;



public class SupplierDAO { 
    private Connection con;

    public SupplierDAO(Connection con) throws SQLException {
        this.con = con;
    }

    public ArrayList<Supplier> getAllSuppliers() throws SQLException {

        ArrayList<Supplier> suppliers = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Suppliers");
        ResultSet rs = ps.executeQuery();


        while(rs.next()) {
            int id = rs.getInt(1);
            String businessName = rs.getString(2);
            String ABN = rs.getString(3);
            String ACN = rs.getString(4);
            String contactName = rs.getString(5);
            String contactPhone = rs.getString(6);
            String imagePath = rs.getString(7);

            suppliers.add(new Supplier(id, businessName, ABN, ACN, contactName, contactPhone, imagePath));
        }

        return suppliers;
    }
    public ArrayList<Supplier> getSuppliersBySearch(String searchTerm) throws SQLException {

        ArrayList<Supplier> suppliers = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Suppliers WHERE Business_Name LIKE ?");
        ps.setString(1, "%" + searchTerm + "%");
        ResultSet rs = ps.executeQuery();


        while(rs.next()) {
            int id = rs.getInt(1);
            String businessName = rs.getString(2);
            String ABN = rs.getString(3);
            String ACN = rs.getString(4);
            String contactName = rs.getString(5);
            String contactPhone = rs.getString(6);
            String imagePath = rs.getString(7);

            suppliers.add(new Supplier(id, businessName, ABN, ACN, contactName, contactPhone, imagePath ));
        }

        return suppliers;
    }

    public Supplier getSupplierByID(int id) throws SQLException{

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Suppliers WHERE Supplier_ID = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return new Supplier(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
        }
        return null;
    }

    public void updateSupplier(int id, String businessName, String ABN, String ACN, String contactName, String contactPhone) throws SQLException {

        PreparedStatement ps = con.prepareStatement("UPDATE Suppliers SET Business_Name = ?, ABN = ?, ACN = ?, Contact_Name = ?, Contact_Phone = ? WHERE Supplier_ID = ?");
        ps.setString(1, businessName);
        ps.setString(2, ABN);
        ps.setString(3, ACN);
        ps.setString(4, contactName);
        ps.setString(5, contactPhone);
        ps.setInt(6, id);

        ps.executeUpdate();
    }

    public void addSupplier(String businessName, String ABN, String ACN, String contactName, String contactPhone) throws SQLException {

        PreparedStatement ps = con.prepareStatement("INSERT INTO Suppliers (Business_Name, ABN, ACN, Contact_Name, Contact_Phone, Image_Path) VALUES (?,?,?,?,?,?)");
        ps.setString(1, businessName);
        ps.setString(2, ABN);
        ps.setString(3, ACN);
        ps.setString(4, contactName);
        ps.setString(5, contactPhone);
        ps.setString(6, "placeholder.png");

        ps.executeUpdate();
    }

    public void deleteSupplier(int id) throws SQLException {

        PreparedStatement ps = con.prepareStatement("DELETE FROM Suppliers WHERE Supplier_ID = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
    }

    public int getLastInsertID() throws SQLException {
        
        PreparedStatement ps = con.prepareStatement("SELECT last_insert_id()");

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

}
