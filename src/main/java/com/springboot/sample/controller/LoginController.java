package com.springboot.sample.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.sample.entity.LoginDTO;
import com.springboot.sample.entity.LoginVo;
import com.springboot.sample.service.LoginService;


@Controller
public class LoginController {
	@Autowired
	private  LoginService service;
	
	
	@GetMapping("/login.htm")  //to handler initial phase request
	public   String  showForm(@ModelAttribute("login") LoginVo cmd) {
		System.out.println("hello");
		return "login_form";
	}
	
	@PostMapping("/login.htm")
	public   String  processForm(Map<String,Object> map,@ModelAttribute("login") LoginVo cmd) {
		 LoginDTO dto=null;
		 String resultMsg=null;
		 dto=new LoginDTO();
		 BeanUtils.copyProperties(cmd, dto);
		 resultMsg=service.ServiceValidate(dto);
		 map.put("resultMsg", resultMsg);
		 return "login_form";
	}

}
