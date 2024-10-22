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
        <link rel="stylesheet" href="css/orderStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
         <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management - Checkout</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
<<<<<<< HEAD
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
=======
            <h1>Order History</h1>

            <br>

            <div class="order-summary">
                <h2>Had a memorable experience? Find your orders here!</h2>

                <br>

                <%
                    List<order> orders = (List<order>) request.getAttribute("orders");
                    if (orders == null || orders.isEmpty()) {   
                %>
                        <p>No orders found for your account.</p>
                <%
                    } else {
                        DBConnector conn = new DBConnector();
                        Connection connection = conn.openConnection();
                        orderDAO orderDAO = new orderDAO(connection);

                        User user = (User) session.getAttribute("user");//This is the fix for the hardcoded carID as well. Issue is ids are automatically created in DBeaver, not in project
                        int userID = user.getUserID(); //Therefore, get__ID() does not work properly. Need to get session data and manually retrieve it
                        List<Integer> orderIds = orderDAO.getOrderID(userID); // Created list method in DAO, populate list and wrap main logic in for loop

                        for (Integer orderId : orderIds) {
                            System.out.println("Order ID: " + orderId);
                        

                        for (order ord : orders) {
                            int carId = ord.getCarID();
                            String carMake = "";
                            String carRating = "";
                            int carOdometer = 0;
                            Car car = null;

                            if (carId > 0) { // Ensure carId is a valid positive integer
                                try {
                                    car = orderDAO.getCarById(carId); // Pass the carId as an int
                                    if (car != null) {
                                        // Output car details
                                        carMake = car.getCarMake() + " " + car.getCarModel() + " " + car.getCarTrim();
                                        carRating = car.getCarRating() + "/5 Star Rating";
                                        carOdometer = car.getCarOdometer();
                                    } else {
                                        out.println("Error: Car not found.");
                                    }
                                } catch (SQLException e) {
                                    out.println("Database error: " + e.getMessage());
                                } catch (Exception e) {
                                    out.println("Unexpected error: " + e.getMessage());
                                }
                            } else {
                                out.println("Error: Invalid Car ID.");
                            }
                %>
                            <div class="card">
                                <p>Order ID: <%= orderId %></p>
                                <br>
                                <p>Car Model: <%= carMake %></p>
                                <p>Rating: <%= carRating %></p>
                                <p>Starting Odometer: <%= carOdometer %> km</p>
                                <p>Dates: <%= ord.getRentalDateStart() %> to <%= ord.getRentalDateFinish() %></p>
                                <br>
                                <p>Base Price: $<%= ord.getbasePriceString() %></p>
                                <p>Taxes & Fees: $<%= ord.gettaxesFeesString() %></p>
                                <p>Total Price: $<%= ord.gettotalPriceString() %></p>
                            </div>
                <%
                        } // End of for loop
                        }
                    } // End of else block
                %>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

                </div>

                <br><br>
<<<<<<< HEAD

                

            </main>
=======
            
        </main>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
