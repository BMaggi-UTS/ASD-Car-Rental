package controller;

import java.io.IOException;

<<<<<<< HEAD
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

=======
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.CarDAO;

<<<<<<< HEAD
public class UpdateListingServlet extends HttpServlet {
=======
public class UpdateListingServlet extends HttpServlet{
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
<<<<<<< HEAD
        
        try {
            int carID = Integer.parseInt(request.getParameter("id"));
            String carMake = request.getParameter("make");
            String carModel = request.getParameter("model");
            String carTrim = request.getParameter("trim");
            int carOdometer = Integer.parseInt(request.getParameter("odometer"));
            String carImage = request.getParameter("imageurl");
            String carTransmission = request.getParameter("transmission");
            String carFuel = request.getParameter("fuel");
            int carSeats = Integer.parseInt(request.getParameter("seats"));
            String carBodyStyle = request.getParameter("bodystyle");
            String carQuip = request.getParameter("quip");
            int carPurchasePrice = Integer.parseInt(request.getParameter("purchaseprice"));
            int carCurrentPrice = Integer.parseInt(request.getParameter("currentprice"));
            int carPriceKM = Integer.parseInt(request.getParameter("pricekm"));
            int carRating = Integer.parseInt(request.getParameter("rating"));
            int locationID = Integer.parseInt(request.getParameter("locID"));
            if(carTransmission.length() != 1) {
                throw new IllegalArgumentException("Please only enter one character for transmission, e.g. M for manual, A for Automatic");
            }
            if(carFuel.length() != 1) {
                throw new IllegalArgumentException("Please only enter one character for fuel, e.g. P for petrol, H for hybrid");
            }
            carDAO.updateCar(carID, carMake, carModel, carTrim, carImage, carOdometer, carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
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
=======
        int carID;
        String carMake;
        String carModel;
        String carTrim;
        int carOdometer;
        String carImage;
        String carTransmission;
        String carFuel;
        int carSeats;
        String carBodyStyle;
        String carQuip;
        int carPurchasePrice;
        int carCurrentPrice;
        int carPriceKM;
        int carRating;
        int locationID;
        try {
            carID = Integer.parseInt(request.getParameter("id"));
            carMake = request.getParameter("make");
            carModel = request.getParameter("model");
            carTrim = request.getParameter("trim");
            carOdometer = Integer.parseInt(request.getParameter("odometer"));
            carImage = request.getParameter("imageurl");
            carTransmission = request.getParameter("transmission");
            carFuel = request.getParameter("fuel");
            carSeats = Integer.parseInt(request.getParameter("seats"));
            carBodyStyle = request.getParameter("bodystyle");
            carQuip = request.getParameter("quip");
            carPurchasePrice = Integer.parseInt(request.getParameter("purchaseprice"));
            carCurrentPrice = Integer.parseInt(request.getParameter("currentprice"));
            carPriceKM = Integer.parseInt(request.getParameter("pricekm"));
            carRating = Integer.parseInt(request.getParameter("rating"));
            locationID = Integer.parseInt(request.getParameter("locID"));

            carDAO.updateProduct(null, carMake, carModel, carTrim, carImage, null, carTransmission, carFuel, null, carBodyStyle, carQuip, null, null, null, null, null);
        } catch(Exception e) {

>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
        }
    }
}