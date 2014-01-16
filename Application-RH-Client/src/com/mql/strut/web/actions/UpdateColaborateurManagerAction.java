package com.mql.strut.web.actions;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class UpdateColaborateurManagerAction {

	private Long code;
	private String salaire;
	private String poste;
	private Long manageractuel;
	private String messageGood;
	private String type;
	
	private Collaborateur col;
	@EJB
	private IManagerRemote manager;
	
	public void setCode(Long code) {
		this.code = code;
	}


	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public void setManageractuel(Long manageractuel) {
		this.manageractuel = manageractuel;
	}


	public String execute() {
		
		System.out.println(manager.parseDate(new Date()));
		
		manager.editerCollaborateur(code, poste, Double.parseDouble(salaire), manageractuel, manager.parseDate(new Date()));
		messageGood = "Collaborateur modifié avec success !!";
		type = "managerColaborateur";
		col = manager.consulterColab(code);
		System.out.println(col.getMatricule());
		return "success";
	}


	public Long getCode() {
		return code;
	}


	public String getMessageGood() {
		return messageGood;
	}


	public String getType() {
		return type;
	}
	
	
	
	
}
