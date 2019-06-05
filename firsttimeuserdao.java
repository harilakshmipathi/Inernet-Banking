package com.HSBCBank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.HSBCBank.bean.firsttimeuserbean;

import java.sql.Connection;

import com.HSBCBank.util.DBconnection;
import com.HSBCBank.bean.firsttimeuserbean;

public class firsttimeuserdao {
	public String signupUser(firsttimeuserbean register)
	 {
		System.out.println("ssssss");
	 String Name = register.getName();
	 String pass = register.getPassword();
	 String emailid= register.getEmailid();
	 String customerid = register.getcustomerid();
	 String confrimpassword = register.getconfrimpassword();
	 String balance = register.getbalance();
	 
	 Connection con = null;
	 PreparedStatement st = null;
	 
	 try
		{
		 con = DBconnection.createConnection();
		 String query = "Insert into customers(name,password,emailid,customerid,confrimpassword,balance) "
		 		+ "values(?,?,?,?,?,?)"; 
			 st = con.prepareStatement(query);
			 st.setString(1, Name);
			st.setString(2, pass);
	       st.setString(3,emailid);
	       st.setString(4, customerid);
	       st.setString(5, confrimpassword);
	       st.setString(6, balance);
	      
			System.out.println("about to execute...");
			int i= st.executeUpdate();
			System.out.println(i);
			
			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
				}	
			catch(SQLException e)
			{
			e.printStackTrace();
			}
			return "Oops.. Something went wrong there..!";
	 }
	 
	
}