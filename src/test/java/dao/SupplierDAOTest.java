package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.TestInstance.Lifecycle;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.*;


import model.Supplier;
import model.dao.SupplierDAO;
import model.dao.DBConnector;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Test class testing SupplierDAO read/write funcionality to DB.")
public class SupplierDAOTest {
    Connection conn;
    SupplierDAO supplierDAO;

    @BeforeAll
    public void openConnection() {

        try {
            DBConnector db = new DBConnector();
            conn = db.openConnection();
            conn.setAutoCommit(false);
            supplierDAO = new SupplierDAO(conn);
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @BeforeEach
    public void reset() {
        try {
            conn.prepareStatement("DELETE FROM Suppliers").executeUpdate();
            supplierDAO.addSupplier("Toyota Supplier", "1", "1", "Alice", "0411111111"); 
            supplierDAO.addSupplier("Toyota Wholesaler", "2", "2", "Bob", "0422222222");
            supplierDAO.addSupplier("BMW", "3", "3", "Charlie", "0433333333");
            supplierDAO.addSupplier("Mazda", "4", "4", "Daniel", "0444444444");
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @AfterEach
    public void cleanUp() {
        try {
            conn.rollback();
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    @AfterAll
    public void closeConnection() {
        try {
            conn.close();
        }
        catch (SQLException ex){
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @Test
    @DisplayName("Test returning all suppliers in the database")
    public void testGetAllSuppliers() {
        try{
            ArrayList<Supplier> suppliers = supplierDAO.getAllSuppliers();
            int numOfSuppliersReturned = suppliers.size();
            assertEquals(4, numOfSuppliersReturned);
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @Test
    @DisplayName("Test returning only suppliers that match a given search term")
    public void testGetSuppliersBySearch() {
        try{
            ArrayList<Supplier> suppliers = supplierDAO.getSuppliersBySearch("Toyota");
            int numOfSuppliersReturned = suppliers.size();
            assertEquals(2, numOfSuppliersReturned);
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @Test
    @DisplayName("Test returning the correct supplier when retrieving with supplier ID")
    public void testGetSupplierByID() {
        
        try{
            int lastInsertID = supplierDAO.getLastInsertID();
            Supplier supplier = supplierDAO.getSupplierByID(lastInsertID);
            assertEquals("Mazda", supplier.getBusinessName());
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @Test
    @DisplayName("Test returning the correct supplier when retrieving with supplier ID")
    public void testUpdateSupplier() {
        
        try{
            int lastInsertID = supplierDAO.getLastInsertID();
            supplierDAO.updateSupplier(lastInsertID, "Mitsubishi", "null", "null", "null", "null");
            Supplier supplier = supplierDAO.getSupplierByID(lastInsertID);
            assertEquals("Mitsubishi", supplier.getBusinessName());
            assertEquals("null", supplier.getABN());
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

    @Test
    @DisplayName("Test adding a supplier to the db")
    public void testAddSupplier() {
        
        try{
            supplierDAO.addSupplier("Mitsubishi", "null", "null", "null", "null");
            int lastInsertID = supplierDAO.getLastInsertID();
            Supplier supplier = supplierDAO.getSupplierByID(lastInsertID);
            assertEquals("Mitsubishi", supplier.getBusinessName());
            assertEquals("null", supplier.getABN());
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
    @Test
    @DisplayName("Test deleting a supplier from the db")
    public void testDeleteSupplier() {
        
        try{
            int lastInsertID = supplierDAO.getLastInsertID();
            supplierDAO.deleteSupplier(lastInsertID);
            Supplier supplier = supplierDAO.getSupplierByID(lastInsertID);
            assertTrue(supplier == null);
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierDAOTest.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }

}
