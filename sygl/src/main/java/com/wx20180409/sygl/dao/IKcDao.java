/**
 * @(#)IKcDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月5日
 */
package com.wx20180409.sygl.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Repository
public interface IKcDao {
	
	public int findKcBySpAndKf(@Param("spbh")int spbh,@Param("kfbh")int kfbh);
	
	public void saveKc(@Param("spbh")int spbh,@Param("sl")int sl,@Param("kfbh")int kfbh);
	
	public void updateKc(@Param("spbh")int spbh,@Param("sl")int sl,@Param("kfbh")int kfbh);
}
