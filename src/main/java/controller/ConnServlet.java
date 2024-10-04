package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import model.dao.CarDAO;
import model.dao.DBConnector;
import model.dao.UserDAO;
import model.dao.orderDAO;
import model.dao.paymentDAO;
import model.dao.LocationDAO;

import model.dao.*;


public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private CarDAO carDAO;
    private orderDAO orderDAO;
    private UserDAO userDAO;
    private paymentDAO paymentDAO;
    private Connection connection;
    private LocationDAO locationDAO;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
            connection = db.openConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Failed to establish database connection.");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("carDAO", carDAO);

        connection = db.openConnection();

        try {
            carDAO = new CarDAO(connection);
            // orderDAO = new orderDAO(connection);
            paymentDAO = new paymentDAO(connection);
            userDAO = new UserDAO(connection);
            
            locationDAO = new LocationDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("carDAO", carDAO);
        // session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("paymentDAO", paymentDAO);
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("locationDAO", locationDAO);
        System.out.println("All DAOs have been set in session.");
        // request.getRequestDispatcher("index.jsp").include(request, response);
    }

    @Override
    public void destroy(){
        try{
            db.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
