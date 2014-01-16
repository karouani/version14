package com.sqli.challange.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="heierarchie",discriminatorType=DiscriminatorType.STRING)
@XmlSeeAlso(value={ManagerRH.class,AmbassadeurRH.class,ManagerAgence.class,Administrateur.class,ResponsableProduction.class,Collaborateur.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Collaborateurs implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codecol;
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
	private double salaireactuel;
	private String posttravail;
	private String email;
	
	
	//relation entre les autres class
	
	@ManyToOne
	@JoinColumn(name="codebu")
	private BusinessUnite bu;
	
	@ManyToOne
	@JoinColumn(name="codest")
	private Site site;
	
	 

	
	/*@ManyToMany
	@JoinTable(name="col_deps",joinColumns=@JoinColumn(name="codecol"),inverseJoinColumns=@JoinColumn(name="codedip"))
	@XmlTransient
	private List<Diplomes> diplome;*/
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codecompte")
	private Compte cmp;
	
	@OneToMany(mappedBy="colab",cascade=CascadeType.ALL)
	@XmlTransient
	private List<HistoriqueSalPostTravail> historiquesal=new ArrayList<>();
	
	@ManyToMany(mappedBy="colab",cascade=CascadeType.ALL)
	@XmlTransient
	private List<ColCompTechno> comptechno=new ArrayList<>();
	
	@OneToMany(mappedBy="col",cascade=CascadeType.ALL)
	@XmlTransient
	private List<Rituls> rituls=new ArrayList<>();
	
	//updating 15 -01
		@OneToMany(mappedBy="col",cascade=CascadeType.ALL)
		@XmlTransient
		private List<Diplomes> ldips=new ArrayList<Diplomes>();
		
	
	public Collaborateurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Collaborateurs(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire, String dateparticipeseminaire,
			double salaireactuel, String posttravail) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.abreviation = abreviation;
		this.sexe = sexe;
		this.dateembauche = dateembauche;
		this.moisBAP = moisBAP;
		this.participeseminaire = participeseminaire;
		this.dateparticipeseminaire = dateparticipeseminaire;
		this.salaireactuel = salaireactuel;
		this.posttravail = posttravail;
	}



	public Collaborateurs(int matricule, String nom, String prenom,
			String abreviation, String sexe, String dateembauche, String moisBAP,
			String participeseminaire,
			String dateparticipeseminaire, double salaireactuel,
			String posttravail, String email) {
		super();
		
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.abreviation = abreviation;
		this.sexe = sexe;
		this.dateembauche = dateembauche;
		this.moisBAP = moisBAP;
		this.participeseminaire = participeseminaire;
		this.dateparticipeseminaire = dateparticipeseminaire;
		this.salaireactuel = salaireactuel;
		this.posttravail = posttravail;
		this.email = email;
	}



	public long getCodecol() {
		return codecol;
	}

	public void setCodecol(long codecol) {
		this.codecol = codecol;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDateembauche() {
		return dateembauche;
	}

	public void setDateembauche(String dateembauche) {
		this.dateembauche = dateembauche;
	}

	public String getMoisBAP() {
		return moisBAP;
	}

	public void setMoisBAP(String moisBAP) {
		this.moisBAP = moisBAP;
	}

	public String getDatedepart() {
		return datedepart;
	}

	public void setDatedepart(String datedepart) {
		this.datedepart = datedepart;
	}

	public String isParticipeseminaire() {
		return participeseminaire;
	}

	public void setParticipeseminaire(String participeseminaire) {
		this.participeseminaire = participeseminaire;
	}

	public String getDateparticipeseminaire() {
		return dateparticipeseminaire;
	}

	public void setDateparticipeseminaire(String dateparticipeseminaire) {
		this.dateparticipeseminaire = dateparticipeseminaire;
	}

	public double getSalaireactuel() {
		return salaireactuel;
	}

	public void setSalaireactuel(double salaireactuel) {
		this.salaireactuel = salaireactuel;
	}

	 

	public String getPosttravail() {
		return posttravail;
	}

	public void setPosttravail(String posttravail) {
		this.posttravail = posttravail;
	}

	public BusinessUnite getBu() {
		return bu;
	}

	public void setBu(BusinessUnite bu) {
		this.bu = bu;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	/*@JsonIgnore
	public List<Diplomes> getDiplome() {
		return diplome;
	}

	public void setDiplome(List<Diplomes> diplome) {
		this.diplome = diplome;
	}*/

	public Compte getProfil() {
		return cmp;
	}

	public void setProfil(Compte cmp) {
		this.cmp = cmp;
	}

	@JsonIgnore
	public List<HistoriqueSalPostTravail> getHistoriquesal() {
		return historiquesal;
	}

	public void setHistoriquesal(List<HistoriqueSalPostTravail> historiquesal) {
		this.historiquesal = historiquesal;
	}

	@JsonIgnore
	public List<ColCompTechno> getComptechno() {
		return comptechno;
	}

	public void setComptechno(List<ColCompTechno> comptechno) {
		this.comptechno = comptechno;
	}

	@JsonIgnore
	public List<Rituls> getRituls() {
		return rituls;
	}

	public void setRituls(List<Rituls> rituls) {
		this.rituls = rituls;
	}



	public int getMatricule() {
		return matricule;
	}



	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}


	@JsonIgnore
	public List<Diplomes> getLdips() {
		return ldips;
	}



	public void setLdips(List<Diplomes> cldp) {
		this.ldips = cldp;
	}



	public String getParticipeseminaire() {
		return participeseminaire;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Collaborateurs [codecol=" + codecol + ", matricule="
				+ matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", abreviation=" + abreviation + ", sexe=" + sexe
				+ ", dateembauche=" + dateembauche + ", moisBAP=" + moisBAP
				+ ", datedepart=" + datedepart + ", participeseminaire="
				+ participeseminaire + ", dateparticipeseminaire="
				+ dateparticipeseminaire + ", salaireactuel=" + salaireactuel
				+ ", posttravail=" + posttravail + ", email=" + email + ", bu="
				+ bu + ", site=" + site + ", cmp=" + cmp + ", historiquesal="
				+ historiquesal + ", comptechno=" + comptechno + ", rituls="
				+ rituls + ", cldp=" + ldips + "]";
	}

}
