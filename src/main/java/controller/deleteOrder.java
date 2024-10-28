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

public class deleteOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");
        User user = (User) session.getAttribute("user");

        // Check if user is logged in
        if (user == null) {
            session.setAttribute("orderError", "User session expired. Please log in again.");
            response.sendRedirect("login.jsp");
            return;
        }

        int userID = user.getUserID();

        try {
            // Fetch the most recent order for the user
            int deleteOrderID = orderDAO.getMostRecentOrder(userID);

            orderDAO.deleteOrder(deleteOrderID);
            session.setAttribute("orderMessage", "Order deleted successfully.");

            // Redirect or forward to an appropriate page (e.g., ordersView.jsp)
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            System.out.println("Error deleting order: " + e.getMessage());
            session.setAttribute("orderError", "An error occurred while deleting the order.");
            response.sendRedirect("paymentView.jsp");
        }
    }
}

