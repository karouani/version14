package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class HistoriqueSalPostTravail implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codehspt;
	private double hsalaire;
	private String hdasl;
	private String hdescspt;
	@ManyToOne
	@JoinColumn(name="codecol")
	private Collaborateurs colab;
	
	
	
	public HistoriqueSalPostTravail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoriqueSalPostTravail(double hsalaire, String hdasl, String hdescspt) {
		super();
		this.hsalaire = hsalaire;
		this.hdasl = hdasl;
		this.hdescspt = hdescspt;
	}
	public long getCodehspt() {
		return codehspt;
	}
	public void setCodehspt(long codehspt) {
		this.codehspt = codehspt;
	}
	public double getHsalaire() {
		return hsalaire;
	}
	public void setHsalaire(double hsalaire) {
		this.hsalaire = hsalaire;
	}
	public String getHdasl() {
		return hdasl;
	}
	public void setHdasl(String hdasl) {
		this.hdasl = hdasl;
	}
	public String getHdescspt() {
		return hdescspt;
	}
	public void setHdescspt(String hdescspt) {
		this.hdescspt = hdescspt;
	}
	public Collaborateurs getColab() {
		return colab;
	}
	public void setColab(Collaborateurs colab) {
		this.colab = colab;
	}

}
