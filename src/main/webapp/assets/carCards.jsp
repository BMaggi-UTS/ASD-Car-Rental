<a href="/car.jsp?id=<%= car.getCarID() %>">
<div class="card">
    <div class="imgBox">
        <img src="<%= car.getCarImage() %>" alt="<%= car.getCarMake() %>" class="car">
        <div class="make-model">
            <h3><%= car.getCarMake() %></h3>
            <h3><%= car.getCarModel() %></h3>
        </div>
    </div>
    <hr>
    <div class="contentBox">
        <div class="card-content">
            <div class="car-details">
                <div>
                    <i class="fa-solid fa-chair"></i>
                    <h2> <%= car.getCarSeats() %> Seats </h2>
                </div>
                <div>
                    <i class="fa-solid fa-gas-pump"></i>
                    <h2> 
                    <% if(car.getCarFuel().equals("P")) { %>
                        <%= "Petrol" %>
                    <% } else if(car.getCarFuel().equals("D")) { %>
                        <%= "Diesel" %>
                    <% } else if(car.getCarFuel().equals("H")) { %>
                        <%= "Hybrid" %>
                    <% } %>
                    </h2>
                </div>
                <div>
                    <i class="fa-solid fa-car-side"></i>
                    <h2> <%= car.getCarBodyStyle() %></h2>
                </div>
            </div>
            <div class="detail-price">
                <h2>$<%= car.getCarPriceKM() %> <span>/ a KM</span></h2>
                <h2><%= car.getCarQuip() %></h2>
            </div>
        </div>
        <a href="#" class="buy">Book Now</a>
    </div>
</div>
</a>