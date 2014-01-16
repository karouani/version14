package com.mql.strut.web.models;

import java.io.File;

public class Mail {
	
	private String login;
	private String password;
	private String recipient;
    private String subject;
    private String message;
    
	public Mail() {
		super();
	}

	public Mail(String login, String password, String recipient,
			String subject, String message) {
		super();
		this.login = login;
		this.password = password;
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
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

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	@Override
	public String toString() {
		return "Mail [login=" + login + ", password=" + password
				+ ", recipient=" + recipient + ", subject=" + subject
				+ ", message=" + message + "]";
	}

}
