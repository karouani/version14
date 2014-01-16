package com.sqli.challange.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ColCompTechno  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String level;
	@ManyToOne
	@JoinColumn(name="codecol")
	private Collaborateurs colab;
	
	@ManyToOne
	@JoinColumn(name="codecompt")
	private Competence comp;
	
	@ManyToOne
	@JoinColumn(name="codetechno")
	private Technologies techno;
	
	public ColCompTechno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ColCompTechno(String level, Collaborateurs colab, Competence comp,
			Technologies techno) {
		super();
		this.level = level;
		this.colab = colab;
		this.comp = comp;
		this.techno = techno;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Collaborateurs getColab() {
		return colab;
	}
	public void setColab(Collaborateurs colab) {
		this.colab = colab;
	}
	public Competence getComp() {
		return comp;
	}
	public void setComp(Competence comp) {
		this.comp = comp;
	}
	public Technologies getTechno() {
		return techno;
	}
	public void setTechno(Technologies techno) {
		this.techno = techno;
	}
}
