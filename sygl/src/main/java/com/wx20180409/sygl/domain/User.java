/**
 * @(#)User.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月29日
 */
package com.wx20180409.sygl.domain;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public class User {
	private Integer uno;
	private String uname;
	private String upass;
	private String truename;

	public User(){}
	
	public User(Integer uno, String uname, String upass, String truename) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.upass = upass;
		this.truename = truename;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(Integer uno) {
		this.uno = uno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}
	
	
}
