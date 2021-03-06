package com.newroad.acl.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newroad.acl.system.entity.Function;
import com.newroad.acl.system.entity.TreeNode;
import com.newroad.acl.system.entity.User;
import com.newroad.acl.system.service.FunctionServiceIf;
import com.newroad.acl.system.service.UserRoleServiceIf;

@Controller
public class MenuController {
	@Resource
	FunctionServiceIf functionService;
	
	@Resource
	UserRoleServiceIf userRoleService;
	
	@RequestMapping("/data_tree")
	@ResponseBody
	public List<TreeNode> getMenu(String id,HttpSession session){

		List<TreeNode> treeNodes=new ArrayList<TreeNode>();
		@SuppressWarnings("unchecked")
		List<Integer> roleIds=(List<Integer>) session.getAttribute("roleIds");
		
		List<Function> funs=null;
		
		if(StringUtils.isBlank(id)) {
			
			funs=functionService.getFunctionsByRoleIdAndParentId(roleIds, null);
			
		}else {
			
			funs=functionService.getFunctionsByRoleIdAndParentId(roleIds, Integer.valueOf(id));
		}
		//funs->treeNodes
		for(Function fun:funs) {
			if(fun.getFuncType()!=0) {
				TreeNode treeNode=new TreeNode();
				treeNode.setId(fun.getFuncId().toString());
				treeNode.setText(fun.getFuncName());
				treeNode.setState(fun.getParentId()!=null?"open":"closed");
				treeNode.addAttributes("url", fun.getFuncUrl());
				treeNodes.add(treeNode);
			}
		}
		return treeNodes;
	}
	

}
