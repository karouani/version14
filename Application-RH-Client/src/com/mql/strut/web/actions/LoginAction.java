package com.mql.strut.web.actions;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.struts2.interceptor.SessionAware;


import com.mql.strut.web.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.sessions.IAdminRemote;
import com.sqli.challange.sessions.IAuthentificationRemote;

@Stateless(name="login")
public class LoginAction extends ActionSupport implements SessionAware {

	private String login;
	private String password;
	private String message;
	private String retour;
	private String name;
	private Long id;
	private String role;
	private String photo;
	
	private Map<String, Object> session;

	private Object obj;
	private User u;
	private User user;

	@EJB
	private IAuthentificationRemote remote;

	public LoginAction() {
		u = new User();
	}

	/*********************Injection****************************/
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setLogin(String login) {
		u.setLogin(login);
	}

	public void setPhoto(String photo) {
		u.setPhoto(photo);
	}
	public void setPassword(String pwd) {
		u.setPassword(pwd);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(Long id) {
		u.setId(id);
	}

	public void setRole(String role) {
		u.setRole(role);
	}

	public void setName(String name) {
		u.setName(name);
	}


	/********************* Methode D'action****************************/
	public String execute(){

		User userSession = (User) session.get("user");
		String action;
		if (userSession != null) {
			action = isIdentifier(userSession.getLogin(), userSession.getPassword());
			return action;
		}else{
			//System.out.println("Pour Enregistrer Session");
			this.setMessage(remote.getMsg());
			action = isIdentifier(u.getLogin(), u.getPassword());
			if(!"error".equals(action)){
				session.put("user",u);
				//System.out.println("Get Message Action  "+remote.getMsg());
				return action;
			}
			else {
				this.setMessage(remote.getMsg());
				return action;
			}
		}
	}

	//Methode de Verification
	public String isIdentifier(String login, String password) {
		if(login != null && password != null){
			
			obj=remote.sauthentifier(login, password);
			if(obj != null ){
				if(obj instanceof Administrateur){

					this.setName(((Administrateur) obj).getNom());
					this.setRole(((Administrateur) obj).getCmp().getRole());
					this.setId(((Administrateur) obj).getIdadm());
					this.setPhoto(((Administrateur) obj).getPhoto());
					
					user = new User(u.getLogin(), u.getPassword(),name ,id ,role,photo);
					retour = "admin";
				}else if(obj instanceof ManagerRH){

					this.setName(((ManagerRH) obj).getNom());
					this.setRole(((ManagerRH) obj).getProfil().getRole());
					this.setId(((ManagerRH) obj).getCodecol());
					user = new User(u.getLogin(), u.getPassword(),name ,id,role);
					retour = "managerRh";
				} else if(obj instanceof ManagerAgence){

					this.setName(((ManagerAgence) obj).getNom());
					this.setId(((ManagerAgence) obj).getCodecol());
					this.setRole(((ManagerAgence) obj).getProfil().getRole());

					user = new User(u.getLogin(), u.getPassword(),name,id,role);
					retour = "manager";
				} else if(obj instanceof AmbassadeurRH){

					this.setName(((AmbassadeurRH) obj).getNom());
					this.setId(((AmbassadeurRH) obj).getCodecol());
					this.setRole(((AmbassadeurRH) obj).getProfil().getRole());

					user = new User(u.getLogin(), u.getPassword(),name,id,role);

					retour = "manager";
				} else if(obj instanceof ResponsableProduction){

					this.setName(((ResponsableProduction) obj).getNom());
					this.setRole(((ResponsableProduction) obj).getProfil().getRole());
					this.setId(((ResponsableProduction) obj).getCodecol());

					user = new User(u.getLogin(), u.getPassword(),name,id,role);
					retour = "manager";
				} 
			}
			else{
				retour = "error";
			}

		}else{
			retour = "error";
		}
		
		return retour;
	}

	//Methode de Recuperation

	public String getMessage() {
		System.out.println("Get Message()  "+message);
		return message;
	}

	public User getU() {
		return u;
	}

}
