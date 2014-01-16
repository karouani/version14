package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.models.Manager;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class AjouterManagerRHAction implements ModelDriven<Manager> {
	private String messageErreur;
	private Manager manager;
	private String menu;
	private String id;
	
	private String bu;
	private String site;
	private String manageractuel;
	private List<String> techno;
	private List<String> diplome;


	@EJB
	private IAdminRemote admin;

	//Constructeur 
	public AjouterManagerRHAction() {
		manager = new Manager();
	}

	//Methode d'injection des listes
	public void remplirTechno() {
		techno = new ArrayList<>();
		for (int i = 0; i < manager.getLevel().size(); i++) {
			techno.add(manager.getDesctechno().get(i)+","+manager.getComp().get(i)+","+manager.getLevel().get(i));
		}
	}

	public void remplirDiplome() {
		diplome = new ArrayList<>();
		for (int i = 0; i < manager.getEcole().size(); i++) {
			diplome.add(manager.getEcole().get(i)+","+
					manager.getPromotion().get(i)+","+
					manager.getEcole().get(i)+","+
					manager.getType_diplome().get(i)+","+
					manager.getType_ecole().get(i)+","+
					manager.getNiveau().get(i));

		}
	}

	
	//Methode d'action
	public String execute(){
		System.out.println("*************  seminaire "+manager.getParticipeseminaire());
		
		Collaborateurs col = null;

		try {
			
			String partic="true";

			if(manager.getParticipeseminaire() == null){
				partic="false";
			}
			
			int mat = manager.getMatricule();
			if("ManagerRH".equals(manager.getProfile())){
				System.out.println("in home");
				col=new ManagerRH(manager.getMatricule(), manager.getNom(), manager.getPrenom(), manager.getAbreviation(), manager.getSexe(), manager.getDateembauche(), manager.getMoisBAP(),partic, manager.getDateparticipeseminaire(), Double.parseDouble(manager.getSalaireactuel()), manager.getPosttravail(),manager.getEmail());
				System.out.println("Collaborateur "+col);
			}
			remplirTechno();
			remplirDiplome();
			
			System.out.println("Collaborateur "+col);


			int n=admin.ajoutermanager(col, techno, diplome, 
					Long.parseLong(bu), 
					Long.parseLong(site), 
					manager.getUsername1(), 
					manager.getPassword1(), 
					manager.getProfile());
			messageErreur = "Manager ajouter avec succes !!";
			menu = "nouveauManagerRh";
			System.out.println("Retour "+n);
			if(n==1){
				menu = "nouveauManagerRh";
				messageErreur = "Matricule existe DŽja !!";
				return "error";
			}else if(n==2){
				menu = "nouveauManagerRh";
				messageErreur = "Login existe DŽja !!";
				return "error";
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		
		return "success";
		//return null;
	}
	//Recuperation

	public String getBu() {
		return bu;
	}

	public String getSite() {
		return site;
	}




	public void setBu(String bu) {
		this.bu = bu;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getManageractuel() {
		return manageractuel;
	}

	public void setManageractuel(String manageractuel) {
		this.manageractuel = manageractuel;
	}

	public String getMessageErreur() {
		return messageErreur;
	}
	
	public String getMenu() {
		return menu;
	}

	@Override
	public Manager getModel() {
		return manager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
