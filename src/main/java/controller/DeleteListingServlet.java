package controller;

import java.io.IOException;
// import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;

// import model.Car;
// import model.dao.CarDAO;

public class DeleteListingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String[] idList = request.getParameterValues("deleteCheckbox");
        System.out.println(idList);
     }
}
