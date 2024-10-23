<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="model.dao.orderDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paymentStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management - Checkout</title>
        
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
                <h1>Payment Details</h1>
                <br>

                <!-- Order Summary Section -->
                <div class="order-summary">
                    <% 
                        
                        // Retrieve and process input parameters
                        String pickupDate = request.getParameter("pickupDate");
                        String dropoffDate = request.getParameter("dropoffDate");
                            
                        // Calculate prices
                        String basePriceString = request.getParameter("booking-price");
                        double basePrice = Double.parseDouble(basePriceString);
                        double taxesFees = basePrice * 0.10;
                        double totalPrice = basePrice + taxesFees;
                            
                        String taxesFeesString = String.format("%.2f", taxesFees);
                        String totalPriceString = String.format("%.2f", totalPrice);
                            
                        // Open a connection using DBConnector
                        DBConnector conn = new DBConnector();
                        Connection connection = conn.openConnection();
                        // Use the connection to create an orderDAO controller
                        orderDAO orderDAO = new orderDAO(connection);

                        String carValid = "";
                        String carMake = "";
                        String carRating = "";
                        int carOdometer = 0;
                        int carID = 0;
                        
                        Car car = null;

                        try {
                            // Fetch car data by ID if valid
                            carValid = request.getParameter("orderCarID");
                            if (carValid != null) {
                                try {
                                    carID = Integer.parseInt(carValid);
                                    car = orderDAO.getCarById(carID); 
                                    if (car != null) {
                                        // Output car details
                                        carMake = car.getCarMake() + " " + car.getCarModel() + " " + car.getCarTrim();
                                        carRating = car.getCarRating() + "/5 Star Rating";
                                        carOdometer = car.getCarOdometer();
                                    } else {
                                        out.println("Error: Car not found.");
                                    }
                                } catch (NumberFormatException e) {
                                    out.println("Error: Invalid car ID format.");
                                }
                            } else {
                                out.println("Error: Car ID is missing.");
                            }
                            
                        } catch (SQLException e) {
                            out.println("Database error: " + e.getMessage());
                        } catch (Exception e) {
                            out.println("Unexpected error: " + e.getMessage());
                        }
                    %>

                    <h2>Order Summary</h2>
                    <div class="card">
                        <!-- Draw data from carID in database and list model here -->
                       
                        <p><strong><%= carMake %></strong></p>
                        <p><%= carRating %></p>
                        <p><%= carOdometer %>km</p>

                        <br>

                        <p>Pickup Date: <%= pickupDate %></p>
                        <p>Dropoff Date: <%= dropoffDate %></p>

                        <br><br>

                        <p>Base Price: $<%= basePriceString %></p>
                        <p>Taxes & Fees: $<%= taxesFeesString %></p> 
                        <p><strong>Total Price: $<%= totalPriceString %></strong></p> 

                        <img src="<%= car.getCarImage() %>" alt="Car Image">

                        <form action="deleteOrder" method="POST">
                            <button class="trash-button" type="submit">
                                <i class="fas fa-trash"></i> <!-- Font Awesome trash bin icon -->
                            </button>
                        </form>

                    </div>
                </div>

                <br>

                <!-- Content to show previously filled information -->
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Personal Details</h2>
                </div>
                <br>
                <div class="locked-section">

                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Driver's License</h2>
                    
                </div>

                <br><br>

                <!-- Button to return to the orderView page -->
                <div class="middle">
                    <a href="/editDriverView.jsp" class="back-button">Need to change your driver details? Click here to update.</a>
                </div>

                <br><br>

                <hr>

                <br><br>
                

                <!-- Payment Information Section -->
                <div class="payment-summary">
                    <h2>Add Payment Information</h2>
                    <br>

                    <form action="addPayment" method="POST">
                        <input type="hidden" name="orderCarID" value="<%= carID %>"> 
                        <input type="hidden" name="pickupDate" value="<%= pickupDate %>">
                        <input type="hidden" name="dropoffDate" value="<%= dropoffDate %>">
                        <input type="hidden" name="base-price" value="<%= basePriceString %>">
                        <input type="hidden" name="tax-fees" value="<%= taxesFeesString %>">
                        <input type="hidden" name="booking-price" value="<%= totalPriceString %>">

                        <div class="form-group">
                            <label for="cardName">Name on Card:</label>
                            <input type="text" id="cardName" name="cardName" maxlength="50" required>
                        </div>

                        <!-- Card Number -->
                        <div class="form-group">
                            <label for="cardNumber">Card Number:</label>
                            <input type="text" id="cardNumber" name="cardNumber" maxlength="16" required>
                        </div>

                        <!-- Expiry Date -->
                        <div class="form-group">
                            <label for="expiryDate">Expiry Date:</label>
                            <input type="month" id="expiryDate" name="expiryDate" required>
                        </div>

                        <!-- CVV -->
                        <div class="form-group">
                            <label for="cvv">CVV:</label>
                            <input type="text" id="cvv" name="cvv" pattern="\d{3,4}" maxlength="4" required>
                        </div>
                    <br>
                        <button type="submit" class="btn-submit">Add Payment Details</button>
                    </form>

                    <br><br>


                    <div class="middle">
                        <p>By clicking the button below, your payment will be processed.</p>
                        <br>
                    </div>
                </div>
                
                
                <div class="middle">
                    <br>
                    <p>Having trouble? Email us at asdgroup@support.com</p>
                </div>

            

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
