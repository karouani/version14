package com.mql.strut.web.actions;

import java.io.File;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mql.strut.web.models.Admin;
import com.mql.strut.web.models.MonFichier;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.Compte;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless(name="adminRemote")
public class UpdateAdminAction implements ModelDriven<Admin> , ServletRequestAware{

	private Admin administrateur;
	private String message;
	private String confirm_password;
	private Long idadm;
	private String nom;
	private String prenom;
	private String email;
	private String photo;
	private String description;
	private String sexe;
	private String username;
	private String password;
	private boolean status;
	private String type;
	private String deconnecte = null;

	private MonFichier monFichier;

	private HttpServletRequest servletRequest;

	private File myFile;
	private String myFileFileName;
	private String myFileContentType;

	@EJB
	private IAdminRemote adminRemote;

	public UpdateAdminAction() {
		administrateur = new Admin();
		monFichier = new MonFichier();
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest=servletRequest;
	}

	//Injection de Dépandance

	public void setMyFile(File myFile) {
		monFichier.setMyFile(myFile);
	}
	
	public void setMyFileContentType(String myFileContentType) {
		monFichier.setMyFileContentType(myFileContentType);
	}

	public void setMyFileFileName(String myFileFileName) {
		monFichier.setMyFileFileName(myFileFileName);
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	//Methode d'action
	public String execute(){

		String lien = servletRequest.getSession().getServletContext().getRealPath("/");
		//String[] url=String.valueOf(servletRequest.getContextPath()).split("/");
		monFichier.setDestPath(lien+"profileImages");
		System.out.println(">> Mon lien "+monFichier.getDestPath());
		System.out.println("************* "+servletRequest.getContextPath());

		try{
			System.out.println("Src File name: " + monFichier.getDestPath());
			System.out.println("Dst File name: " + monFichier.getMyFileFileName());
			File destFile  = new File(monFichier.getDestPath(), monFichier.getMyFileFileName());
			FileUtils.copyFile(monFichier.getMyFile(), destFile);
			
			String image;
			if(monFichier.getMyFileFileName() != null){
				image = monFichier.getMyFileFileName();
			}else{
				image = administrateur.getPhoto();
			}
			System.out.println(">>> Image "+image);
			Administrateur admin = adminRemote.consulterAdmin(administrateur.getIdadm());
			admin.setDescription(administrateur.getDescription());
			admin.setEmail(administrateur.getEmail());
			admin.setNom(administrateur.getNom());
			admin.setPhoto(image);
			admin.setPrenom(administrateur.getPrenom());
			admin.setSexe(administrateur.getSexe());
			admin.getCmp().setPassword(administrateur.getPassword());
			admin.getCmp().setUsername(administrateur.getUsername());

			admin.getCmp().setStatus(administrateur.getStatus());

			if(adminRemote.editermonprofil(administrateur.getIdadm(),admin)){
				System.out.println(admin);
				message = "Enregistrement avec Success !!";
				System.out.println(message);
				type = "Administrateur";
				if(adminRemote.consulterAdmin(administrateur.getIdadm()).getCmp().getStatus() == "out"){
					deconnecte = "deconnecter";
				}
				return "admin";
			}else{
				message = "ressayer Plus tard !!";
				System.out.println(message);
				return "error";
			}
		}catch(Exception e){
			message =  "Error Essayer plus tard";
			return "error";
		}

	}



	//Récupération
	public Admin getAdministrateur() {
		return administrateur;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return administrateur;
	}
	public String getType(){
		return type;
	}
	public String getDeconnecte(){
		return deconnecte;
	}
}
