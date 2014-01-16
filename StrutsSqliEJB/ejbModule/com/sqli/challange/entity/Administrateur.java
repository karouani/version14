package com.sqli.challange.entity;

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

@Entity
@Table(name="administrateur")
public class Administrateur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idadm;
	private String nom;
	private String prenom;
	private String photo;
	private String email;
	private String sexe;
	private String description;
	
	@OneToOne
	@JoinColumn(name="codecompte")
	private Compte cmp;
	

	public Administrateur(String nom, String prenom, String photo,
			String email, String sexe, String description) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.email = email;
		this.sexe = sexe;
		this.description = description;
	}

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdadm() {
		return idadm;
	}

	public void setIdadm(long idadm) {
		this.idadm = idadm;
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

	public Compte getCmp() {
		return cmp;
	}

	public void setCmp(Compte cmp) {
		this.cmp = cmp;
	}

	@Override
	public String toString() {
		return "Administrateur [idadm=" + idadm + ", nom=" + nom + ", prenom="
				+ prenom + ", photo=" + photo + ", email=" + email + ", sexe="
				+ sexe + ", description=" + description + ", cmp=" + cmp + "]";
	}
	
}
