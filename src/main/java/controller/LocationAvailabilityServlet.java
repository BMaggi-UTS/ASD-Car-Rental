package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Car;
import model.Location;
import model.dao.LocationDAO;
import model.dao.CarDAO;


public class LocationAvailabilityServlet extends HttpServlet {
    public ArrayList<Integer> locationIDs = new ArrayList<>();
    public ArrayList<Location> locations = new ArrayList<>();
    public ArrayList<Integer> carID = new ArrayList<>();
    public ArrayList<Car> cars = new ArrayList<>();
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LocationDAO locationDAO = (LocationDAO) session.getAttribute("locationDAO");
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
        String pickupName = request.getParameter("pickup");
        String dropoffName = request.getParameter("dropoff");
        session.setAttribute("pickupName", pickupName);
        session.setAttribute("dropoffName", dropoffName);
        System.out.println(dropoffName);
        String paymentSelectName = request.getParameter("selected-type");
        Integer expectedKMs = Integer.parseInt("0" + request.getParameter("km-amount"));
        //db error handling
        if (locationDAO == null || carDAO == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "DAO objects not found in session.");
            return;
        }
        
        //date handling
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate pickupDate = LocalDate.parse(request.getParameter("pickup-date"), dateTimeFormat);
            LocalDate dropoffDate = LocalDate.parse(request.getParameter("dropoff-date"), dateTimeFormat);
            long daysBetween = ChronoUnit.DAYS.between(pickupDate, dropoffDate);
            session.setAttribute("pickupDate", pickupDate);
            session.setAttribute("dropoffDate", dropoffDate);
            session.setAttribute("daysBetween", daysBetween);
            System.out.println(daysBetween);
        } catch(DateTimeParseException e) {
            request.setAttribute("errors", "errors");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        
        //location name handling
        try {
            cars = carDAO.fetchCars();
            locations = locationDAO.fetchLocations();
            for(Location location : locations) {
                if (pickupName.equals(location.getLocationName())) {
                    locationIDs.add(location.getLocationID());
                }
            }
            for(int locationID : locationIDs) {
                carID.clear();
                for(Car car : cars) {
                    if (car.getLocationID() == locationID) {
                        carID.add(car.getCarID());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred while fetching locations.");
        }
        if (carID.size() > 0) {
            session.setAttribute("carID", carID);
            session.setAttribute("paymentSelectName", paymentSelectName);
            session.setAttribute("expectedKMs", expectedKMs);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            carID.clear();
        } else {
            carID.add(0);
            session.setAttribute("carID", carID);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            carID.clear();
        }
    }
}