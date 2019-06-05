package com.HSBCBank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.HSBCBank.bean.Bankcustomerbean;
import com.HSBCBank.dao.BankCustomerdao;


/**
 * Servlet implementation class Bankcustomers
 */
@WebServlet("/Bankcustomers")
public class Bankcustomers extends HttpServlet {
	public HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()  
     */
    public Bankcustomers() {
        super();
    
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
		
   		
   	 System.out.println("hari");

		String Id = request.getParameter("customerid");
		String pass = request.getParameter("password");
		String name ;//= request.getParameter("Name");
		String balance;//= request.getParameter("Balance");
		PrintWriter out = response.getWriter();
		System.out.println("11111111");
		Bankcustomerbean loginBean = new Bankcustomerbean();
		loginBean.setcustomerid(Id);
		loginBean.setPassword(pass);
		System.out.println("11111111");
		
		
		BankCustomerdao loginDao = new BankCustomerdao();
		System.out.println("555");
		String userValidate = loginDao.authenticateUser(loginBean);//Calling authenticateUser function
		
		if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
		 {
		
		
           			HttpSession session=request.getSession(); // true session gets created 
			      session.setAttribute("CustId",Id);

			      System.out.println("session created for " + Id);
			      
			  	out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limnote-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function() {");
				out.println("swal ( 'welcome' , 'HSBC BANK !' , 'success');");
				out.println("});");
				out.println("</script>");

			request.getRequestDispatcher("/Transistion.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		 }
		 else
		 {

				out.println("<script src='https://cdnjs.cloudfare.com/ajax/libs/limnote-sweetalert2/6.11.4/sweetalert2.al.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function() (");
				out.println("swal ( 'incorrecct id or password !' , 'success');");
				out.println("));");
				out.println("</script>");
				
	         request.setAttribute("Customerlogin", false);
		 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
		 request.getRequestDispatcher("/Bankcustomer.jsp").forward(request, response);//forwarding the request
		 }
		 
}
}
