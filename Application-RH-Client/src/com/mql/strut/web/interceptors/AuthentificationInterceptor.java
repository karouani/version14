package com.mql.strut.web.interceptors;


import java.util.Map;

import javax.ejb.EJB;

import com.mql.strut.web.actions.LoginAction;
import com.mql.strut.web.actions.TestAction;
import com.mql.strut.web.models.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sqli.challange.sessions.IAuthentificationLocal;

public class AuthentificationInterceptor extends AbstractInterceptor{


	public String intercept(ActionInvocation inv) throws Exception {

		Map<String, Object> session = inv.getInvocationContext().getSession();
		User user = (User) session.get("user");

		if( inv.getAction() instanceof LoginAction){
			return inv.invoke();
		}else{
			if(user == null){
				return ActionSupport.LOGIN;
			}
			return inv.invoke();
		}

	}

}
