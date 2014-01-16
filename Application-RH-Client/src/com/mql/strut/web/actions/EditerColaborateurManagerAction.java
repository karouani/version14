package com.mql.strut.web.actions;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.ColabDips;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class EditerColaborateurManagerAction {
	private String type;
	private Long code;
	private Collaborateur col;
	
	private List<ManagerRH> managerActuel;
	
	@EJB
	private IManagerRemote manager;

	

	public void setType(String type) {
		this.type = type;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public void setCol(Collaborateur col) {
		this.col = col;
	}
	
	public String execute() {
		col = manager.consulterColab(code);
		managerActuel = manager.consulterlistManagerRH();
		return "success";
	}
	
	public String getType() {
		return type;
	}
	
	public Long getCode() {
		return code;
	}

	public Collaborateur getCol() {
		return col;
	}

	public List<ManagerRH> getManagerActuel() {
		return managerActuel;
	}

}
