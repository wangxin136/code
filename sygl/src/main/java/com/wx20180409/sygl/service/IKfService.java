/**
 * @(#)IKfService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.service;

import java.util.List;

import com.wx20180409.sygl.domain.Kf;
import com.wx20180409.sygl.domain.PageInfo;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public interface IKfService {
	
	public int total(Integer kfbh,String kfmc);
	
	public List<Kf> kfList(Integer page,Integer rows,Integer kfbh,String kfmc);
	
	public void saves(List<Kf> list);
	
	public void delete(Integer kfbh);
	
	public Kf findOne(Integer kfbh);
	
	public void update(Kf kf);
}
