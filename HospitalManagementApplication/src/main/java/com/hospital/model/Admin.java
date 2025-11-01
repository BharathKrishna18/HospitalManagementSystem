package com.hospital.model;


public class Admin {
	private String adminId;
	private String password;
	private String name;
	
	public Admin(String adminId,String password,String name) {
		this.adminId = adminId;
		this.password = password;
		this.name = name;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
