package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

import java.util.logging.Logger;
import java.util.logging.Level;

import model.User;
import model.dao.UserDAO;

public class UpdateDetailsServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        User user = (User) session.getAttribute("user");
        int userID = user.getUserID();

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("surname");
        String prefName = request.getParameter("prefname");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");

        try {

            Boolean valid = true;
            if (!RegexUtils.validateName(firstName)) {
                session.setAttribute("fnameErr", "Invalid first name! Please enter a valid first name.");
                valid = false; 
            }
            if (!RegexUtils.validateName(lastName)) {
                session.setAttribute("surnameErr", "Invalid surname! Please enter a valid surname.");
                valid = false;   
            }
            if (!RegexUtils.validatePhoneNo(phone)) {
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid phone number.");
                valid = false;
            }
            if (valid) {

                userDAO.updateFirstName(userID, firstName);
                userDAO.updateLastName(userID, lastName);
                userDAO.updatePreferredName(userID, prefName);
                userDAO.updatePhoneNumber(userID, phone);
                userDAO.updateDateOfBirth(userID, dob);

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPreferredName(prefName);
                user.setPhone(phone);
                user.setDateOfBirth(dob);

                response.sendRedirect("/settings.jsp");
                return;
            }
            else {
                response.sendRedirect("/settings.jsp");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UpdateDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        User user = (User) session.getAttribute("user");
        int userID = user.getUserID();
        
        try {
            userDAO.deleteUser(userID);
        }
        catch (SQLException ex) {
            Logger.getLogger(UpdateDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        session.setAttribute("user", null);

        response.sendRedirect("login.jsp");
    }

    
}
