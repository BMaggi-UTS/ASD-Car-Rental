package controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.order;
import model.dao.orderDAO;
import model.dao.paymentDAO;

public class deletePayment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        paymentDAO paymentDAO = (paymentDAO) session.getAttribute("paymentDAO");
        User user = (User) session.getAttribute("user");

        // Check if user is logged in
        if (user == null) {
            session.setAttribute("orderError", "User session expired. Please log in again.");
            response.sendRedirect("login.jsp");
            return;
        }

        int userID = user.getUserID();

        try {
            // Fetch the most recent payment for the user
            int deletePaymentID = paymentDAO.getMostRecentPayment(userID);

            System.out.println("Deleting: " + deletePaymentID);

            paymentDAO.deletePayment(deletePaymentID);
            session.setAttribute("paymentMessage", "Payment deleted successfully.");

            // Redirect
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            System.out.println("Error deleting order: " + e.getMessage());
            session.setAttribute("orderError", "An error occurred while deleting the order.");
            response.sendRedirect("paymentView.jsp");
        }
    }
}


