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
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
                <h1>Checkout</h1>
                <br>

                
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Order Summary</h2>
                </div>
                <br>
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Personal Details</h2>
                </div>
                <br>
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Driver's License</h2>
                </div>

                <br><br>

                <div class="middle">
                    <a href="./orderView.jsp" class="back-button">Need to change your details? Click here to go back.</a>
                </div>

                <br><br>

                <hr>

                <br><br>
                
                <!-- Payment Information Section -->
                <div class="payment-summary">
                    <h2>Payment Information</h2>

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
                        <div class="form-group">
                            <label for="billingAddress">Billing Address:</label>
                            <input type="text" id="billingAddress" name="billingAddress" required>
                        </div>
                        <button type="submit" class="btn-submit">Complete Payment</button>
                    </form>
                </div>

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
