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
        AvailabilityDAO availabilityDAO = new AvailabilityDAO(con); %>
    </head>

    <body>
    <jsp:include page="/ConnServlet"/>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
             <% ArrayList<Availability> availabilities = availabilityDAO.fetchAllAvailability(); %>
                <div class="product-wrapper br-top">
                    <div class="option-container">
                        <h1>Modify Bookings</h1>
                        <div>
                        <form action="/ModifyBookingServlet" method="post" autocomplete="off" id="update-listing-form">
                            <div class="control-buttons">
                                <a onclick="editAll()"><i class="fa-solid fa-pencil"></i></a>
                                <button type="submit"><i class="fa-solid fa-floppy-disk"></i></button>
                            </div>
                            
                                <table>
                                    <tr>
                                        <th>ID</th>
                                        <th>Car ID</th>
                                        <th>Order ID</th>
                                        <th>Start Date</th>
                                        <th>Finish Date</th>
                                    </tr>
                                    <% for (Availability availability : availabilities) { %>
                                        <tr>
                                            <td class="bg-not-active" ondblclick="swap('<%= availability.getAvailabilityID() %>')" id="<%= availability.getAvailabilityID() %>">
                                                <p><%= availability.getAvailabilityID() %></p>
                                                <input type="text" class="hidden" name="aID" value="<%= availability.getAvailabilityID() %>">
                                            </td>
                                            <td class="bg-not-active" ondblclick="swap('<%= availability.getCarID() + availability.getAvailabilityID() + 88 %>')" id="<%= availability.getCarID() + availability.getAvailabilityID() + 88 %>">
                                                <p><%= availability.getCarID() %></p>
                                                <input type="text" class="hidden" name="cID" value="<%= availability.getCarID()%>">
                                            </td>
                                            <td class="bg-not-active" ondblclick="swap('<%= availability.getOrderID() + availability.getAvailabilityID() + 99 %>')" id="<%= availability.getOrderID() + availability.getAvailabilityID() + 99 %>">
                                                <p><%= availability.getOrderID() %></p>
                                                <input type="text" class="hidden" name="oID" value="<%= availability.getOrderID()%>">
                                            </td>
                                            <td class="bg-not-active" ondblclick="swap('<%= availability.getStartDate() + availability.getAvailabilityID() %>')" id="<%= availability.getStartDate() + availability.getAvailabilityID() %>">
                                                <p><%= availability.getStartDate() %></p>
                                                <input type="text" class="hidden" name="startDate" value="<%= availability.getStartDate() %>">
                                            </td>
                                            <td class="bg-not-active" ondblclick="swap('<%= availability.getFinishDate() + availability.getAvailabilityID() %>')" id="<%= availability.getFinishDate() + availability.getAvailabilityID() %>">
                                                <p><%= availability.getFinishDate() %></p>
                                                <input type="text" class="hidden" name="finishDate" value="<%= availability.getFinishDate() %>">
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