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
        <%-- <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script> --%>
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
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <h1>Sydney Car Rental</h1>
                <h2>All your car hire needs in one convenient website</h2>
                    <div class="product-wrapper">
                     <a href="/car.jsp">
                        <div class="card">
                            <div class="imgBox">
                                <img src="assets/imgs/mg3.webp" alt="mg3" class="car">
                            </div>
                            <div class="contentBox">
                                <div class="card-content">
                                    <div class="name-price">
                                        <h3>All new MG3</h3>
                                        <h2 class="price">$182 <span>/ a day</span></h2>
                                        <h2 class="price">Unlimited kms</h2>
                                    </div>
                                    <div class="car-details">
                                        <h2> 5 seats <h2>
                                        <h2> Hybrid </h2>
                                        <h2> Fuel Efficient </h2>
                                    </div>
                                </div>
                                <a href="#" class="buy">Book Now</a>
                            </div>
                        </div>
                        </a>
                        <div class="card">
                            <div class="imgBox">
                                <img src="assets/imgs/mg3.webp" alt="mg3" class="car">
                            </div>
                            <div class="contentBox">
                                <div class="card-content">
                                    <div class="name-price">
                                        <h3>All new MG3</h3>
                                        <h2 class="price">$182 <span>/ a day</span></h2>
                                        <h2 class="price">Unlimited kms</h2>
                                    </div>
                                    <div class="car-details">
                                        <h2> 5 seats <h2>
                                        <h2> Hybrid </h2>
                                        <h2> Fuel Efficient </h2>
                                    </div>
                                </div>
                                <a href="#" class="buy">Book Now</a>
                            </div>
                        </div>
                    </div>    
            <main class="main-container">
                <h1>Sydney Car Rental</h1>
                <h2>All your car hire needs in one convenient website</h2>
                <% ArrayList<Car> cars = carDAO.fetchCars(); %>
                <% for(Car car : cars) { %>
                    <%= car.getCarMake() %>
                <% } %>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
