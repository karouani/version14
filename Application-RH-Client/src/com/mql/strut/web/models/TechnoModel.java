package com.mql.strut.web.models;

public class TechnoModel {
	private String techno;
	private String comp;
	private String level;
	
	
	
	public TechnoModel() {
		super();
	}

	public TechnoModel(String techno, String comp, String level) {
		super();
		this.techno = techno;
		this.comp = comp;
		this.level = level;
	}
	
	public String getTechno() {
		return techno;
	}
	public String getComp() {
		return comp;
	}
	public String getLevel() {
		return level;
	}
	public void setTechno(String techno) {
		this.techno = techno;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "TechnoModel [techno=" + techno + ", comp=" + comp + ", level="
				+ level + "]";
	}
}
