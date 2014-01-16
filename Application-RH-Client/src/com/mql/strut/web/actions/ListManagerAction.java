package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ListManagerAction {
	
	private String type;
	private String qui;
	private List<Collaborateurs> list;
	
	@EJB
	private IAdminRemote admin;
	//IOC
	public void setType(String type) {
		this.type = type;
	}
	public void setQui(String qui) {
		this.qui = qui;
	}
	
	public ListManagerAction() {
		list = new ArrayList<Collaborateurs>();
	}
	//Methode d'action
	public String execute() {
		String retour = "error";
		list = admin.consulterAllCollaborateurrsManager();
		if ("admin".equals(getQui())) {
			retour = "managerAdmin";
		}
		return retour;
	}
	
	//Recuperation
	public String getType() {
		return type;
	}
	public String getQui() {
		return qui;
	}
	public List<Collaborateurs> getList() {
		return list;
	}
	
}
