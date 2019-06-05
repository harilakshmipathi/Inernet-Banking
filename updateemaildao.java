package com.HSBCBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.HSBCBank.bean.updateemailbean;
import com.HSBCBank.util.DBconnection;

public class updateemaildao {
	public String authenticateUser(updateemailbean loginbean )
{

	
	   String customerid =loginbean.getcustomerid();
		String emailId= loginbean.getemailId();

		System.out.println("in update email custid = " +customerid);
		
		Connection con = null;
		 PreparedStatement st = null;

		 try
			{
			 con = DBconnection.createConnection();
			 System.out.println("dao 11111");
			 String query = "update customers set emailid = '"+loginbean.getemailId()+"'"
			 		+ " Where customerid = "+ loginbean.getcustomerid();
	       
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

