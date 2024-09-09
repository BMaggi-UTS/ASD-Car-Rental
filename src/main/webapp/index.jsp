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
                <div class="location-availability-wrapper">
                    <h1>Sydney Car Rental</h1>
                    <div class="location-selector">
                        <div class="location-selector-wrapper">
                            <div class="selector-wrapper">
                                <p class="label">Pickup</p>
                                <div class="pickup pickme">
                                    <input Type="text" placeholder="Search..." id="pickup" onkeyup="filterFunction()" class="selector" autocomplete="off">
                                    <div id="search-results" class="pickme">
                                        <button onclick="clickResultPickup('Sydney')">Sydney</button>
                                        <button onclick="clickResultPickup('Brisbane')">Brisbane</button>
                                        <button onclick="clickResultPickup('Adelaide')">Adelaide</button>
                                    </div>
                                </div>
                            </div>

                            <div class="selector-wrapper">
                                <p class="label">Dropoff</p>
                                <div class="dropoff pickme">   
                                    <input Type="text" placeholder="Search..." id="dropoff" onkeyup="filterFunction2()" class="selector" autocomplete="off">
                                    <div id="search-results2" class="pickme">
                                        <button onclick="clickResultPickup2('Sydney')">Sydney</button>
                                        <button onclick="clickResultPickup2('Brisbane')">Brisbane</button>
                                        <button onclick="clickResultPickup2('Adelaide')">Adelaide</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="price-selector-wrapper selector-wrapper" id="priceorkm">
                            <button onclick="darken('day')" id="day" class="not-selected">Pay by day</button>
                            <button onclick="darken('km')" id="km" class="not-selected">Pay by KM</button>
                        </div>
                        <div class="km-wrapper" id="km-holder">
                            <p>Estimated travel kms</p>
                            <input type="text" placeholder="1234">
                        </div>
                    </div>
                    <div class="availability-selector">
                        <div class="date-wrapper">
                            <input type="date">
                            <input type="date">
                        </div>
                        <div class="price-selector-wrapper selector-wrapper" id="age">
                            <button onclick="darken('day')" id="day" class="not-selected">21-25</button>
                            <button onclick="darken('km')" id="km" class="not-selected">25+</button>
                        </div>
                        <div class="submit-search">
                            <input type="submit" value="Search">
                        </div>
                    </div>
                </div>
                <div class="filter-bar-wrapper">
                    <div class="filter-bar-search-wrapper">
                        <input type="text" class="filter-bar-search" placeholder="Search...">
                        <i class="fa-solid fa-magnifying-glass filter-bar-search-wrapper-i"></i>
                        </input>
                    </div>
                    <%-- <div class="spacer">
                    </div> --%>
                    <div class="filter-bar-wrapper-div">
                        <i class="fa-solid fa-sort"></i>
                    </div>
                    <div class="filter-bar-wrapper-div filter-icon-border">
                        <i class="fa-solid fa-filter"></i>
                    </div>
                </div>
                <div class="product-wrapper">
                <% ArrayList<Car> cars = carDAO.fetchCars(); %>
                <% for(Car car : cars) { %>
                <a href="/car.jsp?id=<%= car.getCarID() %>">
                    <div class="card">
                        <div class="imgBox">
                            <img src="<%= car.getCarImage() %>" alt="<%= car.getCarMake() %>" class="car">
                            <div class="make-model">
                                <h3><%= car.getCarMake() %></h3>
                                <h3><%= car.getCarModel() %></h3>
                            </div>
                        </div>
                        <hr>
                        <div class="contentBox">
                            <div class="card-content">
                                <div class="car-details">
                                    <div>
                                        <i class="fa-solid fa-chair"></i>
                                        <h2> <%= car.getCarSeats() %> Seats </h2>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-gas-pump"></i>
                                        <h2> 
                                        <% if(car.getCarFuel().equals("P")) { %>
                                            <%= "Petrol" %>
                                        <% } else if(car.getCarFuel().equals("D")) { %>
                                            <%= "Diesel" %>
                                        <% } else if(car.getCarFuel().equals("H")) { %>
                                            <%= "Hybrid" %>
                                        <% } %>
                                        </h2>
                                    </div>
                                    <div>
                                        <i class="fa-solid fa-car-side"></i>
                                        <h2> <%= car.getCarBodyStyle() %></h2>
                                    </div>
                                </div>
                                <div class="detail-price">
                                    <h2>$<%= car.getCarPriceKM() %> <span>/ a KM</span></h2>
                                    <h2><%= car.getCarQuip() %></h2>
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
<script src="js/script.js"></script>
