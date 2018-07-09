/**
 * @(#)UserAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月29日
 */
package com.wx20180409.sygl.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wx20180409.sygl.domain.User;
import com.wx20180409.sygl.service.IUserService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class UserAction {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping("/login.do")
	public String login(String uname,String upass,HttpSession session) {
		User user = service.fingUserForLogin(uname, upass);
		if(user==null) {
			return "fail";
		}else {
			session.setAttribute("loginUser", user);
			return "ok";
		}
	}
}







