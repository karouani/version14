package com.mql.strut.web.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.io.FileUtils;

import com.mql.strut.web.UTILS.LectureExcel;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ImporterExcelAction {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String url;
	private String message;
	private int taile;
	private List<String> erreur;
	private LectureExcel me;
	private String type;
	
	@EJB
	private IAdminRemote admin;
	
	public String execute(){
		try {
			System.out.println("Debut uploaded");
			url=System.getProperty("java.io.tmpdir");
			System.out.println("le src nom du fichier "+myFile);
			System.out.println("le dest nom du fichier "+myFileFileName);
			File destFile=new File(url+"/",myFileFileName);
			FileUtils.copyFile(myFile, destFile);
			System.out.println("Fin uploaded");

			erreur=new ArrayList<String>(); 
			//cicin2.xlsx 
			System.out.println("Lien donnee de fichier exel "+url+"/"+myFileFileName);
			me=new LectureExcel(url+myFileFileName); 
			System.out.println("in action "); 
			for(String st:me.getResultas()){ 
				System.out.println(st);
			} //cote administrateur 
			erreur=admin.SauvegarderManagerFromExcel(me.getResultas()); 
			taile=erreur.size();
			message = "yes";
			type = "exelImport";
		} catch (Exception e) {
			
		}
		return "success";
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
	
	public String getType() {
		return type;
	}
	public List<String> getErreur() {
		return erreur;
	}

}
