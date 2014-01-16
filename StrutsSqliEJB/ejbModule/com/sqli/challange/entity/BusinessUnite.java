package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
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
public class BusinessUnite implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codebu;
	private String descbu;
	
	@OneToMany(mappedBy="bu")
	@XmlTransient
	private List<Collaborateurs> lcols;
	
	
	public BusinessUnite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessUnite(String descbu) {
		super();
		this.descbu = descbu;
	}
	public long getCodebu() {
		return codebu;
	}
	public void setCodebu(long codebu) {
		this.codebu = codebu;
	}
	public String getDescbu() {
		return descbu;
	}
	public void setDescbu(String descbu) {
		this.descbu = descbu;
	}
	@JsonIgnore
	public List<Collaborateurs> getLcols() {
		return lcols;
	}
	public void setLcols(List<Collaborateurs> lcols) {
		this.lcols = lcols;
	}
	

}
