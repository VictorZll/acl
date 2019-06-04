package com.newroad.acl.system.service;

import java.util.List;

import com.newroad.acl.system.entity.Function;

public interface FunctionServiceIf {
	/**
	 * 根据角色Id和父权限Id获得权限信息
	 * @param roleIds
	 * @param parentId
	 * @return
	 */
	List<Function> getFunctionsByRoleIdAndParentId(List<Integer> roleIds ,Integer parentId);
	/**
	 * 根据角色Id和权限类型查询权限信息
	 * @param roleIds
	 * @param funcType
	 * @return
	 */
	List<Function> getFunctionsByRoleIdAndFuncType(List<Integer> roleIds,Integer funcType);
}
