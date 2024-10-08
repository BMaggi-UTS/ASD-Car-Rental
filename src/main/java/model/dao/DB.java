package model.dao;

import java.sql.Connection;
public abstract class DB {   
protected String URL = "jdbc:mysql://13.55.60.202:3306/";//replace this string with your jdbc:derby local host url   
protected String db = "CarRental-ASD";//name of the database   
protected String dbuser = "wy5jR63bAEYi1GxT";//db root user   
protected String dbpass = "6JcL1ECgLzQnmH75"; //db root password   
protected String driver = "com.mysql.cj.jdbc.Driver"; //jdbc client driver
protected Connection conn; //connection null-instance to be initialized in sub-classes
}
