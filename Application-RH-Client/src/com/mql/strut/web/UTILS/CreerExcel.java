package com.mql.strut.web.UTILS;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.xmlbeans.soap.SOAPArrayType;
public class CreerExcel {

	 private  SimpleDateFormat fmt = new SimpleDateFormat("dd-MM");
	 private Map<String, Object[]> data = new TreeMap<String, Object[]>();
	 private String[] titres;
	 private String nmsheet;
	 private String filenome;
	 //={BusinessPlan.getDts(),null};

	 public CreerExcel(Map< String, Object[]> dat,String[] tit,String nom,String flnom){
		// BusinessPlan.setDts(val);
		 System.out.println("in construct");
		this.data=dat;
		this.titres=tit;
		this.nmsheet=nom;
		this.filenome=flnom;
		createCicin();
	 }
	 
	 public void createCicin(){
		 
		 try {
			 System.out.println("in method");
		 Workbook wb;
		 wb = new XSSFWorkbook();

	     Map<String, CellStyle> styles = createStyles(wb);

	     Sheet sheet = wb.createSheet(nmsheet);

	     //turn off gridlines
	     sheet.setDisplayGridlines(false);
	     sheet.setPrintGridlines(false);
	     sheet.setFitToPage(true);
	     sheet.setHorizontallyCenter(true);
	     PrintSetup printSetup = sheet.getPrintSetup();
	     printSetup.setLandscape(true);

	     //the following three statements are required only for HSSF
	     sheet.setAutobreaks(true);
	     printSetup.setFitHeight((short)1);
	     printSetup.setFitWidth((short)1);

	     //the header row: centered text in 48pt font
	     Row headerRow = sheet.createRow(0);
	     headerRow.setHeightInPoints(12.75f);
	     for (int i = 0; i < titres.length; i++) {
	         Cell cell = headerRow.createCell(i);
	         cell.setCellValue(titres[i]);
	         cell.setCellStyle(styles.get("header"));
	     }
	     //columns for 11 weeks starting from 9-07
	     Calendar calendar = Calendar.getInstance();
	     int year = calendar.get(Calendar.YEAR);

	     //freeze the first row
	     sheet.createFreezePane(0, 1);

	     Row row;
	     Cell cell;
	     int rownum = 1;
	     
	     
	     Set<String> keyset = data.keySet();

			for (String key : keyset)
			{
			    row = sheet.createRow(rownum++);
			    Object [] objArr = data.get(key);
			    int cellnum = 0;
			    for (Object obj : objArr)
			    {
			       cell = row.createCell(cellnum++);
			       if(obj instanceof String){
			            cell.setCellValue((String)obj);
			       cell.setCellStyle(styles.get("cell_h"));}
			        else if(obj instanceof Integer){
			            cell.setCellValue((Integer)obj);
			       cell.setCellStyle(styles.get("cell_h"));
			        }
			    }
			}

	    

	     //set column widths, the width is measured in units of 1/256th of a character width
	     sheet.setColumnWidth(0, 256*20);
	     sheet.setColumnWidth(1,256*40);
	     sheet.setColumnWidth(2, 256*40);
	     sheet.setColumnWidth(3, 256*10);
	     sheet.setColumnWidth(4, 256*20);
	     sheet.setColumnWidth(5, 256*10);
	     sheet.setColumnWidth(6, 256*20);
	     sheet.setColumnWidth(7, 256*20);
	     sheet.setColumnWidth(8, 256*10);
	     sheet.setColumnWidth(9, 256*10);
	     sheet.setColumnWidth(10, 256*10);
	     sheet.setColumnWidth(11, 256*10);
	     sheet.setColumnWidth(12, 256*10);
	     sheet.setColumnWidth(13, 256*20);
	     sheet.setColumnWidth(14, 256*30);
	     sheet.setZoom(4,5);


	     // Write the output to a file
	     int x= (int) (Math.random()*99999);
	     String file = filenome+x+".xls";
	     if(wb instanceof XSSFWorkbook) file += "x";
	     FileOutputStream out;
	     String url=System.getProperty("java.io.tmpdir");
	     System.getProperty("java.io.tmpdir"+url);
			out = new FileOutputStream(url+"/"+file);
		
	     wb.write(out);
	     out.close();
		} 
	     catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	

	 /**
	  * create a library of cell styles
	  */
	 private static Map<String, CellStyle> createStyles(Workbook wb){
	     Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
	     DataFormat df = wb.createDataFormat();

	     CellStyle style;
	     Font headerFont = wb.createFont();
	     headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(headerFont);
	     styles.put("header", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setFont(headerFont);
	     style.setDataFormat(df.getFormat("d-mmm"));
	     styles.put("header_date", style);

	     Font font1 = wb.createFont();
	     font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_LEFT);
	     style.setFont(font1);
	     styles.put("cell_b", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setFont(font1);
	     styles.put("cell_b_centered", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_RIGHT);
	     style.setFont(font1);
	     style.setDataFormat(df.getFormat("d-mmm"));
	     styles.put("cell_b_date", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_RIGHT);
	     style.setFont(font1);
	     style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setDataFormat(df.getFormat("d-mmm"));
	     styles.put("cell_g", style);

	     Font font2 = wb.createFont();
	     font2.setColor(IndexedColors.BLUE.getIndex());
	     font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_LEFT);
	     style.setFont(font2);
	     styles.put("cell_bb", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_RIGHT);
	     style.setFont(font1);
	     style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     style.setDataFormat(df.getFormat("d-mmm"));
	     styles.put("cell_bg", style);

	     Font font3 = wb.createFont();
	     font3.setFontHeightInPoints((short)14);
	     font3.setColor(IndexedColors.DARK_BLUE.getIndex());
	     font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_LEFT);
	     style.setFont(font3);
	     style.setWrapText(true);
	     styles.put("cell_h", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_LEFT);
	     style.setWrapText(true);
	     styles.put("cell_normal", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_CENTER);
	     style.setWrapText(true);
	     styles.put("cell_normal_centered", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_RIGHT);
	     style.setWrapText(true);
	     style.setDataFormat(df.getFormat("d-mmm"));
	     styles.put("cell_normal_date", style);

	     style = createBorderedStyle(wb);
	     style.setAlignment(CellStyle.ALIGN_LEFT);
	     style.setIndention((short)1);
	     style.setWrapText(true);
	     styles.put("cell_indented", style);

	     style = createBorderedStyle(wb);
	     style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	     style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	     styles.put("cell_blue", style);

	     return styles;
	 }

	 private static CellStyle createBorderedStyle(Workbook wb){
	     CellStyle style = wb.createCellStyle();
	     style.setBorderRight(CellStyle.BORDER_THIN);
	     style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderBottom(CellStyle.BORDER_THIN);
	     style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderLeft(CellStyle.BORDER_THIN);
	     style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	     style.setBorderTop(CellStyle.BORDER_THIN);
	     style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	     return style;
	 }

	public SimpleDateFormat getFmt() {
		return fmt;
	}

	public void setFmt(SimpleDateFormat fmt) {
		this.fmt = fmt;
	}

	public Map<String, Object[]> getData() {
		return data;
	}

	public void setData(Map<String, Object[]> data) {
		this.data = data;
	}

	public String[] getTitres() {
		return titres;
	}

	public void setTitres(String[] titres) {
		this.titres = titres;
	}

	public String getNmsheet() {
		return nmsheet;
	}

	public void setNmsheet(String nmsheet) {
		this.nmsheet = nmsheet;
	}

	public String getFilenome() {
		return filenome;
	}

	public void setFilenome(String filenome) {
		this.filenome = filenome;
	}

	
	}
