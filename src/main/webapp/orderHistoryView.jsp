<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/orderStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management - Checkout</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
                <h1>Order History</h1>

                <br><br>

                <!-- Order Summary Section -->
                <div class="order-summary">
                    <h2>Had a memorable experience? Find your orders here!</h2>

                    <br>

                    <div class="card">
                        <h3>[Order Number here]</h3>
                        <h3>[Owner of rental's name here]</h3>
                        <h4>[Car model here]</h4> 
                        <p>Rating: [Owner/car star rating here]</p>

                        <br>
                        
                        <p>Dates: [Dates/time booked]</p>
                        <p>Meeting Location: [Location]</p>
                    
                        <br><br>

                        <p>Base Price: $[Base price]</p>
                        <p>Taxes & Fees: $[Taxes and fees]</p>
                        <p><strong>Total Price: $[Total price]</strong></p>

                        <br><br>
                        
                    </div>

                    <br>

                    <div class="card">
                        <h3>[Order Number here]</h3>
                        <h3>[Owner of rental's name here]</h3>
                        <h4>[Car model here]</h4> 
                        <p>Rating: [Owner/car star rating here]</p>

                        <br>
                        
                        <p>Dates: [Dates/time booked]</p>
                        <p>Meeting Location: [Location]</p>
                    
                        <br><br>

                        <p>Base Price: $[Base price]</p>
                        <p>Taxes & Fees: $[Taxes and fees]</p>
                        <p><strong>Total Price: $[Total price]</strong></p>

                        <br><br>
                        
                    </div>

                    <br>

                    <div class="card">
                        <h3>[Order Number here]</h3>
                        <h3>[Owner of rental's name here]</h3>
                        <h4>[Car model here]</h4> 
                        <p>Rating: [Owner/car star rating here]</p>

                        <br>
                        
                        <p>Dates: [Dates/time booked]</p>
                        <p>Meeting Location: [Location]</p>
                    
                        <br><br>

                        <p>Base Price: $[Base price]</p>
                        <p>Taxes & Fees: $[Taxes and fees]</p>
                        <p><strong>Total Price: $[Total price]</strong></p>

                        <br><br>
                        
                    </div>

                </div>

                <br><br>

                

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
