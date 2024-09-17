package model.dao;
import java.sql.Connection;
public abstract class DB {   
    protected String URL = "jdbc:mysql://13.55.60.202:3306/";//replace this string with your jdbc:derby local host url   
    protected String db = "CarRental-ASD";//name of the database   
    protected String dbuser = "root";//db root user   
    protected String dbpass = "password"; //db root password   
    protected String driver = "com.mysql.cj.jdbc.Driver"; //jdbc client driver
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}