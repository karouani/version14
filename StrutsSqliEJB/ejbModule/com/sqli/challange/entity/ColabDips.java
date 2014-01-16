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
@Table(name="ColabDips")
public class ColabDips implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idcoldips;
	
	@ManyToOne
	@JoinColumn(name="codecol")
	private Collaborateurs col;
	
	@ManyToOne
	@JoinColumn(name="codedip")
	private Diplomes dip;
	
	
	public ColabDips() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ColabDips(long idcoldips, Collaborateurs col, Diplomes dip) {
		super();
		this.idcoldips = idcoldips;
		this.col = col;
		this.dip = dip;
	}


	public long getIdcoldips() {
		return idcoldips;
	}


	public void setIdcoldips(long idcoldips) {
		this.idcoldips = idcoldips;
	}


	public Collaborateurs getCol() {
		return col;
	}


	public void setCol(Collaborateurs col) {
		this.col = col;
	}


	public Diplomes getDip() {
		return dip;
	}


	public void setDip(Diplomes dip) {
		this.dip = dip;
	}
	
	
}
