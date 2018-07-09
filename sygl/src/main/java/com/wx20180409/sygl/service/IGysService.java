/**
 * @(#)IGysService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月1日
 */
package com.wx20180409.sygl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wx20180409.sygl.domain.Gys;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public interface IGysService {
	
	public int total(Integer gysbh,String gysmc);
	
	public List<Gys> fingGysByPage(Integer page,Integer rows,Integer gysbh,String gysmc);
	
	public void delete(Integer gysbh);
	
	public void saves(List<Gys> list);
	
	public Gys fingOne(Integer gysbh);
	
	public void update(Gys gys);
}
