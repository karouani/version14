package com.mql.strut.web.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ResponsableProduction;

public class Manager {
	
	private List<String> ecole; 
	private List<String> niveau;
	private List<String> type_ecole;
	private List<String> type_diplome;
	private List<String> promotion;
	private List<String> desctechno;
	private List<String> comp;
	private List<String> level;
	
	private int matricule;
	private String nom;
	private String prenom;
	private String abreviation;
	private String sexe;
	private String dateembauche;
	private String moisBAP;
	private String datedepart;
	private String participeseminaire;
	private String dateparticipeseminaire;
	private String salaireactuel;
	private String posttravail;
	private String email;
	
	private String profile;
	private String username1;
	private String password1;
	private String confirm_password1;
	
	//private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	public Manager() {
	}
	
	public Manager(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche,
			String moisBAP, String datedepart, String participeseminaire,
			String dateparticipeseminaire, String salaireactuel,
			String posttravail, String email) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.abreviation = abreviation;
		this.sexe = sexe;
		this.dateembauche = dateembauche;
		this.moisBAP = moisBAP;
		this.datedepart = datedepart;
		this.participeseminaire = participeseminaire;
		this.dateparticipeseminaire = dateparticipeseminaire;
		this.salaireactuel = salaireactuel;
		this.posttravail = posttravail;
		this.email = email;
	}


	public Manager(List<String> ecole, List<String> niveau,
			List<String> type_ecole, List<String> type_diplome,
			List<String> promotion, List<String> desctechno, List<String> comp,
			List<String> level, int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche,
			String moisBAP, String datedepart, String participeseminaire,
			String dateparticipeseminaire, String salaireactuel,
			String posttravail, String email, String profile, String username1,
			String password1, String confirm_password1) {
		super();
		this.ecole = ecole;
		this.niveau = niveau;
		this.type_ecole = type_ecole;
		this.type_diplome = type_diplome;
		this.promotion = promotion;
		this.desctechno = desctechno;
		this.comp = comp;
		this.level = level;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.abreviation = abreviation;
		this.sexe = sexe;
		this.dateembauche = dateembauche;
		this.moisBAP = moisBAP;
		this.datedepart = datedepart;
		this.participeseminaire = participeseminaire;
		this.dateparticipeseminaire = dateparticipeseminaire;
		this.salaireactuel = salaireactuel;
		this.posttravail = posttravail;
		this.email = email;
		this.profile = profile;
		this.username1 = username1;
		this.password1 = password1;
		this.confirm_password1 = confirm_password1;
		
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

	public List<String> getDesctechno() {
		return desctechno;
	}

	public List<String> getComp() {
		return comp;
	}

	public List<String> getLevel() {
		return level;
	}

	public int getMatricule() {
		return matricule;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public String getSexe() {
		System.out.println("Sexe get "+sexe);
		return sexe;
	}

	public String getDateembauche() {
		return dateembauche;
	}

	public String getDatedepart() {
		return datedepart;
	}

	public String getParticipeseminaire() {
		return participeseminaire;
	}

	public String getDateparticipeseminaire() {
		return dateparticipeseminaire;
	}

	public String getSalaireactuel() {
		return salaireactuel;
	}

	public String getPosttravail() {
		return posttravail;
	}

	public String getEmail() {
		return email;
	}

	public String getProfile() {
		return profile;
	}

	public String getUsername1() {
		return username1;
	}

	public String getPassword1() {
		return password1;
	}

	public String getConfirm_password1() {
		return confirm_password1;
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

	public void setDesctechno(List<String> desctechno) {
		this.desctechno = desctechno;
	}

	public void setComp(List<String> comp) {
		this.comp = comp;
	}

	public void setLevel(List<String> level) {
		this.level = level;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public void setSexe(String sexe) {
		System.out.println("Sexe set "+sexe);
		this.sexe = sexe;
	}

	public void setDateembauche(String dateembauche) {
		this.dateembauche = dateembauche;
	}

	
	public void setDatedepart(String datedepart) {
		this.datedepart = datedepart;
	}

	public void setParticipeseminaire(String participeseminaire) {
		/*if(participeseminaire == null) this.participeseminaire = "oui";
		else this.participeseminaire = "non";*/
		this.participeseminaire=participeseminaire;
	}

	public void setDateparticipeseminaire(String dateparticipeseminaire) {
		this.dateparticipeseminaire = dateparticipeseminaire;
	}

	public void setSalaireactuel(String salaireactuel) {
		this.salaireactuel = salaireactuel;
	}

	public void setPosttravail(String posttravail) {
		this.posttravail = posttravail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public void setConfirm_password1(String confirm_password1) {
		this.confirm_password1 = confirm_password1;
	}

	public String getMoisBAP() {
		return moisBAP;
	}

	public void setMoisBAP(String moisBAP) {
		this.moisBAP = moisBAP;
	}

	@Override
	public String toString() {
		return "this [ecole=" + ecole + ", niveau=" + niveau
				+ ", type_ecole=" + type_ecole + ", type_diplome="
				+ type_diplome + ", promotion=" + promotion + ", desctechno="
				+ desctechno + ", comp=" + comp + ", level=" + level
				+ ", matricule=" + matricule + ", nom=" + nom + ", prenom="
				+ prenom + ", abreviation=" + abreviation + ", sexe=" + sexe
				+ ", dateembauche=" + dateembauche + ", moisBAP=" + moisBAP
				+ ", datedepart=" + datedepart + ", participeseminaire="
				+ participeseminaire + ", dateparticipeseminaire="
				+ dateparticipeseminaire + ", salaireactuel=" + salaireactuel
				+ ", posttravail=" + posttravail + ", email=" + email
				+ ", profile=" + profile + ", username1=" + username1
				+ ", password1=" + password1 + ", confirm_password1="
				+ confirm_password1 +"]";
	}
	
	
}
