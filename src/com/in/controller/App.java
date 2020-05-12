package com.in.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.in.dao.AppDao;
import com.bean.Application;

//@WebServlet("/App")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int s = 0;
	//private static final String SAVE_DIR = "product/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Application u = new Application();

		//String savePath = "C:/Users/Puspita Ganguly/Titan/Titans/WebContent/images/" + SAVE_DIR;
		//System.out.println(savePath);
		//ile fileSaveDir = new File(savePath);
		//if (!fileSaveDir.exists()) {
			//fileSaveDir.mkdir();
		//}

		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String website = request.getParameter("website");
		String restaurant = request.getParameter("restaurant");
		String address = request.getParameter("address");
		String estd = request.getParameter("estd");
		String pincode = request.getParameter("pincode");
		String country = request.getParameter("country");
		String restauranttype = request.getParameter("restauranttype");
		String description = request.getParameter("description");
		String userperiod = request.getParameter("userperiod");
		Part part = request.getPart("imagePath");
		System.out.println(part.getName());
		//String fileName = extractFileName(part);
		//part.write(fileName);

		u.setEmail(email);
		u.setPhone(phone);
		u.setWebsite(website);
		u.setRestaurant(restaurant);
		u.setAddress(address);
		u.setEstd(estd);
		u.setPincode(pincode);
		u.setCountry(country);
		u.setRestauranttype(restauranttype);
		u.setDescription(description);
		u.setUserperiod(userperiod);
		//u.setImagepath(imagePath);

		s = AppDao.application(u);
		if (s == 0) {
			request.setAttribute("message",
					"<font color='red' size='5'>Oops!! something went wrong, please try again.</font>");
			request.getRequestDispatcher("application.html").include(request, response);
		} else if (s == 1) {

			request.setAttribute("message",
					"<font color='#006400' size='5'>Thank you for register ..please login .</font>");
			request.getRequestDispatcher("owner.html").include(request, response);
		}

	}

	// private String extractFileName(Part part) {
	//	String contentDisp = part.getHeader("content-disposition");
		//String[] items = contentDisp.split(";");
		//for (String s : items) {
			//if (s.trim().startsWith("filename")) {
				//return s.substring(s.indexOf("=") + 2, s.length() - 1);
			//}
		//}
		//return "";
	}

