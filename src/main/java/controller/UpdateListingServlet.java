package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CarDAO;

public class UpdateListingServlet extends HttpServlet{
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

        }
    }
}