Sydney Car Rental Web Application

Overview
This is a Car Rental Web Application built using Maven and Java Development Kit (JDK) 21. The application allows users to browse available cars, make orders, and payments and manage their rentals seamlessly through a user-friendly interface.

======================================================================
Code Authors
======================================================================

Michael Lunn - 13917657
    src/main/java/controller:
        AddSupplierServlet.java
        DeleteSupplierServlet.java
        EditSupplierServlet.java
        LoginServlet.java
        RegexUtils.java
        RegisterServlet.java
        SupplierServlet.java
        SuppliersServlet.java
        UpdateDetailsServlet.java
    src/main/java/model:
        dao/UserDAO.java
        dao/SupplierDAO.java
        User.java
        Admin.java
        Customer.java
        Staff.java
        Supplier.java
    src/main/webapp:
        assets/nav.jsp (Dropdown menu button)
        css/style.css (For supplier and user login, registration, settings pages etc.)
        js/settingsModal.js
        editSupplierView.jsp
        login.jsp
        register.jsp
        resetpassword.jsp
        settings.jsp
        signout.jsp
        suppliersView.jsp
        supplierView.jsp
    src/test/java/dao:
        UserDAOTest.java
        SupplierDAOTest.java
    .github/workflows:
        cd.yml
        
    /:
        README.md
        azure-pipelines-michael.yml
        .gitignore



        



Features
1. User Access Management
2. Order Management
3. Payment Management
4. Catalogue Management
5. Supplier Management
6. Account Administration
7. Availability Management
8. Records/report Management
9. Shipment Management
10. Inventory Administration

Prerequisites:
JDK 21 or higher
Apache Maven 3.6.0 or higher
MySQL or any compatible database

Github Repo:
https://github.com/BMaggi-UTS/ASD-Car-Rental.git

DB Schema:
The database schema is located in 'db' folder at the root of the directory.

Build Steps

1. Clone the repo:
    git clone https://github.com/BMaggi-UTS/ASD-Car-Rental.git
    cd ASD-Car-Rental
2. Build the project:
    mvn clean install
3. Configure the database:
    - Create an instance of MySQL running either locally or remotely and enter the details into the DB.java file.
4. Run the application
    mvn jetty:run
5. Access the application
    http://localhost:8080

Dependencies:
- JUnit 5.11
- Apache Commons Codec 1.17.1
- Jakarta EE 10.0.0
- Eclipse Jetty 11.0.23
- MySQL Connector 8.3.0

