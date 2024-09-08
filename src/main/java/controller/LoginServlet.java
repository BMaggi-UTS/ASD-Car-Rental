package controller;

import org.apache.commons.codec.digest.DigestUtils;

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
        
        String email = request.getParameter("email");
        String hashedPassword = DigestUtils.sha256Hex(request.getParameter("password"));


        User user = null;
        
     
        try {
            int userID = userDAO.getUserID(email, hashedPassword);
            int roleID = userDAO.getRoleID(userID);
            
            switch(roleID) {
                case 1:
                    user = userDAO.createInstanceOfCustomer(email, hashedPassword);
                    session.setAttribute("user", user);
                    break;
                case 2:
                    user = userDAO.createInstanceOfStaff(email, hashedPassword);
                    session.setAttribute("user", user);
                    break;
                case 3:
                    user = userDAO.createInstanceOfAdmin(email, hashedPassword);
                    session.setAttribute("user", user);
                    break;
            }

            if (user == null) {
                session.setAttribute("loginErr", "Email or password is incorrect!");
                request.getRequestDispatcher("login.jsp").include(request, response);
                return;
            }
            else {
                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        } 
        catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
