Sydney Car Rental Web Application

Overview
This is a Car Rental Web Application built using Maven and Java Development Kit (JDK) 21. The application allows users to browse available cars, make orders, and payments and manage their rentals seamlessly through a user-friendly interface.

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

Build steps:

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
- 