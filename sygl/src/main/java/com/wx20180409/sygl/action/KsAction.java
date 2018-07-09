/**
 * @(#)Ks.java
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

import com.wx20180409.sygl.domain.Ks;
import com.wx20180409.sygl.domain.PageInfo;
import com.wx20180409.sygl.service.IKsService;
import com.wx20180409.sygl.util.Zjm;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class KsAction {
	
	@Autowired
	private IKsService service;
	
	@RequestMapping("/ks.do")
	public PageInfo ksList(Integer page,Integer rows,Integer ksbh,String ksmc) {
		Integer total = service.total(ksbh, ksmc);
		List<Ks> list = service.ksList(page, rows, ksbh, ksmc);
		
		PageInfo p = new PageInfo(total,list);
		return p;
	}
	
	@RequestMapping("/ksDelete.do")
	public void delete(Integer ksbh) {
		service.delete(ksbh);
	}
	
	@RequestMapping("/ksSave.do")
	public void saves(MultipartFile excel) throws Exception {
		List<Ks> list = new ArrayList<Ks>();
		Zjm z = new Zjm();
		
		Workbook work = WorkbookFactory.create(excel.getInputStream());
		Sheet sheet = work.getSheetAt(0);
		for(int i = 1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			Cell c4 = row.getCell(3);
			Cell c5 = row.getCell(4);
			
			String ksmc = c1.getStringCellValue();
			String ksxb = c2.getStringCellValue();
			Integer ksnl = (int) c3.getNumericCellValue();
			Integer kslxfs = (int) c4.getNumericCellValue();
			String fkfs = c5.getStringCellValue();
			String zjm = z.String2Alpha(ksmc);
			Ks ks = new Ks(null,ksmc,zjm,ksxb,ksnl,kslxfs,fkfs,null,null,null,null,null);
			
			list.add(ks);
		}
		service.saves(list);
 	}
	
	@RequestMapping("/ksFindOne.do")
	public Ks findOne(Integer ksbh) {
		return service.findOne(ksbh);
	}
	
	@RequestMapping("/ksUpdate.do")
	public void update(Ks ks) {
		Zjm z = new Zjm();
		String zjm = z.String2Alpha(ks.getKsmc());
		ks.setZjm(zjm);
		service.update(ks);
	}
}
