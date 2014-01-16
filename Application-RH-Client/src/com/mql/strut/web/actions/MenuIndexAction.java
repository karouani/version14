package com.mql.strut.web.actions;

public class MenuIndexAction {

	private String index;

	public String getIndex() {
		return index;
	}
	
	public String execute() {
		if("Administrateur".equals(index)){
			index = "admin";
			return "admin";
		}else if("ManagerRH".equals(index)){
			index = "managerRh";
			return "managerRh";
		}else{
			index = "manager";
			return "manager";
		}
	}

	public void setIndex(String index) {
		this.index = index;
	}

	
}
