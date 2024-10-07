package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;
import model.*;

public class DeleteSupplierServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");

        String[] url = request.getRequestURI().split("/");
        int id = Integer.parseInt(url[url.length-1]);

        try {
            supplierDAO.deleteSupplier(id);
            response.sendRedirect("/suppliers");
        }
        catch (SQLException ex) {
            Logger.getLogger(DeleteSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
    
    }
}
