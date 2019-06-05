package com.HSBCBank.dao;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.pept.transport.Connection;

public class sendmail { 
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	Connection Conn = null;
	String Dbname =  "customers";
	String  serverip="100.00.000.000";
	String servereport= "3316";
	String url ="jdbc:sqlserver://"+serverip+"\\SQLEXPERSS:"+servereport+";databaseName="+Dbname+"";
	Connection con = null;
	 PreparedStatement st = null;
	ResultSet result=null;
	Statement  stmt=null;
String driver ="jdbc:oracle:thin:@localhost:1521:orcl";
String username =  "system"; 
String password =  "root"; 	 

try {
	Class.forName("driver").newInstance(); 
	con = (Connection) DriverManager.getConnection(url,username,password);
	 result = null;
	 String emailTo,emailSubject,emailBody,emailAttachments;
	 result = ((java.sql.Statement) stmt).executeQuery("Select * fromm customers");
	 
	 while(result.next())
		{
			emailTo =result.getString("emailTo");
			emailSubject =result.getString("emailSubject");
			emailBody =result.getString("emailBody");
			emailAttachments =result.getString("emailAttachments");
			
			System.out.println( emailTo +" /" +emailSubject + "/" + emailBody + "/" + emailAttachments);

		}
			Conn.close();
		
	}
		catch(SQLException e)
			{
			e.printStackTrace();
			}
			
		
}	
	
}



