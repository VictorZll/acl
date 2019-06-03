package com.newroad.acl.system.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newroad.acl.system.dao.UserRoleDao;
import com.newroad.acl.system.service.UserRoleServiceIf;
@Service
public class UserRoleServiceImp implements UserRoleServiceIf {
	
	@Resource
	UserRoleDao dao;
	
	@Override
	public List<Integer> getRoleIdsByUserId(Integer userId) {
		
		return dao.getRoleIdsByUserId(userId);
	}

}
