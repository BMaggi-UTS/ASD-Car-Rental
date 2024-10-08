package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Car;
import model.User;
import model.order;
import model.dao.CarDAO;
import model.dao.orderDAO; 
 


public class addOrderItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");

        User user = (User) session.getAttribute("user");

        int userID = user.getUserID();
        System.out.println("userID assigned: " + userID);
        
        
        // Retrieve parameters from the request
        
        try {
            int carID = Integer.parseInt(request.getParameter("orderCarID"));
            System.out.println("carID assigned: " + carID); 

            Car car = carDAO.selectSpecificCar(carID);

            String pickupDate = request.getParameter("pickupDate");
            System.out.println("pickupDate assigned: " + pickupDate); 


            String dropoffDate = request.getParameter("dropoffDate");
            System.out.println("dropoffDate assigned: " + dropoffDate); 


            // double bookingPrice = Double.parseDouble(request.getParameter("booking-price"));
            String currentDateTime = java.time.LocalDateTime.now().toString(); // Capture current date and time
            System.out.println("curentDateTime assigned: " + currentDateTime); 

            int odometerStart = car.getCarOdometer(); // Retrieve Odometer Start
            System.out.println("odometerStart assigned: " + odometerStart); 

            int odometerFinish = 0; // Retrieve Odometer Finish
            int licenseNumber = Integer.parseInt(request.getParameter("license")); // Retrieve License Number
            System.out.println("licenseNumber assigned: " + licenseNumber); 

            String taxPrice = request.getParameter("tax-fees");
            System.out.println("Tax Price assigned: " + taxPrice); 

            String basePrice = request.getParameter("base-price");
            System.out.println("Base Price assigned: " + basePrice); 

            String totalPrice = request.getParameter("booking-price");
            System.out.println("Total Price assigned: " + totalPrice); 

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
            newOrder.settaxesFeesString(taxPrice);
            newOrder.setbasePriceString(basePrice);
            newOrder.settotalPriceString(totalPrice);

            
            // Save the order using orderDAO
            orderDAO.createOrder(newOrder); // Change to createOrder method
            
            session.setAttribute("orderDetails", newOrder); // Set order details in session
            request.getRequestDispatcher("paymentView.jsp").forward(request, response); // Forward to paymentView
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
