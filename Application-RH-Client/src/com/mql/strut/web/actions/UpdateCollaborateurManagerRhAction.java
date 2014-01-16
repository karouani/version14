package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.models.TechnoModel;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IManagerRHRemote;

@Stateless
public class UpdateCollaborateurManagerRhAction {

	private String index;
	private String message;

	private Long id;
	private int matricule;
	private String nom;
	private String prenom;
	private String email;
	private String abreviation;
	private String sexe;
	private Long site;
	private Long bu;
	private String participeseminaire;
	private String dateparticipeseminaire;

	private List<String> ecole; 
	private List<String> niveau;
	private List<String> type_ecole;
	private List<String> type_diplome;
	private List<String> promotion;

	private List<String> desctechno;
	private List<String> comp;
	private List<String> level;

	private List<String> diplome;
	private List<String> techno;

	@EJB
	private IManagerRHRemote managerRh;

	public String getIndex() {
		return index;
	}

	public void setDesctechno(List<String> desctechno) {
		this.desctechno = desctechno;
	}

	public void setComp(List<String> comp) {
		this.comp = comp;
	}

	public void setLevel(List<String> level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public Long getCode() {
		return id;
	}

	public List<String> getEcole() {
		return ecole;
	}

	public List<String> getNiveau() {
		return niveau;
	}

	public List<String> getType_ecole() {
		return type_ecole;
	}

	public List<String> getType_diplome() {
		return type_diplome;
	}

	public List<String> getPromotion() {
		return promotion;
	}

	public void setEcole(List<String> ecole) {
		this.ecole = ecole;
	}

	public void setNiveau(List<String> niveau) {
		this.niveau = niveau;
	}

	public void setType_ecole(List<String> type_ecole) {
		this.type_ecole = type_ecole;
	}

	public void setType_diplome(List<String> type_diplome) {
		this.type_diplome = type_diplome;
	}

	public void setPromotion(List<String> promotion) {
		this.promotion = promotion;
	}

	
	//Methode d'injection des listes
	public void remplirTechno() {
		techno = new ArrayList<>();
		for (int i = 0; i < level.size(); i++) {
			techno.add(desctechno.get(i)+","+comp.get(i)+","+level.get(i));
		}
	}

	public void remplirDiplome() {
		diplome = new ArrayList<>();
		for (int i = 0; i < ecole.size(); i++) {
			diplome.add(ecole.get(i)+","+
					niveau.get(i)+","+
					type_ecole.get(i)+","+
					type_diplome.get(i)+","+
					promotion.get(i)
					);
		}
	}

	public String execute() {

		remplirDiplome();
		remplirTechno();

		for (String ds:diplome) {
			System.out.println("Voila diplome recuperer par JSP "+ds);
		}
		
		managerRh.UpdateCollaborateurManagerRhAction(
				id, 
				nom, 
				prenom, 
				email, 
				abreviation, 
				sexe, 
				site, 
				bu, 
				participeseminaire, 
				dateparticipeseminaire,
				diplome,
				techno);
		System.out.println("Apres enregistrement Diplome Size >>>>> "+diplome.size());
		message = "Update avec Success !!";
		
		
		index = "yes";

		return "success";
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public void setSite(Long site) {
		this.site = site;
	}
	public void setBu(Long bu) {
		this.bu = bu;
	}

	public void setParticipeseminaire(String participeseminaire) {
		this.participeseminaire = participeseminaire;
	}
	public void setDateparticipeseminaire(String dateparticipeseminaire) {
		this.dateparticipeseminaire = dateparticipeseminaire;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

}
