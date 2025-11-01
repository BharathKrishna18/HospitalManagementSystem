package com.hospital.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class DoctorRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public String findDoctorByIdandPassword(String doctorId,String password) {
		String sql = "select name from doctor where doctorId = ? and password = ?";
		try {
			return jdbcTemplate.queryForObject(sql,String.class,doctorId,password);
		}catch(Exception exception) {
			return "Invalid Credentials";
		}
	}
}
