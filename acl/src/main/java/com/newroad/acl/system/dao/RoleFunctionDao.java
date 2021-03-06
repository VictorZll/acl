package com.newroad.acl.system.dao;

import com.newroad.acl.system.entity.RoleFunction;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleFunctionDao {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("funcId") Integer funcId);

    int insert(RoleFunction record);

    List<RoleFunction> selectAll();
}