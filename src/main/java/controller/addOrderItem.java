// package controller;

// import java.io.IOException;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import model.order; 
// import model.dao.orderDAO; 

// public class addOrderItem extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         HttpSession session = request.getSession();
//         orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        
//         // Retrieve parameters from the request
//         int userID = Integer.parseInt(request.getParameter("userID")); // Retrieves User ID from the request
//         int staffID = Integer.parseInt(request.getParameter("staffID")); // Retrieve Staff ID 
//         int carID = Integer.parseInt(request.getParameter("orderCarID"));
//         String pickupDate = request.getParameter("pickupDate");
//         String dropoffDate = request.getParameter("dropoffDate");
//         double bookingPrice = Double.parseDouble(request.getParameter("booking-price"));
//         String currentDateTime = java.time.LocalDateTime.now().toString(); // Capture current date and time
//         int odometerStart = Integer.parseInt(request.getParameter("odometerStart")); // Retrieve Odometer Start
//         int odometerFinish = Integer.parseInt(request.getParameter("odometerFinish")); // Retrieve Odometer Finish
//         int licenseNumber = Integer.parseInt(request.getParameter("licenseNumber")); // Retrieve License Number

//         try {
//             // Create a new order object
//             order newOrder = new order();
//             newOrder.setUserID(userID);
//             newOrder.setStaffID(staffID);
//             newOrder.setCarID(carID);
//             newOrder.setOrderDateTime(currentDateTime);
//             newOrder.setStatus("Pending"); // Default status, change if needed
//             newOrder.setRentalDateStart(pickupDate);
//             newOrder.setRentalDateFinish(dropoffDate);
//             newOrder.setOdometerStart(odometerStart);
//             newOrder.setOdometerFinish(odometerFinish);
//             newOrder.setLicenseNumber(licenseNumber);
            
//             // Save the order using orderDAO
//             orderDAO.createOrder(newOrder); // Change to createOrder method
            
//             session.setAttribute("orderDetails", newOrder); // Set order details in session
//             request.getRequestDispatcher("orderView.jsp").forward(request, response); // Forward to orderView
//         } catch (NumberFormatException e) {
//             System.out.println("Error parsing number: " + e.getMessage());
//             session.setAttribute("orderError", "Invalid input provided.");
//             response.sendRedirect("index.jsp"); // Redirect back to the main page
//         } catch (Exception e) {
//             System.out.println("Error: " + e.getMessage());
//             session.setAttribute("orderError", "An error occurred while processing your order.");
//             response.sendRedirect("index.jsp"); // Redirect back to the main page
//         }
//     }
// }
