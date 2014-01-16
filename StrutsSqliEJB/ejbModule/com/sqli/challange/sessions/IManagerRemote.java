package com.sqli.challange.sessions;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.ColCompTechno;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Competence;
import com.sqli.challange.entity.Compte;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.Rituls;
import com.sqli.challange.entity.Site;
import com.sqli.challange.entity.Technologies;


@Remote
public interface IManagerRemote {
	public boolean checkrhcol(long rh,long col);
	
	//Ajouter
	public List<Site> consulterAllSite();
	public List<BusinessUnite> consulterAllBu();
	///////////////
	public long organiserRitules(long idcol, long idmanagerRh, long idmanager);
	
	public int editermonprofil(long id,Collaborateurs mng,List<String> ltechcomp,List<String> dips,String log,String pwd);
	public int editermyprofile(long idadm, String nom, String prenom,String email, String sexe,String username,String password);
	public void ajouterManagerRH(Collaborateurs rh,List<String> ltechcomp,List<String> dips,long ibu,long ist,String log,String pwd,String prof);
	public void ajouterCollaborateur(Collaborateur col,List<String> ltechcomp,List<String> dips,long ibu,long ist,long idrh);
	public void editerCollaborateur(long idcol,String post,double sal,long idmanagerrh,String dt);
	public void activerMRHCols(long idmrh,List<Long> listcol);
	public void desactiverMRHCols(long idmrh,List<Long> listcol);
	
	public List<Collaborateur> consulterlistCollaborateur();
	public List<ManagerRH> consulterlistManagerRH();
	public Collaborateur consulterColab(long id);
	public List<Collaborateur> consulterlistCollabRH(long rh);
	public List<Collaborateur> consulterlistCollabNRH(long rh);
	
////****
	public Rituls consulterRituls(long id);
	
	public Competence checkcomp(String comp);
	public Technologies checktechno(String tech);
	public ColCompTechno addColCompTechno(long col,long comp,long techno,String levl);
	public Diplomes addDiplomat(String titre, String promotion, String ecole,String typediplome, String typecole, String niveau,long idcol);
	public boolean checkLogin(String log);
	public boolean checkMatricuke(int mat);
	
	public Compte ajouterCompte(long col,String log,String pwd,String profil);
	public void addsalhisto(long idcol,double nsal,String dt);
	public void affecterRhCol(long cl,long rh);
	public void deaffecterRhCol(long cl,long rh);
	public String parseDate(Date d);
	
	//Deux methodes pour recuperation Lists Diplome et Technologies
	public List<String> listDiplomes(long id);
	public List<String> listTechno(long id);
	
	public String MoisBap(String dt);
	public String Abrvis(String nom,String prenom);
	public long checkSite(String st);
	public long checkBu(String bu);
	public int CreerManagerFExcel(String mg);
	public int ajouterExcelManager(Collaborateurs col,String log,String pwd,String prof,long idbu,long idst);
	public List<String> SauvegarderManagerFromExcel(List<String> res);
	
	//collaborateur from excel
	public int CreerCollaborateurFExcel(String mg);
	public int ajouterExcelCollaborateur(Collaborateurs col,long idbu,long idst,long mgract);
	public List<String> SauvegarderCollaborateurFromExcel(List<String> res);
		//new 14-17
	public String crypterMDF5(String pwd);
	public int generateMax();
	
	//update 16
	public long getIdFMatricule(int mat);
	
	//web service
	public void ajouterManagerRHRS(int mat,String nm,String pr,String em,String abr,String sx,String dtem,String mb,String pd,String dtps,String pt,String sal,String ltechcomp,String dips,long ibu,long ist,String log,String pwd,String prof);
	public void ajouterCollaborateurRS(int mat,String nm,String pr,String em,String abr,String sx,String dtem,String mb,String pd,String dtps,String pt,String sal,String ltechcomp,String dips,long ibu,long ist,long idrh);
	public Collaborateur consulterColFromMat(int mat);
	public void ajouterCollaborateurDips(long col, String dip);
	public void ajouterCollaborateurTeCmp(long col, String dip);
	public List<String> consulterTechno();
	public List<String> consulterComp();
	public Collaborateurs consulterManagersFromMat(int mat);
	public List<String> consulterAllTechno();
	public List<String> consulterAllComp();
	public List<ManagerRH> consulterlistRhNon(long idcol);
}
