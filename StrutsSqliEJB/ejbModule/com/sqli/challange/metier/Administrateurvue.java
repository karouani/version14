package com.sqli.challange.metier;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sqli.challange.entity.Administrateur;
import com.sqli.challange.entity.AmbassadeurRH;
import com.sqli.challange.entity.BusinessUnite;
import com.sqli.challange.entity.ColCompTechno;
import com.sqli.challange.entity.ColabDips;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Competence;
import com.sqli.challange.entity.Compte;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.HistoriqueSalPostTravail;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.entity.Site;
import com.sqli.challange.entity.Technologies;
import com.sqli.challange.sessions.IAdminLocal;
import com.sqli.challange.sessions.IAdminRemote;


@Stateless(name="admin")
public class Administrateurvue implements IAdminLocal,IAdminRemote {

	@PersistenceContext(unitName="emsqli")
	private EntityManager em;

	@Override
	public boolean editermonprofil(long id,Administrateur administrateur) {
		Administrateur admin=em.find(Administrateur.class, id);

		String status = "in";
		if(administrateur.getCmp().getStatus() == null){
			status = "out";
		}
		if(administrateur.getDescription() != null){
			admin.setDescription(administrateur.getDescription());
		}
		if(administrateur.getEmail() != null){
			admin.setEmail(administrateur.getEmail());
		}

		if(administrateur.getNom() != null){
			admin.setNom(administrateur.getNom());
		}

		if(administrateur.getPhoto() != null){
			admin.setPhoto(administrateur.getPhoto());
		}

		if(administrateur.getPrenom() != null){
			admin.setPrenom(administrateur.getPrenom());
		}

		if(administrateur.getSexe() != null){
			admin.setSexe(administrateur.getSexe());
		}

		if(administrateur.getCmp().getPassword()  != null){
			admin.getCmp().setPassword(administrateur.getCmp().getPassword());
		}

		if(administrateur.getCmp().getUsername()  != null){
			admin.getCmp().setUsername(administrateur.getCmp().getUsername());
		}

		admin.getCmp().setStatus(status);

		em.persist(admin);
		return true;
	}



	@Override
	public void ajouteradministrateur(Administrateur admin,String log,String pwd,String role) {
		// TODO Auto-generated method stub
		//System.out.println("in add administrateur");
		em.persist(admin);
		Administrateur ad=this.consulterAdmin(admin.getIdadm());
		this.ajoutercompteadmin(ad.getIdadm(), log, pwd, role);
	}

	@Override
	public void desactivercompteadmin(long id) {
		// TODO Auto-generated method stub
		Administrateur admin=this.consulterAdmin(id);

		Compte cp=admin.getCmp();
		cp.setStatus("out");

		em.persist(cp);

	}

	@Override
	public int ajoutermanager(
			Collaborateurs rh,
			List<String> ltechcomp,
			List<String> dips,
			long ibu,
			long ist,
			String log,
			String pwd,String prof){
		int n=0;
		System.out.println("dkhelna hnaya");

		if(this.checkMatricuke(rh.getMatricule())){

			if(this.checkLogin(log)){

				List<Technologies> ltechno=new ArrayList<Technologies>();
				List<Competence> lcomp=new ArrayList<Competence>();
				List<String> llevls=new ArrayList<String>();

				for(String val:ltechcomp){
					System.out.println("valeur "+val);
					ltechno.add(this.checktechno(val.split(",")[0]));
					lcomp.add(this.checkcomp(val.split(",")[1]));
					llevls.add(val.split(",")[2]);
				}

				rh.setBu(em.find(BusinessUnite.class, ibu));
				rh.setSite(em.find(Site.class, ist));


				em.persist(rh);

				System.out.println("code RH 9bal "+rh.getCodecol());

				for(String dp:dips){
					this.addDiplomat(dp.split(",")[0], dp.split(",")[4], dp.split(",")[0], dp.split(",")[2], dp.split(",")[3], dp.split(",")[1], rh.getCodecol());
				}

				for (int i = 0; i < llevls.size(); i++) {
					System.out.println("code techno comp "+lcomp.get(i).getdicrpt()+ ltechno.get(i).getDesctechno());
					this.addColCompTechno(rh.getCodecol(), lcomp.get(i).getCodecompt(), ltechno.get(i).getCodetechno(), llevls.get(i));
				}

				this.ajouterCompte(rh.getCodecol(), log, pwd, prof);

			}else{
				n=2;
			}
		}
		else{
			n=1;
		}
		return n;
	}


