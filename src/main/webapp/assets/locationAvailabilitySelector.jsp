<div class="location-availability-wrapper">
    <h1>Sydney Car Rental</h1>
    <form action="/LocationAvailabilityServlet" method="post" autocomplete="off" id="locationAvailabilityForm">
<<<<<<< HEAD
    
        <div class="location-selector">
        
            <div class="location-selector-wrapper">
            
=======
        <div class="location-selector">
            <div class="location-selector-wrapper">
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
                <div class="selector-wrapper">
                    <% ArrayList<Location> locations = locationDAO.fetchLocations(); %>
                    <p class="label">Pickup</p>
                    <div class="pickup pickme">
<<<<<<< HEAD
                        <input Type="text" placeholder="Search..." id="pickup" onkeyup="filterFunction()" class="selector" autocomplete="off" name="pickup" required value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
=======
                        <input Type="text" placeholder="Search..." id="pickup" onkeyup="filterFunction()" class="selector" autocomplete="off" name="pickup" value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
                        <input Type="text" placeholder="Search..." id="dropoff" onkeyup="filterFunction2()" class="selector" autocomplete="off" name="dropoff" required value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
=======
                        <input Type="text" placeholder="Search..." id="dropoff" onkeyup="filterFunction2()" class="selector" autocomplete="off" name="dropoff" value="<% if(pickupName != null) { %><%= pickupName %><% } %>">
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
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
<<<<<<< HEAD
                <input type="date" name="pickup-date" id="pickup-date" required>
                <input type="date" name="dropoff-date" id="dropoff-date" required>
            </div>
            <div class="price-selector-wrapper selector-wrapper" id="age">
                <button onclick="darken('21-25')" id="15-25" class="not-selected" type="button">21-25</button>
                <button onclick="darken('25+')" id="25" class="not-selected" type="button">25+</button>
                <input type="hidden" id="selected-type-age" name="selected-type-age">
=======
                <input type="date" name="pickup-date" id="pickup-date">
                <input type="date" name="dropoff-date" id="dropoff-date">
            </div>
            <div class="price-selector-wrapper selector-wrapper" id="age">
                <button onclick="darken('21-25')" id="day" class="not-selected">21-25</button>
                <button onclick="darken('25+')" id="km" class="not-selected">25+</button>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
            </div>
            <div class="submit-search">
                <input type="submit" value="Search">
            </div>
        </div>
<<<<<<< HEAD
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
    
=======
    </form>
>>>>>>> f1e12794eb8cc3bc137fa4b87757a78a48868620
</div>