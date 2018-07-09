/**
 * @(#)SpAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年6月30日
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

import com.wx20180409.sygl.domain.PageInfo;
import com.wx20180409.sygl.domain.Sp;
import com.wx20180409.sygl.service.ISpService;
import com.wx20180409.sygl.util.Zjm;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class SpAction {
	
	@Autowired
	private ISpService service;
	
	@RequestMapping("/sp.do")
	public PageInfo spList(Integer page,Integer rows,Integer spbh,String spmc) {
		
		 int total= service.total(spbh, spmc) ;
		 List<Sp> list =service.findSpByPage(page, rows, spbh, spmc);
		 
		 PageInfo p = new PageInfo(total,list);
		 return p;
	}
	
	@RequestMapping("/spDelete.do")
	public void delete(Integer spbh) {
		service.delete(spbh);
	}
	
	@RequestMapping("/saves.do")
	public void saves(MultipartFile excel) throws Exception {
		List<Sp> list = new ArrayList<Sp>();
		
		Workbook book = WorkbookFactory.create(excel.getInputStream());
		
		Sheet sheet = book.getSheetAt(0);
		Zjm z = new Zjm();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			
			String spmc = c1.getStringCellValue();
			String dw = c2.getStringCellValue();
			String xh = c3.getStringCellValue();
			String zjm= z.String2Alpha(spmc);
			
			Sp sp = new Sp(null,spmc,zjm,dw,xh,null,null,null);
			list.add(sp);
		}
		service.saves(list);
	}
	
	@RequestMapping("/fingOne.do")
	public Sp findOne(Integer spbh) {
		
		return service.findOne(spbh);
	}
	
	@RequestMapping("/spUpdate.do")
	public void update(Sp sp) {
		Zjm z=new Zjm();
		String zjm = z.String2Alpha(sp.getSpmc());
		sp.setZjm(zjm);
		service.update(sp);
	}
}


