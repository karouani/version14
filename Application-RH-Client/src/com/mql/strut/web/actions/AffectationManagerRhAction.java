package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class AffectationManagerRhAction {

	private List<Long> managerYes;
	private Long code;
	private String message;
	private String type;

	@EJB
	private IManagerRemote managerActivate;

	public void setManagerYes(List<Long> managerYes) {
		this.managerYes = managerYes;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String execute() {
		if( managerYes.size() == 0) {
			message= "Enregistrement avec success";
			type = "affectation";
			return "success";
		}
		else{
			List<Long> colsact=new ArrayList<Long>();

			for(Collaborateur col:managerActivate.consulterlistCollabRH(code)){
				colsact.add(col.getCodecol());
			}

			for(Long id:managerYes){
				if(managerActivate.checkrhcol(code, id)){
					managerActivate.affecterRhCol(id,code);
				}
			}

			for(Long id:colsact){
				if(!managerYes.contains(id)){
					managerActivate.deaffecterRhCol(id, code);
				}
			}

			message= "Enregistrement avec success";
			type = "affectation";
			System.out.println(message);
			return "success";
		}

	}

	public List<Long> getManagerYes() {
		return managerYes;
	}

	public Long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}

}
