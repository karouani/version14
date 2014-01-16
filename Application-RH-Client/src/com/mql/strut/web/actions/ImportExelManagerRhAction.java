package com.mql.strut.web.actions;

public class ImportExelManagerRhAction {
	private String excel;

	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}
	
	public String execute() {
		return "success";
	}
}
