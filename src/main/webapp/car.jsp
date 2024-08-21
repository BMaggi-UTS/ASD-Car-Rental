<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/product.css">
        <%-- <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script> --%>
        <title>Car Rental</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="pic-content-wrapper">
                    <div class="car-pic">
                        <img src="assets/imgs/mg3.webp">
                    </div>
                    <div class="detail-content">
                        <h1>All new MG3<h1>
                        <h2>MG</h2>
                        <table>
                            <tr>
                                <td>icon</td>
                                <td>5 Seats</td>
                            </tr>
                            <tr>
                                <td>icon</td>
                                <td>Hybrid Drivetrain</td>
                            </tr>
                            <tr>
                                <td>icon</td>
                                <td>Fuel Efficient</td>
                            </tr>
                        </table>
                        <h1 class="rental-price"> $179<span>/ day</span></h1>
                        <a href="#" class="select"> Select </a>
                    </div>
                </div>
                <hr>
                <div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
