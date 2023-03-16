package com.xadmin.usermanagement.utils;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 public static Connection createConnection()
 {
     Connection con =null;
     String url = "jdbc:mysql://localhost:3306/userdb"; //MySQL URL and followed by the database name
     String username = "root"; 
     String password = "boufous"; //MySQL password   
     try 
     {

          Class.forName("com.mysql.jdbc.Driver"); //loading  driver 
         System.out.println("error sql");
         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
        
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }
     

     System.out.println("Printing connection object "+con);
     return con; 
 }
}