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
            <% for(Car car : cars) { %>
            <% String uniqueKey = Integer.toString(car.getCarID()) + car.getCarModel() + car.getCarTrim(); %>
                <form action="/UpdateListingServlet" method="post" autocomplete="off" id="update-listing-form">
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
                                <input type="text" value="<%= car.getCarID() %>" name="id">
                                <input type="text" value="<%= car.getCarMake() %>" name="make<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarModel() %>" name="model<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarTrim() %>" name="trim<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarOdometer() %>" name="odometer<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarImage() %>" name="imageurl<%= uniqueKey %>">
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
                                <input type="text" value="<%= car.getCarTransmission() %>" name="transmission<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarFuel() %>" name="fuel<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarSeats() %>" name="seats<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarBodyStyle() %>" name="bodystyle<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarQuip() %>" name="quip<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarPurchasePrice() %>" name="purchaseprice<%= uniqueKey %>">
                            </div>
                            <div class="table-emulator">
                                <h2>Current Price</h2>
                                <h2>Price Per KM</h2>
                                <h2>Car Rating</h2>
                                <h2>Location ID</h2>
                            </div>
                            <div class="table-emulator">
                                <input type="text" value="<%= car.getCarCurrentPrice() %>" name="currentprice<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarPriceKM() %>" name="pricekm<%= uniqueKey %>">
                                <input type="text" value="<%= car.getCarRating() %>" name="rating<%= uniqueKey %>">
                                <input type="text" value="<%= car.getLocationID() %>" name="locID<%= uniqueKey %>">
                            </div>
                            <button type="submit" class="submit-modal"><i class="fa-solid fa-floppy-disk "></i></button>
                        </div>
                        
                    </div>
                </form>
                <% } %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Modify Listings</h1>
                        <h1><%
                                if(request.getAttribute("errors") != null) {
                                 %>
                                 <div class="errors">
                                    <p>
                                        <%= request.getAttribute("errors") %>
                                    </p>
                                 </div>
                                 <%
                                }
                                %></h1>
                        <div>
                        <form action="/UpdateListingServlet" method="post" autocomplete="off" id="update-listing-form">
                            <div class="control-buttons">
                                <a onclick="editAll()"><i class="fa-solid fa-pencil"></i></a>
                                <button type="submit"><i class="fa-solid fa-floppy-disk"></i></button>
                            </div>
                            
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
                                    <% String uniqueKey = Integer.toString(car.getCarID()) + car.getCarModel() + car.getCarTrim(); %>
                                            <tr>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarID() %>')" id="<%= car.getCarID() %>">
                                                    <p><%= car.getCarID() %></p>
                                                    <input type="text" class="hidden" name="id<%= uniqueKey %>" value="<%= car.getCarID() %>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarMake() + uniqueKey %>')" id="<%= car.getCarMake() + uniqueKey %>">
                                                    <p><%= car.getCarMake() %></p>
                                                    <input type="text" class="hidden" name="make<%= uniqueKey %>" value="<%= car.getCarMake()%>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarModel() + uniqueKey %>')" id="<%= car.getCarModel() + uniqueKey %>">
                                                    <p><%= car.getCarModel()%></p>
                                                    <input type="text" class="hidden" name="model<%= uniqueKey %>" value="<%= car.getCarModel()%>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= Integer.toString(car.getCarOdometer()) + uniqueKey %>')" id="<%= Integer.toString(car.getCarOdometer()) + uniqueKey %>">
                                                    <p><%= car.getCarOdometer() %></p>
                                                    <input type="text" class="hidden" name="odometer<%= uniqueKey %>" value="<%= car.getCarOdometer() %>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarTransmission() + uniqueKey %>')" id="<%= car.getCarTransmission() + uniqueKey %>">
                                                    <p><%= car.getCarTransmission()%></p>
                                                    <input type="text" class="hidden" name="transmission<%= uniqueKey %>" value="<%= car.getCarTransmission() %>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= car.getCarFuel() + uniqueKey %>')" id="<%= car.getCarFuel() + uniqueKey %>">
                                                    <p><%= car.getCarFuel() %></p>
                                                    <input type="text" class="hidden" name="fuel<%= uniqueKey %>" value="<%= car.getCarFuel() %>">
                                                </td>
                                                <td class="bg-not-active" ondblclick="swap('<%= Integer.toString(car.getLocationID()) + uniqueKey  %>')" id="<%= Integer.toString(car.getLocationID()) + uniqueKey %>">
                                                    <p><%= car.getLocationID() %></p>
                                                    <input type="text" class="hidden" name="locID<%= uniqueKey %>" value="<%= car.getLocationID() %>">
                                                </td>
                                                <input type="hidden" value="<%= car.getCarImage() %>" name="imageurl<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarSeats() %>" name="seats<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarBodyStyle() %>" name="bodystyle<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarQuip() %>" name="quip<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarPurchasePrice() %>" name="purchaseprice<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarCurrentPrice() %>" name="currentprice<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarPriceKM() %>" name="pricekm<%= uniqueKey %>">
                                                <input type="hidden" value="<%= car.getCarRating() %>" name="rating<%= uniqueKey %>">
                                                
                                                <td onclick="openModal( <%= car.getCarID()%> + 'overlay')" class="bg-not-active">
                                                   <i class="fa-solid fa-chevron-right"></i>
                                                </td>
                                            </tr>
                                        
                                    <% } %>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>