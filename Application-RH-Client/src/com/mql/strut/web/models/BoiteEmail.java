package com.mql.strut.web.models;

public class BoiteEmail {

	private int id;
	private String from;
	private String subject;
	private String date;
	private String sender;
	private String message;
	
	public BoiteEmail() {
	}
	
	public BoiteEmail(int id, String from, String subject, String date,
			String sender, String message) {
		super();
		this.id = id;
		this.from = from;
		this.subject = subject;
		this.date = date;
		this.sender = sender;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BoiteEmail [id=" + id + ", from=" + from + ", subject="
				+ subject + ", date=" + date + ", sender=" + sender
				+ ", message=" + message + "]";
	}
	
}
