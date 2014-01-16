package com.sqli.challange.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@DiscriminatorValue("Collaborateur")
@XmlAccessorType(XmlAccessType.FIELD)
public class Collaborateur extends Collaborateurs {

	public Collaborateur(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			 String participeseminaire,
			 String dateparticipeseminaire, double salaireactuel,
			String posttravail, String email) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				 participeseminaire, dateparticipeseminaire, salaireactuel,
				posttravail, email);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	@JoinColumn(name="manageractuel")
	private ManagerRH manageractuel;
	
	@ManyToOne
	@JoinColumn(name="managerancien")
	private ManagerRH managerancien;
	
	public Collaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collaborateur(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire, String dateparticipeseminaire,
			double salaireactuel, String posttravail) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				participeseminaire, dateparticipeseminaire, salaireactuel, posttravail);
		// TODO Auto-generated constructor stub
	}
	
	public ManagerRH getManageractuel() {
		return manageractuel;
	}

	public void setManageractuel(ManagerRH manageractuel) {
		this.manageractuel = manageractuel;
	}

	public ManagerRH getManagerancien() {
		return managerancien;
	}

	public void setManagerancien(ManagerRH managerancien) {
		this.managerancien = managerancien;
	}

}
