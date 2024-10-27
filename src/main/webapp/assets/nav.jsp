<% 
  Boolean isStaff = (Boolean) session.getAttribute("isStaff");
  if(isStaff == null) {
    isStaff = false;
  }
  User checkUser = (User) session.getAttribute("user");
%>

<nav>
  <div class="container navbar">
    <a href="/"><img src="/assets/imgs/logo.png" alt="logo" class="logo"/></a>
    <div class="search-div">
      <form method="post" action="/SearchCarServlet" autocomplete="off" id="searchSubmit" class="search-div-form">
        <input type="text" name="searchQuery" placeholder="Search for your next rental . . ." />
        <a href="#" onclick="document.getElementById('searchSubmit').submit()">
          <i class="fa-solid fa-magnifying-glass search-icon fa-2xl"></i>
        </a>
      </form>
    </div>
    <div class="dropdown">
      <button class="dropbtn">Menu <i class="fa-solid fa-bars "></i></button>
        <div class="dropdown-content">
            <% if(checkUser == null) { %>
            <a class="dropdown-content" href="/login.jsp">Login</a>
            <% } else { %>
            <a class="dropdown-content" href="/settings.jsp">My account</a>
            <a class="dropdown-content" href="/viewOrders">My orders</a>
            <% if(isStaff) { %>
            <a class="dropdown-content" href="/catalogueStaffView.jsp">Staff dashboard</a>
            <% } %>
            <a class="dropdown-content" href="/signout.jsp">Logout</a>
            <% } %>
        </div>
    </div>
  </div>
</nav>