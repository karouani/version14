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
public class Site implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codest;
	private String descsite;
	
	@OneToMany(mappedBy="site")
	@XmlTransient
	private List<Collaborateurs> lcols;
	
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(String descsite) {
		super();
		this.descsite = descsite;
	}
	public long getCodest() {
		return codest;
	}
	public void setCodest(long codest) {
		this.codest = codest;
	}
	public String getDescsite() {
		return descsite;
	}
	public void setDescsite(String descsite) {
		this.descsite = descsite;
	}
	
	@JsonIgnore
	public List<Collaborateurs> getLcols() {
		return lcols;
	}
	public void setLcols(List<Collaborateurs> lcols) {
		this.lcols = lcols;
	}
	
}
