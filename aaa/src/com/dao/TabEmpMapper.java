package com.dao;

import com.domain.TabEmp;

public interface TabEmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabEmp record);

    int insertSelective(TabEmp record);

    TabEmp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabEmp record);

    int updateByPrimaryKey(TabEmp record);
}