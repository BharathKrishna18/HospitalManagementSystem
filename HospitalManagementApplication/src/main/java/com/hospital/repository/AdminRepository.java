package com.hospital.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String validateAdmin(String adminId,String password) {
		try {
			String sql = "select name from admin where adminid= ? and password = ?";
			return jdbcTemplate.queryForObject(sql,String.class,adminId,password);
		}catch(Exception exception) {
			return "Invalid Credentials";
		}
	}
}
