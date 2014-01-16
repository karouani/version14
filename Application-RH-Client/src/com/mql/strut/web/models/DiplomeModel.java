package com.mql.strut.web.models;

public class DiplomeModel {
	private String titre;
	private String promo;
	private String ecole;
	private String typeD;
	private String typeE;
	private String niveau;
	
	
	public DiplomeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DiplomeModel(String titre, String promo, String ecole, String typeD,
			String typeE, String niveau) {
		super();
		this.titre = titre;
		this.promo = promo;
		this.ecole = ecole;
		this.typeD = typeD;
		this.typeE = typeE;
		this.niveau = niveau;
	}
	public String getTitre() {
		return titre;
	}
	public String getPromo() {
		return promo;
	}
	public String getEcole() {
		return ecole;
	}
	public String getTypeD() {
		return typeD;
	}
	public String getTypeE() {
		return typeE;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public void setTypeD(String typeD) {
		this.typeD = typeD;
	}
	public void setTypeE(String typeE) {
		this.typeE = typeE;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Diplome [titre=" + titre + ", promo=" + promo + ", ecole="
				+ ecole + ", typeD=" + typeD + ", typeE=" + typeE + ", niveau="
				+ niveau + "]";
	}
}
