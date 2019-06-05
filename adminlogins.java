package com.HSBCBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HSBCBank.bean.Bankcustomerbean;
import com.HSBCBank.bean.adminbean;
import com.HSBCBank.dao.BankCustomerdao;
import com.HSBCBank.dao.adminlogindao;

@WebServlet("/adminlogins")
public class adminlogins extends HttpServlet {
	public HttpSession session;
	private static final long serialVersionUID = 1L;
       
    
    public adminlogins() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

 		
	   	 System.out.println("hari");

			String Id = request.getParameter("adminid");
			String pass = request.getParameter("password");
			
			System.out.println("11111111");
			adminbean loginBean = new adminbean();
			loginBean.setadminid(Id);
			loginBean.setPassword(pass);
			System.out.println("11111111");
			
			
			adminlogindao loginDao = new adminlogindao();
			System.out.println("555");
			String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
			 
			if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
			 {
				 session = request.getSession(); //Creating a session
				session.setAttribute("customerId", Id); //setting session attribute	

				request.setAttribute("hari", true);
				
				request.getRequestDispatcher("/viewadminpage.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			 }
			 else
			 {
		         request.setAttribute("Customerlogin", false);
			 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			 request.getRequestDispatcher("/Bankcustomer.jsp").forward(request, response);//forwarding the request
			 }
		}
	}
