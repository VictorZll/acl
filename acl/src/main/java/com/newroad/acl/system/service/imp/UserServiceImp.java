package com.newroad.acl.system.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newroad.acl.system.dao.UserMapper;
import com.newroad.acl.system.entity.User;
import com.newroad.acl.system.service.UserServiceIf;
@Transactional
@Service
public class UserServiceImp implements UserServiceIf {
	@Resource
	UserMapper dao;

	@Override
	public User login(String username, String password) {
		return dao.login(username, password);
	}


}
