package com.HSBCBank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.HSBCBank.bean.adminbean;
import com.HSBCBank.util.DBconnection;

public class adminlogindao {
	public String authenticateUser(adminbean loginbean )
	{
		String id = loginbean.getadminid();
		String pass = loginbean.getPassword();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		String adminIdDB = "";
		String passwordDB = "";
		
		try {
			con = DBconnection.createConnection();
			statement =  con.createStatement();
			System.out.println("111111111");
			resultset =   statement.executeQuery("select adminid, password from admin");
			System.out.println("2222222222");
			while(resultset.next())
			{
				System.out.println("333333");
				adminIdDB = resultset.getString("adminid");
				System.out.println("444444"+adminIdDB);
				passwordDB = resultset.getString("password");
				
				System.out.println(id);
				System.out.println(pass);
				
				System.out.println("5555");
				
				if(id.equals(adminIdDB) && pass.equals(passwordDB))
				{
				return "SUCCESS"; 
				////If the user entered values are already present in 
				//database, which means user has already registered so I will 
				//return SUCCESS message.
				}
			}
		}
			catch(SQLException e)
				{
				e.printStackTrace();
				}
		return "Invalid user credentials";
		}					
	}	
