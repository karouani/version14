package com.sqli.challange.sessions;

import javax.ejb.Remote;

import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.Site;

 
 

@Remote
public interface IRemote {

	public void addBU(BusinessUnite bs);
	public void addSite(Site st);
 
	public void addDiplome(Diplomes dip,long idtp,long idec);
	public long addCollaborateur(Collaborateurs col,long idbu,long idst);
	public void  activateMRH(long id);
	public long addManagerRH(ManagerRH col,long idbu,long idst);
}
