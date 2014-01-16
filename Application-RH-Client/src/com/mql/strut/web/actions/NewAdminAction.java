package com.mql.strut.web.actions;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mql.strut.web.models.Admin;
import com.mql.strut.web.models.MonFichier;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class NewAdminAction implements ModelDriven<Admin> , ServletRequestAware{

	private String messageN;
	private Admin admin;
	private String type;
	private MonFichier monFichier;

	private HttpServletRequest servletRequest;

	private File myFile;
	private String myFileFileName;
	private String myFileContentType;

	@EJB
	private IAdminRemote administrateur;

	//Constructeur
	public NewAdminAction() {
		admin =new Admin();
		monFichier = new MonFichier();
	}

	//Injection par Intercepteur
	public void setMessageN(String messageN) {
		this.messageN = messageN;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest=servletRequest;
	}

	//Injection de DŽpandance

	public void setMyFile(File myFile) {
		monFichier.setMyFile(myFile);
	}

	public void setMyFileContentType(String myFileContentType) {
		monFichier.setMyFileContentType(myFileContentType);
	}

	public void setMyFileFileName(String myFileFileName) {
		monFichier.setMyFileFileName(myFileFileName);
	}

	//Methode d'action
	public String execute(){
		String url = servletRequest.getSession().getServletContext().getRealPath("/");
		monFichier.setDestPath(url+"profileImages");

		try{
			System.out.println("Src File name: " + monFichier.getDestPath());
			System.out.println("Dst File name: " + monFichier.getMyFileFileName());

			File destFile  = new File(monFichier.getDestPath(), monFichier.getMyFileFileName());
			FileUtils.copyFile(monFichier.getMyFile(), destFile);
			administrateur.ajouteradministrateur(new Administrateur(
					admin.getNom(), 
					admin.getPrenom(), 
					monFichier.getMyFileFileName(), 
					admin.getEmail(), 
					admin.getSexe(), 
					admin.getDescription()),
					admin.getUsername(),
					admin.getPassword(),
					"Administrateur");
			setMessageN("Admin Ajouter avec Success");
			this.type = "nouveauAdmin";
			return "success";
		}catch(Exception e){
			setMessageN("Error Essayer plus tard");
			return "error";
		}

	}

	//Recuperation
	public String getMessageN() {
		return messageN;
	}

	public String getType() {
		return type;
	}

	@Override
	public Admin getModel() {
		return admin;
	}

	public Admin getAdmin() {
		return admin;
	}
}
