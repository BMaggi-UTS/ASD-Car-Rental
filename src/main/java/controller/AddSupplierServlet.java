package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;

public class AddSupplierServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");

        String businessName = request.getParameter("name");
        String abn = request.getParameter("abn");
        String acn = request.getParameter("acn");
        String contactName = request.getParameter("contact-name");
        String contactPhone = request.getParameter("contact-phone");

        try {
            supplierDAO.addSupplier(businessName, abn, acn, contactName, contactPhone);
            int newSupplierID = supplierDAO.getLastInsertID();
            response.sendRedirect("/supplier/" + newSupplierID);
        }
        catch (SQLException ex) {
            Logger.getLogger(AddSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
}
