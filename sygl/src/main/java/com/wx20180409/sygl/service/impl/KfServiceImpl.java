/**
 * @(#)KfServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx20180409.sygl.dao.IKfDao;
import com.wx20180409.sygl.domain.Kf;
import com.wx20180409.sygl.service.IKfService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class KfServiceImpl implements IKfService {
	
	@Autowired
	private IKfDao dao;
	
	@Override
	public int total(Integer kfbh, String kfmc) {
		return dao.total(kfbh, kfmc);
	}

	@Override
	public List<Kf> kfList(Integer page, Integer rows, Integer kfbh, String kfmc) {
		Integer start = (page-1)*rows;
		Integer length = rows;
		
		return dao.kfList(start, length, kfbh, kfmc);
	}

	@Override
	public void saves(List<Kf> list) {
		for(Kf kf:list) {
			dao.saves(kf);
		}
	}

	@Override
	public void delete(Integer kfbh) {
		dao.delete(kfbh);
	}

	@Override
	public Kf findOne(Integer kfbh) {
		return dao.findOne(kfbh);
	}

	
	@Override
	public void update(Kf kf) {
		dao.update(kf);
	}


}
