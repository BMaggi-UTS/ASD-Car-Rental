package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.CarDAO;

public class CreateListingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");
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
        try {
            carDAO.createCar(carID, carMake, carModel, carTrim, carImage, carOdometer, carTransmission, carFuel, carSeats, carBodyStyle, carQuip, carPurchasePrice, carCurrentPrice, carPriceKM, carRating, locationID);
            response.sendRedirect("/catalogueStaffView.jsp");
        } catch(Exception e) {
            System.out.println(e);
            response.sendRedirect("/catalogueStaffView.jsp");
        }
     }
}
