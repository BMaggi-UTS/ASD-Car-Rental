<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Login</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">

                    <form class="login-form" action="login", method="post">
                        <h1 id="login-heading">Login</h1>
                        <div class="form-group">
                            <input class="register-input" type="text" id="email" name="email" placeholder="Email address" required>
                            <img class="form-icon" src="/assets/icons/user.png">
                        </div>
                        <div class="form-group">
                            <input class="register-input" type="password" id="password" name="password" placeholder="Password" required>
                            <img class="form-icon" src="/assets/icons/padlock.png">
                        </div>
                        <button type="submit" class="form-submit">Login</button>
                        <a class="login-redirects" href="resetpassword.jsp"><span class="inline-bold">Forgot password?</span></a>
                        <br>
                        <a class="login-redirects" href="register.jsp">Don't have an account? <span class="inline-bold">Register</span></a>
                    </form>
                
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
