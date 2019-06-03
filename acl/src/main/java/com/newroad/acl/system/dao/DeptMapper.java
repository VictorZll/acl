package com.newroad.acl.system.dao;

import com.newroad.acl.system.entity.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}