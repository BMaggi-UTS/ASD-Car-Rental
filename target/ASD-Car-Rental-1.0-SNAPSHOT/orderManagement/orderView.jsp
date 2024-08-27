<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="orderStyle.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="../assets/nav.jsp" %> 
            <main class="main-container">
                <h1>Checkout</h1>
                
                <h3>[Owner of rental's name here]</h3>
                <h4>[Car model here] </h4>
                <h5>[Owner/car star rating here]</h5>
                <p>[Dates/time booked]</p>
                <p>[Address]</p>

                <br>

                <p>Pricing with total price underneath</p>
            </main>
            <%@ include file="../assets/footer.jsp" %> 
        </div>
    </body>
</html>