	@Override
	public List<Collaborateurs> consulterAllCollaborateurrsManager() {
		// TODO Auto-generated method stub
		List<Collaborateurs> cols=new ArrayList<Collaborateurs>();
		Query sql=em.createQuery("select mg from Collaborateurs mg");

		for (int i = 0; i < sql.getResultList().size(); i++) {

			if(sql.getResultList().get(i) instanceof AmbassadeurRH){
				cols.add((AmbassadeurRH) sql.getResultList().get(i));
			}else if(sql.getResultList().get(i) instanceof ResponsableProduction){
				cols.add((ResponsableProduction) sql.getResultList().get(i));
			}else if(sql.getResultList().get(i) instanceof ManagerAgence){
				cols.add((ManagerAgence) sql.getResultList().get(i));
			}
		}
		return cols;
	}

	@Override
	public List<Collaborateurs> consulterAllCollaborateurrsManagerRH() {
		// TODO Auto-generated method stub
		List<Collaborateurs> cols=new ArrayList<Collaborateurs>();
		Query sql=em.createQuery("select mg from Collaborateurs mg");

		for (int i = 0; i < sql.getResultList().size(); i++) {
			if(sql.getResultList().get(i) instanceof ManagerRH){
				cols.add((ManagerRH) sql.getResultList().get(i));
			}
		}
		return cols;
	}

	@Override
	public List<Administrateur> consulterAllAdmin() {
		List<Administrateur> cols=new ArrayList<>();
		Query sql=em.createQuery("select a from Administrateur a");

		for (int i = 0; i < sql.getResultList().size(); i++) {
			if(sql.getResultList().get(i) instanceof Administrateur){
				cols.add((Administrateur) sql.getResultList().get(i));
				System.out.println(sql.getResultList().get(i));
			}
		}
		return cols;
	}


	@Override
	public Administrateur consulterAdmin(long id) {
		Administrateur admin=em.find(Administrateur.class, id);
		return admin;
	}

	@Override
	public Compte ajoutercompteadmin(long id, String log, String pwd,
			String role) {
		// TODO Auto-generated method stub
		Administrateur adm=this.consulterAdmin(id);
		String val=this.crypterMDF5(pwd);
		Compte cp=new Compte(log.toLowerCase(), val, role);
		cp.setStatus("in");

		adm.setCmp(cp);

		em.persist(cp);

		return cp;
	}

	@Override
	public Compte ajoutercomptemanager(long id, String log, String pwd,
			String role) {
		Collaborateurs col=em.find(Collaborateurs.class, id);
		String val=this.crypterMDF5(pwd);
		Compte cp=new Compte(log.toLowerCase(), val, role);
		cp.setStatus("in");

		col.setProfil(cp);

		em.persist(cp);

		return cp;
	}

	@Override
	public BusinessUnite ajouterBus(String desp) {
		// TODO Auto-generated method stub
		BusinessUnite bu=new BusinessUnite(desp);
		em.persist(bu);

		return bu;
	}

	@Override
	public Site ajouterSite(String s) {
		// TODO Auto-generated method stub
		Site st=new Site(s);
		em.persist(st);

		return st;
	}



	@Override
	public List<Site> consulterAllSite() {
		// TODO Auto-generated method stub
		Query sql=em.createQuery("select a from Site a");
		return sql.getResultList();
	}



	@Override
	public List<BusinessUnite> consulterAllBu() {
		Query sql=em.createQuery("select a from BusinessUnite a");
		return sql.getResultList();
	}



