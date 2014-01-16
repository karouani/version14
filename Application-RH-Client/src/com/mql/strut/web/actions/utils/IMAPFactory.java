package com.mql.strut.web.actions.utils;

import java.util.Properties;

import com.mql.strut.web.UTILS.ConnectionManager;

public class IMAPFactory {

	private static ConnectionManager connexion;
	
	
	   static
	   {
		   connexion = new ConnectionManager();
	   }


	public static ConnectionManager getConnexion() {
		return connexion;
	}


}
