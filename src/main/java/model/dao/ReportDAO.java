package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Report;

public class ReportDAO {
    private Connection con;
    private PreparedStatement reportFetchReadSt;

    public ReportDAO(Connection connection) throws SQLException {
        // Initiates connection to DB
        this.con = connection;
        // Prevents needing confirmation before making changes to DB
        connection.setAutoCommit(true);
        // Preparing predetermined statement for fetching reports
        reportFetchReadSt = connection.prepareStatement("SELECT report_id, report_date, report_type, total_customers, total_revenue, extra_column_1, extra_column_2 FROM Report");
    }

    // Fetch all reports
    public ArrayList<Report> fetchReports() throws SQLException {
        ResultSet rs = reportFetchReadSt.executeQuery();
        ArrayList<Report> reports = new ArrayList<Report>();

        while (rs.next()) {
            int reportID = rs.getInt(1);
            String reportDate = rs.getString(2);
            String reportType = rs.getString(3);
            int totalCustomers = rs.getInt(4);
            double totalRevenue = rs.getDouble(5);
            String additionalField1 = rs.getString(6); // Fetch additionalField1
            String additionalField2 = rs.getString(7); // Fetch additionalField2

            Report report = new Report(reportID, reportDate, reportType, totalCustomers, totalRevenue, additionalField1, additionalField2);
            reports.add(report);
        }

        return reports;
    }

    // Fetch a specific report by ID
    public Report selectSpecificReport(Integer reportID) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT report_id, report_date, report_type, total_customers, total_revenue, extra_column_1, extra_column_2 FROM Report WHERE report_id=?");
        st.setInt(1, reportID);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("report_id");
            String reportDate = rs.getString("report_date");
            String reportType = rs.getString("report_type");
            int totalCustomers = rs.getInt("total_customers");
            double totalRevenue = rs.getDouble("total_revenue");
            String additionalField1 = rs.getString("extra_column_1"); // Fetch additionalField1
            String additionalField2 = rs.getString("extra_column_2"); // Fetch additionalField2

            return new Report(id, reportDate, reportType, totalCustomers, totalRevenue, additionalField1, additionalField2);
        } else {
            return null;
        }
    }
}
