<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.*"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Car Rental</title>
        <% //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector(); %>
            <% //open a connection
            Connection con = conn.openConnection(); %>
            <% //use the connection to create a productDAO controller
            CarDAO carDAO = new CarDAO(con);
            UserDAO userDAO = new UserDAO(con);
            %>
        
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <h1>Sydney Car Rental</h1>
                <h2>All your car hire needs in one convenient website</h2>
                <% ArrayList<Car> cars = carDAO.fetchCars(); %>
                <% for(Car car : cars) { %>
                    <%= car.getCarMake() %>
                <% } %>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
<!-- test -->
