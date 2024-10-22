<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<<<<<<< HEAD
=======
<%@page import="model.dao.orderDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

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
<<<<<<< HEAD



        <style>
            /* Inline CSS to handle hiding/showing new details form */
            .hidden {
                display: none;
            }
            .show {
                display: block;
            }
        </style>

        
        <script>
            /*for appear/disappear animation*/
            function togglePaymentForm() {
                var existingPayment = document.getElementById("existingPayment");
                var newPaymentForm = document.getElementById("newPaymentForm");
                var toggleButton = document.getElementById("toggleButton");

                if (existingPayment.classList.contains("hidden")) {
                    existingPayment.classList.remove("hidden");
                    newPaymentForm.classList.add("hidden");
                    toggleButton.innerText = "Click here to add new details";
                } else {
                    existingPayment.classList.add("hidden");
                    newPaymentForm.classList.remove("hidden");
                    toggleButton.innerText = "Cancel and go back to existing details";
                }
            }
        </script>



    </head>




=======
        
    </head>

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
<<<<<<< HEAD
                <h1>Checkout</h1>
                <br>

                <!-- Order Summary from orderView page -->
                <div class="order-summary">
                    <h2>Order Summary</h2>
                    <div class="card">
                        <h3>[Owner of rental's name here]</h3>
                        <h4>[Car model here]</h4> 
                        <p>Rating: [Owner/car star rating here]</p>

                        <br>
                        
                        <p>Dates: [Dates/time booked]</p>
                        <p>Meeting Location: [Location]</p>
                    </div>
                    <div class="pricing">
                        <p>Base Price: $[Base price]</p>
                        <p>Taxes & Fees: $[Taxes and fees]</p>
                        <p><strong>Total Price: $[Total price]</strong></p>
                    </div>  
=======
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
                        
                        Car car = null;

                        try {
                            // Fetch car data by ID if valid
                            carValid = request.getParameter("orderCarID");
                            if (carValid != null) {
                                try {
                                    int carId = Integer.parseInt(carValid);
                                    car = orderDAO.getCarById(13); //hard code this (e.g. replace with 13) and continue to work until id issue fixed. Meant to be carId.
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
                </div>

                <br>

                <!-- Content to show previously filled information -->
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Personal Details</h2>
                </div>
                <br>
                <div class="locked-section">
<<<<<<< HEAD
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Driver's License</h2>
=======

                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Driver's License</h2>
                    
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
                </div>

                <br><br>

                <!-- Button to return to the orderView page -->
                <div class="middle">
<<<<<<< HEAD
                    <a href="./orderView.jsp" class="back-button">Need to change your details? Click here to go back.</a>
=======
                    <a href="/editDriverView.jsp" class="back-button">Need to change your driver details? Click here to update.</a>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
                </div>

                <br><br>

                <hr>

                <br><br>
                

                <!-- Payment Information Section -->
                <div class="payment-summary">
<<<<<<< HEAD
                    <h2>Payment Information</h2>
                    <br>
                    
                    <!-- Existing Payment Details Section -->
                    <div id="existingPayment" class="show">
                        <div class="paymentCard">
                            <h3>Existing Payment Details</h3>
                            <p>[Name on Card]</p> 
                            <p>[Card Number]</p> 
                            <p>[Expiry Date]</p> 
                            <p>[CVV]</p> 
                            <p>[Name on card]</p>

                            <br>

                            <button class="trash-button">
                                <i class="fas fa-trash"></i> <!-- Font Awesome trash bin icon -->
                            </button>

                        </div>

                        <br><br>
                        
                        <div class="middle">
                            <a href="javascript:void(0);" id="toggleButton" onclick="togglePaymentForm()" class="general-button">Click here to change details</a>
                        </div>

                        <br><br>
                    </div>
                    
                    <!-- New Payment Form Section -->
                    <div id="newPaymentForm" class="hidden">
                        <br><br>
                        <h2>New Card Details:</h2>
                        <br>
                        <form action="paymentProcessing.jsp" method="POST">
                            <div class="form-group">
                                <label for="cardName">Name on Card:</label>
                                <input type="text" id="cardName" name="cardName" required>
                            </div>
                            <div class="form-group">
                                <label for="cardNumber">Card Number:</label>
                                <input type="text" id="cardNumber" name="cardNumber" required>
                            </div>
                            <div class="form-group">
                                <label for="expiryDate">Expiry Date:</label>
                                <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" required>
                            </div>
                            <div class="form-group">
                                <label for="cvv">CVV:</label>
                                <input type="text" id="cvv" name="cvv" required>
                            </div>
                            <br>
                            <button type="submit" class="btn-submit">Add Payment Details</button>
                        </form>
                        <br><br>
                    </div>
=======
                    <h2>Add Payment Information</h2>
                    <br>

                    <form action="addPayment" method="POST">
                        <input type="hidden" name="orderCarID" value="13"> <!-- HARDCODED. Needs to be fixed. -->
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

                    <br><br>


<<<<<<< HEAD

                    <div class="middle">
                        <p>By clicking the button below, your payment will be processed.</p>
                        <br>
                        <a href="./orderView.jsp" class="general-button">Pay now</a>
                    </div>
                </div>

                <div class="middle">
                    <br><br><br>
=======
                    <div class="middle">
                        <p>By clicking the button below, your payment will be processed.</p>
                        <br>
                    </div>
                </div>
                
                
                <div class="middle">
                    <br>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
                    <p>Having trouble? Email us at asdgroup@support.com</p>
                </div>

            

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
