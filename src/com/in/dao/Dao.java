package com.in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.in.connection.DataConnect;
import com.bean.Connect;
//import com.bean.Application;

public class Dao {
	

	public static int adminregister(Connect u1) {
		int status = 0;
		try {
			DataConnect con1 = new DataConnect();
			Connection con = con1.dataConnect();
			System.out.println("data1");
			PreparedStatement ps1 = con
					.prepareStatement("insert into adminregistration(username,email,pass,repass)values(?,?,?,?)");
			ps1.setString(1, u1.getUsername());
			ps1.setString(2, u1.getEmail());
			ps1.setString(3, u1.getPass());
			ps1.setString(4, u1.getRepass());
			status = ps1.executeUpdate();
			con.close();
		}

		catch (SQLException e) {
			System.out.println(e);
		}
		return status;
	}




	public boolean isValidAdmin(String un, String pwd) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select * from adminregistration where email=? and pass=? ";
			DataConnect con1 = new DataConnect();
			con = con1.dataConnect();
			ps = con.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			flag = rs.next();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return flag;

	}

	
}