/**
 * @(#)IJhdService.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月4日
 */
package com.wx20180409.sygl.service;

import java.util.List;
import java.util.Map;

import com.wx20180409.sygl.domain.Jhd;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public interface IJhdService {
	
	public int total();
	
	public List<Jhd> jhdList(int page,int rows);
	
	public String findJhdbh(String  jhdbhPrefix);
	
	public void save(Jhd jhd,String spbhs,String sls,String djs);
	
	public Jhd fingJhdOne(String jhdbh);
	
	public List<Map<String,Object>> xqList(String jhdbh);
}
