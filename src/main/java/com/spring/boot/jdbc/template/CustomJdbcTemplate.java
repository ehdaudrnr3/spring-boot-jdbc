package com.spring.boot.jdbc.template;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CustomJdbcTemplate extends NamedParameterJdbcTemplate {

	public CustomJdbcTemplate(DataSource dataSource) {
		super(dataSource);
	}

	public int update(String sql, HashMap<String, Object> parameters) throws DataAccessException {
		try {
			this.update(sql, parameters);
		} catch (RuntimeException e) {
			throw e;
		}
		return 0;
	}
}
