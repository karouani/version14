package com.mql.strut.web.actions;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.struts2.interceptor.SessionAware;

import com.mql.strut.web.models.Gmail;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Site;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class MenuManagerAction implements SessionAware{

	@EJB
	private IAdminRemote admin;

	private String menu;
	private String type;
	private String form;
	private String gmail;
	private String passwordGmail;
	
	private Map<String, Object> session;
	
	private List<Site> city;
	private List<Collaborateurs> managerRh;
	private List<BusinessUnite> buv;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute(){	
		//System.out.println("In menManager action "+getMenu());
		
		if("nouveauCollaborateur".equals(menu)){
			Gmail gmailMan = (Gmail) session.get("gmail");
			System.out.println("Talab Password voila session Gmail "+gmailMan);
			
			if(gmailMan != null){
				gmail = gmailMan.getLogin();
				passwordGmail = gmailMan.getPassword();
			}
		}
		
		this.setCity(admin.consulterAllSite());
		this.setBuv(admin.consulterAllBu());
		this.setManagerRh(admin.consulterAllCollaborateurrsManagerRH());
		
		return "success";	
	}


	public String getGmail() {
		return gmail;
	}

	public String getMenu() {
		return menu;
	}



	public void setMenu(String menu) {
		this.menu = menu;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getForm() {
		return form;
	}



	public void setForm(String form) {
		this.form = form;
	}



	public List<Site> getCity() {
		return city;
	}



	public void setCity(List<Site> city) {
		this.city = city;
	}



	public List<Collaborateurs> getManagerRh() {
		return managerRh;
	}



	public void setManagerRh(List<Collaborateurs> managerRh) {
		this.managerRh = managerRh;
	}



	public List<BusinessUnite> getBuv() {
		return buv;
	}



	public void setBuv(List<BusinessUnite> buv) {
		this.buv = buv;
	}

	public String getPasswordGmail() {
		return passwordGmail;
	}

	
}
