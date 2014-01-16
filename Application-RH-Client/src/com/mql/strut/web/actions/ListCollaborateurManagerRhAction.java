package com.mql.strut.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.struts2.interceptor.SessionAware;

import com.mql.strut.web.models.User;
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.sessions.IManagerRHRemote;

@Stateless
public class ListCollaborateurManagerRhAction implements SessionAware {

	private String menu;
	private Map<String, Object> session;
	private User userSession;
	private List<Collaborateur> colab;
	private String index;
	private String message;
	
	@EJB
	private IManagerRHRemote managerRh;
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
	public void setMessage(String message) {
		this.message = message;
	}



	public String execute() {
		menu = "listCol";
		colab = new ArrayList<>();
		index = "yes";
		userSession = (User) session.get("user");		
		colab = managerRh.consultermescollaborateurs(userSession.getId());		
		return "success";
	}
	
	public List<Collaborateur> getColab() {
		return colab;
	}

	public String getMenu() {
		return menu;
	}
	
	public String getIndex() {
		return index;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	
}
