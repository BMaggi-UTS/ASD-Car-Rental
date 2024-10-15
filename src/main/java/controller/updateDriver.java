package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.dao.orderDAO;

public class updateDriver extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
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
            // Retrieve license number from request
            String licenseNumber = request.getParameter("license");
            System.out.println("License Number: " + licenseNumber);

            // Call orderDAO to update the driver's license
            orderDAO.updateDriverDetails(userID, licenseNumber);

            // Redirect to the confirmation page or payment view
            request.getRequestDispatcher("paymentView.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            session.setAttribute("orderError", "An error occurred while updating driver details.");
            response.sendRedirect("editDriverView.jsp");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            session.setAttribute("orderError", "An unexpected error occurred.");
            response.sendRedirect("confirmationView.jsp");
        }
    }
}
