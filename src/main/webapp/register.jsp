<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Register</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">

                    <form class="login-form" action="register", method="post">
                        <h1 id="login-heading">Register</h1>
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
                        <button type="submit" class="form-submit">Register</button>
                        <a class="login-redirects" href="login.jsp">Already have an account? <span class="inline-bold">Login</span></a>
                    </form>
                
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
