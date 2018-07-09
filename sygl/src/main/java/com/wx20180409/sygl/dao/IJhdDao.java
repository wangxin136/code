/**
 * @(#)IJhdDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月4日
 */
package com.wx20180409.sygl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx20180409.sygl.domain.Jhd;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Repository
public interface IJhdDao {
	
	public int total();
	
	public List<Jhd> jhdList(@Param("start")int start,@Param("length")int length);
	
	public String findJhdbh(@Param("jhdbhPrefix")String jhdbhPrefix);
	
	public void save(Jhd jhd);
	
	public void saveXq(@Param("jhdbh")String jhdbh,@Param("spbh")int spbh,@Param("dj")int dj,@Param("sl")int sl);
	
	public Jhd fingJhdOne(@Param("jhdbh")String jhdbh);
	
	public List<Map<String,Object>> xqList(@Param("jhdbh")String jhdbh);
}
