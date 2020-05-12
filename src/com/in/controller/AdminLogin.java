package com.in.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.in.connection.DataConnect;

//@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		// String quiry = " select * from adminregistration where email=? AND
		// password=?";
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		System.out.println(email);

		try {
			DataConnect db = new DataConnect();
			Connection con = db.dataConnect();
			PreparedStatement ps = con.prepareStatement("select * from adminregistration where username=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				response.sendRedirect("admin.html");
			}
			ps.close();
			con.close();

		} catch (SQLException e) {
		}

	}

}
