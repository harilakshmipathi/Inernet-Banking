package com.HSBCBank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HSBCBank.bean.firsttimeuserbean;
import com.HSBCBank.dao.firsttimeuserdao;

/**
 * Servlet implementation class viewcustomerpage
 */
@WebServlet("/viewcustomerpage")
public class viewcustomerpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcustomerpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			
				 System.out.println("hari");
				
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String emailid = request.getParameter("emailid");
				String customerid = request.getParameter("customerid");
				String confrimpassword = request.getParameter("confrimpassword");
				
				
				firsttimeuserbean register  = new firsttimeuserbean();
				register.setName(name);	
				register.setPassword(password);
				register.setemailid(emailid);
				register.setcustomerid(customerid);
				register.setconfrimpassword(confrimpassword);
				
				
				firsttimeuserdao signupDao = new firsttimeuserdao();
				//The core Logic of the Signup application is present here. We are going to insert user data in to the database.
				String userSignup = signupDao.signupUser(register);
				if(userSignup.equals("SUCCESS"))   //On success, you can display a message to user on Home page
				{
					request.setAttribute("hari", true);
				request.getRequestDispatcher("/Bankhome.jsp").forward(request, response);
				}
				else   //On Failure, display a meaningful message to the User.
				{
					request.setAttribute("customersigup", false);
				request.setAttribute("errMessage", userSignup);
				request.getRequestDispatcher("/firsttimeuser.jsp").forward(request, response);
				}
				}
		}