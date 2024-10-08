package controller;

import java.io.IOException;
// import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;

import model.dao.CarDAO;

public class DeleteListingServlet extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
        int carID;

        carID = Integer.parseInt(request.getParameter("carID"));

        try {
            carDAO.deleteCar(carID);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("/catalogueStaffView.jsp");
        }
    }
}
