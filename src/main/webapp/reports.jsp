<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="table.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car Rental Reports</title>
    <link rel="stylesheet" href="css/reports_shipment.css">
    <link rel="stylesheet" href="css/navandfooter.css">

</head>
<body>

    <%@ include file="assets/nav.jsp" %> 

    <div class="container">
        <!-- Sales Report Section -->
        <div class="report-section" id="sales-report">
            <h2>Sales Report</h2>
            <div class="report-tables">
                <!-- Custom Sales Report -->
                <h3>Custom Sales Report</h3>
                <label for="sales-start-date">Start Date:</label>
                <input type="date" id="sales-start-date">
                <label for="sales-end-date">End Date:</label>
                <input type="date" id="sales-end-date">
                <button class="btn" id="generate-sales-report">Generate Report</button>
                <button class="btn" id="export-sales-pdf">Export as PDF</button>
                <table id="sales-report-table">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Amount of Customers</th>
                            <th>Amount of Cars Rented</th>
                            <th>Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Filled with JavaScript -->
                    </tbody>
                </table>

                <!-- Monthly Sales Report -->
                <h3>Monthly Sales Report</h3>
                <label for="sales-month">Select Month and Year:</label>
                <select id="sales-month">
                    <!-- Dynamically populated -->
                </select>
                <button class="btn" id="generate-monthly-sales-report">Generate Report</button>
                <table id="monthly-sales-report-table">
                    <thead>
                        <tr>
                            <th>Month</th>
                            <th>Amount of Customers</th>
                            <th>Amount of Cars Rented</th>
                            <th>Monthly Revenue</th>
                            <th>Average Spending per Person</th>
                            <th>Total Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Filled with JavaScript -->
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Renting Report Section -->
        <div class="report-section" id="renting-report">
            <h2>Renting Report</h2>
            <div class="report-tables">
                <!-- Similar structure as Sales Report -->
                <!-- Add date selection and tables as needed -->
            </div>
        </div>

        <!-- Customer Feedback Section -->
        <div class="report-section" id="customer-feedback">
            <h2>Customer Feedback</h2>
            <div class="report-tables">
                <h3>Custom Feedback Report</h3>
                <label for="feedback-start-date">Start Date:</label>
                <input type="date" id="feedback-start-date">
                <label for="feedback-end-date">End Date:</label>
                <input type="date" id="feedback-end-date">
                <button class="btn" id="generate-feedback-report">Generate Report</button>
                <button class="btn" id="export-feedback-pdf">Export as PDF</button>
                <table id="feedback-report-table">
                    <thead>
                        <tr>
                            <th>Customer Name</th>
                            <th>Date</th>
                            <th>Feedback</th>
                            <th>Rating</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Filled with JavaScript -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>   

    <%@ include file="assets/footer.jsp" %>
    <!-- Include jsPDF library -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <!-- Include jsPDF AutoTable plugin -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.23/jspdf.plugin.autotable.min.js"></script>
    <script src="js/report.js"></script>
</body>
</html>
