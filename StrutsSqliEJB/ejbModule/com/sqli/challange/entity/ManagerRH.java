package com.sqli.challange.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@DiscriminatorValue("ManagerRH")
public class ManagerRH extends Collaborateurs {

	public ManagerRH(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire,
			String dateparticipeseminaire, double salaireactuel,
			String posttravail, String email) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				participeseminaire, dateparticipeseminaire, salaireactuel,
				posttravail, email);
		// TODO Auto-generated constructor stub
	}

	public ManagerRH() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerRH(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire, String dateparticipeseminaire,
			double salaireactuel, String posttravail) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				participeseminaire, dateparticipeseminaire, salaireactuel, posttravail);
		// TODO Auto-generated constructor stub
	}

	
	
}
