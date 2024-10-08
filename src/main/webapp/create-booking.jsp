<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.LocationDAO"%>
<%@page import="model.dao.AvailabilityDAO"%>
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
        <% AvailabilityDAO availabilityDAO = new AvailabilityDAO(con); %>
    </head>

    <body>
    <jsp:include page="/ConnServlet"/>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
             <% ArrayList<Availability> availabilities = availabilityDAO.fetchAllAvailability(); %>
             <% int lastID = availabilities.get(availabilities.size()-1).getAvailabilityID(); %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Create a new booking</h1>
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
                        <form action="/CreateBookingServlet" method="post" autocomplete="off" id="update-listing-form">
                            <div class="table-emulator">
                                <h2>ID</h2>
                                <h2>Car ID</h2>
                                <h2>Order ID</h2>
                                <h2>Start Date</h2>
                                <h2>Finish Date</h2>
                            </div>
                            <div class="table-emulator">
                                <input type="text" name="aID" value="<%= lastID + 1 %>">
                                <input type="text" name="cID">
                                <input type="text" name="oID">
                                <input type="text" name="startDate" placeholder="YYYY-MM-DD">
                                <input type="text" name="finishDate" placeholder="YYYY-MM-DD">
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