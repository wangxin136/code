/**
 * @(#)JhdAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月3日
 */
package com.wx20180409.sygl.action;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx20180409.sygl.domain.Jhd;
import com.wx20180409.sygl.domain.PageInfo;
import com.wx20180409.sygl.domain.Sp;
import com.wx20180409.sygl.service.IJhdService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class JhdAction {
	
	@Autowired
	private IJhdService service;
	
	@RequestMapping("/jhd.do")
	public PageInfo jhd(int page,int rows) {
		List<Jhd> list =service.jhdList(page, rows);
		int total = service.total();
		PageInfo p = new PageInfo(total,list);
		return p;
	}
	
	@RequestMapping("/jhsj.do")
	public String jhsj() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return f.format(LocalDateTime.now());
	}
	
	@RequestMapping("/jhdbh.do")
	public String jhdbh(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		
		String jhdbh ="";
		
		synchronized ("dmc") {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
			String jhdbhPrefix = "JHD"+ f.format(LocalDate.now()); // JHD20180704
			
			String oldJhdbh = (String) application.getAttribute("jhdbh");
			if(oldJhdbh==null || !oldJhdbh.startsWith(jhdbhPrefix)) {
				oldJhdbh = service.findJhdbh(jhdbhPrefix);
			}
			
			if(oldJhdbh==null||oldJhdbh.equals("")) {
				//今天没有进货单，当前为今天的第一条进货单
				jhdbh = jhdbhPrefix+"0001";
			}else {
				//今天已经有进货单，当前进货单序号需要+1
				//oldJhdbh="JHD201807040003"
				String xhStr = oldJhdbh.replaceAll(jhdbhPrefix, "");//去掉前缀->0003
				int xh = Integer.parseInt(xhStr)+1; // 3+1=4
				xhStr = xh+""; //"4"
				switch (xhStr.length()) {
				case 1: xhStr = "000"+ xhStr;  break;
				case 2: xhStr = "00"+ xhStr;  break;
				case 3: xhStr = "0"+ xhStr;  break;
				}
				jhdbh = jhdbhPrefix+xhStr;
			}
			application.setAttribute("jhdbh", jhdbh);
		}
		
		return jhdbh;
	}
	@RequestMapping("/jhdsaves.do")
	public void save(Jhd jhd,String spbhs,String sls,String djs) {
		service.save(jhd, spbhs, sls, djs);
	}
	
	@RequestMapping("/jhdOne.do")
	public Jhd fingJhdOne(String jhdbh) {
		return service.fingJhdOne(jhdbh);
	}
	
	@RequestMapping("/jhdXq.do")
	public List<Map<String,Object>> xqList(String jhdbh){
		
		return service.xqList(jhdbh);
	} 
}









