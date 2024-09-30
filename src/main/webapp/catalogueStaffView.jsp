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
        <title>Car Rental</title>
        <% //initiate a connection using DBConnector (connect to the db)
        DBConnector conn = new DBConnector(); %>
        <% //open a connection
        Connection con = conn.openConnection(); %>
        <% //use the connection to create a productDAO controller 
        CarDAO carDAO = new CarDAO(con);
        LocationDAO locationDAO = new LocationDAO(con); %>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Catalogue Management Portal</h1>
                        <p>Here you can manage all of your needs with the current catalogue selection.</p>
                        <div class="option-box-wrapper">
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-user box-icon"></i>
                                    <p>Manage Booking</p>
                                </div>
                            </a>
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-folder-open box-icon"></i>
                                    <p>New Booking</p>
                                </div>
                            </a>
                            <a class="option-box" href="modify-listings.jsp">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-car box-icon"></i>
                                    <p>Modify Listings</p>
                                </div>
                            </a>
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-car-on box-icon"></i>
                                    <p>Add Listing</p>
                                </div>
                            </a>
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-car-burst box-icon"></i>
                                    <p>Delete Listing</p>
                                </div>
                            </a>
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-headset box-icon"></i>
                                    <p>Bookings Audit</p>
                                </div>
                            </a>
                            <a class="option-box" href="#">
                                <div class="inside-option-box">
                                    <i class="fa-solid fa-envelope box-icon"></i>
                                    <p>Catalogue Audit</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
