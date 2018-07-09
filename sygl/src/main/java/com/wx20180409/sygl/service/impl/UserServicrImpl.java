/**
 * @(#)UserServicrImpl.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月29日
 */
package com.wx20180409.sygl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx20180409.sygl.dao.IUserDao;
import com.wx20180409.sygl.domain.User;
import com.wx20180409.sygl.service.IUserService;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@Service
public class UserServicrImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;
	
	@Override
	public User fingUserForLogin(String uname, String upass) {
		return dao.findUserByNameAndPass(uname,upass);
	}

}
