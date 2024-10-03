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
                            <form action="/DeleteListingServlet" method="post" autocomplete="off" id="delete-listing-form">>

                            <% for(Car car : cars) { %>
                                <tr>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarID() %>')" id="<%= car.getCarID() %>"><p><%= car.getCarID() %></p><input type="text" class="hidden" name="id" value="<%= car.getCarID() %>"></td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarMake() + car.getCarID() %>')" id="<%= car.getCarMake() + car.getCarID()%>"><p><%= car.getCarMake()%></p> <input type="text" class="hidden" name="make" value="<%= car.getCarMake()%>"> </td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarModel() + car.getCarID() %>')" id="<%= car.getCarModel() + car.getCarID()%>"><p><%= car.getCarModel()%></p> <input type="text" class="hidden" name="model" value="<%= car.getCarModel()%>"> </td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarOdometer() + car.getCarID() %>')" id="<%= car.getCarOdometer() + car.getCarID()%>"><p><%= car.getCarOdometer() %></p><input type="text" class="hidden" name="odometer" value="<%= car.getCarOdometer() %>"></td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarTransmission() + car.getCarID() %>')" id="<%= car.getCarTransmission() + car.getCarID() %>"><p><%= car.getCarTransmission() %></p><input type="text" class="hidden" name="transmission" value="<%= car.getCarTransmission() %>"></td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getCarFuel() + car.getCarID() %>')" id="<%= car.getCarFuel() + car.getCarID() %>"><p><%= car.getCarFuel() %></p><input type="text" class="hidden" name="fuel" value="<%= car.getCarFuel() %>"></td>
                                    <td class="bg-not-active" ondblclick="swap('<%= car.getLocationID() + car.getCarMake() + car.getCarID() %>')" id="<%= car.getLocationID() + car.getCarMake() + car.getCarID() %>"><p><%= car.getLocationID() %></p><input type="text" class="hidden" name="locID" value="<%= car.getLocationID() %>"></td>
                                    <td class="bg-not-active">
                                        <input type="checkbox" value="<%= car.getCarID()%>" name="deleteCheckbox[]">
                                    </td>
                                </tr>
                            <% } %>
                            <button type="submit">submit</button>
                            </form>

                        </table>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>