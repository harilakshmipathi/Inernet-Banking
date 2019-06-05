package com.HSBCBank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.HSBCBank.bean.firsttimeuserbean;
import com.HSBCBank.bean.sendmoneybean;
import com.HSBCBank.dao.firsttimeuserdao;
import com.HSBCBank.dao.sendmoneydao;

/**
 * Servlet implementation class sendmoneys
 */
@WebServlet("/sendmoneys")
public class sendmoneys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmoneys() {
        super();
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 System.out.println("hari");
		 HttpSession session= request.getSession(false);
		 
		 response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		///request.getRequestDispatcher("Transistion.jsp").include(request, response);
		
		String beneficiaryname = request.getParameter("beneficiaryname");
		String accountnumber = request.getParameter("accountnumber");
		String amount = request.getParameter("amount");
		String ifsccode = request.getParameter("ifsccode");
		String customerid = (String)session.getAttribute("CustId");
		
		
		
		
		sendmoneybean register  = new sendmoneybean();
		register.setbeneficiaryname(beneficiaryname);	
		register.setaccountnumber(accountnumber);
		register.setamount(amount);
		register.setifsccode(ifsccode);
		register.setcustomerid(customerid);
	
		
		
		 sendmoneydao signupDao = new  sendmoneydao();
		//The core Logic of the Signup application is present here. We are going to insert user data in to the database.
		String userSignup = signupDao.signupUser(register);
		if(userSignup.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			out.print("Welcome, "+customerid);
			//HttpSession session=request.getSession(); // true session gets created 
			session.setAttribute("CustId",customerid);
		request.getRequestDispatcher("/Bankhome.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("customersigup", false);
		request.setAttribute("errMessage", userSignup);
		request.getRequestDispatcher("/sendmoney.jsp").forward(request, response);
		}
		}
}