Project structure:
.
├── README.md
├── azure-pipelines-main.yml
├── db
│   └── Dump20241101.sql
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   │   ├── AddSupplierServlet.java
│   │   │   │   ├── ConnServlet.java
│   │   │   │   ├── CreateBookingServlet.java
│   │   │   │   ├── CreateListingServlet.java
│   │   │   │   ├── DeleteBookingServlet.java
│   │   │   │   ├── DeleteListingServlet.java
│   │   │   │   ├── DeleteSupplierServlet.java
│   │   │   │   ├── EditSupplierServlet.java
│   │   │   │   ├── LocationAvailabilityServlet.java
│   │   │   │   ├── LoginServlet.java
│   │   │   │   ├── ModifyBookingServlet.java
│   │   │   │   ├── RegexUtils.java
│   │   │   │   ├── RegisterServlet.java
│   │   │   │   ├── SearchCarServlet.java
│   │   │   │   ├── SupplierServlet.java
│   │   │   │   ├── SuppliersServlet.java
│   │   │   │   ├── UpdateDetailsServlet.java
│   │   │   │   ├── UpdateListingServlet.java
│   │   │   │   ├── addOrderItem.java
│   │   │   │   ├── addPayment.java
│   │   │   │   ├── deleteOrder.java
│   │   │   │   ├── deletePayment.java
│   │   │   │   ├── updateDriver.java
│   │   │   │   ├── updatePayment.java
│   │   │   │   └── viewOrders.java
│   │   │   └── model
│   │   │       ├── Admin.java
│   │   │       ├── Availability.java
│   │   │       ├── Car.java
│   │   │       ├── Customer.java
│   │   │       ├── Location.java
│   │   │       ├── Staff.java
│   │   │       ├── Supplier.java
│   │   │       ├── User.java
│   │   │       ├── dao
│   │   │       │   ├── AvailabilityDAO.java
│   │   │       │   ├── CarDAO.java
│   │   │       │   ├── DB.java
│   │   │       │   ├── DBConnector.java
│   │   │       │   ├── LocationDAO.java
│   │   │       │   ├── SupplierDAO.java
│   │   │       │   ├── UserDAO.java
│   │   │       │   ├── orderDAO.java
│   │   │       │   └── paymentDAO.java
│   │   │       ├── order.java
│   │   │       └── payment.java
│   │   └── webapp
│   │       ├── META-INF
│   │       │   └── context.xml
│   │       ├── WEB-INF
│   │       │   ├── beans.xml
│   │       │   └── web.xml
│   │       ├── addSupplierView.jsp
│   │       ├── assets
│   │       │   ├── carCards.jsp
│   │       │   ├── filterbar.jsp
│   │       │   ├── footer.jsp
│   │       │   ├── icons
│   │       │   │   ├── mail.png
│   │       │   │   ├── padlock.png
│   │       │   │   ├── phone.png
│   │       │   │   └── user.png
│   │       │   ├── imgs
│   │       │   │   └── logo.png
│   │       │   ├── locationAvailabilitySelector.jsp
│   │       │   ├── nav.jsp
│   │       │   ├── orderImages
│   │       │   │   └── Lock.png
│   │       │   └── supplier-logos
│   │       │       ├── 1.png
│   │       │       ├── 10.png
│   │       │       ├── 2.png
│   │       │       ├── 3.png
│   │       │       ├── 4.png
│   │       │       ├── 5.png
│   │       │       ├── 6.png
│   │       │       ├── 7.png
│   │       │       ├── 8.png
│   │       │       ├── 9.png
│   │       │       └── placeholder.png
│   │       ├── car.jsp
│   │       ├── catalogueStaffView.jsp
│   │       ├── checkoutView.jsp
│   │       ├── confirmationView.jsp
│   │       ├── create-booking.jsp
│   │       ├── create-listings.jsp
│   │       ├── critical-errors.jsp
│   │       ├── css
│   │       │   ├── backup style.css
│   │       │   ├── carDetail.css
│   │       │   ├── navandfooter.css
│   │       │   ├── oldstyle.css
│   │       │   ├── orderHistoryStyle.css
│   │       │   ├── orderStyle.css
│   │       │   ├── paymentStyle.css
│   │       │   ├── staffView.css
│   │       │   └── style.css
│   │       ├── delete-booking.jsp
│   │       ├── delete-listings.jsp
│   │       ├── editDriverView.jsp
│   │       ├── editPaymentView.jsp
│   │       ├── editSupplierView.jsp
│   │       ├── index.jsp
│   │       ├── js
│   │       │   ├── modify-listings.js
│   │       │   ├── script.js
│   │       │   └── settingsModal.js
│   │       ├── login.jsp
│   │       ├── modify-booking.jsp
│   │       ├── modify-listings.jsp
│   │       ├── orderHistoryView.jsp
│   │       ├── orderView.jsp
│   │       ├── paymentView.jsp
│   │       ├── register.jsp
│   │       ├── resetpassword.jsp
│   │       ├── settings.jsp
│   │       ├── signout.jsp
│   │       ├── supplierView.jsp
│   │       └── suppliersView.jsp
│   └── test
│       └── java
│           ├── dao
│           │   ├── AvailabilityDAOTest.java
│           │   ├── CarDAOTest.java
│           │   ├── SupplierDAOTest.java
│           │   ├── UserDAOTest.java
│           │   ├── orderDAOTest.java
│           │   └── paymentDAOTest.java
│           └── model
│               └── dao
└── target (omitted)
