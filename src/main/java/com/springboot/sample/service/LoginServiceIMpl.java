package com.springboot.sample.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sample.dao.UserDao;
import com.springboot.sample.entity.LoginBo;
import com.springboot.sample.entity.LoginDTO;

@Service
public class LoginServiceIMpl implements LoginService {
	
	@Autowired
	private UserDao dao;

	@Override
	public String ServiceValidate(LoginDTO dto) {
		// TODO Auto-generated method stub
		long count=0;
		LoginBo bo=null;
		
		bo=new LoginBo();
		
		BeanUtils.copyProperties(dto,bo);

		
		count=dao.validate(bo);
		return count==0?"InValid Credentials ": "Valid Credentials";
	}

}
