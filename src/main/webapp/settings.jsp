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
        <script defer src="script.js"></script>
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

                <div id="modal-overlay">
                    <div class="modal" id="login-details-modal">
                        <button data-close-btn class="close-btn">&times;</button>
                        <form class="edit-details-form" action="register", method="post">
                            <h1 id="login-heading">Login Details</h1>
                            <div class="form-group">
                                <input class="register-input" type="text" id="email" name="email" value="m.lunn54@gmail.com" readonly>
                                <img class="form-icon" src="/assets/icons/mail.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="password" id="password" name="password" value="••••••••••••" readonly>
                                <img class="form-icon" src="/assets/icons/padlock.png">
                            </div>
                            <button type="submit" class="form-submit">Reset Password</button>
                        </form>
                    </div>
                    <div class="modal" id="personal-details-modal">
                        <button data-close-btn class="close-btn">&times;</button>
                        <form class="edit-details-form" action="register", method="post">
                            <h1 id="login-heading">Personal Details</h1>
                            <div class="form-group">
                                <input class="register-input" type="text" id="fname" name="fname" placeholder="First name" value="Michael" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="surname" name="surname" placeholder="Surname" value="Lunn" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="prefname" name="prefname" placeholder="Preferred name" value="Michael">
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="phone" name="phone" placeholder="Phone no" value="0412 345 678" required>
                                <img class="form-icon" src="/assets/icons/phone.png">
                            </div>
                            <br>
                            <p>Date of Birth:</p>
                            <div class="form-group">
                                <input class="register-input" type="date" id="dob" name="dob" value="2001-09-15" required onkeydown="return false">
                            </div>
                            <button type="submit" class="form-submit">Save</button>
                        </form>
                    </div>
                </div>

                <h1>Your Account</h1>
                <div class="settings-section">
                    <div class="edit-line">
                        <h3 class="setting-section-heading">Login Details</h3>
                        <button data-modal-target="#login-details-modal" id="edit-details-btn">Edit details</button>
                    </div>
                    <br>
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
                <br>
                <div class="settings-section">
                    <div class="edit-line">
                        <h3 class="setting-section-heading">Personal Details</h3>
                        <button data-modal-target="#personal-details-modal" id="edit-details-btn">Edit details</button>
                    </div>
                    <br>
                    <div class="setting-line">
                        <p class="setting-label">First Name:</p>
                        <p class="setting-value">Michael</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Surame:</p>
                        <p class="setting-value">Lunn</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Preferred Name:</p>
                        <p class="setting-value">Michael</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Phone No:</p>
                        <p class="setting-value">0412 345 678</p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Date of Birth:</p>
                        <p class="setting-value">15-09-2001</p>
                    </div>
                    <br>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>