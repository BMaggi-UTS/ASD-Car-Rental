<div class="location-availability-wrapper">
    <h1>Sydney Car Rental</h1>
    <form action="/LocationAvailabilityServlet" method="post" autocomplete="off" id="locationAvailabilityForm">
        <div class="location-selector">
            <div class="location-selector-wrapper">
                <div class="selector-wrapper">
                    <% ArrayList<Location> locations = locationDAO.fetchLocations(); %>
                    <p class="label">Pickup</p>
                    <div class="pickup pickme">
                        <input Type="text" placeholder="Search..." id="pickup" onkeyup="filterFunction()" class="selector" autocomplete="off" name="pickup" required value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
                        <div id="search-results" class="pickme">
                            <% for(Location location : locations) { %>
                                <a onclick="clickResultPickup('<%=location.getLocationName()%>')"><%=location.getLocationName()%></a>
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="selector-wrapper">
                    <p class="label">Dropoff</p>
                    <div class="dropoff pickme">
                        <input Type="text" placeholder="Search..." id="dropoff" onkeyup="filterFunction2()" class="selector" autocomplete="off" name="dropoff" required value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
                        <div id="search-results2" class="pickme">
                            <% for(Location location : locations) { %>
                                <a onclick="clickResultPickup2('<%=location.getLocationName()%>')"><%=location.getLocationName()%></a>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="price-selector-wrapper selector-wrapper" id="priceorkm">
                <button onclick="darken('day')" id="day" class="not-selected" type="button">Pay by day</button>
                <button onclick="darken('km')" id="km" class="not-selected" type="button">Pay by KM</button>
                <input type="hidden" id="selected-type" name="selected-type">
            </div>
            <div class="km-wrapper" id="km-holder">
                <p>Estimated travel kms</p>
                <input type="text" placeholder="1234" name="km-amount" id="km-amount">
            </div>
        </div>
        <div class="availability-selector">
            <div class="date-wrapper">
                <input type="date" name="pickup-date" id="pickup-date" required value="<% if(pickupDate != null) { %><%= pickupDate %><% } %>">
                <input type="date" name="dropoff-date" id="dropoff-date" required value="<% if(dropoffDate != null) { %><%= dropoffDate %><% } %>">
            </div>
            <div class="submit-search">
                <input type="submit" value="Search">
            </div>
        </div>
         <% if(request.getAttribute("errors") != null) { %>
        <div class="error-location">
            <div class="errors">
            <p class="error-location-text">
                <%= request.getAttribute("errors") %>
            </p>
            </div>
        </div>
         <% } %>
    </form>
</div>