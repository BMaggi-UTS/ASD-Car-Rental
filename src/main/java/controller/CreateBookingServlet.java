package controller;

import java.io.IOException;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

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
        
        try {
            int availabilityID = Integer.parseInt(request.getParameter("aID"));
            int carID = Integer.parseInt(request.getParameter("cID"));
            int orderID = Integer.parseInt(request.getParameter("oID"));
            String startDate = request.getParameter("startDate");
            String finishDate = request.getParameter("finishDate");
            availabilityDAO.createAvailability(availabilityID, carID, orderID, startDate, finishDate);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(NumberFormatException e) {
            request.setAttribute("errors", "Please only enter a number for an ID");
            request.getRequestDispatcher("/create-booking.jsp").forward(request, response);
            return;
        } catch(MysqlDataTruncation e) {
            request.setAttribute("errors", "Please enter a date in the format: YYYY-MM-DD");
            request.getRequestDispatcher("/create-booking.jsp").forward(request, response);
            return;
        } catch(Exception e) {
            System.out.println(e);
            request.setAttribute("errors", e);
            request.getRequestDispatcher("/critical-errors.jsp").forward(request, response);
            return;
        }
     }
}
