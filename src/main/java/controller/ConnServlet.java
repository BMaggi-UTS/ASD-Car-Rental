package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CarDAO;
import model.dao.DBConnector;
// import model.dao.orderDAO;
import model.dao.paymentDAO;
import model.dao.LocationDAO;

import model.dao.*;


public class ConnServlet extends HttpServlet{
    private DBConnector db;
    private Connection conn;
    private CarDAO carDAO;
    // private orderDAO orderDAO;
    private paymentDAO paymentDAO;
    private Connection connection;
    private LocationDAO locationDAO;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
            conn = db.openConnection();
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
            locationDAO = new LocationDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("carDAO", carDAO);
        // session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("paymentDAO", paymentDAO);
        session.setAttribute("locationDAO", locationDAO);
        System.out.println("All DAOs have been set in session.");
        request.getRequestDispatcher("index.jsp").include(request, response);
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
