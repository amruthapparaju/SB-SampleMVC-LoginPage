package com.springboot.sample.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.sample.entity.LoginBo;

@Repository
public class UserDaoimpl implements UserDao {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM login_details WHERE email=? AND password=? ";
	@Autowired
	private  JdbcTemplate  jt;

	@Override
	public long validate(LoginBo bo) {
	  int count=0;
	  count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getEmail(),bo.getPassword());
		return count;
	}


	
		
		


}
