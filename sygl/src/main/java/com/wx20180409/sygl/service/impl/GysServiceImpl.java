/**
 * @(#)GysServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月1日
 */
package com.wx20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx20180409.sygl.dao.IGysDao;
import com.wx20180409.sygl.domain.Gys;
import com.wx20180409.sygl.service.IGysService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class GysServiceImpl implements IGysService {

	@Autowired
	private IGysDao dao;
	
	@Override
	public int total(Integer gysbh, String gysmc) {
		
		return  dao.total(gysbh, gysmc);
	}

	
	@Override
	public List<Gys> fingGysByPage(Integer page, Integer rows, Integer gysbh, String gysmc) {
		Integer start = (page-1)*rows;
		Integer length = rows;
		return dao.fingGysByPage(start, length, gysbh, gysmc);
	}


	@Override
	public void delete(Integer gysbh) {
		dao.delete(gysbh);
	}


	@Override
	public void saves(List<Gys> list) {
		for(Gys gys:list) {
			dao.saves(gys);
		}
		
	}

	@Override
	public Gys fingOne(Integer gysbh) {
		
		return dao.findOne(gysbh);
	}


	@Override
	public void update(Gys gys) {
		dao.update(gys);
	}

}
