package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class EditerStatusManagerAction {

	private String type;
	private Long code;
	
	private List<Collaborateur> nonlist;
	private List<Collaborateur> list;
	
	@EJB
	private IManagerRemote manager;
	//Construteur
	public EditerStatusManagerAction() {
		list = new ArrayList<>();
		nonlist = new ArrayList<>();
	}
	
	//Injection Par intercepteur
	public void setType(String type) {
		this.type = type;
	}

	public void setCode(Long code) {
		this.code = code;
	}


	//Methode d'action
	public String execute(){
		nonlist = manager.consulterlistCollabNRH(code);
		list = manager.consulterlistCollabRH(code);
		return "success";
	}
	//Getter / Recuperation par vue
	public String getType() {
		return type;
	}
	
	public Long getCode() {
		return code;
	}

	public List<Collaborateur> getNonlist() {
		return nonlist;
	}

	public List<Collaborateur> getList() {
		return list;
	}
	
	

}
