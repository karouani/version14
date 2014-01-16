package com.mql.strut.web.actions;

import java.util.Iterator;

import com.mql.strut.web.UTILS.ConnectionManager;
import com.mql.strut.web.actions.utils.IMAPFactory;
import com.mql.strut.web.models.BoiteEmail;
import com.opensymphony.xwork2.ModelDriven;

public class BoiteAction implements ModelDriven<BoiteEmail>{

	private ConnectionManager con;
	private BoiteEmail boite;
	private String menu;
	
	
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	//Constructeur
	public BoiteAction() {
		con = IMAPFactory.getConnexion();
	}
	
	//Methode Action
	public String execute(){
		if(con.init("ykarouani@gmail.com", "074549775", "imaps", "imap.gmail.com")){
			if(con.openMailBox("INBOX")){
				/*con.remplirEmail();
				Iterator<BoiteEmail> list = con.getList().iterator();
				while(list.hasNext()){
					BoiteEmail p = list.next();
					System.out.println(p.getDate());
				}*/
				System.out.println("*******************Unread***********************");
				System.out.println(con.getUnredEmail());
				boite = con.getUnredEmail();
			}
			con.close();
		}
		return "success";
	}
	//Recuperation
	public BoiteEmail getModel() {
		return boite;
	}

}
