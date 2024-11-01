package controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import model.dao.*;
import model.*;

public class EditSupplierServlet extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");

        // Pulls supplier ID from URL
        String[] url = request.getRequestURI().split("/");
        int id = Integer.parseInt(url[url.length-1]);

        // Pulls supplier info from db, redirects to supplier view
        try {
            Supplier supplier = supplierDAO.getSupplierByID(id);
            session.setAttribute("supplier", supplier);
            request.getRequestDispatcher("/editSupplierView.jsp").forward(request, response);
            return;
        }
        catch (SQLException ex) {
            Logger.getLogger(EditSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        SupplierDAO supplierDAO = (SupplierDAO) session.getAttribute("supplierDAO");

        String[] url = request.getRequestURI().split("/");
        int id = Integer.parseInt(url[url.length-1]);

        String businessName = request.getParameter("name");
        String abn = request.getParameter("abn");
        String acn = request.getParameter("acn");
        String contactName = request.getParameter("contact-name");
        String contactPhone = request.getParameter("contact-phone");

        try{
            boolean valid = true;

            if(businessName.equals("")) {
                session.setAttribute("businessNameErr", "Supplier must have a name!");
                valid = false;
            }
            
            if(!abn.equals("")){
                if(!RegexUtils.validateABN(abn)){
                    session.setAttribute("abnErr", "Invalid ABN! Must be an 11 digit number.");
                    valid = false;
                }
            }
            if(!acn.equals("")){
                if(!RegexUtils.validateACN(acn)){
                    session.setAttribute("acnErr", "Invalid ACN! Must be a 9 digit number.");
                    valid = false;
                }
            }
            if(!RegexUtils.validatePhoneNo(contactPhone)){
                session.setAttribute("phoneErr", "Invalid phone number! Please enter a valid mobile number.");
                valid = false;
            }

            if(valid){
                supplierDAO.updateSupplier(id, businessName, abn, acn, contactName, contactPhone);
                response.sendRedirect("/supplier/" + id);
                return;
            }
            else {
                response.sendRedirect("/supplier/edit/" + id);
                return;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(EditSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
