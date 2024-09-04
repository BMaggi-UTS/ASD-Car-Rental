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

                <div class="modal-overlay">
                    <div class="modal-content">
                        <p id="close-btn">X</p>
                        <form class="edit-details-form" action="register", method="post">
                            <h1 id="login-heading">Edit Details</h1>
                            <div class="form-group">
                                <input class="register-input" type="text" id="fname" name="fname" placeholder="First name" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="surname" name="surname" placeholder="Surname" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="email" name="email" placeholder="Email address" required>
                                <img class="form-icon" src="/assets/icons/mail.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="password" id="password" name="password" placeholder="Password" required>
                                <img class="form-icon" src="/assets/icons/padlock.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="password" id="password" name="password" placeholder="Confirm Password" required>
                                <img class="form-icon" src="/assets/icons/padlock.png">
                            </div>
                            <button type="submit" class="form-submit">Save</button>
                        </form>
                    </div>

                </div>

                <h1>Your Account</h1>
                <div class="settings-main">
                    <div class="edit-line">
                        <a href="edit" id="edit-details-btn">Edit details</a>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">First Name:</p>
                        <p class="setting-value">Michael</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Surame:</p>
                        <p class="setting-value">Lunn</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Email:</p>
                        <p class="setting-value">m.lunn54@gmail.com</p>
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