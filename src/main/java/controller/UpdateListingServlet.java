package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Car;
import model.dao.CarDAO;

public class UpdateListingServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
        ArrayList<Car> cars;
        try {
            cars = carDAO.fetchCars();
            for(Car car : cars) {
                String uniqueKey = Integer.toString(car.getCarID()) + car.getCarModel() + car.getCarTrim();
                int carID = car.getCarID();
                String carMake = request.getParameter("make" + uniqueKey);
                String carModel = request.getParameter("model" + uniqueKey);
                String carTrim = request.getParameter("trim" + uniqueKey);
                int carOdometer = Integer.parseInt(request.getParameter("odometer" + uniqueKey));
                String carImage = request.getParameter("imageurl" + uniqueKey);
                String carTransmission = request.getParameter("transmission" + uniqueKey);
                String carFuel = request.getParameter("fuel" + uniqueKey);
                int carSeats = Integer.parseInt(request.getParameter("seats" + uniqueKey));
                String carBodyStyle = request.getParameter("bodystyle" + uniqueKey);
                String carQuip = request.getParameter("quip" + uniqueKey);
                int carPurchasePrice = Integer.parseInt(request.getParameter("purchaseprice" + uniqueKey));
                int carCurrentPrice = Integer.parseInt(request.getParameter("currentprice" + uniqueKey));
                int carPriceKM = Integer.parseInt(request.getParameter("pricekm" + uniqueKey));
                int carRating = Integer.parseInt(request.getParameter("rating" + uniqueKey));
                int locationID = Integer.parseInt(request.getParameter("locID" + uniqueKey));
                if(carTransmission.length() != 1) {
                    throw new IllegalArgumentException("Please only enter one character for transmission, e.g. M for manual, A for Automatic");
                }
                if(carFuel.length() != 1) {
                    throw new IllegalArgumentException("Please only enter one character for fuel, e.g. P for petrol, H for hybrid");
                }
                carDAO.updateCar(carID, carMake, carModel, carTrim, carImage, carOdometer, carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
            }
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(NumberFormatException e) {
            request.setAttribute("errors", "Please verify your fields - Only Enter Numbers in Number Fields");
            request.getRequestDispatcher("/modify-listings.jsp").forward(request, response);
            return;
        } catch(MysqlDataTruncation e) {
            request.setAttribute("errors", "Please verify your fields - Fromat Incorrect.");
            request.getRequestDispatcher("/modify-listings.jsp").forward(request, response);
            return;
        } catch(IllegalArgumentException e) {
            request.setAttribute("errors", e.getMessage());
            request.getRequestDispatcher("/modify-listings.jsp").forward(request, response);
            return;
        } catch(Exception e) {
            System.out.println(e);
            request.setAttribute("errors", e);
            request.getRequestDispatcher("/critical-errors.jsp").forward(request, response);
            return;
        }
    }
}