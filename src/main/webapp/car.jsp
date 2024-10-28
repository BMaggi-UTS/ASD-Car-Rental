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
        <link rel="stylesheet" href="css/carDetail.css">
        <link rel="stylesheet" href="css/navandfooter.css">

        <%-- <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script> --%>
        <title>Car Rental</title>
        <%
            CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
            String carIdString = request.getParameter("id"); 
            Integer carID = Integer.parseInt(carIdString);
            Car car = carDAO.selectSpecificCar(carID);
        %>
    </head>

    <body>
    <jsp:include page="/ConnServlet"/>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="pic-content-wrapper">
                    <div class="car-pic">
                        <img src="<%= car.getCarImage() %>">
                    </div>
                    <div class="detail-content">
                        <h1><%= car.getCarModel() + " " + car.getCarTrim() %><h1>
                        <h2><%= car.getCarMake() %></h2>
                        <table>
                            <tr>
                                <td><%= car.getCarSeats() %> Seats</td>
                            </tr>
                            <tr>
                                <td><% if(car.getCarFuel().equals("P")) { %>
                                            <%= "Petrol" %>
                                        <% } else if(car.getCarFuel().equals("D")) { %>
                                            <%= "Diesel" %> </h2>
                                        <% } else if(car.getCarFuel().equals("H")) { %>
                                            <%= "Hybrid" %> </h2>
                                        <% } %> Drivetrain</td>
                            </tr>
                            <tr>
                                <td>Fuel Efficient</td>
                            </tr>
                        </table>
                        <h1 class="rental-price"> $179<span>/ day</span></h1>
                        <a href="/" class="dropbtn"> Back to Index </a>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
