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
public class Technologies implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codetechno;
	private String desctechno;
	
	@OneToMany(mappedBy="techno",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@XmlTransient
	private List<ColCompTechno> cct=new ArrayList<ColCompTechno>();

	public long getCodetechno() {
		return codetechno;
	}

	public void setCodetechno(long codetechno) {
		this.codetechno = codetechno;
	}

	public String getDesctechno() {
		return desctechno;
	}

	public void setDesctechno(String desctechno) {
		this.desctechno = desctechno;
	}

	
	public Technologies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technologies(String desctechno) {
		super();
		this.desctechno = desctechno;
	}

	@JsonIgnore
	public List<ColCompTechno> getCct() {
		return cct;
	}

	public void setCct(List<ColCompTechno> cct) {
		this.cct = cct;
	}
	
	

}
