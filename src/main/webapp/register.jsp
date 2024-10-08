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
        <title>Register</title>
    </head>

    <% 
        String duplicateErr = (String) session.getAttribute("duplicateErr");
        session.setAttribute("duplicateErr", "");

        String passwordErr = (String) session.getAttribute("passwordErr");
        session.setAttribute("passwordErr", "");

        String emailErr = (String) session.getAttribute("emailErr");
        session.setAttribute("emailErr", "");

        String fnameErr = (String) session.getAttribute("fnameErr");
        session.setAttribute("fnameErr", "");

        String surnameErr = (String) session.getAttribute("surnameErr");
        session.setAttribute("surnameErr", "");

        String phoneErr = (String) session.getAttribute("phoneErr");
        session.setAttribute("phoneErr", "");

        if(duplicateErr == null){
            duplicateErr = "";
        }
        if(passwordErr == null){
            passwordErr = "";
        }
        if(emailErr == null){
            emailErr = "";
        }
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

                    <form class="login-form" action="register", method="post">
                        <h1 id="login-heading">Register</h1>
                        <p class="error"><%=duplicateErr%></p>
                        <p class="error"><%= passwordErr%></p>
                        <p class="error"><%= emailErr%></p>
                        <p class="error"><%= fnameErr%></p>
                        <p class="error"><%= surnameErr%></p>
                        <p class="error"><%= phoneErr%></p>
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
                            <input class="register-input" type="text" id="phone" name="phone" placeholder="Mobile number" required>
                            <img class="form-icon" src="/assets/icons/phone.png">
                        </div>
                        <div class="form-group">
                            <input class="register-input" type="password" id="password" name="password" placeholder="Password" required>
                            <img class="form-icon" src="/assets/icons/padlock.png">
                        </div>
                        <div class="form-group">
                            <input class="register-input" type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" required>
                            <img class="form-icon" src="/assets/icons/padlock.png">
                        </div>
                        <br>
                        <p>Please enter your Date of Birth:</p>
                        <div class="form-group">
                            <input class="register-input" type="date" id="dob" name="dob" required>
                        </div>
                        <button type="submit" class="form-submit">Register</button>
                        <a class="login-redirects" href="login.jsp">Already have an account? <span class="inline-bold">Login</span></a>
                    </form>
                
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
