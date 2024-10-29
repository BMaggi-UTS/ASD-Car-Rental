<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Car" %>
<html>
<head>
    <title>Admin - Car List</title>
</head>
<body>
    <h1>Car List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Make</th>
            <th>Model</th>
            <th>Trim</th>
            <th>Odometer</th>
            <th>Transmission</th>
            <th>Fuel Type</th>
            <th>Seats</th>
            <th>Body Style</th>
            <th>Purchase Price</th>
            <th>Current Price</th>
        </tr>
        <%
            ArrayList<Car> carList = (ArrayList<Car>) request.getAttribute("carList");
            if (carList != null) {
                for (Car car : carList) {
        %>
        <tr>
            <td><%= car.getCarID() %></td>
            <td><%= car.getMake() %></td>
            <td><%= car.getModel() %></td>
            <td><%= car.getTrim() %></td>
            <td><%= car.getOdometer() %></td>
            <td><%= car.getTransmission() %></td>
            <td><%= car.getFuelType() %></td>
            <td><%= car.getSeats() %></td>
            <td><%= car.getBodyStyle() %></td>
            <td><%= car.getPurchasePrice() %></td>
            <td><%= car.getCurrentPrice() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>