package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.models.DiplomeModel;
import com.mql.strut.web.models.Manager;
import com.mql.strut.web.models.TechnoModel;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Site;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class EditerManagerAction{
	private String type;
	private String form;
	private Long code;
	
	private List<DiplomeModel> diplomes;
	private List<TechnoModel> techno;
	private String index = "yes";
	
	private List<Site> city;
	private List<BusinessUnite> buv;
	
	private DiplomeModel dip;
	private TechnoModel technoModel;
	
	private Collaborateurs col;
	
	@EJB
	private IAdminRemote admin;
	
	//Injection d'indepandance
	
	public void setCity(List<Site> city) {
		this.city = city;
	}
	
	public void setBuv(List<BusinessUnite> buv) {
		this.buv = buv;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setForm(String form) {
		this.form = form;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	//Methode d'action
	public String execute(){
		
		
		diplomes =new ArrayList<>();
		techno = new ArrayList<>();
		
		col = admin.consulterCollaborateurs(code);
		this.setCity(admin.consulterAllSite());
		this.setBuv(admin.consulterAllBu());
		
		for (int i = 0; i < admin.listDiplomes(code).size(); i++) {
			dip = new DiplomeModel();
			dip.setEcole(admin.listDiplomes(code).get(i).split(",")[0]);
			dip.setNiveau(admin.listDiplomes(code).get(i).split(",")[1]);
			dip.setPromo(admin.listDiplomes(code).get(i).split(",")[4]);
			dip.setTitre(admin.listDiplomes(code).get(i).split(",")[0]);
			dip.setTypeD(admin.listDiplomes(code).get(i).split(",")[2]);
			dip.setTypeE(admin.listDiplomes(code).get(i).split(",")[3]);
			
			diplomes.add(dip);
		}
		
		for (int i = 0; i < diplomes.size(); i++) {
			System.out.println(diplomes.get(i));
		}
		
		for (int i = 0; i < admin.listTechno(code).size(); i++) {
			technoModel = new TechnoModel();
			technoModel.setComp(admin.listTechno(code).get(i).split(",")[1]);
			technoModel.setLevel(admin.listTechno(code).get(i).split(",")[2]);
			technoModel.setTechno(admin.listTechno(code).get(i).split(",")[0]);
			
			techno.add(technoModel);
		}
		
		for (int i = 0; i < techno.size(); i++) {
			System.out.println(techno.get(i));
		}
		
		if("managerRh".equals(form)){
			System.out.println("Traitement Retour >>> "+form);
			return "editManagerRh";
		}else{
			System.out.println("Traitement Retour >>> "+form);
			return "editManager";
		}
	}
	//RŽcuperation
	public String getType() {
		return type;
	}
	
	public String getIndex() {
		return index;
	}
	
	public String getForm() {
		return form;
	}

	public Collaborateurs getCol() {
		return col;
	}

	public List<DiplomeModel> getDiplomes() {
		return diplomes;
	}

	public List<TechnoModel> getTechno() {
		return techno;
	}
	
	public List<Site> getCity() {
		return city;
	}

	public List<BusinessUnite> getBuv() {
		return buv;
	}
}
