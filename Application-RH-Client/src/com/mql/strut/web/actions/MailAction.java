package com.mql.strut.web.actions;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;


import com.mql.strut.web.actions.utils.MailFactory;
import com.mql.strut.web.actions.utils.SendMail;
import com.mql.strut.web.models.Mail;
import com.opensymphony.xwork2.ModelDriven;

public class MailAction implements ModelDriven<Mail>{

	//Model ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private Mail mail;

	// file upload properties - fetched by interceptor fileUpload
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;

	//Constructor  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public MailAction() {
		mail = new Mail();
	}

	//Injection par filter +++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	//Methode d'action  +++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String execute(){
		
		File saveFile = null;
        String tempPath = System.getProperty("java.io.tmpdir");
        saveFile = new File(tempPath + File.separator + fileUploadFileName);
        try {
			FileUtils.copyFile(fileUpload, saveFile);
		} catch (Exception e) {
			saveFile = null;
			fileUpload = null;
		}
 
        String retour = SendMail.mail(
        		mail.getLogin(), 
        		mail.getPassword(), 
        		mail.getRecipient(), 
        		mail.getSubject(), 
        		mail.getMessage(), 
        		saveFile
        		);
        
        
        if (saveFile != null) {
            saveFile.delete();
        }
        
        return retour;
       
	}
	// RŽcuperation ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public Mail getModel() {
		// TODO Auto-generated method stub
		return mail;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

}
