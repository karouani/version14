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


public class Admin implements Serializable {

	private Long idadm;
	private String nom;
	private String prenom;
	private String photo;
	private String email;
	private String sexe;
	private String description;
	private String username;
	private String password;
	private String status;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Admin(Long idadm, String nom, String prenom, String photo,
			String email, String sexe, String description, String username,
			String password, String status) {
		super();
		this.idadm = idadm;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.email = email;
		this.sexe = sexe;
		this.description = description;
		this.username = username;
		this.password = password;
		this.status = status;
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



	public String getStatus() {
		return status;
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



	public void setStatus(String status) {
		this.status = status;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Admin [idadm=" + idadm + ", nom=" + nom + ", prenom=" + prenom
				+ ", photo=" + photo + ", email=" + email + ", sexe=" + sexe
				+ ", description=" + description + ", username=" + username
				+ ", password=" + password + ", status=" + status + "]";
	}

}
