<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shipment Tracking</title>
    <link rel="stylesheet" href="reports_shipments.css">
</head>
<body>

     <nav>
        <div class="container navbar">
          <a href="home.html"><img src="logo.png" alt="logo" class="logo" /></a>
          
          <ul class="nav-links">
            <li><a href="home.html">Home</a></li>
            <li><a href="shipment.html">Shipment</a></li>
            <li><a href="settings.html">Settings</a></li>
            <li><a href="Reports.html">Reports</a></li>
          </ul>
      
          <div class="search-div">
            <input type="text" placeholder="Search for your next rental . . ." />
            <i class="fa-solid fa-magnifying-glass search-icon fa-2xl"></i>
          </div>
      
          <div class="cart-div">
            <i class="fa-solid fa-car fa-2xl"></i>
          </div>
        </div>
      </nav>

    <div class="container">
        <!-- Admin View -->
        <div id="admin-view" class="admin-section">
            <div class="report-section" id="car-shipments">
                <h2>Car Shipments</h2>
                <div class="report-tables">
                    <h3>Shipment Details</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Shipment ID</th>
                                <th>Car Model</th>
                                <th>Customer Name</th>
                                <th>Shipping Address</th>
                                <th>Status</th>
                                <th>Carrier</th>
                                <th>Estimated Delivery Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Database -->
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="report-section" id="shipment-history">
                <h2>Shipment History</h2>
                <div class="report-tables">
                    <h3>History Overview</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Shipment ID</th>
                                <th>Car Model</th>
                                <th>Delivery Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Database -->
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="report-section" id="shipping-costs">
                <h2>Shipping Costs</h2>
                <div class="report-tables">
                    <h3>Cost Overview</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Shipping Method</th>
                                <th>Cost</th>
                                <th>Car Model</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Database -->
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="report-section" id="delivery-issues">
                <h2>Delivery Issues</h2>
                <div class="report-tables">
                    <h3>Issues Overview</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Issue ID</th>
                                <th>Shipment ID</th>
                                <th>Description</th>
                                <th>Resolution Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Populate from Database -->
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="report-section" id="order-fulfillment">
                <h2>Order Fulfillment</h2>
                <div class="report-tables">
                    <h3>Fulfillment Details</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Car Model</th>
                                <th>Quantity Shipped</th>
                                <th>Shipped Date</th>
                                <th>Delivery Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Populate from Database -->
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="report-section" id="carrier-performance">
                <h2>Carrier Performance</h2>
                <div class="report-tables">
                    <h3>Performance Overview</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Carrier Name</th>
                                <th>On-Time Delivery Rate</th>
                                <th>Customer Feedback</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Populate from Database -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Customer View -->
        <div id="customer-view" class="customer-section">
            <div class="report-section" id="track-order">
                <h2>Track Your Order</h2>
                <form id="track-order-form">
                    <label for="order-id">Enter your Order ID:</label>
                    <input type="text" id="order-id" name="order-id" required>
                    <button type="submit">Track</button>
                </form>
                <div id="order-status" class="report-tables">
                    <!-- Order status will be displayed here -->
                </div>
            </div>
        </div>
    </div>

    <script src="report.js"></script>
    <script src="tracking.js"></script>
</body>
</html>
