package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Rituls implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idrt;
	
	private long idcol;
	private long idmanagerRh;
	private long idmanager;
	private String themert;
	private String descrt;
	private String lu;
	@Lob
	private String message;
	
	@ManyToOne
	@JoinColumn(name="codecol")
	private Collaborateurs col;

	public Rituls(long idcol, long idmanagerRh, long idmanager,
			String themert, String descrt, String lu, String message) {
		super();
		this.idcol = idcol;
		this.idmanagerRh = idmanagerRh;
		this.idmanager = idmanager;
		this.themert = themert;
		this.descrt = descrt;
		this.lu = lu;
		this.message = message;
	}

	public Rituls() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public long getIdcol() {
		return idcol;
	}

	public void setIdcol(long idcol) {
		this.idcol = idcol;
	}

	public long getIdmanagerRh() {
		return idmanagerRh;
	}

	public void setIdmanagerRh(long idmanagerRh) {
		this.idmanagerRh = idmanagerRh;
	}

	public long getIdmanager() {
		return idmanager;
	}

	public void setIdmanager(long idmanager) {
		this.idmanager = idmanager;
	}

	public long getIdrt() {
		return idrt;
	}

	public void setIdrt(long idrt) {
		this.idrt = idrt;
	}

	public String getThemert() {
		return themert;
	}

	public void setThemert(String themert) {
		this.themert = themert;
	}

	public String getDescrt() {
		return descrt;
	}

	public void setDescrt(String descrt) {
		this.descrt = descrt;
	}

	public String getLu() {
		return lu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Rituls [idrt=" + idrt + ", idcol=" + idcol + ", idmanagerRh="
				+ idmanagerRh + ", idmanager=" + idmanager + ", themert="
				+ themert + ", descrt=" + descrt + ", lu=" + lu
				+ ", message=" + message +"]";
	}

	public Collaborateurs getCol() {
		return col;
	}

	public void setCol(Collaborateurs col) {
		this.col = col;
	}

	public void setLu(String lu) {
		this.lu = lu;
	}

	
}
