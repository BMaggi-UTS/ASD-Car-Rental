<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.DBConnector"%>
<%-- <%@page import="model.location" %> --%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Car Rental</title>
        <% //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector(); %>
            <% //open a connection
            Connection con = conn.openConnection(); %>
            <% //use the connection to create a productDAO controller 
            CarDAO carDAO = new CarDAO(con); %>
            <% LocationDAO locationDAO = new LocationDAO(con); %>
        
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <% ArrayList<Integer> carIDs = (ArrayList<Integer>) session.getAttribute("searchIDResult"); %>
                <% ArrayList<Car> cars = new ArrayList<Car>(); %>
                <% if(carIDs == null || carIDs.size() == 0) { %>
                    <%@ include file="assets/locationAvailabilitySelector.jsp" %>
                    <%@ include file="assets/filterbar.jsp" %>
                    <% cars = carDAO.fetchCars() ;%>
                    <div class="product-wrapper">
                <% } else { %>
                    <% if(carIDs.get(0) == 0) { %>
                        <% cars = null; %>
                        <%= "No cars found. Please enter a different search term" %>
                    <% } else { %>
                        <%@ include file="assets/filterbar.jsp" %>
                        <div class="product-wrapper">
                        <% cars = carDAO.selectArrayCar(carIDs); %>
                    <% } %>
                <% } %>
                <% if(cars != null) {
                    for(Car car : cars) { %>
                        <%@ include file="assets/carCards.jsp" %>
                    <% } %>
                <% } %>
                </div>    
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
<script src="js/script.js"></script>
