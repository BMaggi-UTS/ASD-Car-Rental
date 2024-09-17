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
    <title>Car Rental Reports</title>
    <link rel="stylesheet" href="reports/shipment.css">
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
        <!-- Sales Report Section -->
        <div class="report-section" id="sales-report">
            <h2>Sales Report</h2>
            <div class="report-tables">
                <h3>Daily Sales Report</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Amount of Customers</th>
                            <th>Amount of Cars Rented</th>
                            <th>Daily Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2024-09-01</td>
                            <td>10</td>
                            <td>8</td>
                            <td>$2000</td>
                        </tr>
                        <tr>
                            <td>2024-09-02</td>
                            <td>12</td>
                            <td>10</td>
                            <td>$2500</td>
                        </tr>
                    </tbody>
                </table>

                <h3>Weekly Sales Report</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Week</th>
                            <th>Amount of Customers</th>
                            <th>Amount of Cars Rented</th>
                            <th>Weekly Revenue</th>
                            <th>Average Spending per Person</th>
                            <th>Total Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Week 1 (Sep)</td>
                            <td>80</td>
                            <td>60</td>
                            <td>$15000</td>
                            <td>$187.50</td>
                            <td>$15000</td>
                        </tr>
                    </tbody>
                </table>

                <!-- Monthly Sales Report with a button -->
                <h3>Monthly Sales Report</h3>
                <label for="month">Select Month:</label>
                <select id="month">
                    <option value="September">September</option>
                    <option value="August">August</option>
                </select>
                <button id="generate-report">Generate Report</button>
                <table id="monthly-report">
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
                <h3>Weekly Renting Report</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Car Name</th>
                            <th>Times Rented (Week)</th>
                            <th>Weekly Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Toyota Camry</td>
                            <td>20</td>
                            <td>$5000</td>
                        </tr>
                        <tr>
                            <td>Honda Civic</td>
                            <td>15</td>
                            <td>$3750</td>
                        </tr>
                    </tbody>
                </table>

                <h3>Monthly Renting Report</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Car Name</th>
                            <th>Times Rented (Month)</th>
                            <th>Monthly Revenue</th>
                            <th>Total Revenue</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Toyota Camry</td>
                            <td>80</td>
                            <td>$20000</td>
                            <td>$20000</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Customer Feedback Section -->
        <div class="report-section" id="customer-feedback">
            <h2>Customer Feedback</h2>
            <div class="report-tables">
                <h3>Feedback Overview</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Customer Name</th>
                            <th>Date</th>
                            <th>Feedback</th>
                            <th>Rating</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>John Doe</td>
                            <td>2024-09-05</td>
                            <td>Excellent service!</td>
                            <td>5</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>   
    <script src="report.js"></script>
</body>
</html>


