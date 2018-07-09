/**
 * @(#)IKsService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.service;

import java.util.List;

import com.wx20180409.sygl.domain.Ks;



/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public interface IKsService {
	
	public int total(Integer ksbh,String ksmc);
	
	public List<Ks> ksList(Integer page,Integer rows,Integer ksbh,String ksmc);
	
	public void delete(int ksbh);
	
	public void saves(List<Ks> list);
	
	public Ks findOne(Integer ksbh);
	
	public void update(Ks ks);
}
