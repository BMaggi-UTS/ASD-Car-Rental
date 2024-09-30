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
            <% for(Car car : cars) { %>
                <div id="<%=car.getCarID() + "overlay" %>" class="modal-overlay">
                    <div class="modal">
                        <a class="close-btn" onclick="closeModal(<%=car.getCarID()%>)">&times;</a>
                        <h1><%=car.getCarMake() %> <%=car.getCarModel()%></h1>
                        <div class="table-emulator">
                            <h2>ID</h2>
                            <h2>Make</h2>
                            <h2>Model</h2>
                            <h2>Trim</h2>
                            <h2>Odometer</h2>
                            <h2>Image URL</h2>
                        </div>
                        <div class="table-emulator">
                            <input type="text" value="<%= car.getCarID() %>">
                            <input type="text" value="<%= car.getCarMake() %>">
                            <input type="text" value="<%= car.getCarModel() %>">
                            <input type="text" value="<%= car.getCarTrim() %>">
                            <input type="text" value="<%= car.getCarOdometer() %>">
                            <input type="text" value="<%= car.getCarImage() %>">
                        </div>
                        <div class="table-emulator">
                            <h2>Transmission</h2>
                            <h2>Fuel Type</h2>
                            <h2>Seats</h2>
                            <h2>Body Style</h2>
                            <h2>Quip</h2>
                            <h2>Purchase Price</h2>
                        </div>
                        <div class="table-emulator">
                            <input type="text" value="<%= car.getCarTransmission() %>">
                            <input type="text" value="<%= car.getCarFuel() %>">
                            <input type="text" value="<%= car.getCarSeats() %>">
                            <input type="text" value="<%= car.getCarBodyStyle() %>">
                            <input type="text" value="<%= car.getCarQuip() %>">
                            <input type="text" value="<%= car.getCarPurchasePrice() %>">
                        </div>
                        <div class="table-emulator">
                            <h2>Current Price</h2>
                            <h2>Price Per KM</h2>
                            <h2>Car Rating</h2>
                            <h2>Location ID</h2>
                        </div>
                        <div class="table-emulator">
                            <input type="text" value="<%= car.getCarCurrentPrice() %>">
                            <input type="text" value="<%= car.getCarPriceKM() %>">
                            <input type="text" value="<%= car.getCarRating() %>">
                            <input type="text" value="<%= car.getLocationID() %>">
                        </div>
                    </div>
                </div>
                <% } %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Modify Listings</h1>
                        <div>
                            <div class="control-buttons">
                                <a onclick="editAll()"><i class="fa-solid fa-pencil"></i></a>
                                <a onclick=""><i class="fa-solid fa-floppy-disk"></i></a>
                            </div>
                            <form action="/updateListingServlet" method="post" autocomplete="off" id="update-listing-form">
                                <table>
                                    <tr>
                                        <th>ID</th>
                                        <th>Make</th>
                                        <th>Model</th>
                                        <th>Odometer</th>
                                        <th>Transmission</th>
                                        <th>Fuel</th>
                                        <th>Location</th>
                                        <th>More Details</th>
                                    </tr>
                                    <% for(Car car : cars) { %>
                                            <tr>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarID() %>')" id="<%= car.getCarID() %>"><p><%= car.getCarID() %></p><input type="text" class="hidden" name="id"></td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarMake() + car.getCarID() %>')" id="<%= car.getCarMake() + car.getCarID()%>"><p> <%= car.getCarMake()%></p> <input type="text" class="hidden" name="make"> </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarModel() + car.getCarID() %>')" id="<%= car.getCarModel() + car.getCarID()%>"><p> <%= car.getCarModel()%></p> <input type="text" class="hidden" name="model"> </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarOdometer() + car.getCarID() %>')" id="<%= car.getCarOdometer() + car.getCarID()%>"><p><%= car.getCarOdometer() %></p><input type="text" class="hidden" name="odometer"></td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarTransmission() + car.getCarID() %>')" id="<%= car.getCarTransmission() + car.getCarID() %>"><p><%= car.getCarTransmission() %></p><input type="text" class="hidden" name="transmission"></td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarFuel() + car.getCarID() %>')" id="<%= car.getCarFuel() + car.getCarID() %>"><p><%= car.getCarFuel() %></p><input type="text" class="hidden" name="fuel"></td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getLocationID() + car.getCarMake() + car.getCarID() %>')" id="<%= car.getLocationID() + car.getCarMake() + car.getCarID() %>"><p><%= car.getLocationID() %></p><input type="text" class="hidden" name="locID"></td>
                                                <td class="bg-not-active">
                                                    <button onclick="openModal( <%= car.getCarID()%> + 'overlay')"><i class="fa-solid fa-chevron-right"></i></button>
                                                </td>
                                            </tr>
                                        
                                    <% } %>
                                </table>
                                <button type="submit">aaa</button>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>