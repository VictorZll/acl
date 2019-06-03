package com.newroad.acl.system.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newroad.acl.system.dao.FunctionMapper;
import com.newroad.acl.system.entity.Function;
import com.newroad.acl.system.service.FunctionServiceIf;
@Service
public class FunctionServiceImp implements FunctionServiceIf {
	
	@Resource
	FunctionMapper dao;
	
	@Override
	public List<Function> getFunctionsByRoleIdAndParentId(List<Integer> roleIds, Integer parentId) {
		if(roleIds==null||roleIds.isEmpty()) {
			return new ArrayList<Function>();
		}
		return dao.getFunctionsByRoleIdAndParentId(roleIds, parentId);
	}

}
