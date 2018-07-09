/**
 * @(#)IKsDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx20180409.sygl.domain.Ks;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Repository
public interface IKsDao {
	
	public int total(@Param("ksbh")Integer ksbh,@Param("ksmc")String ksmc);
	
	public List<Ks> ksList(@Param("start")Integer start,@Param("length")Integer length,@Param("ksbh")Integer ksbh,@Param("ksmc")String ksmc);
	
	public void delete(@Param("ksbh")Integer ksbh);
	
	public void saves(Ks ks);
	
	public Ks findOne(@Param("ksbh")Integer ksbh);
	
	public void update(Ks ks);
	
}
