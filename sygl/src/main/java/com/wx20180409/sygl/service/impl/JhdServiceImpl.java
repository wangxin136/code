/**
 * @(#)JhdServiceImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月4日
 */
package com.wx20180409.sygl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.wx20180409.sygl.dao.IJhdDao;
import com.wx20180409.sygl.dao.IKcDao;
import com.wx20180409.sygl.domain.Jhd;
import com.wx20180409.sygl.service.IJhdService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class JhdServiceImpl implements IJhdService {
	
	@Autowired
	private IJhdDao dao ;
	
	@Autowired
	private IKcDao dao2;
	
	@Override
	public int total() {
		return dao.total();
	}

	@Override
	public List<Jhd> jhdList(int page, int rows) {
		int start =(page-1)*rows;
		int length=rows;
		return dao.jhdList(start, length);
	}

	@Override
	public String findJhdbh(String jhdbhPrefix) {
		return dao.findJhdbh(jhdbhPrefix);
	}

	@Override
	public void save(Jhd jhd, String spbhs, String sls, String djs) {
		dao.save(jhd);
		
		String[] spbhArray=spbhs.split(",");
		String[] slArray=sls.split(",");
		String[] djArray=djs.split(",");
		
		for(int i=0;i<spbhArray.length;i++) {
			dao.saveXq(jhd.getJhdbh(),Integer.parseInt(spbhArray[i]),Integer.parseInt(djArray[i]),Integer.parseInt(slArray[i]));
		}
		
		
		//库存
		for(int i=0;i<spbhArray.length;i++) {
			int count = dao2.findKcBySpAndKf(Integer.parseInt(spbhArray[i]),jhd.getKf() );
			if(count==0) {
				dao2.saveKc(Integer.parseInt(spbhArray[i]),Integer.parseInt(slArray[i]),jhd.getKf());
			}else {
				dao2.updateKc(Integer.parseInt(spbhArray[i]),Integer.parseInt(slArray[i]),jhd.getKf());
			}
		}
	}

	
	@Override
	public Jhd fingJhdOne(String jhdbh) {
		return dao.fingJhdOne(jhdbh);
	}

	
	@Override
	public List<Map<String, Object>> xqList(String jhdbh) {
		
		return dao.xqList(jhdbh);
	}
	
	
}
