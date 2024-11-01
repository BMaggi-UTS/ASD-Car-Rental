package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;
import model.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        
        // Gets credentials from login form
        String email = request.getParameter("email");
        String hashedPassword = request.getParameter("password");


        User user = null;
        
     
        try {
            // Finds user in db with matching credentials
            int userID = userDAO.getUserID(email, hashedPassword);
            
            // Finds users role (customer, staff, admin)
            int roleID = userDAO.getRoleID(userID);
            
            // Assigns an instance of customer, staff or admin, depending on the user's role in the db
            switch(roleID) {
                case 1:
                    user = userDAO.createInstanceOfCustomer(email, hashedPassword);
                    session.setAttribute("user", user);
                    session.setAttribute("isStaff", false);
                    break;
                case 2:
                    user = userDAO.createInstanceOfStaff(email, hashedPassword);
                    session.setAttribute("user", user);
                    session.setAttribute("isStaff", true);
                    break;
                case 3:
                    user = userDAO.createInstanceOfAdmin(email, hashedPassword);
                    session.setAttribute("user", user);
                    session.setAttribute("isStaff", true);
                    break;
            }

            // If no user found, sends error message, redirect to login
            if (user == null) {
                session.setAttribute("loginErr", "Email or password is incorrect!");
                response.sendRedirect("login.jsp");
                return;
            }
            // If user found, redirect to index
            else {
                response.sendRedirect("index.jsp");
                return;

            }
        } 
        catch (SQLException | IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
