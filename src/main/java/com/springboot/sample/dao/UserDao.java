package com.springboot.sample.dao;

import com.springboot.sample.entity.LoginBo;

public interface UserDao {
	
	public long validate(LoginBo bo);

}
