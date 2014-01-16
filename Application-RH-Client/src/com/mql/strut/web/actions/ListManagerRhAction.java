package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ListManagerRhAction {
	
	private String retour;

	private List<Collaborateurs> listManagerRh;
	
	@EJB
	private IAdminRemote admin;
	//IOC
	public void setRetour(String retour) {
		this.retour = retour;
	}
	
	public ListManagerRhAction() {
		listManagerRh = new ArrayList<Collaborateurs>();
	}
	//Methode d'action
	public String execute() {
		listManagerRh = admin.consulterAllCollaborateurrsManagerRH();
		System.out.println("retour "+retour);
		return "success";
	}
	
	//Recuperation
	public String getRetour() {
		return retour;
	}
	
	public List<Collaborateurs> getList() {
		return listManagerRh;
	}
	
}
