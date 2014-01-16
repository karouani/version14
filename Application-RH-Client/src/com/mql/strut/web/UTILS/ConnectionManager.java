package com.mql.strut.web.UTILS;

import javax.mail.*;

import java.util.*;

import javax.mail.Flags.Flag;
import java.io.IOException;
import javax.mail.internet.InternetAddress;

import org.apache.struts2.views.xslt.ArrayAdapter;

import com.mql.strut.web.models.BoiteEmail;

public class ConnectionManager {

	private String myLogin;
	private String myPassword;
	private String myProtocole;
	private String myHost;
	private int myPort;
	private Session mySession;
	private Store myStore;
	private Folder myFolder;
	private Message[] myMailBox;
	private BodyPart body;
	private BoiteEmail boite;
	private List<BoiteEmail> list;
	private Object content;

	public ConnectionManager() {
		System.out.println("instanciation BoiteEmail()");
		boite = new BoiteEmail();
		list = new ArrayList<>();
		content = new Object();
	}

	/* ----------------- initialisation de la connection  ---------------*/
	public boolean init(String login, String password, String protocole,
			String host) 
	{
		myLogin = login;
		myPassword = password;
		myProtocole = protocole;
		myHost= host;

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", myProtocole);


		// crŽation d'une session
		mySession = Session.getDefaultInstance(props,null);
		//mySession.setDebug(false);

		//crŽation d'un objet d'enregistrement de message

		try
		{
			myStore = mySession.getStore(myProtocole);
			// DEBUG
			System.out.println("store ok !");
		}
		catch (NoSuchProviderException e)
		{
			// DEBUG
			System.out.println("store pas ok !");
			return false;
		}

		// Connection
		try
		{
			System.out.println("dŽbut conncetion");
			myStore.connect(myHost, myLogin, myPassword);
			System.out.println("connexion ok !");
		}
		catch ( MessagingException e)
		{
			System.out.println("connexion pas ok !");
			return false;
		}
		return true;
	}


	/* -----------------------fermeture de la session ---------*/
	/*-----------------------close ----------------------------*/
	public boolean close()
	{

		try
		{
			// fermeture du store
			myFolder.expunge();
			myStore.close();

		}
		catch (MessagingException e)
		{
			return false;
		}

		return true;
	}

	/*--------------------- ouverture d'un rŽpertoire---------------*/
	/* ---------------------- openMailBox --------------------------*/
	public boolean openMailBox(String mailbox)
	{
		// ouverture du rŽpertoire courant INBOX
		myFolder = null;
		try
		{
			myFolder = myStore.getDefaultFolder();

			if(myFolder == null)
			{
				System.out.println("Pas de boite aux lettres par dŽfaut");
				return false;
			}

			// par dŽfaut on rŽcupre les messages dans INBOX
			myFolder = myFolder.getFolder(mailbox);
			if (myFolder == null)
			{
				System.out.println("pas de inbox");
			}

			try
			{
				myFolder.open(Folder.READ_WRITE);
				System.out.println("ficher " + myFolder.getName() + " ouvert");
			}
			catch (MessagingException e)
			{
				System.err.println("[process_folder]: cannot open folder " + myFolder +
						": " + e.getMessage());
				e.printStackTrace();
			}

		}
		catch (MessagingException e)
		{

			return false;
		}

		try
		{
			myMailBox = new Message[myFolder.getMessageCount()];
			myMailBox = myFolder.getMessages();
		}
		catch( MessagingException e ){}

		return true;
	}

	//retourne le nombre de message contenu dans la boite
	public int nbMessage()
	{
		int totalMessages;
		try
		{
			totalMessages = myFolder.getMessageCount();
		}
		catch( MessagingException e )
		{
			return -1;
		}
		return totalMessages;
	}

	/* ----------------- retourne le nombre de message non lu -----------------*/
	public int nbMessageUnread()
	{
		int nbMessage;
		try
		{
			nbMessage = myFolder.getUnreadMessageCount();
		}
		catch (MessagingException e)
		{
			return -1;
		}
		return nbMessage;
	}

	/* ----------------- retourne le nombre de nouveau message  -----------------*/
	public int nbNewMessage()
	{
		int nbMessage;
		try
		{
			nbMessage = myFolder.getNewMessageCount();
		}
		catch (MessagingException e)
		{
			return -1;
		}
		return nbMessage;
	}

	/*--------------------- retourne le nombre de message non lu ---------------*/
	public int nbMessageRead()
	{
		return (nbMessage()-nbMessageUnread());
	}

	/*--------------------- retourne le nombre d'ancien message  ---------------*/
	public int nbOldMessage()
	{
		return (nbMessage()-nbNewMessage());
	}


	/*------------------------efface le message num ---------------------------*/
	/* ---------------------DeleteMessage--------------------------------------*/
	public boolean deleteMessage(int num)
	{
		try
		{
			myMailBox[num].setFlag(Flags.Flag.DELETED,true);
			return true;
		}
		catch (MessagingException e)
		{
			return false;
		}
	}


	/*------------------------retourner le sujet du message num ---------------------------*/
	/* ---------------------getSubject--------------------------------------*/

	public String getSubject(int num)
	{

		try
		{
			return myMailBox[num].getSubject();
		}
		catch(MessagingException e)
		{
			return null;
		}
	}



	/*-------------- retourner l'adresse du message num --------------------*/
	/* ---------------------GetAdresse--------------------------------------*/

	public String getAdresse(int num)
	{
		Address[] myAdresse;
		InternetAddress myAdr;

		try
		{
			myAdresse = myMailBox[num].getFrom();
			myAdr = new InternetAddress(myAdresse[0].toString());
			return myAdr.getPersonal();
		}
		catch(MessagingException e)
		{
			return null;
		}
	}

