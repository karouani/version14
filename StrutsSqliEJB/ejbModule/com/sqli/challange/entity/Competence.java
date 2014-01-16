package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
public class Competence implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codecompt;
	private String dicrpt;
	
	
	@OneToMany(mappedBy="comp",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@XmlTransient
	private List<ColCompTechno> cct=new ArrayList<ColCompTechno>();
	

	public Competence(String dicrpt) {
		super();
		this.dicrpt = dicrpt;
	}

	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCodecompt() {
		return codecompt;
	}

	public void setCodecompt(long codecompt) {
		this.codecompt = codecompt;
	}

	public String getdicrpt() {
		return dicrpt;
	}

	public void setComp(String dicrpt) {
		this.dicrpt = dicrpt;
	}

	@JsonIgnore
	public List<ColCompTechno> getCct() {
		return cct;
	}

	public void setCct(List<ColCompTechno> cct) {
		this.cct = cct;
	}

	
	 
}
