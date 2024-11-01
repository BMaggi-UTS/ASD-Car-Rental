package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;

import model.dao.*;
import model.*;

public class SuppliersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");
        
        String searchTerm = request.getParameter("search");

        // Checking for null input, convert to wildcard for DB search purposes if null
        if(searchTerm == null) {
            searchTerm = "";
        }

        // Pull suppliers matching search term from DB
        try {
            ArrayList<Supplier> suppliers = supplierDAO.getSuppliersBySearch(searchTerm);
            session.setAttribute("suppliers", suppliers);
            response.sendRedirect("suppliersView.jsp");
        }
        catch (SQLException ex) {
            Logger.getLogger(SuppliersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
