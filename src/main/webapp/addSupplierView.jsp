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
        <title>Suppliers</title>
    </head>
    <%@ include file="assets/nav.jsp" %>
    <body>
        <div class="web-wrapper">
            <main class="main-container">
                <form action="/supplier/add" method="post">
                <div class="supplier-title-line">
                    <input id="name" name="name" type="text" class="supplier-title" placeholder="Supplier Name">
                    <a href="/suppliers" id="return-btn">Return to suppliers</a>
                </div>
                <br><br>
                <div class="supplier-hbox">
                    <img class="supplier-logo" src="/assets/supplier-logos/placeholder.png">
                    <div class="supplier-vbox-details">
                        <div class="supplier-detail-line">
                            <p>ABN:</p>
                            <input id="abn" name="abn" type="text" placeholder="ABN">
                        </div>
                        <div class="supplier-detail-line">
                            <p>ACN:</p>
                            <input id="acn" name="acn" type="text" placeholder="ACN">
                        </div>
                        <div class="supplier-detail-line">
                            <p>Contact name:</p>
                            <input id="contact-name" name="contact-name" type="text" placeholder="Contact name">
                        </div>
                        <div class="supplier-detail-line">
                            <p>Phone number:</p>
                            <input id="contact-phone" name="contact-phone" type="text" placeholder="Contact phone">
                        </div>
                        <br><br>
                        <div class="supplier-detail-line">
                            <button type="submit" id="edit-supplier">Add</button>
                            <a id="delete-supplier">Delete</a>
                        </div>
                    </div>
                </div>
            </form>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>