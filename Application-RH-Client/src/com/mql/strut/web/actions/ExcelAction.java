package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mql.strut.web.UTILS.*;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ExcelAction {

	@EJB
	private IAdminRemote admin;
	
	private StrinCreerExcel home;
	
	
	public String execute(){
		System.out.println("debut preparation");
		/*Map<String, Object[]> data = new TreeMap<String, Object[]>();
		
		String[] titres={"Matricule", "Nom", "Prenom","Abreviation","Date embauche","Participe siminaire","Date Participation","Email","Mois BAP","Post Travail","Salaire","Sexe","Business Unite","Site",};
		//admin consulterAllCollaborateurrsManager
		System.out.println("la taille "+admin.consulterAllCollaborateurrsManager().size());
		//Object[] val=new Object[admin.consulterAllCollaborateurrsManager().size()];
		List<Object> ls=new ArrayList<Object>();
		for (Collaborateurs col:admin.consulterAllCollaborateurrsManager()) {
			String[] val={col.getMatricule(),col.getNom(),col.getPrenom(),col.getDateembauche(),col.getParticipeseminaire(),col.getDateparticipeseminaire(),col.getEmail(),col.getPosttravail(),""+col.getSalaireactuel(),col.getSexe(),col.getBu().getDescbu(),col.getSite().getDescsite()};
				//{col.getMatricule(),col.getNom(),col.getPrenom(),col.getAbreviation(),""+col.getDateembauche(),col.getParticipeseminaire(),""+col.getDateparticipeseminaire(),col.getEmail(),col.getMoisBAP(),col.getPosttravail(),""+col.getSalaireactuel(),col.getSexe(),col.getBu().getDescbu(),col.getSite().getDescsite()};
			//ls.toArray()
			data.put(""+col.getCodecol(),val);
		}
		home=new StrinCreerExcel(data, titres, "managers", "manager");*/
		
		//nnew version
		Map<String, String[]> data = new TreeMap<String, String[]>();

		String[] titres={"Matricule", "Nom", "Prenom","Date embauche","Participe siminaire","Date Participation","Email","Post Travail","Salaire","Sexe","Business Unite","Site","Profil","Matricule Manager Acteul"};
		//admin consulterAllCollaborateurrsManager
		//System.out.println("la taille "+admin.consulterAllCollaborateurrsManager().size());
		//Object[] val=new Object[admin.consulterAllCollaborateurrsManager().size()];
		List<String> ls=new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
			String[] val={"132"+i,"ManagerRH "+i,"agence"+i,"01/01/2012","oui","01/01/2012","cicin"+i+"@hotmail.com","APP"+i,"7005","H","MRR1","RABAT","ManagerRH","30991"};
			//{col.getMatricule(),col.getNom(),col.getPrenom(),col.getAbreviation(),""+col.getDateembauche(),col.getParticipeseminaire(),""+col.getDateparticipeseminaire(),col.getEmail(),col.getMoisBAP(),col.getPosttravail(),""+col.getSalaireactuel(),col.getSexe(),col.getBu().getDescbu(),col.getSite().getDescsite()};
			//ls.toArray()
			data.put("132"+i,val);
		}
		String[] val={"11345","Yassine","Karawani","01/12/2012","oui","01/01/2012","cicinRH@hotmail.com","ARP","7080.65","H","MRR2","CASABLANCA","ManagerRH","30991"};
		data.put("11345",val);
		String[] val2={"18845","Amin","Home","15/12/2012","oui","01/01/2012","cicin23@hotmail.com","ARP","7080.65","H","MRR3","FES","ManagerRH","30991"};
		data.put("18845",val2);
		
		home=new StrinCreerExcel(data, titres, "Manager Rh", "managerRH2013",12);
		System.out.println("fin preparation");
		return null;
	}
	

}
