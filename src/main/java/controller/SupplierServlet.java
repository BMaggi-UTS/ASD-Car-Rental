package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;
import model.*;

public class SupplierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");

        // Pulls supplier ID from URL
        String[] url = request.getRequestURI().split("/");
        int id = Integer.parseInt(url[url.length-1]);

        // Pulls supplier info from DB, redirect to supplier view
        try {
            Supplier supplier = supplierDAO.getSupplierByID(id);
            session.setAttribute("supplier", supplier);
            request.getRequestDispatcher("/supplierView.jsp").forward(request, response);
            return;
        }
        catch (SQLException ex) {
            Logger.getLogger(SupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
