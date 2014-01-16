package com.mql.strut.web.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mql.strut.web.UTILS.StrinCreerExcel;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.sessions.IAdminRemote;

@Stateless
public class ExportExcelAdminAction {


	private String index = "";

	private InputStream inputStream;
	private String fileName;
	private double fileSize;

	@EJB
	private IAdminRemote admin;

	private StrinCreerExcel home;

	public String execute() {
		Map<String, String[]> data = new TreeMap<String, String[]>();

		String[] titres ={
				"Matricule",
				"Nom",
				"Prenom",
				"Date embauche",
				"Participe siminaire",
				"Date Participation",
				"Email",
				"Post Travail",
				"Salaire",
				"Sexe",
				"Business Unite",
				"Site",
				"Profil"
				};

		int x= (int) (Math.random()*99999);

		for (Collaborateurs col:admin.consulterAllCollaborateurrsManager()) {
			String[] val={  ""+col.getMatricule(),
					col.getNom(),
					col.getPrenom(),
					col.getDateembauche(),
					col.getParticipeseminaire(),
					col.getDateparticipeseminaire(),
					col.getEmail(),
					col.getPosttravail(),
					""+col.getSalaireactuel(),
					col.getSexe(),
					col.getBu().getDescbu(),
					col.getSite().getDescsite(),
					col.getClass().getSimpleName()};
			data.put(""+col.getCodecol(),val);
			home=new StrinCreerExcel(data, titres,"Manager", "manager2013",x);
		}
		String url=System.getProperty("java.io.tmpdir");
		String file = "manager2013"+x+".xlsx";

		File f = new File(url+file);

		double bytes = f.length();
		double kilobytes = (bytes / 1024);
		double megabytes = (kilobytes / 1024);

		fileName = file;
		fileSize = kilobytes;
		try {
			inputStream = new FileInputStream(url+file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String getIndex() {
		return index;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public Double getFileSize() {
		return fileSize;
	}

}
