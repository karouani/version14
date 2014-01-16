package com.sqli.challange.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("ResponsableProduction")
public class ResponsableProduction extends Collaborateurs {

	public ResponsableProduction(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire,
			String dateparticipeseminaire, double salaireactuel,
			String posttravail, String email) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				participeseminaire, dateparticipeseminaire, salaireactuel,
				posttravail, email);
		// TODO Auto-generated constructor stub
	}

	public ResponsableProduction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponsableProduction(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire, String dateparticipeseminaire,
			double salaireactuel, String posttravail) {
		super(matricule, nom, prenom, abreviation, sexe, dateembauche, moisBAP,
				participeseminaire, dateparticipeseminaire, salaireactuel, posttravail);
		// TODO Auto-generated constructor stub
	}

	 
}
