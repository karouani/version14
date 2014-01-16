package com.mql.strut.web.actions;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.ColabDips;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IManagerRHRemote;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless(name="profile")
public class ProfileAction extends ActionSupport {
	
	private Long id;
	private String type;
	private String status;
	private String message;
	private String index = "yes";
	private String form;
	
	@EJB
	private IAdminRemote admin;
	
	private Administrateur administrateur;
	private Collaborateurs collaborateurs;
	
	//Methode d'injection
	public void setId(Long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setForm(String form) {
		this.form = form;
	}
	
	public void setMessage(String message) {
		this.message = message ;
	}
	//Methode D'action
	public String execute() {
		
		if("Administrateur".equals(type)){
			administrateur = admin.consulterAdmin(id);
			//System.out.println(administrateur.getPhoto());
			status = admin.consulterAdmin(id).getCmp().getStatus();
			return "admin";
		}
		
		else if("ManagerRH".equals(type)){
			collaborateurs = (ManagerRH)admin.consulterCollaborateurs(id);
			status = "UpdateProfileManagerRh";
			if("manager".equals(form)){
				System.out.println("Vous etes Ici Test sur manager RH");
				return "manager";
			}
			return "managerRH";
		}
		
		else if("ManagerAgence".equals(type)){
			collaborateurs = (ManagerAgence)admin.consulterCollaborateurs(id);
			status = "UpdateProfileManager";
			return "manager";
		}
		else if("AmbassadeurRH".equals(type)){
			collaborateurs = (AmbassadeurRH)admin.consulterCollaborateurs(id);
			status = "UpdateProfileManager";
			return "manager";
		}
		else if("ResponsableProduction".equals(type)){
			collaborateurs = (ResponsableProduction)admin.consulterCollaborateurs(id);
			status = "UpdateProfileManager";
			return "manager";
		}
		
		else{
			return "error";
		}
	}
	
	
	//RŽcuperation
	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public Collaborateurs getAutres() {
		return collaborateurs;
	}

	public String getStatus() {
		return status;
	}
	
	public String getIndex() {
		return index;
	}

}
