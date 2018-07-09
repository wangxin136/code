/**
 * @(#)IGysDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月1日
 */
package com.wx20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx20180409.sygl.domain.Gys;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Repository
public interface IGysDao {
	
	public int total(@Param("gysbh")Integer gysbh,@Param("gysmc")String gysmc);
	
	public List<Gys> fingGysByPage(@Param("start")Integer start, @Param("length")Integer length, @Param("gysbh")Integer gysbh,@Param("gysmc")String gysmc);
	
	public void delete(@Param("gysbh")Integer gysbh);
	
	public void saves(Gys gys);
	
	public Gys findOne(@Param("gysbh")Integer gysbh);
	
	public void update(Gys gys);
	
}
