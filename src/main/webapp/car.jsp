<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/carDetail.css">
        <link rel="stylesheet" href="css/navandfooter.css">

        <%-- <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script> --%>
        <title>Car Rental</title>
        <%
            //initiate a connection using DBConnector (connect to the db)
            DBConnector conn = new DBConnector();
            //open a connection
            Connection con = conn.openConnection();
            //use the connection to create a productDAO controller
            CarDAO carDAO = new CarDAO(con);
            String carIdString = request.getParameter("id"); 
            Integer carID = Integer.parseInt(carIdString);
            Car car = carDAO.selectSpecificCar(carID);
        %>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %>
            <main class="main-container">
                <div class="pic-content-wrapper">
                    <div class="car-pic">
                        <img src="<%= car.getCarImage() %>">
                    </div>
                    <div class="detail-content">
                        <h1><%= car.getCarModel() + " " + car.getCarTrim() %><h1>
                        <h2><%= car.getCarMake() %></h2>
                        <table>
                            <tr>
                                <td>icon</td>
                                <td><%= car.getCarSeats() %> Seats</td>
                            </tr>
                            <tr>
                                <td>icon</td>
                                <td><% if(car.getCarFuel().equals("P")) { %>
                                            <%= "Petrol" %>
                                        <% } else if(car.getCarFuel().equals("D")) { %>
                                            <%= "Diesel" %> </h2>
                                        <% } else if(car.getCarFuel().equals("H")) { %>
                                            <%= "Hybrid" %> </h2>
                                        <% } %> Drivetrain</td>
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
                <div class="calendar-wrapper">
                    <div>
                        <div class="month">
                            <ul>
                                <li>August<br><span style="font-size:18px">2024</span></li>
                            </ul>
                        </div>
                        <ul class="weekdays">
                            <li>Mo</li>
                            <li>Tu</li>
                            <li>We</li>
                            <li>Th</li>
                            <li>Fr</li>
                            <li>Sa</li>
                            <li>Su</li>
                        </ul>
                        <ul class="days">
                            <li>1</li>
                            <li>2</li>
                            <li>3</li>
                            <li>4</li>
                            <li>5</li>
                            <li>6</li>
                            <li>7</li>
                            <li>8</li>
                            <li>9</li>
                            <li><span class="active">10</span></li>
                            <li>11</li>
                            <li>12</li>
                            <li>13</li>
                            <li>14</li>
                            <li>15</li>
                            <li>16</li>
                            <li>17</li>
                            <li>18</li>
                            <li>19</li>
                            <li>20</li>
                            <li>21</li>
                            <li>22</li>
                            <li>23</li>
                            <li>24</li>
                            <li>25</li>
                            <li>26</li>
                            <li>27</li>
                            <li>28</li>
                            <li>29</li>
                            <li>30</li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                        </ul>
                    </div>
                    <div>
                        <div class="month">
                            <ul>
                                <li>September<br><span style="font-size:18px">2024</span></li>
                            </ul>
                        </div>
                        <ul class="weekdays">
                            <li>Mo</li>
                            <li>Tu</li>
                            <li>We</li>
                            <li>Th</li>
                            <li>Fr</li>
                            <li>Sa</li>
                            <li>Su</li>
                        </ul>
                        <ul class="days">
                            <li>1</li>
                            <li>2</li>
                            <li>3</li>
                            <li>4</li>
                            <li>5</li>
                            <li>6</li>
                            <li>7</li>
                            <li>8</li>
                            <li>9</li>
                            <li>10</li>
                            <li>11</li>
                            <li>12</li>
                            <li>13</li>
                            <li>14</li>
                            <li>15</li>
                            <li>16</li>
                            <li>17</li>
                            <li>18</li>
                            <li>19</li>
                            <li>20</li>
                            <li>21</li>
                            <li>22</li>
                            <li>23</li>
                            <li>24</li>
                            <li>25</li>
                            <li>26</li>
                            <li>27</li>
                            <li>28</li>
                            <li>29</li>
                            <li>30</li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                            <li> </li>
                        </ul>
                    </div>
                </div>
            </main>
            <%@ include file="assets/footer.jsp" %>
        </div>
    </body>
</html>
