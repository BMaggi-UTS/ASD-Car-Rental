package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import model.dao.CarDAO;
import model.dao.DBConnector;
import model.dao.UserDAO;
<<<<<<< HEAD
// import model.dao.orderDAO;
import model.dao.paymentDAO;
import model.dao.LocationDAO;
import model.dao.AvailabilityDAO;
=======
import model.dao.orderDAO;
import model.dao.paymentDAO;
import model.dao.LocationDAO;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

import model.dao.*;


public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private CarDAO carDAO;
<<<<<<< HEAD
    // private orderDAO orderDAO;
=======
    private orderDAO orderDAO;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    private UserDAO userDAO;
    private paymentDAO paymentDAO;
    private Connection connection;
    private LocationDAO locationDAO;
<<<<<<< HEAD
    private SupplierDAO supplierDAO;
    private AvailabilityDAO availabilityDAO;
=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    
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
<<<<<<< HEAD
=======
        session.setAttribute("carDAO", carDAO);
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

        connection = db.openConnection();

        try {
            carDAO = new CarDAO(connection);
<<<<<<< HEAD
            // orderDAO = new orderDAO(connection);
            paymentDAO = new paymentDAO(connection);
            userDAO = new UserDAO(connection);
            locationDAO = new LocationDAO(connection);
            supplierDAO = new SupplierDAO(connection);
            availabilityDAO = new AvailabilityDAO(connection);

=======
            orderDAO = new orderDAO(connection);
            paymentDAO = new paymentDAO(connection);
            userDAO = new UserDAO(connection);
            
            locationDAO = new LocationDAO(connection);
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("carDAO", carDAO);
<<<<<<< HEAD
        // session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("paymentDAO", paymentDAO);
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("locationDAO", locationDAO);
        session.setAttribute("supplierDAO", supplierDAO);
        session.setAttribute("availabilityDAO", availabilityDAO);
=======
        session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("paymentDAO", paymentDAO);
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("locationDAO", locationDAO);
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
