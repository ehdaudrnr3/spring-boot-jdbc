package com.spring.boot.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.boot.jdbc.model.User;

@Component
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(User user) {
		String sql = "INSERT INTO USER(USER_NAME, PASSWORD, AGE) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPasswrod(), user.getAge());
	}
	
	public List<User> findAll() {
		String sql = "SELECT * FROM USER";
		
        RowMapper<User> mapper = new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("user_name"),
						rs.getString("password"),
						rs.getInt("age"));
						
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}
	
	public List<User> findByName(String name) {
		String sql = "SELECT * FROM USER WHERE USER_NAME =?";
		
		RowMapper<User> mapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("user_name"),
						rs.getString("password"),
						rs.getInt("age"));
			}
		};
		
		return jdbcTemplate.query(sql, mapper, name);
	}
	
	public void update(User user) {
		String sql = "UPDATE USER SET PASSWORD = ?, AGE = ? WHERE USER_NAME =?";
		jdbcTemplate.update(sql, user.getPasswrod(), user.getAge(), user.getUsername());
	}
}
