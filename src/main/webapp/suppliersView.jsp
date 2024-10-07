<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Suppliers</title>
    </head>

    <% ArrayList<Supplier> suppliers = (ArrayList<Supplier>) session.getAttribute("suppliers"); %>
    <%@ include file="assets/nav.jsp" %>
    <body>
        <div class="web-wrapper">
            <main class="main-container">
                <a class="add-supplier-btn" href="add">Add New Supplier</a>
                <h1>Suppliers</h1>
                <br><br>
                <div class="supplier-search-bar">
                    <form class="supplier-search" method="post" action="suppliers">
                        <label>Search: </label>
                        <input class="supplier-search-input" type="text" name="search" id="search">
                        <button class="supplier-search-btn" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>

                <% 
                for(Supplier s : suppliers) { 
                    %>

                <div class="supplier-box">
                    <a href="supplier/<%= s.getSupplierID()%>"><img class="suppliers-logo" src="/assets/supplier-logos/<%= s.getImagePath()%>"></a>
                    <a href="supplier/<%= s.getSupplierID()%>" class="supplier-name"><%= s.getBusinessName() %></a>
                    <div class="suppliers-edit-btns">
                        <a class="suppliers-edit-btn" id="edit-supplier" href="supplier/edit/<%= s.getSupplierID()%>">Edit</a>
                        <a class="suppliers-edit-btn" id="delete-supplier" href="supplier/delete/<%= s.getSupplierID()%>">Delete</a>
                    </div>
                </div>
                <% } %>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
