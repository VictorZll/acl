package com.newroad.acl.system.service;

import java.util.List;

public interface UserRoleServiceIf {
	List<Integer> getRoleIdsByUserId(Integer userId);
}