	@Override
	public boolean checkLogin(String log) {
		// TODO Auto-generated method stub
		Query sql=em.createQuery("select col from Collaborateurs col where col.cmp.username like :x");
		sql.setParameter("x", log);

		if(sql.getResultList().size() == 0){
			return true;
		}

		return false;
	}



	@Override
	public boolean checkMatricuke(int mat) {
		
		Query sql2=em.createQuery("select col from Collaborateurs col");
		
		if(sql2.getResultList().size() > 0){
			Query sql=em.createQuery("select col from Collaborateurs col where col.matricule = :x");
			sql.setParameter("x", mat);

			System.out.println("voila la liste "+sql.getResultList()+" size "+sql.getResultList().size());
			if(sql.getResultList().size() == 0){
				System.out.println("in condition chek mat");
				return true;
			}
			else {
				return false;
			}
		}
		
		

		return true;
	}

	@Override
	public Competence checkcomp(String comp) {
		// TODO Auto-generated method stub
		Query sql=em.createQuery("select cp from Competence cp where cp.dicrpt LIKE :x");
		sql.setParameter("x", comp);
		Competence cp=null;

		for (int i = 0; i < sql.getResultList().size(); i++) {
			cp=(Competence) sql.getResultList().get(i);
		}
		if(cp != null){
			return cp;
		}
		else{
			cp=new Competence(comp);
			em.persist(cp);
			return cp;
		}		 
	}

	@Override
	public Technologies checktechno(String tech) {
		Query sql=em.createQuery("select tec from Technologies tec where tec.desctechno LIKE :x");
		sql.setParameter("x", tech);
		Technologies tec=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			tec=(Technologies) sql.getResultList().get(i);
		}

