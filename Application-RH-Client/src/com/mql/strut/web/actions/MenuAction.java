package com.mql.strut.web.actions;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.struts2.interceptor.SessionAware;

import com.mql.strut.web.models.User;
import com.opensymphony.xwork2.ActionContext;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Site;
import com.sqli.challange.sessions.IAdminRemote;

import freemarker.ext.servlet.HttpRequestHashModel;
@Stateless
public class MenuAction{
	
	
	
	@EJB
	private IAdminRemote admin;
	
	private String menu = "yes";
	private String type;
	private String form;
	
	private List<Site> city;
	private List<Collaborateurs> managerRh;
	private List<BusinessUnite> buv;
	
	public void setType(String type) {
		this.type = type;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public void setCity(List<Site> city) {
		this.city = city;
	}

	public void setManagerRh(List<Collaborateurs> managerRh) {
		this.managerRh = managerRh;
	}

	public void setBuv(List<BusinessUnite> buv) {
		this.buv = buv;
	}

	public String execute(){
		this.setCity(admin.consulterAllSite());
		this.setBuv(admin.consulterAllBu());
		this.setManagerRh(admin.consulterAllCollaborateurrsManagerRH());
		
		 return "success";	
	}

	public String getMenu() {
		return menu;
	}

	
	public String getType() {
		return type;
	}
	public String getForm() {
		return form;
	}
	public List<Site> getCity() {
		return city;
	}

	public List<Collaborateurs> getManagerRh() {
		return managerRh;
	}

	public List<BusinessUnite> getBuv() {
		return buv;
	}

	

}
