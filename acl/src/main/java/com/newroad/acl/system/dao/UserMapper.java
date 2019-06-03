package com.newroad.acl.system.dao;

import org.apache.ibatis.annotations.Param;

import com.newroad.acl.system.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param("username")String username,@Param("password")String password);
}