package com.newroad.acl.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newroad.acl.system.entity.User;
import com.newroad.acl.system.service.UserServiceIf;

@Controller
@RequestMapping("/system/user")
public class UserController {
	
	@Resource
	UserServiceIf service;
	
	@RequestMapping
	public String toListUser() {
		return "system/user";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> listUser(Integer page,Integer rows){
		if(page==null||rows==null) {
			return new HashMap<>();
		}
		int count=service.getCount();
		List<User> list=service.listByPage(page, rows);
		Map<String, Object> map=new HashMap<>();
		map.put("rows", list);
		map.put("total", count);
		return map;
	}
	
	

}
