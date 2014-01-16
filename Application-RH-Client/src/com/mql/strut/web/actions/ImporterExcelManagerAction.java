package com.mql.strut.web.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.io.FileUtils;

import com.mql.strut.web.UTILS.LectureExcel;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class ImporterExcelManagerAction {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String url;
	private String message;
	private int taile;
	private List<String> erreur;
	private LectureExcel me;
	private String excel;

	@EJB
	private IManagerRemote manager;

	public String execute(){
		try {
			url=System.getProperty("java.io.tmpdir");
			File destFile=new File(url+"/",myFileFileName);
			FileUtils.copyFile(myFile, destFile);

			erreur=new ArrayList<String>(); 
			//cicin2.xlsx 
			me=new LectureExcel(url+myFileFileName); 
			for(String st:me.getResultas()){ 
				System.out.println(st);
			} 
			
			if ("importExcelCol".equals(excel)) {
				erreur=manager.SauvegarderCollaborateurFromExcel(me.getResultas());
			}else{
				erreur=manager.SauvegarderManagerFromExcel(me.getResultas());
			}
			
			taile=erreur.size();
			message = "yes";
			excel = "exelImport";
			
		} catch (Exception e) {

		}
		return "success";
	}

	
	public void setExcel(String excel) {
		this.excel = excel;
	}


	public File getMyFile() {
		return myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public String getUrl() {
		return url;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public int getTaile() {
		return taile;
	}

	public String getExcel() {
		return excel;
	}

	public List<String> getErreur() {
		return erreur;
	}

}
