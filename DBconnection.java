package com.HSBCBank.util;

 
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

		public static Connection createConnection()
		 {
		Connection  con = null;
		 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		 String username = "system"; 
		 String password = "root"; 	 
		 try 
		 {
		 try 
		 {
		 Class.forName("oracle.jdbc.driver.OracleDriver"); 
		 } 
		 catch (ClassNotFoundException e)
		 {
		 e.printStackTrace();
		 }
		 
		 con = DriverManager.getConnection(url, username, password); 
		 System.out.println("Printing connection object "+con);
		 } 
		 catch (Exception e) 
		 {
		 e.printStackTrace();
		 }
		 
		 return con; 
		 }
		}



