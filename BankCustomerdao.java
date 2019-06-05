package com.HSBCBank.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.HSBCBank.bean.Bankcustomerbean;


import com.HSBCBank.util.DBconnection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BankCustomerdao {
	public String authenticateUser(Bankcustomerbean loginbean )
	{
		String id = loginbean.getcustomerid();
		String pass = loginbean.getPassword();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		String customerIdDB = "";
		String passwordDB = "";
		String nameDB ="";
		String balanceDB="";
		
		try {
			con = DBconnection.createConnection();
			statement =  con.createStatement();
			System.out.println("111111111");
			resultset =   statement.executeQuery("select customerid, password,name,balance"
					+ " from customers");
			System.out.println("2222222222");
			while(resultset.next())
			{
				System.out.println("333333");
				customerIdDB = resultset.getString("customerid");
				System.out.println("444444"+customerIdDB);
				passwordDB = resultset.getString("password");
				nameDB = resultset.getString("name");
				balanceDB = resultset.getString("balance");
				
				System.out.println(id);
				System.out.println(pass);
				
				System.out.println("5555");
				
				if(id.equals(customerIdDB) && pass.equals(passwordDB))
				{
				return "SUCCESS";
				////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
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