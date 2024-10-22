package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
<<<<<<< HEAD
// import model.User;
// import model.dao.UserDAO;
=======
import model.User;
import model.dao.UserDAO;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

public class UpdateDetailsServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

<<<<<<< HEAD
        // HttpSession session = request.getSession();
        // User user = (User) session.getAttribute("user");
        // UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
=======
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620

        

    }
    
}
