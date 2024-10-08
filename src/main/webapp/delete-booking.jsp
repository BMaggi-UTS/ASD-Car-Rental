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
                        <h1>Delete a listing</h1>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Car ID</th>
                                <th>Order ID</th>
                                <th>Start Date</th>
                                <th>Finish Date</th>
                            </tr>
                            

                            <% for(Availability availability : availabilities) { %>
                            <form action="/DeleteBookingServlet" method="post" autocomplete="off" id="delete-listing-form">>
                                <tr>
                                
                                    <td class="bg-not-active"><p><%= availability.getAvailabilityID() %></p></td>
                                    <td class="bg-not-active"><p><%= availability.getCarID()%></p>  </td>
                                    <td class="bg-not-active"><p><%= availability.getOrderID()%></p> </td>
                                    <td class="bg-not-active"><p><%= availability.getStartDate() %></p></td>
                                     <td class="bg-not-active"><p><%= availability.getFinishDate() %></p></td>
                                    <td class="bg-not-active">
                                        <input type="hidden" value="<%= availability.getAvailabilityID()%>" name="aID">
                                        <button type="submit">submit</button>
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