/**
 * @(#)DispatcherAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月29日
 */
package com.wx20180409.sygl.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class DispatcherAction {
	
	@RequestMapping("/toMain.do")
	public ModelAndView toMain() {
		return new ModelAndView("main.html");
	}
	@RequestMapping("/menu.do")
	public ModelAndView toMenu() {
		return new ModelAndView("menu.json");
	}
	
	@RequestMapping("/toSp.do")
	public ModelAndView toSp() {
		return new ModelAndView("sp.html");
	}
	
	@RequestMapping("/toGys.do")
	public ModelAndView toGys() {
		return new ModelAndView("toGys.html");
	}
	
	@RequestMapping("/toKf.do")
	public ModelAndView toKf() {
		return new ModelAndView("Kf.html");
	}
	
	@RequestMapping("/toKs.do")
	public ModelAndView toKs() {
		return new ModelAndView("Ks.html");
	}
	
	@RequestMapping("/toJhd.do")
	public ModelAndView toJhd() {
		return new ModelAndView("Jhd.html");
	}
	@RequestMapping("/toThd.do")
	public ModelAndView toThd() {
		return new ModelAndView("thd.html");
	}
	
}







