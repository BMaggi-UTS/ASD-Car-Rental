package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import model.dao.CarDAO;
import model.dao.DBConnector;
import model.dao.orderDAO;
import model.dao.paymentDAO;

import model.dao.*;;


public class ConnServlet extends HttpServlet {
    
    private DBConnector db;
    private CarDAO carDAO;
    private UserDAO userDAO;
    private orderDAO orderDAO;
    private paymentDAO paymentDAO;
    private Connection connection;
    
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
            userDAO = new UserDAO(connection);
            orderDAO = new orderDAO(connection);
            paymentDAO = new paymentDAO(connection);
        } catch (SQLException e) {
            System.out.print(e);
        }

        session.setAttribute("carDAO", carDAO);
        session.setAttribute("userDAO", userDAO);
        session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("paymentDAO", paymentDAO);
        System.out.println("All DAOs have been set in session.");
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
