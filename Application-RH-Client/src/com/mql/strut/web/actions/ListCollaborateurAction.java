package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class ListCollaborateurAction {
	private String type;
	private List<Collaborateur> colaborateur;
	
	@EJB
	private IManagerRemote manager;
	
	public ListCollaborateurAction() {
		colaborateur = new ArrayList<>();
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setColaborateur(List<Collaborateur> colaborateur) {
		this.colaborateur = colaborateur;
	}
	
	
	public String execute(){
		colaborateur = manager.consulterlistCollaborateur();
		return "success";
	}
	
	
	public String getType() {
		return type;
	}
	public List<Collaborateur> getColaborateur() {
		return colaborateur;
	}
	

}
