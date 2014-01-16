package com.mql.strut.web.actions.utils;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {


	public static String  mail(
			final String email,
			final String password,
			String recipient,
			String subject,
			String message,
			File attachFile){
		try {
			// sets SMTP server properties
			Properties properties = MailFactory.getProperties();
			properties.put("mail.user", email);
			properties.put("mail.password", password);

			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email, password);
				}
			};
			Session session = Session.getInstance(properties, auth);

			// creates a new e-mail message
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(email,"Ressources Humaines"));
			
			String[] v = recipient.split(",");
			InternetAddress[] toAddresses = new InternetAddress[v.length];
			for (int i = 0; i < v.length; i++) {
				toAddresses[i] = new InternetAddress(v[i]);
			}
			
			
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// adds attachments
			if (attachFile != null) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(attachFile);
				} catch (Exception ex) {
					return "error";
				}

				multipart.addBodyPart(attachPart);
			}

			// sets the multi-part as e-mail's content
			msg.setContent(multipart);

			// sends the e-mail
			Transport.send(msg);

			return "success";

		} catch (Exception e) {
			return "error";
		}
	}
}
