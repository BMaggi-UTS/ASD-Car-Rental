package controller;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.payment;
import model.dao.orderDAO;
import model.dao.paymentDAO; 


public class addPayment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        paymentDAO paymentDAO = (paymentDAO) session.getAttribute("paymentDAO");

        User user = (User) session.getAttribute("user");

        int userID = user.getUserID();
        System.out.println("userID assigned: " + userID);

        int orderID = 0;

        try {
            orderID = orderDAO.getMostRecentOrder(userID);
        } catch (Exception e) {
            System.out.println("getMostRecentOrder Error: " + e.getMessage());
        }
        
        // Retrieve parameters from the request
        
        try {

            String cardName = request.getParameter("cardName");
            String cardNumber = request.getParameter("cardNumber");
            String expiry = request.getParameter("expiryDate");
            String cvc = request.getParameter("cvv");

            // Convert the expiry string to YearMonth
            YearMonth expiryYearMonth;
            try {
                expiryYearMonth = YearMonth.parse(expiry, DateTimeFormatter.ofPattern("yyyy-MM"));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid expiry date format. Expected format: YYYY-MM", e);
            }

            // Create a new order object
            payment newPayment = new payment();

            newPayment.setOrderID(orderID);
            newPayment.setUserID(userID);
            newPayment.setCardName(cardName);
            newPayment.setCardNumber(cardNumber);
            newPayment.setExpiry(expiryYearMonth);
            newPayment.setCvc(cvc);
 
            // Save the payment using paymentDAO
            
            paymentDAO.createPayment(newPayment); 
            System.out.println("Added: " + cardName);
            int recentPay = paymentDAO.getMostRecentPayment(userID);
            System.out.println("Newly added userID: " + recentPay);


            request.getRequestDispatcher("checkoutView.jsp").forward(request, response); // Forward to paymentView

        } catch (Exception e) {
            System.out.println("Servlet Error: " + e.getMessage());
            session.setAttribute("paymentError", "An error occurred while processing your order.");
            response.sendRedirect("index.jsp"); // Redirect back to the main page
        } 
    }
}