	/*------------------ retourner le sujet du message num -----------------*/
	/* ---------------------getSubject--------------------------------------*/

	public String getDate(int num)
	{
		GregorianCalendar myCalendar = new GregorianCalendar();
		String myDate = new String();
		String temp = new String();

		try
		{
			myCalendar.setTime(myMailBox[num].getReceivedDate());

			switch (myCalendar.get(myCalendar.DAY_OF_WEEK))
			{
			case Calendar.SUNDAY:    temp = "dimanche "; break;
			case Calendar.MONDAY:    temp = "lundi "; break;
			case Calendar.TUESDAY:   temp = "mardi "; break;
			case Calendar.WEDNESDAY: temp = "mercredi "; break;
			case Calendar.THURSDAY:  temp = "jeudi "; break;
			case Calendar.FRIDAY:    temp = "vendredi "; break;
			case Calendar.SATURDAY:  temp = "samedi "; break;
			}
			myDate = temp;

			Integer i = new Integer(myCalendar.get(myCalendar.DATE));
			myDate += i.toString();

			switch (myCalendar.get(myCalendar.MONTH))
			{
			case 0:   temp = " janvier"; break;
			case 1:   temp = " fŽvrier"; break;
			case 2:   temp = " mars"; break;
			case 3:   temp = " avril"; break;
			case 4:   temp = " mai"; break;
			case 5:   temp = " juin"; break;
			case 6:   temp = " juillet"; break;
			case 7:   temp = " aožt"; break;
			case 8:   temp = " septembre"; break;
			case 9:   temp = " octobre"; break;
			case 10:  temp = " novembre"; break;
			case 11:  temp = " dŽcembre"; break;
			}
			myDate += temp;

			return myDate;
		}
		catch(MessagingException e)
		{
			return null;
		}
	}

	/*------------------ retourner le text du message num -----------------*/

	public String getText(int num)
	{
		try
		{
			content = myMailBox[num].getContent();


			if (content instanceof Multipart){
				return typeMime(myMailBox[num]).getContent().toString();
			}else{
				return myMailBox[num].getContent().toString();
			}
		}
		catch(MessagingException e)
		{
			return null;
		}

		catch(IOException io)
		{
			return null;
		}
	}

	/*----------------------Get unread Message-------------------------------------*/

	public BoiteEmail getUnredEmail(){
		
		if(nbMessageUnread() > 0){

			int num = nbMessage()-1;
			try
			{
				content = myMailBox[num].getContent();

				boite.setDate(myMailBox[num].getReceivedDate().toString());
				boite.setFrom(myMailBox[num].getFrom()[0].toString());
				boite.setId(num);
				boite.setSender(myMailBox[num].getAllRecipients()[0].toString());
				boite.setSubject(myMailBox[num].getSubject().toString());

				if (content instanceof Multipart){
					boite.setMessage(typeMime(myMailBox[num]).getContent().toString());
				}else{
					boite.setMessage(myMailBox[num].getContent().toString());
				}
				
			}
			catch(MessagingException e)
			{
				return null;
			}

			catch(IOException io)
			{
				return null;
			}
		}
		return boite;

	}

	/* ---------------------getEmailComplete--------------------------------------*/


	public BoiteEmail getEmail(int num)
	{
		try
		{
			content = myMailBox[num].getContent();

			boite.setDate(myMailBox[num].getReceivedDate().toString());
			boite.setFrom(myMailBox[num].getFrom()[0].toString());
			boite.setId(num);
			boite.setSender(myMailBox[num].getAllRecipients()[0].toString());
			boite.setSubject(myMailBox[num].getSubject().toString());

			if (content instanceof Multipart){
				boite.setMessage(typeMime(myMailBox[num]).getContent().toString());
			}else{
				boite.setMessage(myMailBox[num].getContent().toString());
			}
			return boite;
		}
		catch(MessagingException e)
		{
			return null;
		}

		catch(IOException io)
		{
			return null;
		}
	}


	/*--------retourne si le messages est nouveau ou non-------*/
	/* ---------------------isNew--------------------------------------*/
	public boolean isNew(int num)
	{
		try
		{
			return myMailBox[num].isSet(Flag.RECENT);
		}
		catch(MessagingException e)
		{
			return false;
		}
	}

	/*--------retourne si le messages est lu ou non-------*/
	/* ---------------------isRead--------------------------------------*/
	public boolean isRead(int num)
	{
		try
		{
			return myMailBox[num].isSet(Flag.SEEN);
		}
		catch(MessagingException e)
		{
			return false;
		}
	}
	/*------------- Test Sur Le type de Conteny d'email--------*/
	public BodyPart typeMime(Message msg){
		try{
			Multipart mpart = (Multipart) msg.getContent();
			//System.out.println("Le messages est  :\n\n");
			int lim = mpart.getCount();
			for(int j = 0; j < lim; j++) {
				body = mpart.getBodyPart(j);
			}
		}catch(Exception e){}
		return body;
	}

	public List<BoiteEmail> getList(){
		return list;
	}

	public void remplirEmail(){
		for (int i= 0; i < 10; i++) 
		{
			Message msg =  myMailBox[i];

			try {
				content = msg.getContent();

				int id         = msg.getMessageNumber();
				String date    = ""+msg.getReceivedDate();
				String subject = msg.getSubject();
				String from    = ""+msg.getFrom()[0];
				String to      = ""+msg.getAllRecipients()[0];
				String message;

				if (content instanceof Multipart){
					message = typeMime(myMailBox[i]).getContent().toString();
				}else{
					message = myMailBox[i].getContent().toString();
				}

				list.add(new BoiteEmail(id, from, subject, date, to, message));

			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}