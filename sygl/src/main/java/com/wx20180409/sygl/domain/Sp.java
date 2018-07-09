/**
 * @(#)Sp.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
 */
package com.wx20180409.sygl.domain;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public class Sp {
	private Integer spbh;
	private	String spmc;
	private	String zjm;
	private	String dw;
	private	String xh;
	
	private String yl1;
	private String yl2;
	private String yl3;

	public Sp() {}
	
	public Sp(Integer spbh, String spmc, String zjm, String dw, String xh, String yl1, String yl2, String yl3) {
		super();
		this.spbh = spbh;
		this.spmc = spmc;
		this.zjm = zjm;
		this.dw = dw;
		this.xh = xh;
		this.yl1 = yl1;
		this.yl2 = yl2;
		this.yl3 = yl3;
	}

	public Integer getSpbh() {
		return spbh;
	}

	public void setSpbh(Integer spbh) {
		this.spbh = spbh;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getZjm() {
		return zjm;
	}

	public void setZjm(String zjm) {
		this.zjm = zjm;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getYl1() {
		return yl1;
	}

	public void setYl1(String yl1) {
		this.yl1 = yl1;
	}

	public String getYl2() {
		return yl2;
	}

	public void setYl2(String yl2) {
		this.yl2 = yl2;
	}

	public String getYl3() {
		return yl3;
	}

	public void setYl3(String yl3) {
		this.yl3 = yl3;
	}
	
	
}
