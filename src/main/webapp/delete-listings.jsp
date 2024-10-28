<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <link rel="stylesheet" href="css/staffView.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <script defer src="js/modify-listings.js"></script>
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
    <jsp:include page="/ConnServlet"/>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
             <% ArrayList<Car> cars = carDAO.fetchCars(); %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Delete a listing</h1>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Make</th>
                                <th>Model</th>
                                <th>Odometer</th>
                                <th>Transmission</th>
                                <th>Fuel</th>
                                <th>Location</th>
                                <th>Delete?</th>
                            </tr>
                           

                            <% for(Car car : cars) { %>
                             <form action="/DeleteListingServlet" method="post" autocomplete="off" id="delete-listing-form">
                                <tr>
                                    <td class="bg-not-active"><p><%= car.getCarID()%></p> </td>
                                    <td class="bg-not-active"><p><%= car.getCarMake()%></p> </td>
                                    <td class="bg-not-active"><p><%= car.getCarModel()%></p> </td>
                                    <td class="bg-not-active"><p><%= car.getCarOdometer() %></p></td>
                                    <td class="bg-not-active"><p><%= car.getCarTransmission() %></p></td>
                                    <td class="bg-not-active"><p><%= car.getCarFuel() %></p></td>
                                    <td class="bg-not-active"><p><%= car.getLocationID() %></p></td>
                                    <td class="bg-not-active">
                                        <input type="hidden" value="<%= car.getCarID()%>" name="carID">
                                        <button type="submit">Delete</button>
                                    </td>
                                </tr>
                                </form>
                            <% } %>
                             

                           

                        </table>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>