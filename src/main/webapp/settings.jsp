<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Settings</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="settings-sidebar">
                    <h1 id="settings-heading">Settings</h1>
                    <a class="setting-menu-item" href="account">Account</a>
                    <a class="setting-menu-item" href="preferences">Preferences</a>
                    <a class="setting-menu-item" href="paymentmethods">Payment methods</a>
                    <hr class="setting-divider">
                    <a class="setting-menu-item" href="signout">Sign out</a>
                </div>

                <h1>Your Account</h1>
                <div class="settings-main">
                    <div class="edit-line">
                        <a href="edit" id="edit-details-btn">Edit details</a>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">First Name:</p>
                        <p class="setting-value">$UsrFName$</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Surame:</p>
                        <p class="setting-value">$UsrSurname$</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Email:</p>
                        <p class="setting-value">$UsrEmail$</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Password:</p>
                        <p class="setting-value">••••••••••••</p>
                    </div>
                    <br>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>