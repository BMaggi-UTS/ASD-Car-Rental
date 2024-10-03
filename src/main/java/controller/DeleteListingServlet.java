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

public class DeleteListingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String[] idList = request.getParameterValues("deleteCheckbox");
        System.out.println(idList);
     }
}
