package controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Car;
import model.Location;
<<<<<<< HEAD
// import model.Availability;
import model.dao.LocationDAO;
import model.dao.CarDAO;
// import model.dao.AvailabilityDAO;
=======
import model.dao.LocationDAO;
import model.dao.CarDAO;
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620


public class LocationAvailabilityServlet extends HttpServlet {
    public ArrayList<Integer> locationIDs = new ArrayList<>();
    public ArrayList<Location> locations = new ArrayList<>();
    public ArrayList<Integer> carID = new ArrayList<>();
    public ArrayList<Car> cars = new ArrayList<>();
    
<<<<<<< HEAD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            LocationDAO locationDAO = (LocationDAO) session.getAttribute("locationDAO");
            CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
            
            cars = carDAO.fetchCars();
            String paymentSelectName = request.getParameter("selected-type");
            Integer expectedKMs = Integer.parseInt("0" + request.getParameter("km-amount"));
            
            
            //availability handling may throw DateTimeParseException
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
=======
    
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
            LocalDate pickupDate = LocalDate.parse(request.getParameter("pickup-date"), dateTimeFormat);
            LocalDate dropoffDate = LocalDate.parse(request.getParameter("dropoff-date"), dateTimeFormat);
            long daysBetween = ChronoUnit.DAYS.between(pickupDate, dropoffDate);
            session.setAttribute("pickupDate", pickupDate);
            session.setAttribute("dropoffDate", dropoffDate);
            session.setAttribute("daysBetween", daysBetween);
<<<<<<< HEAD
            if(daysBetween < 0) {
                throw new IllegalArgumentException("Date finished must be later than date started");
            }


            //location handling
            String pickupName = request.getParameter("pickup");
            String dropoffName = request.getParameter("dropoff");
            session.setAttribute("pickupName", pickupName);
            session.setAttribute("dropoffName", dropoffName);
=======
            System.out.println(daysBetween);
        } catch(DateTimeParseException e) {
            request.setAttribute("errors", "errors");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        
        //location name handling
        try {
            cars = carDAO.fetchCars();
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
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


        } catch (DateTimeParseException e) {
            request.setAttribute("errors", "Date Error");
            request.getRequestDispatcher("/").forward(request, response);
            return;
        } catch(IllegalArgumentException e) {
            request.setAttribute("errors", e.getMessage());
            request.getRequestDispatcher("/").forward(request, response);
            return;
        }catch (Exception e) {
            System.out.println(e);
            request.setAttribute("errors", e);
            request.getRequestDispatcher("/critical-errors.jsp").forward(request, response);
            return;
=======
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
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        }
    }
}