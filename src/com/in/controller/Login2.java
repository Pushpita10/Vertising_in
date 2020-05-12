package com.in.controller;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean2;
import com.in.dao.UserDao2;

/**
 * Servlet implementation class LoginServlet
 */
public class Login2 extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	PrintWriter out = response.getWriter();

try
{	    

     UserBean2 user2 = new UserBean2();
     user2.setUsername(request.getParameter("username"));
     user2.setPass(request.getParameter("pass"));

     user2 = UserDao2.login(user2);
	   		    
     if (user2.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user2); 
          response.sendRedirect("application.html"); //logged-in page
     }
	        
     else 
          response.sendRedirect("OwnerLogin.html"); //error page
     out.println("<font color=red>Please fill all the fields</font>");
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}
