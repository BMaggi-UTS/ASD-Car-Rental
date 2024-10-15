<nav>
  <div class="container navbar">
    <a href="/index"><img src="/assets/imgs/logo.png" alt="logo" class="logo"/></a>
    <div class="search-div">
      <form method="post" action="/SearchCarServlet" autocomplete="off" id="searchSubmit" class="search-div-form">
        <input type="text" name="searchQuery" placeholder="Search for your next rental . . ." />
        <a href="#" onclick="document.getElementById('searchSubmit').submit()">
          <i class="fa-solid fa-magnifying-glass search-icon fa-2xl"></i>
        </a>
      </form>
    </div>
    <div class="cart-div">
      <i class="fa-solid fa-car fa-2xl"></i>
    </div>
  </div>
</nav>