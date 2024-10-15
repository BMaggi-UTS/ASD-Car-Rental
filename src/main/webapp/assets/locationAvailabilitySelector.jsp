<div class="location-availability-wrapper">
    <h1>Sydney Car Rental</h1>
    <form action="/LocationAvailabilityServlet" method="post" autocomplete="off">
        <div class="location-selector">
            <div class="location-selector-wrapper">
                <div class="selector-wrapper">
                    <% ArrayList<Location> locations = locationDAO.fetchLocations(); %>
                    <p class="label">Pickup</p>
                    <div class="pickup pickme">
                        <input Type="text" placeholder="Search..." id="pickup" onkeyup="filterFunction()" class="selector" autocomplete="off" name="pickup">
                        <div id="search-results" class="pickme">
                            <% for(Location location : locations) { %>
                                <a href="#" onclick="clickResultPickup('<%=location.getLocationName()%>')"><%=location.getLocationName()%></a>
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="selector-wrapper">
                    <p class="label">Dropoff</p>
                    <div class="dropoff pickme">
                        <input Type="text" placeholder="Search..." id="dropoff" onkeyup="filterFunction2()" class="selector" autocomplete="off" name="dropoff">
                        <div id="search-results2" class="pickme">
                            <% for(Location location : locations) { %>
                                <a href="#" onclick="clickResultPickup2('<%=location.getLocationName()%>')"><%=location.getLocationName()%></a>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="price-selector-wrapper selector-wrapper" id="priceorkm">
                <button onclick="darken('day')" id="day" class="not-selected">Pay by day</button>
                <button onclick="darken('km')" id="km" class="not-selected">Pay by KM</button>
            </div>
            <div class="km-wrapper" id="km-holder">
                <p>Estimated travel kms</p>
                <input type="text" placeholder="1234">
            </div>
        </div>
        <div class="availability-selector">
            <div class="date-wrapper">
                <input type="date">
                <input type="date">
            </div>
            <div class="price-selector-wrapper selector-wrapper" id="age">
                <button onclick="darken('day')" id="day" class="not-selected">21-25</button>
                <button onclick="darken('km')" id="km" class="not-selected">25+</button>
            </div>
            <div class="submit-search">
                <input type="submit" value="Search">
            </div>
        </div>
    </form>
</div>