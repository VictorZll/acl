package com.newroad.acl.system.service;

import java.util.List;

import com.newroad.acl.system.entity.User;

public interface UserServiceIf {
	User login(String username,String password);
	
	List<User> listByPage(Integer page,Integer rows);
	
	Integer getCount();
}
