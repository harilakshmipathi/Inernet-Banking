package com.HSBCBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.HSBCBank.bean.firsttimeuserbean;
import com.HSBCBank.bean.sendmoneybean;
import com.HSBCBank.util.DBconnection;

public class sendmoneydao {
	public String signupUser(sendmoneybean register)
	 {
		System.out.println("ssssss");
		String beneficiaryname = register.getbeneficiaryname();
		String accountnumber = register.getaccountnumber();
		String amount = register.getamount();
		String ifsccode = register.getifsccode();
		String customerid = register.getcustomerid();
	
	 
	 Connection con = null;
	 PreparedStatement st = null;
	 
	 try
		{
		 con = DBconnection.createConnection();
		 String query = "Insert into transfer(beneficiaryname,accountnumber,amount,ifsccode,customerid) "
		 		+ "values(?,?,?,?,?)"; 
			 st = con.prepareStatement(query);
			 st.setString(1, beneficiaryname);
			st.setString(2, accountnumber);
			st.setString(3, amount);
	       st.setString(4,ifsccode);
	       st.setString(5,customerid);
	    
	      
			System.out.println("about to execute..." +query);
			int i= st.executeUpdate();
			System.out.println(i);
			
			if (i == 0)  //Just to ensure data has been inserted into the database
				return "Oops.. Something went wrong there..!";
			 
				}	
			catch(SQLException e)
			{
			e.printStackTrace();
			}
	 /////
	 
	 
			try
			{
			 con = DBconnection.createConnection();
			 String query = "update customers set balance =  balance + " + register.getamount()
			 +" Where customerid =  " +register.getaccountnumber();
				 		 System.out.println("dao 222222"+query);
			 System.out.println("dao 333333");	
				 st = con.prepareStatement(query);
			//	 st.setString(1, pass);
				System.out.println("before execute update...");
				int i= st.executeUpdate(query);
				
				System.out.println("dao 44444444 "+i);
				
				if (i==0)  //Just to ensure data has been inserted into the database
					return "Oops.. Something went wrong there..!";
 		}	
				catch(SQLException e)
				{
				e.printStackTrace();
				}
			
///////		
	try
	{
	 con = DBconnection.createConnection();
	 String query = "update customers set balance =  balance - " + register.getamount()+" "
		 		+ " Where   customerid =  " +register.getcustomerid();
		 		 System.out.println("dao 222222"+query);
	 System.out.println("in subtraction");	
		 st = con.prepareStatement(query);
	//	 st.setString(1, pass);
		System.out.println("before execute update...");
		int i= st.executeUpdate(query);
		
		System.out.println("dao 44444444 "+i);
		//con.commit();
		if (i==0)  //Just to ensure data has been inserted into the database
			return "error"; 
	}	
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return "Sucess";
 /////
	 }
}
