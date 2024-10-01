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
             <% int lastID = cars.get(cars.size()-1).getCarID(); %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Create a new listing</h1>
                        <form action="/CreateListingServlet" method="post" autocomplete="off" id="update-listing-form">
                            <div class="table-emulator">
                                <h2>ID</h2>
                                <h2>Make</h2>
                                <h2>Model</h2>
                                <h2>Trim</h2>
                                <h2>Odometer</h2>
                                <h2>Image URL</h2>
                            </div>
                            <div class="table-emulator">
                                <input type="text" name="id" value="<%= lastID + 1 %>">
                                <input type="text" name="make">
                                <input type="text" name="model">
                                <input type="text" name="trim">
                                <input type="text" name="odometer">
                                <input type="text" name="imageurl">
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
                                <input type="text" name="transmission">
                                <input type="text" name="fuel">
                                <input type="text" name="seats">
                                <input type="text" name="bodystyle">
                                <input type="text" name="quip">
                                <input type="text" name="purchaseprice">
                            </div>
                            <div class="table-emulator">
                                <h2>Current Price</h2>
                                <h2>Price Per KM</h2>
                                <h2>Car Rating</h2>
                                <h2>Location ID</h2>
                            </div>
                            <div class="table-emulator">
                                <input type="text" name="currentprice">
                                <input type="text" name="pricekm">
                                <input type="text" name="rating">
                                <input type="text" name="locID">                        
                            </div>
                            <button type="submit" class="submit-modal"><i class="fa-solid fa-floppy-disk "></i></button>
                        </form>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>