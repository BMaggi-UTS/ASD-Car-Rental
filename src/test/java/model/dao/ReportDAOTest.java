package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import model.Report;

public class ReportDAOTest {

    private DBConnector dbConnector;
    private Connection connection;
    private ReportDAO reportDAO;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        // Initialize the DB connection
        dbConnector = new DBConnector();
        connection = dbConnector.openConnection();
        reportDAO = new ReportDAO(connection);
    }

    @After
    public void tearDown() throws SQLException {
        // Close DB connection
        dbConnector.closeConnection();
    }

    @Test
    public void testFetchReports() throws SQLException {
        // Test fetching all reports
        ArrayList<Report> reports = reportDAO.fetchReports();
        assertNotNull(reports);
        assertTrue(reports.size() > 0);
    }

    @Test
    public void testSelectSpecificReport() throws SQLException {
        // Test fetching a specific report by ID
        int reportID = 1; // Example ID
        Report report = reportDAO.selectSpecificReport(reportID);
        assertNotNull(report);
        assertEquals("Monthly", report.getReportType());
    }

    @Test
    public void testAddAndDeleteReport() throws SQLException {
        // Adding a new report
        String insertSQL = "INSERT INTO Report (Report_Date, Report_Type, Total_Customers, Total_Revenue, Additional_Field1, Additional_Field2) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertSt = connection.prepareStatement(insertSQL);
        insertSt.setString(1, "2024-10-01");
        insertSt.setString(2, "TestType");
        insertSt.setInt(3, 100);
        insertSt.setDouble(4, 10000.00);
        insertSt.setString(5, "TestField1");
        insertSt.setString(6, "TestField2");

        int rowsAffected = insertSt.executeUpdate();
        assertEquals(1, rowsAffected);

        // Now, delete the added report
        String deleteSQL = "DELETE FROM Report WHERE Report_Type = 'TestType' AND Report_Date = '2024-10-01'";
        PreparedStatement deleteSt = connection.prepareStatement(deleteSQL);
        int rowsDeleted = deleteSt.executeUpdate();
        assertEquals(1, rowsDeleted);
    }
}


