package com.mql.strut.web.actions;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public class logoutAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	
	
	public String execute(){ 
		session.remove("user"); 
		return SUCCESS;
    }


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}