package com.sqli.challange.sessions;

import javax.ejb.Local;

import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.Site;


 

@Local
public interface ILocal {

	public void addBU(BusinessUnite bs);
	public void addSite(Site st);
	public void addDiplome(Diplomes dip,long idtp,long idec);
	public long addCollaborateur(Collaborateurs col,long idbu,long idst);
	public long addManagerRH(ManagerRH col,long idbu,long idst);
	
	
	
	public void editermonprofil(long id,String un,String pwd,String eml,String phot,String sexe,String decp);
	public void ajouteradministrateur(String un,String pwd,String eml,String phot,String sexe,String decp);
	public void desactivercompteadmin(long id);
	
	public void ajoutermanager(String matrc,String nm,String pr,String abv,
								String site,String bu,String dtemb,String bap,String prsim,
								String dtsim,String pact,String sal,String profil,String login,
								String pwd,String[] nmdip,String[] niv,String[] tpd,String[] tpec,
								String[] promo,String[] techno,String[] tecomp,String[] tclev,String sexe
								);
	
}