		if(tec != null){
			return tec;
		}
		else{
			tec=new Technologies(tech);
			em.persist(tec);
			return tec;
		}	
	}

	@Override
	public ColCompTechno addColCompTechno(long col, long comp, long techno,String levl) {
		// TODO Auto-generated method stub
		Competence cp=em.find(Competence.class, comp);
		Technologies tec=em.find(Technologies.class, techno);
		Collaborateurs cl=em.find(Collaborateurs.class, col);

		ColCompTechno cct=new ColCompTechno(levl, cl, cp, tec);

		cp.getCct().add(cct);
		cl.getComptechno().add(cct);
		tec.getCct().add(cct);

		cct.setColab(cl);
		cct.setTechno(tec);
		cct.setComp(cp);

		em.persist(cct);

		return cct;
	}



	@Override
	public Diplomes addDiplomat(String titre, String promotion, String ecole,
			String typediplome, String typecole, String niveau,long idcol) {
		Collaborateurs col=em.find(Collaborateurs.class, idcol);
		Diplomes dip=new Diplomes(titre, promotion, ecole, typediplome, typecole, niveau);

		col.getLdips().add(dip);
		dip.setCols(col);

		em.persist(dip);

		return dip;
	}

	@Override
	public Compte ajouterCompte(long col, String log, String pwd, String profil) {
		// TODO Auto-generated method stub
		Collaborateurs cl=em.find(Collaborateurs.class, col);
		String val=this.crypterMDF5(pwd);
		Compte cpt=new Compte(log.toLowerCase(), val, profil);
		cpt.setStatus("in");

		System.out.println("notre compte "+cpt.getUsername());
		cl.setProfil(cpt);

		//em.persist(cl);
		em.persist(cpt);


		return cpt;
	}

	@Override
	public int supprimerCol(long id) {
		// TODO Auto-generated method stub
		Collaborateurs col=em.find(Collaborateurs.class, id);
		em.remove(col);
		return 0;
	}




	@Override
	public int editerManager(long id,Collaborateurs mng,List<String> ltechcomp,List<String> dips,long ibu,long ist,String log,String pwd,String prof){

		int n=0;
		System.out.println("Mng Recuperer "+mng);

		Collaborateurs colac=em.find(Collaborateurs.class, id);

		/*int mat = colac.getMatricule();
		String login = colac.getProfil().getUsername();

		List<Technologies> ltechno=new ArrayList<Technologies>();
		List<Competence> lcomp=new ArrayList<Competence>();

		List<String> llevls=new ArrayList<String>();
		List<Diplomes> ldips=new ArrayList<Diplomes>();

		System.out.println("taille techno "+ltechno.size());
		System.out.println("taille comp "+lcomp.size());

		for(String val:ltechcomp){
			ltechno.add(this.checktechno(val.split(",")[0]));
			lcomp.add(this.checkcomp(val.split(",")[1]));
			llevls.add(val.split(",")[2]);
		}*/


		System.out.println("************** Debut set colac **************");
		colac.setMatricule(mng.getMatricule());
		colac.setNom(mng.getNom());
		colac.setPrenom(mng.getPrenom());
		colac.setAbreviation(mng.getAbreviation());
		colac.setSexe(mng.getSexe());
		colac.setDateembauche(mng.getDateembauche());
		colac.setMoisBAP(mng.getMoisBAP());
		colac.setParticipeseminaire(mng.getParticipeseminaire());
		colac.setDateparticipeseminaire(mng.getDateparticipeseminaire());
		colac.setSalaireactuel(mng.getSalaireactuel());
		colac.setPosttravail(mng.getPosttravail());
		colac.setEmail(mng.getEmail());

		colac.setBu(em.find(BusinessUnite.class, ibu));
		colac.setSite(em.find(Site.class, ist));

		System.out.println("************** Colac rempli **************"+colac);
		System.out.println("************** Fin set colac **************");


		this.editerDiplomes(colac.getCodecol(), dips);
		this.MiseajourTechnoCompCol(colac.getCodecol(), this.listTechno(colac.getCodecol()), ltechcomp);

		/*for (int i = 0; i < llevls.size(); i++) {
			System.out.println("code techno comp "+lcomp.get(i).getdicrpt()+ ltechno.get(i).getDesctechno());
			this.addColCompTechno(colac.getCodecol(), lcomp.get(i).getCodecompt(), ltechno.get(i).getCodetechno(), llevls.get(i));
		}*/


		colac.getProfil().setUsername(log.toLowerCase());
		colac.getProfil().setPassword(this.crypterMDF5(pwd));
		this.addsalhisto(colac.getCodecol(), colac.getSalaireactuel(), "");

		em.persist(colac);

		System.out.println("code RH 9bal "+colac.getCodecol());

		return n;
	}


	@Override
	public void addsalhisto(long idcol, double nsal ,String dt) {
		// TODO Auto-generated method stub
		Collaborateurs col=em.find(Collaborateurs.class, idcol);
		System.out.println("voila notre collaborateur "+col.getNom());

		System.out.println("bedua bedua");

		HistoriqueSalPostTravail histo=new HistoriqueSalPostTravail(nsal,dt, "");

		col.getHistoriquesal().add(histo);
		histo.setColab(col);

		System.out.println("voila historique "+histo.getHsalaire());

		em.persist(histo);
		System.out.println("fin de persistance");


	}


	@Override
	public Collaborateurs consulterCollaborateurs(long id) {
		// TODO Auto-generated method stub
		return em.find(Collaborateurs.class, id);
	}



	@Override
	public List<String> listDiplomes(long id) {
		// TODO Auto-generated method stub
		Query sql=em.createQuery("select dip from Diplomes dip where dip.col.codecol = :x");
		sql.setParameter("x", id);
		List<String> diplo=new ArrayList<String>();
		Diplomes cdp=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cdp=(Diplomes) sql.getResultList().get(i);
			diplo.add(cdp.getTitre()+","+cdp.getNiveau()+","+cdp.getTypediplome()+","+cdp.getTypecole()+","+cdp.getPromotion());
		}

		return diplo;
	}


	@Override
	public List<String> listTechno(long id) {
		Query sql=em.createQuery("select cdp from ColCompTechno cdp where cdp.colab.codecol = :x");
		sql.setParameter("x", id);
		List<String> techno=new ArrayList<>();
		ColCompTechno cdp=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cdp=(ColCompTechno) sql.getResultList().get(i);
			techno.add(id+","+cdp.getTechno().getDesctechno()+","+cdp.getComp().getdicrpt()+","+cdp.getLevel());
		}

		return techno;
	}


	@Override
	public String MoisBap(String dt) {
		Map<String, String> months=new HashMap<String, String>();
		months.put("01", "Janvier");
		months.put("02", "F�vrier");
		months.put("03", "Mars");
		months.put("04", "Avril");
		months.put("05", "Mai");
		months.put("06", "Juin");
		months.put("07", "Juillet");
		months.put("08", "Aout");
		months.put("09", "Septembre");
		months.put("10", "Octobre");
		months.put("11", "Novembre");
		months.put("12", "Decembre");
		String bap="Janvier";
		//	01/03/2014
		if(dt.split("/").length == 3){
			int day=Integer.parseInt(dt.split("/")[0]);
			String mois=dt.split("/")[1];
			String calnd[]={"01","02","03","04","05","06","07","08","09","10","11","12"};

			if(day < 15 ){
				bap=months.get(mois);
			}
			else{
				int k=0;
				for (int i = 0; i < calnd.length; i++) {
					if(mois.equals(calnd[i])){
						k=i;
					}
				}
				if(k == 11){
					bap=months.get("01");
				}
				else{
					++k;
					bap=months.get(calnd[k]);
				}
			}
		}



		return bap;
	}



	@Override
	public String Abrvis(String nom, String prenom) {
		String abr=prenom.substring(0, 1)+nom.substring(0, 2);
		return abr;
	}



	@Override
	public long checkSite(String st) {
		long n =0;
		System.out.println("sittte "+st);
		Query sql=em.createQuery("select st from Site st where st.descsite like :x");
		sql.setParameter("x", st);
		if(sql.getResultList().size() > 0){
			Site sint=(Site) sql.getResultList().get(0);
			return sint.getCodest();
		}	
		return n;
	}



	@Override
	public long checkBu(String bu) {
		long n =0;
		System.out.println("buuuu "+bu);
		Query sql=em.createQuery("select bu from BusinessUnite bu where bu.descbu like :x");
		sql.setParameter("x", bu);
		if(sql.getResultList().size() > 0){
			BusinessUnite bun=(BusinessUnite) sql.getResultList().get(0);
			return bun.getCodebu();
		}	
		return n;
	}



	@Override
	public int CreerManagerFExcel(String mg) {
		String log;
		String profil;
		double sal;
		int n=0;
		int mat=0;
		Collaborateurs col=null;
		if(!"".equals(mg)){
			String nm=String.valueOf(mg.split(",")[0]);
			System.out.println("nmmm "+nm);
			
			String rs="";
			System.out.println("contains value "+nm.contains("."));
			if(nm.contains(".")){
				
				rs=nm.substring(0,nm.indexOf("."));
				mat=Integer.parseInt(rs);
			
			}
			else{
				mat=Integer.parseInt(nm);
			}
			
			//debut $$$$$$$$$$

			profil=mg.split(",")[12];

			
			
			System.out.println("vlue checked res "+this.checkMatricuke(mat));
			if(this.checkMatricuke(mat)){


				if(this.checkBu(mg.split(",")[10]) > 0 && this.checkSite(mg.split(",")[11]) > 0){

					System.out.println("get apres check profil "+profil);
					if(profil.equals("ManagerAgence")){

						String conct=""+new Date();
						String vl=conct.split(" ")[3];
						col = new ManagerAgence(mat, mg.split(",")[1], mg.split(",")[2],"abv", mg.split(",")[9],mg.split(",")[3],"bap",mg.split(",")[4],mg.split(",")[5],Double.parseDouble(mg.split(",")[8]),mg.split(",")[7],mg.split(",")[6]);
						col.setMoisBAP(this.MoisBap(mg.split(",")[3]));
						col.setAbreviation(this.Abrvis(mg.split(",")[1], mg.split(",")[2]));
						log=profil.toLowerCase()+String.valueOf(mat);

						this.ajouterExcelManager(col, log, profil.toLowerCase(), profil, this.checkBu(mg.split(",")[10]), this.checkSite(mg.split(",")[11]));

					}
					else if(profil.equals("AmbassadeurRH")){
						col = new AmbassadeurRH(mat, mg.split(",")[1], mg.split(",")[2],"abv", mg.split(",")[9],mg.split(",")[3],"bap",mg.split(",")[4],mg.split(",")[5],Double.parseDouble(mg.split(",")[8]),mg.split(",")[7],mg.split(",")[6]);
						col.setMoisBAP(this.MoisBap(mg.split(",")[3]));
						col.setAbreviation(this.Abrvis(mg.split(",")[1], mg.split(",")[2]));
						String conct=""+new Date();
						String vl=conct.split(" ")[3];
						log=profil.toLowerCase()+String.valueOf(mat);

						this.ajouterExcelManager(col, log, profil.toLowerCase(), profil, this.checkBu(mg.split(",")[10]), this.checkSite(mg.split(",")[11]));
					}
					else if(profil.equals("ResponsableProduction")){
						
						System.out.println("in production");
						col = new ResponsableProduction(mat, mg.split(",")[1], mg.split(",")[2],"abv", mg.split(",")[9],mg.split(",")[3],"bap",mg.split(",")[4],mg.split(",")[5],Double.parseDouble(mg.split(",")[8]),mg.split(",")[7],mg.split(",")[6]);
						col.setMoisBAP(this.MoisBap(mg.split(",")[3]));
						col.setAbreviation(this.Abrvis(mg.split(",")[1], mg.split(",")[2]));
						String conct=""+new Date();
						String vl=conct.split(" ")[3];
						log=profil.toLowerCase()+String.valueOf(mat);

						this.ajouterExcelManager(col, log, profil.toLowerCase(), profil, this.checkBu(mg.split(",")[10]), this.checkSite(mg.split(",")[11]));

					}else{
						n=4;
						return n;
					}

				}
				else {
					n=3;
					return n;
				}

			}
			else{
				n=2;
				return n;
			}
			
			//fin $$$$$$$$$$
		}

		return n;
	}



	@Override
	public int ajouterExcelManager(Collaborateurs col, String log, String pwd,String prof, long idbu, long idst) {
		int n=0;
		if(idbu == 0)idbu=1;
		if(idst == 0)idst=2;
		System.out.println("site et bu  "+idbu+"   et "+idst);
		System.out.println("collaborateur "+col);
		col.setBu(em.find(BusinessUnite.class, idbu));
		col.setSite(em.find(Site.class, idst));
		em.persist(col);
		System.out.println("voila login "+log+" et password "+pwd);
		this.ajouterCompte(col.getCodecol(), log, pwd, prof);
		System.out.println("Voila code apres persistance "+em.find(Collaborateurs.class, col.getCodecol()));

		return n;
	}



	@Override
	public List<String> SauvegarderManagerFromExcel(List<String> res) {
		// TODO Auto-generated method stub
		System.out.println("in invocation methode");

		res.remove(0);
		for(String st:res){
			System.out.println(st);
		}

		List<String> managererrone=new ArrayList<String>();

		for(String st:res){
			if(this.CreerManagerFExcel(st) != 0 ){
				managererrone.add(st);
			}
		}
		return managererrone;
	}



	@Override
	public String crypterMDF5(String pwd) {

		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer(); 
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());

			byte byteData[] = md.digest();

			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			//System.out.println("Digest(in hex format):: " + sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	@Override
	public int generateMax(){
		int n;

		System.out.println("in debut");
		Query sql=em.createQuery("select max(col.matricule) from Collaborateurs col");

		
		if((Integer) sql.getResultList().get(0) == null  || (Integer) sql.getResultList().get(0) == 0){
			n=0;
			System.out.println("val de n in req 0 "+n);
		}
		else{
			n=(Integer) sql.getResultList().get(0);
			
			System.out.println("val de n in req max "+n);
		}

		
		return n;
	}

	@Override
	public void editerDiplomes(long idcol, List<String> ldips) {
		// TODO Auto-generated method stub
	Query sql=em.createQuery("select dip from Diplomes dip where dip.col.codecol = :x and dip.dldip = :z");
		sql.setParameter("x", idcol);
		sql.setParameter("z", 0);
		List<Diplomes> nldips=new ArrayList<Diplomes>();
		for(String dp:ldips){
			System.out.println("les dips li jayin");
			System.out.println("old dip :"+dp);
		}
		for (int i = 0; i < sql.getResultList().size(); i++) { 
			Diplomes dip=(Diplomes) sql.getResultList().get(i); 
			System.out.println("old dip :"+dip.getTitre());
			nldips.add(dip);
			
		}
		for(Diplomes dp:nldips){
			//supprimerDiplomes(idcol, dip.getCodedip());
			System.out.println("new dip :"+dp.getTitre());
			
			this.supprimerDiplomes(idcol, dp.getCodedip());
		}

		for(String dp:ldips){
			this.addDiplomat(dp.split(",")[0], dp.split(",")[1], dp.split(",")[2], dp.split(",")[3], dp.split(",")[4], dp.split(",")[5], idcol);
		}	
	}



	@Override
	public void supprimerDiplomes(long idcol, long iddip) {
		// TODO Auto-generated method stub
		System.out.println("in deleted");
		Diplomes dip=em.find(Diplomes.class, iddip);
		dip.setDldip(1);
		em.persist(dip);
	}



	@Override
	public String ConsulterTechnCompCol(long idcol, long idtcc) {
		// TODO Auto-generated method stub
		Query sql = em.createQuery("select tcc from ColCompTechno tcc where tcc.colab.codecol = :x  and tcc.id = :y");
		sql.setParameter("x", idcol);
		sql.setParameter("y", idtcc);
		String st="";
		ColCompTechno cct;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cct=(ColCompTechno) sql.getResultList().get(i);
			st=cct.getTechno().getDesctechno()+","+cct.getComp().getCodecompt()+","+cct.getLevel();
		}
		return st;
	}



	@Override
	public boolean UpdateTechnCompCol(long idcol, long idtcc, String st) {
		Query sql = em.createQuery("select tcc from ColCompTechno tcc where tcc.colab.codecol = :x  and tcc.id = :y");
		sql.setParameter("x", idcol);
		sql.setParameter("y", idtcc);
		String stn="";
		ColCompTechno cct=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cct=(ColCompTechno) sql.getResultList().get(i);
		}
		if(cct != null ){
			cct.setComp(this.checkcomp(st.split(",")[1]));
			cct.setTechno(this.checktechno(st.split(",")[0]));
			cct.setLevel(st.split(",")[2]);
			em.persist(cct);
			return true;
		}
		
		return false;
	}



	@Override
	public void MiseajourTechnoCompCol(long idcol, List<String> ltecactuel,
										List<String> ltecnew) {
		int ol=ltecactuel.size();
		int nl=ltecnew.size();
		if(ol == 0){
			for (int i = 0; i < nl; i++) {
				this.addColCompTechno(idcol, this.checkcomp(ltecnew.get(i).split(",")[1]).getCodecompt(), this.checktechno(ltecnew.get(i).split(",")[0]).getCodetechno(), ltecnew.get(i).split(",")[2]);
			}
		}else if(nl != 0){
			for (int i = 0; i < ol; i++) {
				long n=Long.parseLong(ltecactuel.get(i).split(",")[0]);
				String bd=this.ConsulterTechnCompCol(idcol, n);
				String frmtec=ltecnew.get(i);
				if(!bd.equals(frmtec)){
					this.UpdateTechnCompCol(idcol, n, frmtec);
				}
			}

			for (int i = ol; i < nl; i++) {
				this.addColCompTechno(idcol, this.checkcomp(ltecnew.get(i).split(",")[1]).getCodecompt(), this.checktechno(ltecnew.get(i).split(",")[0]).getCodetechno(), ltecnew.get(i).split(",")[2]);
			}

		}
		
		
		
	}
}
