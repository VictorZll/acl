package com.newroad.acl.system.service;

import com.newroad.acl.system.entity.User;

public interface UserServiceIf {
	User login(String username,String password);
}
