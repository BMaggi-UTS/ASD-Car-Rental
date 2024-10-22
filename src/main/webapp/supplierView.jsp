<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="/css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Supplier</title>
    </head>

    <% Supplier supplier = (Supplier) session.getAttribute("supplier"); %>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="supplier-title-line">
                    <p class="supplier-title"><%= supplier.getBusinessName()%></p>
                    <a href="/suppliers" id="return-btn">Return to suppliers</a>
                </div>
                <br><br>
                <div class="supplier-hbox">
                    <img class="supplier-logo" src="/assets/supplier-logos/<%= supplier.getImagePath()%>">
                    <div class="supplier-vbox-details">
                        <div class="supplier-detail-line">
                            <p>ABN:</p>
                            <p><%= supplier.getABN()%></p>
                        </div>
                        <div class="supplier-detail-line">
                            <p>ACN:</p>
                            <p><%= supplier.getACN()%></p>
                        </div>
                        <div class="supplier-detail-line">
                            <p>Contact name:</p>
                            <p><%= supplier.getContactName()%></p>
                        </div>
                        <div class="supplier-detail-line">
                            <p>Phone number:</p>
                            <p><%= supplier.getContactPhone()%></p>
                        </div>
                        <br><br>
                        <div class="supplier-detail-line">
                            <a id="edit-supplier">Edit</a>
                            <a id="delete-supplier">Delete</a>
                        </div>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>