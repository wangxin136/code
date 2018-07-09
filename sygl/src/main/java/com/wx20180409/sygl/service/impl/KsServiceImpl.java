/**
 * @(#)KsServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx20180409.sygl.dao.IKsDao;
import com.wx20180409.sygl.domain.Ks;
import com.wx20180409.sygl.service.IKsService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class KsServiceImpl implements IKsService {

	@Autowired
	private IKsDao dao;
	
	@Override
	public int total(Integer ksbh,String ksmc) {
		return dao.total(ksbh, ksmc);
	}

	@Override
	public List<Ks> ksList(Integer page, Integer rows, Integer ksbh, String ksmc) {
		Integer start =(page-1)*rows;
		Integer length= rows;
		
		return dao.ksList(start, length, ksbh, ksmc);
	}

	@Override
	public void delete(int ksbh) {
		dao.delete(ksbh);
	}

	@Override
	public void saves(List<Ks> list) {
		for(Ks ks:list) {
			dao.saves(ks);
		}
	}

	@Override
	public Ks findOne(Integer ksbh) {
		return dao.findOne(ksbh);
	}

	@Override
	public void update(Ks ks) {
		dao.update(ks);
	}

}
