package com.mql.strut.web.models;

public class Gmail {
	private String login;
	private String password;
	public Gmail(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public Gmail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Gmail [login=" + login + ", password=" + password + "]";
	}
	
	
}
