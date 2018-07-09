/**
 * @(#)ISpDao.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
 */
package com.wx20180409.sygl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wx20180409.sygl.domain.Sp;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Repository
public interface ISpDao {
	
	public int total(@Param("spbh")Integer spbh,@Param("spmc")String spmc);
	
	public List<Sp> fingSpByPage(@Param("start")Integer start , @Param("length")Integer length,@Param("spbh") Integer spbh,@Param("spmc") String spmc);

	public void delete(@Param("spbh")Integer spbh);
	
	public void saves(Sp sp);
	
	public Sp findOne(@Param("spbh") Integer spbh) ;
	
	public void update(Sp sp);
}
