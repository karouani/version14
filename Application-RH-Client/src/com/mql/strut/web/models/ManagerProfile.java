package com.mql.strut.web.models;

import java.io.File;
import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class ManagerProfile implements Serializable {

	private Long idadm;
	private String nom;
	private String prenom;
	private String email;
	private String sexe;
	private String username;
	private String password;
	private String confirm_password;
	
	public ManagerProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ManagerProfile(Long idadm, String nom, String prenom,
			String email, String sexe,String username,
			String password) {
		super();
		this.idadm = idadm;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.username = username;
		this.password = password;
	}

	public Long getIdadm() {
		return idadm;
	}



	public String getUsername() {
		return username;
	}



	public String getPassword() {
		return password;
	}



	public void setIdadm(Long idadm) {
		this.idadm = idadm;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}


	@Override
	public String toString() {
		return "Admin [idadm=" + idadm + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", sexe=" + sexe
				+ ", username=" + username
				+ ", password=" + password + "]";
	}

}
