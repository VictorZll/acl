package com.newroad.acl.system.service.imp;

import java.util.List;

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

	@Override
	public List<User> listByPage(Integer page, Integer rows) {
		double count=getCount();
		int pageCount=(int) Math.ceil(count/rows);
		if(page>pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		Integer offset=(page-1)*rows;
		return dao.listByPage(offset, rows);
	}

	@Override
	public Integer getCount() {
		return dao.getCount();
	}


}
