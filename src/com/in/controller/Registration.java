package com.in.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDataServlet
 */
public class Registration extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String fullname = request.getParameter("fullname");
  String email = request.getParameter("email");
  String username = request.getParameter("username");
  String pass = request.getParameter("pass");
  String repass = request.getParameter("repass");
  //String qual = request.getParameter("qual");
  //String percent = request.getParameter("percent");
  //String year = request.getParameter("yop");
  //Boolean valid = request.getParameter("valid")
  // validate given input
  if (fullname.isEmpty() || email.isEmpty() || username.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("registration1.html");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } else {
   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 

    String query = "insert into userdetails(fullname,email,username,pass,repass) values(?,?,?,?,?)";

    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, fullname);
    ps.setString(2, email);
    ps.setString(3, username);
    ps.setString(4, pass);
    //ps.setInt(5, Integer.parseInt(age));
    ps.setString(5, repass);
    //ps.setString(7, percent);
    //ps.setString(8, year);
   // ps.setBoolean(9, valid);

    ps.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted");
    ps.close();
    con.close();
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
   rd.forward(request, response);
  }
 }
}
