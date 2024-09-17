package controller;

import jakarta.servlet.http.*;
import model.User;
import model.dao.UserDAO;

public class UpdateDetailsServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

        

    }
    
}
