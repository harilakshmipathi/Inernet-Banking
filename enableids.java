package com.HSBCBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HSBCBank.bean.Enableidbean;

import com.HSBCBank.dao.enableiddao;


/**
 * Servlet implementation class enableids
 */
@WebServlet("/enableids")
public class enableids extends HttpServlet {
	public HttpSession session;
	
    public enableids() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hari");

		String customerid = request.getParameter("customerid");
		String emailid = request.getParameter("emailid");
		
		System.out.println("11111111");
		Enableidbean loginBean = new Enableidbean();
		loginBean.setcustomerid(customerid);
		loginBean.setemailid(emailid);
		System.out.println("11111111");
		
		
		enableiddao loginDao = new enableiddao();
		System.out.println("555");
		String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
		 System.out.println("666666");
		 System.out.println("servlet 7777"+userValidate);
		 
		if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
		 {
			 session = request.getSession(); //Creating a session
			session.setAttribute("customerid", customerid); //setting session attribute	

			request.setAttribute("hari", true);
			
			request.getRequestDispatcher("/Bankcustomer.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		 }
		 else
		 {
	         request.setAttribute("Customerlogin", false);
		 request.setAttribute("errorMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
		 request.getRequestDispatcher("/enableid.jsp").forward(request, response);//forwarding the request
		 }
	
}
	}


