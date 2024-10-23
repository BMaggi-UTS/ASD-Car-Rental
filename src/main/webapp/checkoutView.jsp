<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="model.dao.orderDAO"%>
<%@page import="model.dao.paymentDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page import="model.payment"%>
<%@ page import="java.time.format.DateTimeFormatter" %>

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
                <h1>Checkout</h1>
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
                        paymentDAO paymentDAO = new paymentDAO(connection);

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
                        
                        try{

                        } catch (Exception e) {
                            out.println("Unexpected error: " + e.getMessage());
                        }


                        payment payment = null;
                        int paymentID = 0;
                        String cardName = "";
                        String cardNumber = "";
                        String expiry = "";
                        String cvc = "";

                        try{
                            User user = (User) session.getAttribute("user");
                            int userID = user.getUserID();
                            int newPaymentID = paymentDAO.getMostRecentPayment(userID);
                            System.out.println("New Payment ID:" + newPaymentID);
                            payment = paymentDAO.getPaymentById(newPaymentID);
                            try {
                                if (payment != null) {
                                    paymentID = payment.getPaymentID();
                                    cardName = payment.getCardName();
                                    cardNumber = payment.getCardNumber();
                                    expiry = payment.getExpiry().format(DateTimeFormatter.ofPattern("MM/yyyy"));// or just .toString() will work
                                    cvc = payment.getCvc();
                                } else {
                                    out.println("Error: Payment is null.");
                                }
                            } catch (NumberFormatException e) {
                                out.println("Error: Invalid car ID format.");
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

                        <br><br>
                        
                        <p><strong>Payment Details:</strong></p>
                        <p>Card Name: <%= cardName %></p>
                        <p>Card Number: <%= cardNumber %></p>
                        <p>Expiry: <%= expiry %></p>
                        <p>CVC/CVV: <%= cvc %></p>

                        <br>

                        <form action="deletePayment" method="POST">
                            <button class="trash-button" type="submit">
                                <i class="fas fa-trash"></i> <!-- Font Awesome trash bin icon -->
                            </button>
                        </form>

                    </div>
                </div>

                <br>

                <!-- Button to return to the orderView page -->
                <div class="middle">
                    <a href="/editPaymentView.jsp" class="back-button">Need to change your payment details? Click here to update.</a>
                </div>

                <div class="middle">
                    <p>By clicking the button below, your payment will be processed.</p>
                    <br>
                </div>

                <div class="middle">
                    <a href="/confirmationView.jsp" class="pay-button">Pay Now</a>
                </div>

                <br><br>

                <hr>

                <br><br>
                
                <div class="middle">
                    <br>
                    <p>Having trouble? Email us at asdgroup@support.com</p>
                </div>

            

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
