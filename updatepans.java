package com.HSBCBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HSBCBank.bean.updateadharbean;
import com.HSBCBank.bean.updatepanbean;
import com.HSBCBank.dao.upadatedao;
import com.HSBCBank.dao.upadatepandao;

/**
 * Servlet implementation class updatepans
 */
@WebServlet("/updatepans")
public class updatepans extends HttpServlet {
	public HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepans() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("hari");
	   	 
		   	String customerid = request.getParameter("customerid");
				String pannumber = request.getParameter("pannumber");
		
				
				System.out.println("11111111");
				updatepanbean loginBean = new updatepanbean();
				loginBean.setcustomerid(customerid);
				loginBean.setpannumber(pannumber);
				
				System.out.println("11111111");
				
				
				upadatepandao loginDao = new upadatepandao();
				System.out.println("555");
				String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
				 System.out.println("666666");
				 System.out.println("servlet 7777"+userValidate);
				if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
				 {
					 session = request.getSession(); //Creating a session
					session.setAttribute("password", "pannumber"); //setting session attribute	

					request.setAttribute("hari", true);
					
					request.getRequestDispatcher("/Bankhome.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
				 }
				 else
				 {
			         request.setAttribute("Customerlogin", false);
				 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
				 request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);//forwarding the request
				 }
			}
		}
