// src/main/java/controller/AdminServlet.java
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.CarDAO;
import model.Car;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true); // Create a new session if one doesn't exist
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", "admin"); // Hard-code a dummy admin user
        }

        String action = request.getParameter("action");

        if ("showCars".equals(action)) {
            try {
                Connection connection = (Connection) getServletContext().getAttribute("DBConnection"); // Assume DB connection is set in context
                if (connection != null) {
                    CarDAO carDAO = new CarDAO(connection);
                    ArrayList<Car> cars = carDAO.fetchCars(); // Fetch cars from the database
                    request.setAttribute("carList", cars); // Pass car data to the JSP
                } else {
                    throw new SQLException("Database connection is null");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }
}