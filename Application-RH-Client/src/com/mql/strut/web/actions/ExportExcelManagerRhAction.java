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
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.sessions.IManagerRemote;


@Stateless
public class ExportExcelManagerRhAction {

	private String index = "";

	private InputStream inputStream;
	private String fileName;
	private String fileSize;
	private String file;
	
	@EJB
	private IManagerRemote manager;

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
				"Profil",
				"Matricule Manager Actuel"
				};

		int x= (int) (Math.random()*99999);

		for (Collaborateur col:manager.consulterlistCollaborateur()) {
			
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
					col.getClass().getSimpleName(),
					""+col.getManageractuel().getMatricule()
				};
			data.put(""+col.getCodecol(),val);
			home=new StrinCreerExcel(data, titres,"Collaborateurs", "Collaborateurs2013",x);
			System.out.println("*********************** Variable home "+home);
			file = home.getNomFichier();
		}
		String url=System.getProperty("java.io.tmpdir");
		//String file = "Collaborateurs"+x+".xlsx";

		File f = new File(url+file);

		//long bytes = f.length()/1024;

		fileName = file;
		fileSize = "";
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

	public String getFileSize() {
		return fileSize;
	}

}
