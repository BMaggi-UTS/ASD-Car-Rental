package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Availability;
import model.dao.AvailabilityDAO;

public class ModifyBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AvailabilityDAO availabilityDAO = (AvailabilityDAO) session.getAttribute("availabilityDAO");
        ArrayList<Availability> availabilities;
        try {
            availabilities = availabilityDAO.fetchAllAvailability();
            
            for(Availability availability : availabilities) {
                
                int availabilityID = availability.getAvailabilityID();
                int carID = Integer.parseInt(request.getParameter("cID" + availability.getAvailabilityID()));
                int orderID = Integer.parseInt(request.getParameter("oID" + availability.getAvailabilityID()));
                String startDate = request.getParameter("startDate" + availability.getAvailabilityID());
                String finishDate = request.getParameter("finishDate" + availability.getAvailabilityID());
                
                availabilityDAO.updateAvailability(availabilityID, carID, orderID, startDate, finishDate);
            }
            
            response.sendRedirect("/catalogueStaffView.jsp");
        // } 
        // catch(NumberFormatException e) {
        //     request.setAttribute("errors", "Please only enter a number for an ID");
        //     request.getRequestDispatcher("/modify-booking.jsp").forward(request, response);
        //     return;
        } catch(MysqlDataTruncation e) {
            request.setAttribute("errors", "Please enter a date in the format: YYYY-MM-DD");
            request.getRequestDispatcher("/modify-booking.jsp").forward(request, response);
            return;
        } catch(Exception e) {
            System.out.println(e);
            request.setAttribute("errors", e);
            request.getRequestDispatcher("/critical-errors.jsp").forward(request, response);
            return;
        } 
    }
}