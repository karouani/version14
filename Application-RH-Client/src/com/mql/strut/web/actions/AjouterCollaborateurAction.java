package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.struts2.interceptor.SessionAware;

import com.mql.strut.web.actions.utils.SendMail;
import com.mql.strut.web.models.CollaborateurModel;
import com.mql.strut.web.models.Gmail;
import com.mql.strut.web.models.Manager;
import com.mql.strut.web.models.User;
import com.opensymphony.xwork2.ModelDriven;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Rituls;
import com.sqli.challange.sessions.IManagerRemote;

@Stateless
public class AjouterCollaborateurAction implements ModelDriven<CollaborateurModel>, SessionAware{
	
	private String messageCollaborateur;
	private String menu;
	
	private CollaborateurModel colab;
	
	private Collaborateur col;

	private Long bu;
	private Long site;
	private List<String> techno;
	private List<String> diplome;
	private Long manageractuel;
	
	private String emailGmail;
	private String pass;
	private Long idManager;
	
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@EJB
	private IManagerRemote manager;
	
	public AjouterCollaborateurAction() {
		colab = new CollaborateurModel();
	}
	//Injection
	public void setMenu(String type) {
		this.menu = type;
	}
	
	public Long getIdManager() {
		return idManager;
	}
	public void setEmailGmail(String email) {
		this.emailGmail = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setMessageCollaborateur(String messageCollaborateur) {
		this.messageCollaborateur = messageCollaborateur;
	}
	public void setCol(Collaborateur col) {
		this.col = col;
	}
	public void setBu(Long bu) {
		this.bu = bu;
	}
	public void setSite(Long site) {
		this.site = site;
	}
	public void setManageractuel(Long manageractuel) {
		this.manageractuel = manageractuel;
	}
	public void setTechno(List<String> techno) {
		this.techno = techno;
	}
	public void setDiplome(List<String> diplome) {
		this.diplome = diplome;
	}
	
	//Methode d'injection des listes
	public void remplirTechno() {
		techno = new ArrayList<>();
		for (int i = 0; i < colab.getLevel().size(); i++) {
			techno.add(colab.getDesctechno().get(i)+","+colab.getComp().get(i)+","+colab.getLevel().get(i));
		}
	}

	public void remplirDiplome() {
		diplome = new ArrayList<>();
		for (int i = 0; i < colab.getEcole().size(); i++) {
			diplome.add(colab.getEcole().get(i)+","+
					colab.getPromotion().get(i)+","+
					colab.getEcole().get(i)+","+
					colab.getType_diplome().get(i)+","+
					colab.getType_ecole().get(i)+","+
					colab.getNiveau().get(i));

		}
	}

	//Methode d'action
	public String execute(){
		this.remplirTechno();
		this.remplirDiplome();
		
		Gmail gmailSession = (Gmail) session.get("gmail");
		if(gmailSession == null){
			Gmail gm = new Gmail(emailGmail, pass);
			session.put("gmail", gm);
		}
		col = new Collaborateur(colab.getMatricule(), 
								colab.getNom(), 
								colab.getPrenom(), 
								colab.getAbreviation(), 
								colab.getSexe(), 
								colab.getDateembauche(), 
								colab.getMoisBAP(), 
								colab.getParticipeseminaire(), 
								colab.getDateparticipeseminaire(), 
								colab.getSalaireactuel(), 
								colab.getPosttravail(), 
								colab.getEmail());
		
		
	
			long idcol;
			//idcol= manager.ajouterCollaborateur(col, techno, diplome, bu, site, manageractuel);
			//System.out.println(">>>>>>>>>>>>>>>>  get code apres l'ajouterCollaborateur() "+col.getCodecol());
			
			Long idrt = manager.organiserRitules(
									idcol, 
									col.getManageractuel().getCodecol(), 
									idManager
									);
			//String recipiant = col.getEmail()+","+col.getManageractuel().getEmail();
			
			Rituls r = manager.consulterRituls(idrt);
			
			String sujet1 = r.getDescrt().split(",")[0];
			String sujet2 = r.getDescrt().split(",")[1];
			String sujet3 = r.getDescrt().split(",")[2];
			
			String message1 = r.getMessage().split(",")[0];
			String message2 = r.getMessage().split(",")[1];
			String message3 = r.getMessage().split(",")[2];
			
			String emailMan = null ;
			for (int i = 0; i < manager.consulterlistCollaborateur().size(); i++) {
				if(this.idManager.equals(manager.consulterlistCollaborateur().get(i).getCodecol()))
					emailMan = manager.consulterlistCollaborateur().get(i).getEmail();
			}
			
			SendMail.mail(this.emailGmail, this.pass,col.getManageractuel().getEmail(),sujet1, message1, null);
			SendMail.mail(this.emailGmail, this.pass, emailMan,sujet2, message2, null);
			SendMail.mail(this.emailGmail, this.pass, col.getEmail(),sujet3, message3, null);
			*/
			messageCollaborateur = "Collaborateur ajoutŽ avec success !!";
			menu = "nouveauCollaborateur";
			
		    return "success";
	}
	
	public CollaborateurModel getModel() {
		return colab;
	}
	public String getMessageCollaborateur() {
		return messageCollaborateur;
	}
	public Collaborateur getCol() {
		return col;
	}
	public Long getBu() {
		return bu;
	}
	public Long getSite() {
		return site;
	}
	public Long getManageractuel() {
		return manageractuel;
	}
	public List<String> getTechno() {
		return techno;
	}
	public List<String> getDiplome() {
		return diplome;
	}

	public String getMenu() {
		return menu;
	}

}
