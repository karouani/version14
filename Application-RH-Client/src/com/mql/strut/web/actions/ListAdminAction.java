package com.mql.strut.web.actions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ListAdminAction {
	
	private String type;
	private List<Administrateur> list;
	
	@EJB
	private IAdminRemote admin;
	
	//IOC
	public void setType(String type) {
		this.type = type;
	}
	
	//ethode d'action
	public String execute() {
		list = admin.consulterAllAdmin();
		return "list";
	}
	
	///RŽcuperation
	public String getType() {
		//return type;
		return type;
	}


	public List<Administrateur> getList() {
		return list;
	}
}
