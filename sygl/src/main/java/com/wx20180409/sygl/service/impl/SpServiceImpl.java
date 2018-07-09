/**
 * @(#)SpServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
 */
package com.wx20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx20180409.sygl.dao.ISpDao;
import com.wx20180409.sygl.domain.Sp;
import com.wx20180409.sygl.service.ISpService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class SpServiceImpl implements ISpService {

	@Autowired
	private ISpDao dao;
	
	@Override
	public int total(Integer spbh, String spmc) {
		return dao.total(spbh, spmc);
	}

	@Override
	public List<Sp> findSpByPage(Integer page, Integer rows, Integer spbh, String spmc) {
		Integer start=(page-1)*rows;  
		Integer length=rows;
		
		return dao.fingSpByPage(start, length, spbh, spmc);
	}

	@Override
	public void delete(Integer spbh) {
		dao.delete(spbh);
	}

	@Override
	public void saves(List<Sp> list) {
		for(Sp sp:list) {
			dao.saves(sp);
		}
	}

	@Override
	public Sp findOne(Integer spbh) {
		
		return dao.findOne(spbh);
	}


	@Override
	public void update(Sp sp) {
			dao.update(sp);
	}

}
