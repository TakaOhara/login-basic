package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserInfo findByEmail(String email) {
		String sql = "SELECT id, username, email, password, enabled, authority "
				+ "FROM user_info WHERE email = ?";
		
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, email);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername((String)result.get("username"));
		userInfo.setEmail((String)result.get("email"));
		userInfo.setPassword((String)result.get("password"));
		userInfo.setAuthority((String)result.get("authority"));
		userInfo.setEnabled((boolean)result.get("enabled"));
		
		return userInfo;
	}

	@Override
	public void insert(UserInfo userInfo) {
		jdbcTemplate.update("INSERT INTO user_info(username, email, password, enabled, authority) VALUES(?, ?, ?, ?, ?)",
				 userInfo.getUsername(), userInfo.getEmail(), userInfo.getPassword(), userInfo.getEnabled(), userInfo.getAuthority() );
	}

}
