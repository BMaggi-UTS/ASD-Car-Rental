<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paymentStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management - Checkout</title>



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




    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
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
                    <a href="./orderView.jsp" class="back-button">Need to change your details? Click here to go back.</a>
                </div>

                <br><br>

                <hr>

                <br><br>
                

                <!-- Payment Information Section -->
                <div class="payment-summary">
                    <h2>Payment Information</h2>
                    <br>
                    
                    <!-- Existing Payment Details Section -->
                    <div id="existingPayment" class="show">
                        <div class="middle">
                            <h3>Existing Payment Details</h3>
                            <p>[Name on Card]</p> 
                            <p>[Card Number]</p> 
                            <p>[Expiry Date]</p> 
                            <p>[CVV]</p> 
                            <p>[Name on card]</p>
                        </div>

                        <button class="trash-button">
                            <i class="fas fa-trash"></i> <!-- Font Awesome trash bin icon -->
                        </button>

                        <br><br><br>
                        
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

                    <br><br>



                    <div class="middle">
                        <p>By clicking the button below, your payment will be processed.</p>
                        <br>
                        <a href="./orderView.jsp" class="general-button">Pay now</a>
                    </div>

                    
                </div>

            

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
