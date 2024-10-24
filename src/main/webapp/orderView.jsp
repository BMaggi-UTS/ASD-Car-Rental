<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.*"%> 
<%@page import="model.dao.orderDAO"%>
<%@page import="model.dao.DBConnector"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/orderStyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="css/navandfooter.css">
        <script src="https://kit.fontawesome.com/cd2f5b5ad0.js" crossorigin="anonymous"></script>
        <title>Order Management - Checkout</title>
    </head>

    <body>
        <div class="web-wrapper">
            <%@ include file="assets/nav.jsp" %> 

            <main class="main-container">
                <h1>Checkout</h1>
                <br>

                <h2>We offer free cancellation for all rental services!</h2>
                <div class="middle">
                    <p>Plans changed? We've got your back.</p>
                </div>

                <br><br>

                <!-- Order Summary Section -->
                <div class="order-summary">
                    <% 
                        
                        // Retrieve and process input parameters
                        String pickupDate = request.getParameter("pickupDate");
                        String dropoffDate = request.getParameter("dropoffDate");
                            
                        // Calculate prices
                        String basePriceString = request.getParameter("booking-price");
                        double basePrice = Double.parseDouble(basePriceString);
                        double taxesFees = basePrice * 0.10;
                        double totalPrice = basePrice + taxesFees;
                            
                        String taxesFeesString = String.format("%.2f", taxesFees);
                        String totalPriceString = String.format("%.2f", totalPrice);
                            
                        // Open a connection using DBConnector
                        DBConnector conn = new DBConnector();
                        Connection connection = conn.openConnection();
                        // Use the connection to create an orderDAO controller
                        orderDAO orderDAO = new orderDAO(connection);

                        String carValid = "";
                        String carMake = "";
                        String carRating = "";
                        int carOdometer = 0;
                        int carID = 0;
                        
                        Car car = null;

                        try {
                            // Fetch car data by ID if valid
                            carValid = request.getParameter("orderCarID");
                            if (carValid != null) {
                                try {
                                    carID = Integer.parseInt(carValid);
                                    car = orderDAO.getCarById(carID); 
                                    if (car != null) {
                                        // Output car details
                                        carMake = car.getCarMake() + " " + car.getCarModel() + " " + car.getCarTrim();
                                        carRating = car.getCarRating() + "/5 Star Rating";
                                        carOdometer = car.getCarOdometer();
                                    } else {
                                        out.println("Error: Car not found.");
                                    }
                                } catch (NumberFormatException e) {
                                    out.println("Error: Invalid car ID format.");
                                }
                            } else {
                                out.println("Error: Car ID is missing.");
                            }
                            
                        } catch (SQLException e) {
                            out.println("Database error: " + e.getMessage());
                        } catch (Exception e) {
                            out.println("Unexpected error: " + e.getMessage());
                        }
                    %>

                    <h2>Order Summary</h2>
                    <div class="card">
                        <!-- Draw data from carID in database and list model here -->
                       
                        <p><strong><%= carMake %></strong></p>
                        <p><%= carRating %></p>
                        <p><%= carOdometer %>km</p>

                        <br>

                        <p>Pickup Date: <%= pickupDate %></p>
                        <p>Dropoff Date: <%= dropoffDate %></p>

                        <br><br>

                        <p>Base Price: $<%= basePriceString %></p>
                        <p>Taxes & Fees: $<%= taxesFeesString %></p> 
                        <p><strong>Total Price: $<%= totalPriceString %></strong></p> 

                        <img src="<%= car.getCarImage() %>" alt="Car Image">

                    </div>
                </div>

                <br><br>

                <!-- Personal Details Section -->
                <div class="order-summary">
                    <h2>Personal Details</h2>

                    <%
                    User user = (User) session.getAttribute("user");

                    int userID = user.getUserID();
                    String userFirstName = user.getFirstName();
                    String userLastName = user.getLastName();
                    String userEmail= user.getEmail();
                    String userPhone = user.getPhone();
                    %>
                    
                    <h3>Name: <%= userFirstName %> <%= userLastName %></h3>
                    <p>Email: <%= userEmail %></p>
                    <p>Phone: <%= userPhone %></p>
                    

                    <br>

                </div>

                <br><br>

                <!-- Driver's License Section -->
                <div class="driver-info">
                    <h2>Driver's License</h2>
                    <div class="middle">
                    <p>Enter your details exactly as it appears on your driver's license so we can verify your eligibility to drive.</p>
                    <br>
                    <p class="note">Please note: Driver's with a provisional license are not eligible to book a vehicle.</P>
                    </div>
                    <br><br>

                    <form action="addOrderItem" method="POST">
                        <!-- Hidden inputs -->
                        <input type="hidden" name="orderCarID" value="<%= carID %>"> 
                        <input type="hidden" name="pickupDate" value="<%= pickupDate %>">
                        <input type="hidden" name="dropoffDate" value="<%= dropoffDate %>">
                        <input type="hidden" name="base-price" value="<%= basePriceString %>">
                        <input type="hidden" name="tax-fees" value="<%= taxesFeesString %>">
                        <input type="hidden" name="booking-price" value="<%= totalPriceString %>">
                        
                        
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <input type="firstName" id="firstName" name="firstName" required>
                        </div>
                        <div class="form-group">
                            <label for="middleName">Middle Name:</label>
                            <input type="middleName" id="middleName" name="middleName" required>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                            <input type="lastName" id="lastName" name="lastName" required>
                        </div>

                        <div class="form-group">
                            <label for="license">License Number:</label>
                            <input type="number" id="license" name="license" min="0" max="99999999" required oninput="checkLength(this)">

                            <script>
                                function checkLength(input) {
                                    if (input.value.length > 8) {
                                        input.setCustomValidity("Number cannot be longer than 8 digits");
                                    } else {
                                        input.setCustomValidity("");
                                    }
                                }
                            </script>
                        </div>



                        <br>

                        <div class="form-group">
                            <label for="expiry">Expiration Date:</label>
                            <div class="expiry-date">
                                <select id="expiryDay" name="expiryDay" required>
                                    <option value="" disabled selected>Day</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                  </select>
                                  

                                <select id="expiryMonth" name="expiryMonth" required>
                                    <option value="" disabled selected>Month</option>
                                    <option value="01">January</option>
                                    <option value="02">February</option>
                                    <option value="03">March</option>
                                    <option value="04">April</option>
                                    <option value="05">May</option>
                                    <option value="06">June</option>
                                    <option value="07">July</option>
                                    <option value="08">August</option>
                                    <option value="09">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>

                                <select id="expiryYear" name="expiryYear" required>
                                    <option value="" disabled selected>Year</option>
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                    <option value="2026">2026</option>
                                    <option value="2026">2027</option>
                                    <option value="2026">2028</option>
                                    <option value="2026">2029</option>
                                    <option value="2026">2030</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="DOB">Date of Birth:</label>
                            <input type="date" id="DOB" name="DOB" required>
                        </div>

                        <div class="form-group">
                            <label>State</label>
                            <div class="dropdown">
                                <select name="State">
                                    <option value="" disabled selected>Select</option>
                                    <option value="NSW">NSW</option>
                                    <option value="ACT">ACT</option>
                                    <option value="VIC">VIC</option>
                                    <option value="SA">SA</option>
                                    <option value="WA">WA</option>
                                    <option value="NT">NT</option>
                                </select>
                            </div>
                        </div>
                        
                        <br><br>

                        <button type="submit" class="btn-submit">Save and Continue</button>
                    </form>
                </div>

                <br><br>


                <hr>
                <!-- Payment Information Section -->
                <div class="locked-section">
                    <h2><img src="assets/orderImages/Lock.png" alt="Lock Icon"> Payment Information</h2>
                </div>

            </main>

            <%@ include file="assets/footer.jsp" %> 
        </div>
    </body>
</html>
