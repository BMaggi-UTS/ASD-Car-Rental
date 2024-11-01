<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Settings</title>
        <script defer src="js/settingsModal.js"></script>
    </head>

    <% 
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("login.jsp");
        }

        String fnameErr = (String) session.getAttribute("fnameErr");
        session.setAttribute("fnameErr", "");

        String surnameErr = (String) session.getAttribute("surnameErr");
        session.setAttribute("surnameErr", "");

        String phoneErr = (String) session.getAttribute("phoneErr");
        session.setAttribute("phoneErr", "");

        if(fnameErr == null){
            fnameErr = "";
        }
        if(surnameErr == null){
            surnameErr = "";
        }
        if(phoneErr == null){
            phoneErr = "";
        }

    %>


    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="settings-sidebar">
                    <h1 id="settings-heading">Settings</h1>
                    <a class="setting-menu-item" href="settings.jsp">Account</a>
                    <a class="setting-menu-item" href="catalogueStaffView.jsp">Staff View</a>
                    <hr class="setting-divider">
                    <a class="setting-menu-item" href="signout.jsp">Sign out</a>
                </div>

                <div id="modal-overlay">
                    <div class="modal" id="login-details-modal">
                        <button data-close-btn class="close-btn">&times;</button>
                        <form class="edit-details-form" action="register", method="post">
                            <h1 id="login-heading">Login Details</h1>
                            <div class="form-group">
                                <input class="register-input" type="text" id="email" name="email" value="<%= user.getEmail()%>" readonly>
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
                        <form class="edit-details-form" action="user/save", method="post">
                            <h1 id="login-heading">Personal Details</h1>
                            <div class="form-group">
                                <input class="register-input" type="text" id="fname" name="fname" placeholder="First name" value="<%= user.getFirstName()%>" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="surname" name="surname" placeholder="Surname" value="<%= user.getLastName()%>" required>
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="prefname" name="prefname" placeholder="Preferred name" value="<%= user.getPreferredName()%>">
                                <img class="form-icon" src="/assets/icons/user.png">
                            </div>
                            <div class="form-group">
                                <input class="register-input" type="text" id="phone" name="phone" placeholder="Phone no" value="<%= user.getPhone()%>" required>
                                <img class="form-icon" src="/assets/icons/phone.png">
                            </div>
                            <br>
                            <p>Date of Birth:</p>
                            <div class="form-group">
                                <input class="register-input" type="date" id="dob" name="dob" value="<%= user.getDateOfBirth()%>" required onkeydown="return false">
                            </div>
                            <button type="submit" class="form-submit">Save</button>
                        </form>
                    </div>
                </div>

                <h1>Your Account</h1>
                <div class="errors">
                    <p class="error"><%= fnameErr%></p>
                    <p class="error"><%= surnameErr%></p>
                    <p class="error"><%= phoneErr%></p>
                </div>
                <div class="settings-section">
                    <div class="edit-line">
                        <h3 class="setting-section-heading">Login Details</h3>
                        <button data-modal-target="#login-details-modal" id="edit-details-btn">Edit details</button>
                    </div>
                    <br>
                    <div class="setting-line">
                        <p class="setting-label">Email:</p>
                        <p class="setting-value"><%= user.getEmail()%></p>
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
                        <p class="setting-value"><%= user.getFirstName()%></p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Surname:</p>
                        <p class="setting-value"><%= user.getLastName()%></p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Preferred Name:</p>
                        <p class="setting-value"><%= user.getPreferredName()%></p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Phone No:</p>
                        <p class="setting-value"><%= user.getPhone()%></p>
                    </div>
                    <div class="setting-line">
                        <p class="setting-label">Date of Birth:</p>
                        <p class="setting-value"><%= user.getDateOfBirth()%></p>
                    </div>
                    <br>
                </div>
                <br><br><br><br>
                <a class="delete-account-button" href="user/delete">Delete Account</a>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>