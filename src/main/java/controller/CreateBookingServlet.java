package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.AvailabilityDAO;

public class CreateBookingServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    AvailabilityDAO availabilityDAO = (AvailabilityDAO) session.getAttribute("availabilityDAO");
        int availabilityID;    
        int carID;
        int orderID;
        String startDate;
        String finishDate;
        availabilityID = Integer.parseInt(request.getParameter("aID"));
        carID = Integer.parseInt(request.getParameter("cID"));
        orderID = Integer.parseInt(request.getParameter("oID"));
        startDate = request.getParameter("startDate");
        finishDate = request.getParameter("finishDate");
        try {
            availabilityDAO.createAvailability(availabilityID, carID, orderID, startDate, finishDate);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("/catalogueStaffView.jsp");
        }
     }
}
