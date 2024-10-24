<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.orderDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

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
                        int carID = 0;
                        
                        try {
                            carValid = request.getParameter("orderCarID");
                            if (carValid != null) {
                                try {
                                    carID = Integer.parseInt(carValid);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid car ID format: " + carValid);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred while processing car ID: " + e.getMessage());
                        }
                %>


                <h1>Edit Payment Details</h1>
                <br>

                <h2>Made a mistake? No worries!</h2>
                <div class="middle">
                    <p>Enter your new details here.</p>
                </div>

                <br><br>


                <!-- Payment Information Section -->
                <div class="payment-summary">
                    <h2>Add Payment Information</h2>
                    <br>

                    <form action="updatePayment" method="POST">
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
                        <button type="submit" class="btn-submit">Update Payment Details</button>
                    </form>

                    <br><br>


                    <div class="middle">
                        <p>By clicking the button below, your payment details will be updated and payment will be processed.</p>
                        <br>
                    </div>
                </div>

                <br><br>


                <hr>
                

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
