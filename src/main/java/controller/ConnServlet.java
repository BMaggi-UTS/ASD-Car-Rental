package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import model.dao.*;

import java.util.logging.Logger;
import java.util.logging.Level;


public class ConnServlet extends HttpServlet{
    private Connection connection;
    private DBConnector db;

    private CarDAO carDAO;
    private orderDAO orderDAO;
    private UserDAO userDAO;
    private paymentDAO paymentDAO;
    private LocationDAO locationDAO;
    private SupplierDAO supplierDAO;
    private AvailabilityDAO availabilityDAO;
    
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

        // Checks if database connection already established, if not, creates database connection
        connection = (Connection) session.getAttribute("connection");
        if(connection == null) {
            connection = db.openConnection();
            session.setAttribute("connection", connection);
        }
        // Checks if DAOs are already in the session, if they are, it will reuse them to reduce open db connections
        try {
            carDAO = (CarDAO) session.getAttribute("carDAO");
            if(carDAO == null) {
                carDAO = new CarDAO(connection);
                session.setAttribute("carDAO", carDAO);
            }

            userDAO = (UserDAO) session.getAttribute("userDAO");
            if(userDAO == null) {
                userDAO = new UserDAO(connection);
                session.setAttribute("userDAO", userDAO);
            }

            locationDAO = (LocationDAO) session.getAttribute("locationDAO");
            if(locationDAO == null) {
                locationDAO = new LocationDAO(connection);
                session.setAttribute("locationDAO", locationDAO);
            }

            supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");
            if(supplierDAO == null) {
                supplierDAO = new SupplierDAO(connection);
                session.setAttribute("supplierDAO", supplierDAO);
            }

            orderDAO = (orderDAO) session.getAttribute("orderDAO");
            if(orderDAO == null) {
                orderDAO = new orderDAO(connection);
                session.setAttribute("orderDAO", orderDAO);
            }

            paymentDAO = (paymentDAO) session.getAttribute("paymentDAO");
            if(paymentDAO == null) {
                paymentDAO = new paymentDAO(connection);
                session.setAttribute("paymentDAO", paymentDAO);
            }

            availabilityDAO = (AvailabilityDAO) session.getAttribute("availabilityDAO");
            if(availabilityDAO == null) {
                availabilityDAO = new AvailabilityDAO(connection);
                session.setAttribute("availabilityDAO", availabilityDAO);
            }

            System.out.println("All DAOs have been set in session.");

        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
