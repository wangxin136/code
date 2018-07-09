/**
 * @(#)GysAction.java
 * Description:	TODO 填写文件作用简要说明
 * Version :	0.0.0
 * Copyright:	Copyright (c) 哈尔滨修盾信息科技有限公司  版权所有
 * Create by:	王鑫  2018年7月1日
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

import com.wx20180409.sygl.domain.Gys;
import com.wx20180409.sygl.domain.PageInfo;
import com.wx20180409.sygl.service.IGysService;
import com.wx20180409.sygl.util.Zjm;

/**
 * TODO 填写功能说明
 * @author 王鑫
 */
@RestController
public class GysAction {
	
	@Autowired
	private IGysService service;
	
	@RequestMapping("/gys.do")
	public PageInfo GysList(Integer page,Integer rows,Integer gysbh,String gysmc) {
		int total =service.total(gysbh, gysmc) ;
		List<Gys> list =service.fingGysByPage(page, rows, gysbh, gysmc);
		
		PageInfo p = new PageInfo(total,list);
		return p;
	}
	
	@RequestMapping("/gysDelete.do")
	public void delete(Integer gysbh){
		service.delete(gysbh);
	}
	
	@RequestMapping("/gysSaves.do")
	public void saves(MultipartFile excel) throws Exception {
		
		System.out.println(1111);
		System.out.println(excel);
		
		List<Gys> list = new ArrayList<Gys>();
		Zjm z = new Zjm();
		
		Workbook work = WorkbookFactory.create(excel.getInputStream());
		Sheet sheet = work.getSheetAt(0);
		for(int i=1;i<=sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				Cell c3 = row.getCell(2);
				
				String gysmc = c1.getStringCellValue();
				String gysdz = c2.getStringCellValue();
				Integer gysdh = (int) c3.getNumericCellValue();
				String  zjm = z.String2Alpha(gysmc);
				
				Gys gys = new Gys(null,gysmc,zjm,gysdz,gysdh,null,null,null,null,null);
				list.add(gys);
		}
			service.saves(list);
	}

	@RequestMapping("/gysFindOne.do")
	public Gys FindOne(Integer gysbh) {
		return service.fingOne(gysbh);
	}
	
	@RequestMapping("/gysUpdate.do")
	public void update(Gys gys) {
		Zjm z = new Zjm();
		String zjm = z.String2Alpha(gys.getGysmc());
		gys.setZjm(zjm);
		service.update(gys);
	}
}


