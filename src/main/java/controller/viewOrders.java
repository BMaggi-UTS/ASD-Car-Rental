package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.order;
import model.dao.orderDAO; 
 
public class viewOrders extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            System.out.println("User is null. Redirecting to login.jsp");
            return;
        }

        orderDAO orderDAO = (orderDAO) session.getAttribute("orderDAO");

        int userID = user.getUserID();
        System.out.println(userID);

        try {
            List<order> orders = orderDAO.getOrdersByUserID(userID);
            request.setAttribute("orders", orders); // Set the orders in the request

            // Forward to the JSP page to display the orders
            RequestDispatcher dispatcher = request.getRequestDispatcher("orderHistoryView.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
        }
    }
    
}
