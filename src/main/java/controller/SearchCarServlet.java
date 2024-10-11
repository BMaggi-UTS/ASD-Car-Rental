package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Car;
import model.dao.CarDAO;



public class SearchCarServlet extends HttpServlet {
    public ArrayList<Integer> carID = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarDAO carDAO = (CarDAO) session.getAttribute("carDAO");

        String searchQuery = request.getParameter("searchQuery");
        String[] searchQueryList = searchQuery.split(" ");
        try {
            ArrayList<Car> cars = carDAO.fetchCars();
            for(Car car : cars) {
                for(String sQuery : searchQueryList) {
                    String carMake = car.getCarMake();
                    String carModel = car.getCarModel();
                    ArrayList<String> carMakes = new ArrayList<>();
                    String[] carMakeList = carMake.split(" ");
                    String[] carModelList = carModel.split(" ");
                    for(String individualCarMakes : carMakeList) {
                        carMakes.add(individualCarMakes);
                    }
                    for(String carModels : carModelList) {
                        carMakes.add(carModels);
                    }
                    for(String carMakeSplit : carMakes) {
                        if(sQuery.toLowerCase().equals(carMakeSplit.toLowerCase())) {
                            carID.add(car.getCarID());
                        }
                    }
                }
            }
            if (carID.size() > 0) {
                System.out.println("Product ids that match: " + carID);
                session.setAttribute("searchIDResult", carID);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                carID.clear();
            } else {
                System.out.println("No matching id's");
                carID.add(0);
                session.setAttribute("searchIDResult", carID);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                carID.clear();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
