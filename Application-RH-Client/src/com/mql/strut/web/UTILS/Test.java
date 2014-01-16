package com.mql.strut.web.UTILS;

import java.util.Iterator;

import com.mql.strut.web.models.BoiteEmail;

public class Test {

	private ConnectionManager con;
	public Test() {
		con = new ConnectionManager();
		exp01();
	}

	private void exp01() {
		if(con.init("ykarouani@gmail.com", "074549775", "imaps", "imap.gmail.com")){
			if(con.openMailBox("INBOX")){
				/*System.out.println("********************* Remplir Email !! **********************");
				con.remplirEmail();
				Iterator<BoiteEmail> list = con.getList().iterator();
				while(list.hasNext()){
					BoiteEmail p = list.next();
					System.out.println(p.getDate());
				}
				//System.out.println(">> "+con.nbMessageUnread());
				//System.out.println(con.getEmail(3).getMessage());
				*/
				//Hadi dawer dyalh recuperation de nombre messages jabti li 2695
				//Daba ghantester ch7al men message li mat9rach Kayn Wa7ed
				int n = con.nbMessage();
				System.out.println(n);
				//Daba nrecuperer Hadak message li fih dik djaja okii
				//kaynin 2 facebook o index 0
				System.out.println(con.getEmail(n-2));
				
				//System.out.println(con.getEmail(n-1));
				System.out.println(con.nbMessageUnread());
				
				//Baghi njarrab supprimer wach ghatsde9 hhh
				//Nsupprimer message dyal facebook hhhh 
				
				con.deleteMessage(n-1);
			}
			con.close();
		}
	}

	public static void main(String[] args) {
		new Test();
	}

}
