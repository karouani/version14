package com.mql.strut.web.UTILS;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LectureExcel {

	private String url;
	private List<String> resultas;
	private String extensn;


	public LectureExcel(String url) {
		super();
		this.url = url;
		resultas=new ArrayList<String>();
		this.extensn=url.substring(url.lastIndexOf(".")+1);
		if("xls".equals(this.extensn)){
			lireExcelXSL();
		}else if("xlsx".equals(this.extensn)){
			lireExcelXSLX();
		}
	}


	//Excel format 2007 XSLX
	public List<String> lireExcelXSLX(){
		try {

			//debut lecture
			File fl=new File(url);
			//System.out.println(fl.getPath());
			InputStream ExcelFileToRead = new FileInputStream(fl);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFWorkbook test = new XSSFWorkbook();
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			String st;

			Iterator rows = sheet.rowIterator();

			while (rows.hasNext())
			{
				st="";
				row=(XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				while (cells.hasNext())
				{
					cell=(XSSFCell) cells.next();
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
					{

						st+=cell.getStringCellValue()+",";
					}
					else if (DateUtil.isCellDateFormatted(cell))
					{
						try {
							System.out.println("in date format");
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							st += sdf.format(cell.getDateCellValue())+",";
							System.out.println("in date "+st);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						//System.out.print(cell.getStringCellValue()+",");

						st+=cell.getNumericCellValue()+",";
						System.out.println("stttt  "+st);
					}
					else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK)
					{
						//System.out.print(cell.getStringCellValue()+",");

						st+=" "+",";
						System.out.println("stttt  "+st);
					}


				}
				resultas.add(st);
				System.out.println();
			}
			//Fin de lecture
		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultas;
	}


	//lire excel 2003 XSL
	public List<String> lireExcelXSL(){

		try {

			File fl=new File(url);
			InputStream ExcelFileToRead = new FileInputStream(fl);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

			HSSFSheet sheet=wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;

			String st;
			Iterator rows = sheet.rowIterator();

			while (rows.hasNext())
			{
				st="";
				row=(HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				while (cells.hasNext())
				{
					cell=(HSSFCell) cells.next();
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
					{

						st+=cell.getStringCellValue()+",";
					}
					else if (DateUtil.isCellDateFormatted(cell))
					{
						try {
							System.out.println("in date format");
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							st += sdf.format(cell.getDateCellValue())+",";
							System.out.println("in date "+st);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						//System.out.print(cell.getStringCellValue()+",");

						st+=cell.getNumericCellValue()+",";
						System.out.println("stttt  "+st);
					}

				}
				resultas.add(st);
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return resultas;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getResultas() {
		return resultas;
	}
	public void setResultas(List<String> resultas) {
		this.resultas = resultas;
	}


}
