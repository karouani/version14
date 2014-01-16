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
public class UpdateManagerRhAction implements ModelDriven<Manager> {

	
		private String messageErreur;
		private Manager manager;
		private String type;
		private String form;
		private String id;
		private Long idcol;
		private String messageErreurUpdate;
		
		private String bu;
		private String site;
		private String manageractuel;
		private List<String> techno;
		private List<String> diplome;
		
		private Collaborateurs col2;
		
		@EJB
		private IAdminRemote admin;

		//Constructeur 
		public UpdateManagerRhAction() {
			manager = new Manager();
		}
		//Injection 
		public void setBu(String bu) {
			this.bu = bu;
		}

		public void setSite(String site) {
			this.site = site;
		}
		
		public void setManageractuel(String manageractuel) {
			this.manageractuel = manageractuel;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public void setIdcol(Long idcol) {
			this.idcol = idcol;
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
			
			try {
				
				remplirTechno();
				remplirDiplome();
				
				int mat = manager.getMatricule();
				Double salaireactuel = new Double(manager.getSalaireactuel());
				
				if("ManagerRH".equals(manager.getProfile())){
					col2=new ManagerRH(manager.getMatricule(), 
										   manager.getNom(), 
										   manager.getPrenom(),
										   manager.getAbreviation(), 
										   manager.getSexe(), 
										   manager.getDateembauche(), 
										   manager.getMoisBAP(),
										   manager.getParticipeseminaire(), 
										   manager.getDateparticipeseminaire(), 
										   salaireactuel, 
										   manager.getPosttravail(),
										   manager.getEmail());
				}
				
				int n2 =0;
				n2=admin.editerManager(idcol, col2, techno, diplome, Long.parseLong(bu), Long.parseLong(site), manager.getUsername1(), manager.getPassword1(), manager.getProfile());
				messageErreurUpdate = "Manager Editer avec succŽs !!";
				type = "editManagerRh";
				form = "managerRh";
				
				if(n2==1){
					messageErreurUpdate = "Vous ne pouvez pas utilisŽ ce Matricule car il existe DŽjˆ !!";
					return "managerRhEdit";
				}else if(n2==2){
					messageErreurUpdate = "Vous ne pouvez pas utilisŽ ce Login car il existe DŽjˆ !!";
					return "managerRhEdit";
				}
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			
			return "managerRhEdit";
		}
		
		//Recuperation

		public String getBu() {
			return bu;
		}

		public String getSite() {
			return site;
		}

		public String getManageractuel() {
			return manageractuel;
		}

		public String getMessageErreur() {
			return messageErreur;
		}
		
		public String getMessageErreurUpdate() {
			return messageErreurUpdate;
		}
		
		public String getType() {
			return type;
		}

		@Override
		public Manager getModel() {
			System.out.println(manager);
			return manager;
		}

		public String getId() {
			return id;
		}
		
		public Long getIdcol() {
			return idcol;
		}

		public Long getCode() {
			return idcol;
		}
		
		public String getForm() {
			return form;
		}


}
