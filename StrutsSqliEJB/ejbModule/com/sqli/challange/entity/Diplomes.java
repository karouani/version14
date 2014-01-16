package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplomes implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codedip;
	private String titre;
	private String promotion;
	private String ecole;
	private String typediplome;
	private String typecole;
	private String niveau;
	private int dldip;
	
	@ManyToOne
	@JoinColumn(name="codecol")
	private Collaborateurs col;
	

	public Diplomes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Diplomes(String titre, String promotion, String ecole,
			String typediplome, String typecole, String niveau) {
		super();
		this.titre = titre;
		this.promotion = promotion;
		this.ecole = ecole;
		this.typediplome = typediplome;
		this.typecole = typecole;
		this.niveau = niveau;
	}



	public long getCodedip() {
		return codedip;
	}

	public void setCodedip(long codedip) {
		this.codedip = codedip;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getTypediplome() {
		return typediplome;
	}

	public void setTypediplome(String typediplome) {
		this.typediplome = typediplome;
	}

	public String getTypecole() {
		return typecole;
	}

	public void setTypecole(String typecole) {
		this.typecole = typecole;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@JsonIgnore
	public Collaborateurs getCols() {
		return col;
	}

	public void setCols(Collaborateurs cols) {
		this.col = cols;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	
	public int getDldip() {
		return dldip;
	}



	public void setDldip(int dldip) {
		this.dldip = dldip;
	}
}
