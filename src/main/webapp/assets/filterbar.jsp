<div class="filter-bar-wrapper">
    <p>
        <% if(dropoffDate == null) {%><%="Please select a date before proceeding"%><% } %>
    </p>
    <p>
        <% if(user == null) {%><%="Please log in"%><% } %>
    </p>
    <p>
        <% if(daysBetween == null || expectedKMs == null) {%><%="Please select pay by days, or kms"%><% } %>
    </p>
</div>