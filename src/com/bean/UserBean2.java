package com.bean;

public class UserBean2 {
	private String fullname;
	private String email;
	private String username;
	private String pass;
	private String repass;
	// private String qual;
	// private String percent;
	// private String yop;
	public boolean valid;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
}
