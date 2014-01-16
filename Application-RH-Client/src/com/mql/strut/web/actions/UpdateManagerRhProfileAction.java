package com.mql.strut.web.actions;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.models.ManagerProfile;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class UpdateManagerRhProfileAction implements ModelDriven<ManagerProfile>{
	private ManagerProfile profile;
	
	private String type;
	private String message;
	private String index = "yes";
	
	@EJB
	private IManagerRemote manager;
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String execute() {
		int n = manager.editermyprofile( profile.getIdadm(),
				profile.getNom(), 
				profile.getPrenom(),
				profile.getEmail(), 
				profile.getSexe(), 
				profile.getUsername(), 
				profile.getPassword());
		if(n == 1){
			message = "Profile ModifiŽ avec success !!";
			System.out.println(">>> "+type);
			return "success";
		}else{
			message = "Login existe deja";
			return "success";
		}
		
	}
	public UpdateManagerRhProfileAction() {
		profile = new ManagerProfile();
	}
	public ManagerProfile getModel() {
		return profile;
	}
	
	
	public Long getId() {
		return  profile.getIdadm();
	}
	public String getType() {
		return type;
	}
	public String getMessage() {
		return message;
	}

	public String getIndex() {
		return index;
	}
}
