package com.newroad.acl.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newroad.acl.system.entity.User;
import com.newroad.acl.system.service.UserServiceIf;

@Controller
public class LoginController {
	@Resource
	UserServiceIf service;
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		if(StringUtils.isBlank(username)||StringUtils.isBlank(password)) {
			return "redirect:/login.jsp";
		}
		User user=service.login(username, password);
		System.out.println("username->"+username);
		if(user==null) {
			return "redirect:/login.jsp";
		}
		session.setAttribute("user", user);
		return "jsp/index";	
	}

}
