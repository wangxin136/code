/**
 * @(#)kfAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月2日
 */
package com.wx20180409.sygl.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wx20180409.sygl.domain.Kf;
import com.wx20180409.sygl.domain.PageInfo;
import com.wx20180409.sygl.service.IKfService;
import com.wx20180409.sygl.util.Zjm;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class KfAction {
	
	@Autowired
	private IKfService service;
	
	
	@RequestMapping("/kf.do")
	public PageInfo kfList(Integer page,Integer rows,Integer kfbh,String kfmc) {
		Integer total = service.total(kfbh, kfmc);
		List<Kf> list = service.kfList(page, rows, kfbh, kfmc);
		
		PageInfo p = new PageInfo(total,list);
		return p;
	}
	
	@RequestMapping("/kfsaves.do")
	public void saves(MultipartFile excel) throws Exception {
		List<Kf> list = new ArrayList<Kf>();
		Zjm z = new Zjm();
		
		Workbook work =WorkbookFactory.create(excel.getInputStream());
		Sheet sheet = work.getSheetAt(0);
		for(int i=1;i<=sheet.getLastRowNum();i++ ) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			Cell c4 = row.getCell(3);
			
			String kfmc = c1.getStringCellValue();
			String kfdz = c2.getStringCellValue();
			String kfgly = c3.getStringCellValue();
			Integer kflxfs = (int) c4.getNumericCellValue();
			String zjm = z.String2Alpha(kfmc);
			Kf kf = new Kf(null,kfmc,zjm,kfdz,kfgly,kflxfs,null,null,null,null,null);
			list.add(kf);
		}
		service.saves(list);
	}
	
	@RequestMapping("/kfDelete.do")
	public void delete(Integer kfbh) {
		service.delete(kfbh);
	}

	@RequestMapping("/kfFindOne.do")
	public Kf findOne(Integer kfbh) {
		return service.findOne(kfbh);
	}
	
	@RequestMapping("/kfUpdate.do")
	public void update(Kf kf) {
		Zjm z = new Zjm();
		String zjm =z.String2Alpha(kf.getKfmc());
		kf.setZjm(zjm);
		service.update(kf);
	}
}	














