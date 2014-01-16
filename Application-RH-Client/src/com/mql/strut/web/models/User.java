package com.mql.strut.web.models;

public class User {
	
	private String login;
	private String password;
	private String name;
	private Long id;
	private String role;
	private String photo;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String login, String password, String name , Long id,String role) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.id =id;
		this.role = role;
	}


	public User(String login, String password, String name , Long id,String role,String photo) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.id =id;
		this.role = role;
		this.photo=photo;
	}
	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name="
				+ name + ", id = "+ id +", role = "+ role +"]";
	}
	
}
