package com.newroad.acl.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newroad.acl.system.entity.Function;
import com.newroad.acl.system.entity.User;
import com.newroad.acl.system.service.FunctionServiceIf;
import com.newroad.acl.system.service.UserRoleServiceIf;
import com.newroad.acl.system.service.UserServiceIf;

@Controller
public class LoginController {
	@Resource
	UserServiceIf service;

	@Resource
	UserRoleServiceIf userRoleService;
	
	@Resource
	FunctionServiceIf functionService;
	
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
		//登录成功
		//将登录成功之后的用户信息保存到session中
		session.setAttribute("user", user);
		//获得登录成功之后的这个用户的角色信息
		List<Integer> roleIds=userRoleService.getRoleIdsByUserId(user.getUserId());
		//将用户的角色Id保存到session 中
		session.setAttribute("roleIds", roleIds);
		
		//获取当前用户的按钮权限
		List<Function> funs=functionService.getFunctionsByRoleIdAndFuncType(roleIds, 0);
		//将这个用户的按钮权限存储到这个map中，然后将map存储到session中
		Map<String, Function> funsByCode=new HashMap<String, Function>();
		Map<String, Function> functionsByUrl=new HashMap<String, Function>();

		
		for(Function function:funs) {
			
			funsByCode.put(function.getFuncCode(), function);
			functionsByUrl.put(function.getFuncUrl(), function);
		}
		
		session.setAttribute("functionsByCode", funsByCode);
		session.setAttribute("functionsByUrl", functionsByUrl);
		
		return "jsp/index";	
	}

}
