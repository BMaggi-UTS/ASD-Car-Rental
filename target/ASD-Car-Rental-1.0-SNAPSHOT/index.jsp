<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Car Rental</title>
        <% //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector(); %>
            <% //open a connection
            Connection con = conn.openConnection(); %>
            <% //use the connection to create a productDAO controller
            CarDAO carDAO = new CarDAO(con); %>
        
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <h1>Sydney Car Rental</h1>
                <h2>All your car hire needs in one convenient website</h2>
                    <div class="product-wrapper">
                    <% ArrayList<Car> cars = carDAO.fetchCars(); %>
                    <% for(Car car : cars) { %>
                        
                     <a href="/car.jsp">
                        <div class="card">
                            <div class="imgBox">
                                <img src="<%= car.getCarImage() %>" alt="<%= car.getCarMake() %>" class="car">
                            </div>
                            <div class="contentBox">
                                <div class="card-content">
                                    <div class="name-price">
                                        <h3><%= car.getCarMake() + " " + car.getCarModel() %></h3>
                                        <h2 class="price">$<%= car.getCarPriceKM() %> <span>/ a KM</span></h2>
                                        <h2 class="price"><%= car.getCarQuip() %></h2>
                                    </div>
                                    <div class="car-details">
                                        <h2> <%= car.getCarSeats() %> seats <h2>
                                        <h2> <% if(car.getCarFuel().equals("P")) { %>
                                            <%= "Petrol" %>
                                        <% } else if(car.getCarFuel().equals("D")) { %>
                                            <%= "Diesel" %> </h2>
                                        <% } else if(car.getCarFuel().equals("H")) { %>
                                            <%= "Hybrid" %> </h2>
                                        <% } %>
                                        <h2> <%= car.getCarBodyStyle() %></h2>
                                    </div>
                                </div>
                                <a href="#" class="buy">Book Now</a>
                            </div>
                        </div>
                        </a>
                    <% } %>
                    </div>    
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
