package com.in.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.in.connection.DataConnect;
import com.bean.Application;


public class AppDao {
	public static int application(Application u1) {
		int status = 0;
		try {
			DataConnect con1 = new DataConnect();
			Connection con = con1.dataConnect();
			System.out.println("data1");
			PreparedStatement ps1 = con.prepareStatement(
					"insert into app(email,phone,website,restaurant,address,estd,pincode,country,restauranttype,description,userperiod,imagePath)values(?,?,?,?,?,?,?,?,?,?,?)");
			// System.out.println(status);
			ps1.setString(1, u1.getEmail());
			ps1.setString(2, u1.getPhone());
			ps1.setString(3, u1.getWebsite());
			ps1.setString(4, u1.getRestaurant());
			ps1.setString(5, u1.getAddress());
			ps1.setString(6, u1.getEstd());
			ps1.setString(7, u1.getPincode());
			ps1.setString(8, u1.getCountry());
			ps1.setString(9, u1.getRestauranttype());
			ps1.setString(10, u1.getDescription());
			ps1.setString(11, u1.getUserperiod());
			ps1.setString(12, u1.getImagepath());
			status = ps1.executeUpdate();
			System.out.println(status);
			con.close();
		}

		catch (SQLException e) {
			System.out.println(e);
		}
		return status;
	}

}
