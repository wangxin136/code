package com.dao;

import com.domain.TabUser;

public interface TabUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabUser record);

    int insertSelective(TabUser record);

    TabUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabUser record);

    int updateByPrimaryKey(TabUser record);
}