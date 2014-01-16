package com.mql.strut.web.actions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class StatistiqueAction {
	private List<Double> salaire;
	@EJB
	private IManagerRemote manager;
	
	public String execute() {
		for (int i = 0; i < manager.consulterlistCollaborateur().size(); i++) {
			salaire.add(manager.consulterlistCollaborateur().get(i).getSalaireactuel());
		}
		
		return "success";
	}

	public List<Double> getSalaire() {
		return salaire;
	}
	
}
