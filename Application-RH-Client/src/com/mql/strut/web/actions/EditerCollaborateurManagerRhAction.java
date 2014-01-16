package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.models.DiplomeModel;
import com.mql.strut.web.models.TechnoModel;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.Site;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class EditerCollaborateurManagerRhAction {

	private String type;
	private String index;
	private Long code;
	private Collaborateur col;
	private String message;
	
	private List<Site> city;
	private List<BusinessUnite> buv;
	
	private List<DiplomeModel> diplomes;
	private List<TechnoModel> techno;
	
	private DiplomeModel dip;
	private TechnoModel technoModel;
	
	@EJB
	private IManagerRemote manager;
	
	public void setCity(List<Site> city) {
		this.city = city;
	}
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setBuv(List<BusinessUnite> buv) {
		this.buv = buv;
	}
	
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
		
		diplomes =new ArrayList<>();
		techno = new ArrayList<>();
		
		for (int i = 0; i < manager.listDiplomes(code).size(); i++) {
			dip = new DiplomeModel();
			System.out.println("Liste Dip BD "+manager.listDiplomes(code).get(i));
			dip.setEcole(manager.listDiplomes(code).get(i).split(",")[0]);
			dip.setNiveau(manager.listDiplomes(code).get(i).split(",")[1]);
			dip.setPromo(manager.listDiplomes(code).get(i).split(",")[4]);
			dip.setTitre(manager.listDiplomes(code).get(i).split(",")[0]);
			dip.setTypeD(manager.listDiplomes(code).get(i).split(",")[3]);
			dip.setTypeE(manager.listDiplomes(code).get(i).split(",")[2]);
			
			System.out.println("Diplome li Gaddite"+dip);
			diplomes.add(dip);
		}
		
		for (int i = 0; i < manager.listTechno(code).size(); i++) {
			technoModel = new TechnoModel();
			technoModel.setComp(manager.listTechno(code).get(i).split(",")[1]);
			technoModel.setLevel(manager.listTechno(code).get(i).split(",")[2]);
			technoModel.setTechno(manager.listTechno(code).get(i).split(",")[0]);
			
			techno.add(technoModel);
		}
		
		this.setCity(manager.consulterAllSite());
		this.setBuv(manager.consulterAllBu());
		index = "yes";
		col = manager.consulterColab(code);
		return "success";
	}
	
	public String getType() {
		return type;
	}
	
	public Long getCode() {
		return code;
	}

	public Collaborateur getModel() {
		return col;
	}

	public List<Site> getCity() {
		return city;
	}

	public List<BusinessUnite> getBuv() {
		return buv;
	}

	public String getIndex() {
		return index;
	}


	public List<DiplomeModel> getDiplomes() {
		return diplomes;
	}


	public List<TechnoModel> getTechno() {
		return techno;
	}
	
}
