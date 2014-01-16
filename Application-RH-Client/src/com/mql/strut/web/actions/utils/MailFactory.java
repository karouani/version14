package com.mql.strut.web.actions.utils;

import java.util.Properties;


public class MailFactory {

	private static Properties properties = new Properties();
	
	
	   static
	   {
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }


	public static Properties getProperties() {
		return properties;
	}
}
