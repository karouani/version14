package com.sqli.challange.sessions;

import javax.ejb.Remote;

@Remote
public interface IAuthentificationRemote {

	public Object sauthentifier(String login,String pwd);
	//public  Object getUtilisateur();
	public  String getMsg();
	//new 14-17
	public String crypterMDF5(String pwd);
}
