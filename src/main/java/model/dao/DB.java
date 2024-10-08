package model.dao;
import java.sql.Connection;
public abstract class DB {   

// EC2 DB
// protected String URL = "jdbc:mysql://13.55.60.202:3306/";
// protected String db = "CarRental-ASD";  
// protected String dbuser = "wy5jR63bAEYi1GxT";//db root user   
// protected String dbpass = "6JcL1ECgLzQnmH75"; //db root password   


// // Local DB
protected String URL = "jdbc:mysql://localhost:3306/";
protected String db = "CarRental-ASD";  
protected String dbuser = "root";//db root user   
protected String dbpass = "password"; //db root password   


protected String driver = "com.mysql.cj.jdbc.Driver"; //jdbc client driver
protected Connection conn; //connection null-instance to be initialized in sub-classes
}
