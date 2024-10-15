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
