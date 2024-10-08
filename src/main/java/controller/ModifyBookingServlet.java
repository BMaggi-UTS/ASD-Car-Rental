package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.order;
import model.dao.AvailabilityDAO;

public class ModifyBookingServlet extends HttpServlet {
    @Override
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
            System.out.println("a"+availabilityID + " c" + carID + " o" + orderID + startDate + finishDate);
            availabilityDAO.updateAvailability(availabilityID, carID, orderID, startDate, finishDate);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("/catalogueStaffView.jsp");
        }
    }
}