<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.*"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.*"%>

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
        <%-- //use the connection to create a productDAO controller 
        //CarDAO carDAO = new CarDAO(con); %>
        LocationDAO locationDAO = new LocationDAO(con); --%>
    </head>

    <body>
        <jsp:include page="/ConnServlet"/>
        <% 
            CarDAO carDAO = (CarDAO) session.getAttribute("carDAO"); 
            UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
            LocationDAO locationDAO = (LocationDAO) session.getAttribute("locationDAO");
            User user = (User) session.getAttribute("user");
        %>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <%
                ArrayList<Integer> carIDs = (ArrayList<Integer>) session.getAttribute("searchIDResult");
                ArrayList<Integer> carIDLocation = (ArrayList<Integer>) session.getAttribute("carID");
                String pickupName = (String) session.getAttribute("pickupName");
                String dropoffName = (String) session.getAttribute("dropoffName");
                String paymentSelected = (String) session.getAttribute("paymentSelectName");
                LocalDate pickupDate = (LocalDate) session.getAttribute("pickupDate");
                LocalDate dropoffDate = (LocalDate) session.getAttribute("dropoffDate");
                Integer expectedKMs = (Integer) session.getAttribute("expectedKMs");
                Long daysBetween = (Long) session.getAttribute("daysBetween");
                ArrayList<Car> cars = new ArrayList<Car>();
                if(carIDs == null || carIDs.size() == 0) {
                    if(carIDLocation == null || carIDLocation.size() == 0) {
                        cars = carDAO.fetchCars();
                        %>  <%@ include file="assets/locationAvailabilitySelector.jsp" %>
                            <%@ include file="assets/filterbar.jsp" %>
                        <div class="product-wrapper"> <%
                        carIDs = null;
                        carIDLocation = null;
                    }
                }
                if(carIDs != null && carIDs.size() > 0) {
                    if(carIDs.get(0) == 0 ) { 
                        cars = null;
                    %><%= "No cars found. Please enter a different search term" %><%
                    } else {
                        %> <%@ include file="assets/filterbar.jsp" %>
                        <div class="product-wrapper"> <%
                        cars = carDAO.selectArrayCar(carIDs);
                    }
                }
                if(carIDLocation != null && carIDLocation.size() > 0) {
                    if(carIDLocation.get(0) == 0) {
                        %> <%= "No cars found at this location" %> <%
                    } else { %>
                        <%@ include file="assets/filterbar.jsp" %>
                        <div class="product-wrapper">
                        <% cars = carDAO.selectArrayCar(carIDLocation);
                        carIDLocation = null;
                    }
                } %>
                <% if(cars != null) {
                    for(Car car : cars) { %>
                        <%@ include file="assets/carCards.jsp" %>
                    <% } %>
                    <% cars.clear(); %>
                <% } else {
                    %> <%= "Error loading cars" %> <%
                } %>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
<script src="js/script.js"></script>
<script>
document.getElementById("locationAvailabilityForm").reset();
document.getElementById("pickup-date").min = new Date().toISOString().split("T")[0];
document.getElementById("dropoff-date").min = new Date().toISOString().split("T")[0];

</script>
