package com.HSBCBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.HSBCBank.bean.forgotpasswordbean;
import com.HSBCBank.util.DBconnection;

public class forgotpasworddao {
	public String authenticateUser(forgotpasswordbean loginbean )
	{
		
		String pass= loginbean.getpassword();
		String customerid=loginbean.getcustomerid();
		
		Connection con = null;
		 PreparedStatement st = null;

		 try
			{
			 con = DBconnection.createConnection();
			 System.out.println("dao 11111");
			 String query = "update customers set password = "+ loginbean.getpassword()+" "
			 		+ " Where customerid in "+loginbean.getcustomerid();
	       
			 System.out.println("dao 222222"+query);
			 System.out.println("dao 333333");	
				 st = con.prepareStatement(query);
			//	 st.setString(1, pass);
				System.out.println("before execute update...");
				int i= st.executeUpdate(query);
				
				System.out.println("dao 44444444 "+i);
				
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