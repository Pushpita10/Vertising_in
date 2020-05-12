package com.in.controller;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.in.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class Login extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	PrintWriter out = response.getWriter();

try
{	    

     UserBean user = new UserBean();
     user.setUsername(request.getParameter("username"));
     user.setPass(request.getParameter("pass"));

     user = UserDao.login(user);
	   		    
     if (user.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("customer.html"); //logged-in page
     }
	        
     else 
          response.sendRedirect("LoginPage.html"); //error page
     out.println("<font color=red>Please fill all the fields</font>");
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}
