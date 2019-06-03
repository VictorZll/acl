package com.newroad.acl.system.dao;

import com.newroad.acl.system.entity.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int insert(UserRole record);

    List<UserRole> selectAll();
    
    List<Integer> getRoleIdsByUserId(Integer userId);
}