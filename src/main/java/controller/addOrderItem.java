package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.order; 
import model.dao.orderDAO; 
import model.Car; 
import model.dao.CarDAO; 
import model.User; 
import model.dao.UserDAO; 


public class addOrderItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");

        User user = (User) session.getAttribute("user");

        int userID = user.getUserID();
        
        
        // Retrieve parameters from the request

        int carID = Integer.parseInt(request.getParameter("orderCarID")); 
        

        try {
            Car car = carDAO.selectSpecificCar(carID);
            String pickupDate = request.getParameter("pickupDate");
            String dropoffDate = request.getParameter("dropoffDate");
            // double bookingPrice = Double.parseDouble(request.getParameter("booking-price"));
            String currentDateTime = java.time.LocalDateTime.now().toString(); // Capture current date and time
            int odometerStart = car.getCarOdometer(); // Retrieve Odometer Start
            int odometerFinish = 0; // Retrieve Odometer Finish
            int licenseNumber = Integer.parseInt(request.getParameter("licenseNumber")); // Retrieve License Number
    
            // Create a new order object
            order newOrder = new order();
            newOrder.setUserID(userID);
            newOrder.setCarID(carID);
            newOrder.setOrderDateTime(currentDateTime);
            newOrder.setRentalDateStart(pickupDate);
            newOrder.setRentalDateFinish(dropoffDate);
            newOrder.setOdometerStart(odometerStart);
            newOrder.setOdometerFinish(odometerFinish);
            newOrder.setLicenseNumber(licenseNumber);
            
            // Save the order using orderDAO
            orderDAO.createOrder(newOrder); // Change to createOrder method
            
            session.setAttribute("orderDetails", newOrder); // Set order details in session
            request.getRequestDispatcher("orderView.jsp").forward(request, response); // Forward to orderView
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
            session.setAttribute("orderError", "Invalid input provided.");
            response.sendRedirect("index.jsp"); // Redirect back to the main page
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            session.setAttribute("orderError", "An error occurred while processing your order.");
            response.sendRedirect("index.jsp"); // Redirect back to the main page
        } 
    }
}
