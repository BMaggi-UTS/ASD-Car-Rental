<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.ShipmentDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shipment Tracking</title>
    <link rel="stylesheet" href="css/reports_shipment.css">
    <link rel="stylesheet" href="css/navandfooter.css">
</head>
<body>

    <!-- Navigation Bar -->
    <%@ include file="assets/nav.jsp" %> 

    <div class="container">
        <!-- Customer View Section -->
        <div id="customer-view" class="customer-section">
            <div class="report-section" id="track-order">
                <h2>Track Your Order</h2>
                <form id="track-order-form">
                    <label for="order-id">Enter your Order ID:</label>
                    <input type="text" id="order-id" name="order-id" required>
                    <button type="submit">Track</button>
                </form>
                <div id="order-status" class="report-tables">
                    <!-- Order details will be displayed here after submission -->
                </div>
            </div>
        </div>

        <!-- Admin View Section (Optional) -->
        <div id="admin-view" class="admin-section">
            <div class="report-section" id="admin-shipment">
                <h2>All Shipment Details (Admin View)</h2>
                <!-- Admin table of all shipments -->
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Car</th>
                            <th>Status</th>
                            <th>Delivery Date</th>
                            <th>Customer Address</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Example data for presentation -->
                        <tr>
                            <td>12345</td>
                            <td>Tesla Model S</td>
                            <td>In Transit</td>
                            <td>12th October 2024</td>
                            <td>123 Main Street, Sydney, NSW</td>
                        </tr>
                        <tr>
                            <td>67890</td>
                            <td>BMW X5</td>
                            <td>Delivered</td>
                            <td>8th October 2024</td>
                            <td>456 Elm Street, Melbourne, VIC</td>
                        </tr>
                        <!-- Add more rows as needed -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <%@ include file="assets/footer.jsp" %>

    <!-- Scripts -->
    <script src="js/report.js"></script>
    <script src="js/tracking.js"></script>
</body>
</html>
