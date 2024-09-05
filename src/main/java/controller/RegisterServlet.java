package controller;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.*;
import javax.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        
        String firstName = request.getParameter("fname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");
        String dateOfBirth = request.getParameter("dob");

        String hashedPassword = DigestUtils.sha256Hex(request.getParameter("password"));

        Boolean valid = true;
        try {
            if (userDAO.checkUserExists(email)) {
                session.setAttribute("duplicateErr", "User is already registered with this email!");
                valid = false;
            }
            if (!password.equals(confirmPassword)) {
                session.setAttribute("passwordErr", "Passwords do not match!");
                valid = false;
            }
            if (!RegexUtils.validateEmail(email)) {
                session.setAttribute("emailErr", "Invalid email! Please enter a valid email.");
                valid = false;
            }
            if (!RegexUtils.validateName(firstName)) {
                session.setAttribute("fnameErr", "Invalid first name! Please enter a valid first name.");
                valid = false;   
            }
            if (!RegexUtils.validateName(surname)) {
                session.setAttribute("surnameErr", "Invalid surname! Please enter a valid surname.");
                valid = false;   
            }
            if (!RegexUtils.validatePhoneNo(phone)) {
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid phone number.");
                valid = false;
            }
            if (!RegexUtils.validatePassword(password)) {
                session.setAttribute("passwordErr", "Invalid password! Password cannot be empty.");
                valid = false;   
            }
            if (valid) {
                userDAO.registerNewCustomer(firstName, surname, email, phone, hashedPassword, dateOfBirth);
                request.getRequestDispatcher("login.jsp").include(request, response);
                return;
            }
            else {
                request.getRequestDispatcher("register.jsp").include(request, response);
                return;
            }
        }
        catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
