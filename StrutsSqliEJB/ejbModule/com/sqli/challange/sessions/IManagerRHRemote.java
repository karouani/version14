package com.sqli.challange.sessions;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.ColCompTechno;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Competence;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.Site;
import com.sqli.challange.entity.Technologies;


@Remote
public interface IManagerRHRemote {
	public int editermonprofil(long id,Collaborateurs mng,List<String> ltechcomp,List<String> dips,String log,String pwd);
	public int editerprofilcollaborateur(long col,Collaborateur mng,List<String> ltechcomp,List<String> dips);
	public long organiserRitules(long idcol, long idmanagerRh, long idmanager);
	
	public List<Collaborateur> consultermescollaborateurs(long id);
	public ManagerRH consultermrh(long id);
	
	
	public Competence checkcomp(String comp);
	public Technologies checktechno(String tech);
	public ColCompTechno addColCompTechno(long col,long comp,long techno,String levl);
	public Diplomes addDiplomat(String titre, String promotion, String ecole,String typediplome, String typecole, String niveau,long idcol);
	public boolean checkLogin(String log);
	public boolean checkMatricuke(int mat);
	public void UpdateCollaborateurManagerRhAction(Long id, String nom,
			String prenom, String email, String abreviation, String sexe,
			Long site, Long bu, String participeseminaire,
			String dateparticipeseminaire , List<String> diplome , List<String> techno );
	public Collaborateur consultercolab(long id);
	
	public String crypterMDF5(String pwd);
	
	public void editerDiplomes(long idcol, List<String> ldips);
	public void supprimerDiplomes(long idcol, long iddip);
}
