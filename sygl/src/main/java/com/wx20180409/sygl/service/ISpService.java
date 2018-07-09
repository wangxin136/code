/**
 * @(#)ISpService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
 */
package com.wx20180409.sygl.service;

import java.util.List;

import com.wx20180409.sygl.domain.Sp;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public interface ISpService {
	
	public int total(Integer spbh,String spmc);
	
	public List<Sp> findSpByPage(Integer page,Integer rows,Integer spbh,String spmc);
	
	public void delete(Integer spbh);
	
	public void saves(List<Sp> list);
	
	public Sp findOne(Integer spbh) ;
	
	public void update(Sp sp);
}
