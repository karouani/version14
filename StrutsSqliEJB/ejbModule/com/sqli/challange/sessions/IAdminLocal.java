package com.sqli.challange.sessions;

import java.util.List;

import javax.ejb.Local;

import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.ColCompTechno;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Competence;
import com.sqli.challange.entity.Compte;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.Site;
import com.sqli.challange.entity.Technologies;


@Local
public interface IAdminLocal {

	public boolean editermonprofil(long id,Administrateur adm);
	public void ajouteradministrateur(Administrateur admin,String log,String pwd,String role);
	public void desactivercompteadmin(long id);
	
	public int ajoutermanager(Collaborateurs manager,List<String> ltechcomp,List<String> dips,long ibu,long ist,String log,String pwd,String prof);
	public Compte ajoutercompteadmin(long id,String log,String pwd,String role);
	public Compte ajoutercomptemanager(long id,String log,String pwd,String role);
	public BusinessUnite ajouterBus(String desp);
	public Site ajouterSite(String st);
	
	public List<Collaborateurs> consulterAllCollaborateurrsManager();
	public List<Collaborateurs> consulterAllCollaborateurrsManagerRH();
	public Collaborateurs consulterCollaborateurs(long id);
	public List<Administrateur> consulterAllAdmin();
	public Administrateur consulterAdmin(long id);
	public List<Site> consulterAllSite();
	public List<BusinessUnite> consulterAllBu();
	
	public boolean checkLogin(String log);
	public boolean checkMatricuke(int mat);
	
	public Competence checkcomp(String comp);
	public Technologies checktechno(String tech);
	public ColCompTechno addColCompTechno(long col,long comp,long techno,String levl);
	
	//public void colabDiplomes(long cl,long dp);
	//public Diplomes addDiplomat(String titre, String promotion, String ecole,String typediplome, String typecole, String niveau);
	public Compte ajouterCompte(long col,String log,String pwd,String profil);
	
	public int supprimerCol(long id);
	public int editerManager(long id,Collaborateurs mng,List<String> ltechcomp,List<String> dips,long ibu,long ist,String log,String pwd,String prof);
	public void addsalhisto(long idcol,double nsal,String dt);
	
	public List<String> listDiplomes(long id);
	//editer 1555555555
	public List<String> listTechno(long id);
	
	public String MoisBap(String dt);
	public String Abrvis(String nom,String prenom);
	public long checkSite(String st);
	public long checkBu(String bu);
	public int CreerManagerFExcel(String mg);
	public int ajouterExcelManager(Collaborateurs col,String log,String pwd,String prof,long idbu,long idst);
	public List<String> SauvegarderManagerFromExcel(List<String> res);
		//new 14-17
	public String crypterMDF5(String pwd);
	public int generateMax();
	
	//15
	public void editerDiplomes(long idcol,List<String> ldips);
	public void supprimerDiplomes(long idcol,long iddip);
	public Diplomes addDiplomat(String titre, String promotion, String ecole,String typediplome, String typecole, String niveau,long idcol);

	
	//voila new mise a jour pour editer manager appliquer sur les autres (manager)
	public String ConsulterTechnCompCol(long idcol,long idtcc);
	public boolean UpdateTechnCompCol(long idcol,long idtcc,String st);
	public void MiseajourTechnoCompCol(long idcol,List<String> ltecactuel,List<String> ltecnew);
	
}
