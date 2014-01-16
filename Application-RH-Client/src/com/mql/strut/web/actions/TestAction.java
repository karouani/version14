package com.mql.strut.web.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.mql.strut.web.models.DiplomeModel;
import com.mql.strut.web.models.Manager;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IAuthentificationLocal;
import com.sqli.challange.sessions.IAuthentificationRemote;

@Stateless
public class TestAction{

	private List<String> ecole; 
	private List<String> niveau;
	private List<String> type_ecole;
	private List<String> type_diplome;
	private List<String> promotion;

	private List<String> diplome;
	
	
	public List<String> getEcole() {
		return ecole;
	}

	public List<String> getNiveau() {
		return niveau;
	}

	public List<String> getType_ecole() {
		return type_ecole;
	}

	public List<String> getType_diplome() {
		return type_diplome;
	}

	public List<String> getPromotion() {
		return promotion;
	}

	public void setEcole(List<String> ecole) {
		this.ecole = ecole;
	}

	public void setNiveau(List<String> niveau) {
		this.niveau = niveau;
	}

	public void setType_ecole(List<String> type_ecole) {
		this.type_ecole = type_ecole;
	}

	public void setType_diplome(List<String> type_diplome) {
		this.type_diplome = type_diplome;
	}

	public void setPromotion(List<String> promotion) {
		this.promotion = promotion;
	}

	
	public void remplirDiplome() {
		diplome = new ArrayList<>();
		for (int i = 0; i < ecole.size(); i++) {
			diplome.add(ecole.get(i)+","+
					promotion.get(i)+","+
					ecole.get(i)+","+
					type_diplome.get(i)+","+
					type_ecole.get(i)+","+
					niveau.get(i));

		}
	}
	
	public String execute() {
		remplirDiplome();
		for (int i = 0; i < diplome.size(); i++) {
			System.out.println("Diplome numero "+i+" >>>> "+diplome.get(i));
		}
		return null;
	}

	
}
