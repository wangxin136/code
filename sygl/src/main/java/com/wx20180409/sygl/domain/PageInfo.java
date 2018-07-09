/**
 * @(#)PageInfo.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
 */
package com.wx20180409.sygl.domain;

import java.util.List;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
public class PageInfo {
	private Integer total;
	private List<?> rows;

	public PageInfo() {}
	
	public PageInfo(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	
	
	
}
