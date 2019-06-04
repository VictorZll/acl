package com.newroad.acl.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newroad.acl.system.entity.Function;

public interface FunctionMapper {
    int deleteByPrimaryKey(Integer funcId);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer funcId);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
    
    List<Function> getFunctionsByRoleIdAndParentId(@Param("roleIds")List<Integer> roleIds, @Param("parentId")Integer parentId);
    
    List<Function> getFunctionsByRoleIdAndFuncType(@Param("roleIds")List<Integer> roleIds, @Param("funcType")Integer funcType);
}