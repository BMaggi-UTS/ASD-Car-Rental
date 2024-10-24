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

                        User user = (User) session.getAttribute("user");
                        int userID = user.getUserID();
                        List<Integer> orderIds = orderDAO.getOrderID(userID);

                        // Loop through order IDs and retrieve order details
                        for (Integer orderId : orderIds) {
                            try {
                                order ord = orderDAO.getOrderById(orderId);
                                if (ord != null) {
                                    int carId = ord.getCarID();
                                    String carMake = "";
                                    String carRating = "";
                                    int carOdometer = 0;
                                    Car car = null;

                                    if (carId > 0) { 
                                        car = orderDAO.getCarById(carId);
                                        if (car != null) {
                                            carMake = car.getCarMake() + " " + car.getCarModel() + " " + car.getCarTrim();
                                            carRating = car.getCarRating() + "/5 Star Rating";
                                            carOdometer = car.getCarOdometer();
                                        } else {
                                            out.println("Error: Car not found.");
                                        }
                                    } else {
                                        out.println("Error: Invalid Car ID.");
                                    }
                                %>
                                    <div class="card">
                                        <p>Order ID: <%= orderId %></p>
                                        <p>Car Model: <%= carMake %></p>
                                        <p>Rating: <%= carRating %></p>
                                        <p>Starting Odometer: <%= carOdometer %> km</p>
                                        <p>Dates: <%= ord.getRentalDateStart() %> to <%= ord.getRentalDateFinish() %></p>
                                        <p>Base Price: $<%= ord.getbasePriceString() %></p>
                                        <p>Taxes & Fees: $<%= ord.gettaxesFeesString() %></p>
                                        <p>Total Price: $<%= ord.gettotalPriceString() %></p>
                                    </div>
                                <%
                                } else {
                                    out.println("Error: Order not found.");
                                }
                            } catch (SQLException e) {
                                out.println("Database error: " + e.getMessage());
                                e.printStackTrace();
                            } catch (Exception e) {
                                out.println("Unexpected error: " + e.getMessage());
                            }
                        }
                    } 
                %>
            </div>

        <br><br>
            
        </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
