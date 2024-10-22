package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.AvailabilityDAO;

public class DeleteBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AvailabilityDAO availabilityDAO = (AvailabilityDAO) session.getAttribute("availabilityDAO");
        int availabilityID;

        availabilityID = Integer.parseInt(request.getParameter("aID"));

        try {
            availabilityDAO.deleteAvailability(availabilityID);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("/catalogueStaffView.jsp");
        }
    }
}