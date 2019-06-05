package com.HSBCBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HSBCBank.bean.updateadharbean;
import com.HSBCBank.bean.updateemailbean;
import com.HSBCBank.dao.upadatedao;
import com.HSBCBank.dao.updateemaildao;

/**
 * Servlet implementation class updateemails
 */
@WebServlet("/updateemails")
public class updateemails extends HttpServlet {
	public HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateemails() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 System.out.println("hari");
	    	String customerid = request.getParameter("customerid");
		 
		 String emailId = request.getParameter("emailId");
				System.out.println("in reuest " + request.getParameter("customerid"));
				System.out.println("email id is  " + request.getParameter("emailId"));
				
				System.out.println("in update email first custid = " +customerid);
				updateemailbean loginBean = new updateemailbean();
				loginBean.setcustomerid(customerid);
				loginBean.setemailId(emailId);
				
				System.out.println("11111111");
				
				
				updateemaildao loginDao = new updateemaildao();
				System.out.println("555");
				String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
				 System.out.println("666666");
				 System.out.println("servlet 7777"+userValidate);
				if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
				 {
					 session = request.getSession(); //Creating a session
					session.setAttribute("password", emailId); //setting session attribute	

					request.setAttribute("hari", true);
					
					request.getRequestDispatcher("/Bankcustomer.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
				 }
				 else
				 {
			         request.setAttribute("Customerlogin", false);
				 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
				 request.getRequestDispatcher("/upadateemails.jsp").forward(request, response);//forwarding the request
				 }
			}
		}

