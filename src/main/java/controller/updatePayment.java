package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.dao.paymentDAO;

public class updatePayment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("bookingPrice", request.getParameter("booking-price"));

        paymentDAO paymentDAO = (paymentDAO) session.getAttribute("paymentDAO");
        User user = (User) session.getAttribute("user");

        // Check if user exists in session
        if (user == null) {
            session.setAttribute("orderError", "User session expired. Please log in again.");
            response.sendRedirect("login.jsp");
            return;
        }

        int userID = user.getUserID();
        System.out.println("UserID: " + userID);

        try {

            int paymentID = paymentDAO.getMostRecentPayment(userID);
 
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

            String expiryAsString = expiryYearMonth.toString();

            
            
            // Call orderDAO to update the driver's license
            paymentDAO.updatePaymentDetails(paymentID, cardName, cardNumber, expiryAsString, cvc);

            // Redirect to the confirmation page or payment view
            request.getRequestDispatcher("checkoutView.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            session.setAttribute("paymentError", "An error occurred while updating payment details.");
            response.sendRedirect("editPaymentView.jsp");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            session.setAttribute("paymentError", "An unexpected error occurred.");
            response.sendRedirect("index.jsp");
        }
    }
}

