package com.sqli.challange.metier;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
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
import com.sqli.challange.entity.Collaborateur;
import com.sqli.challange.entity.Collaborateurs;
import com.sqli.challange.entity.Competence;
import com.sqli.challange.entity.Compte;
import com.sqli.challange.entity.Diplomes;
import com.sqli.challange.entity.HistoriqueSalPostTravail;
import com.sqli.challange.entity.ManagerAgence;
import com.sqli.challange.entity.ManagerRH;
import com.sqli.challange.entity.ResponsableProduction;
import com.sqli.challange.entity.Rituls;
import com.sqli.challange.entity.Site;
import com.sqli.challange.entity.Technologies;
import com.sqli.challange.sessions.IManagerLocal;
import com.sqli.challange.sessions.IManagerRemote;


@Stateless(name="manager")
public class Managervue implements IManagerLocal,IManagerRemote {

	@PersistenceContext(unitName="emsqli")
	private EntityManager em;


	@Override
	public int editermonprofil(long id, Collaborateurs mng,
			List<String> ltechcomp, List<String> dips,
			String log, String pwd) {
		// TODO Auto-generated method stub
		int n=0;
		System.out.println("dkhelna hnaya");

		Collaborateurs colac=em.find(Collaborateurs.class, id);

		if(this.checkMatricuke(mng.getMatricule())){
			if(this.checkLogin(log)){

				List<Technologies> ltechno=new ArrayList<Technologies>();
				List<Competence> lcomp=new ArrayList<Competence>();
				List<String> llevls=new ArrayList<String>();
				List<Diplomes> ldips=new ArrayList<Diplomes>();

				for(String val:ltechcomp){
					ltechno.add(this.checktechno(val.split(",")[0]));
					lcomp.add(this.checkcomp(val.split(",")[1]));
					llevls.add(val.split(",")[2]);
				}

				/*for(String dp:dips){

					ldips.add(this.addDiplomat(dp.split(",")[0], dp.split(",")[4], 
							dp.split(",")[0], dp.split(",")[2], 
							dp.split(",")[3], dp.split(",")[1]));

				}
				*/
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


				/*for(Diplomes dps:ldips){
					//rh.getDiplome().add(dps);
					//dps.getCols().add(rh);
					System.out.println("code dip "+dps.getTitre()+ "code rh "+colac.getCodecol());
					this.colabDiplomes(colac.getCodecol(), dps.getCodedip());
				}
				*/
				for (int i = 0; i < llevls.size(); i++) {
					System.out.println("code techno comp "+lcomp.get(i).getdicrpt()+ ltechno.get(i).getDesctechno());
					this.addColCompTechno(colac.getCodecol(), lcomp.get(i).getCodecompt(), ltechno.get(i).getCodetechno(), llevls.get(i));
				}


				colac.getProfil().setUsername(log);
				colac.getProfil().setPassword(pwd);

				em.persist(colac);

				System.out.println("code RH 9bal "+colac.getCodecol());

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
	public void ajouterManagerRH(Collaborateurs rh,List<String> ltechcomp,List<String> dips,long ibu,long ist,String log,String pwd,String prof) {
		// TODO Auto-generated method stub
		System.out.println("dkhelna hnaya");
		List<Technologies> ltechno=new ArrayList<Technologies>();
		List<Competence> lcomp=new ArrayList<Competence>();
		List<String> llevls=new ArrayList<String>();
		List<Diplomes> ldips=new ArrayList<Diplomes>();

		for(String val:ltechcomp){
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
		this.addsalhisto(rh.getCodecol(), rh.getSalaireactuel(), "");

	}

	@Override
	public void ajouterCollaborateur(Collaborateur col,List<String> ltechcomp,List<String> dips,long ibu,long ist,long idrh) {
		// TODO Auto-generated method stub
		List<Technologies> ltechno=new ArrayList<Technologies>();
		List<Competence> lcomp=new ArrayList<Competence>();
		List<String> llevls=new ArrayList<String>();
		List<Diplomes> ldips=new ArrayList<Diplomes>();

		for(String val:ltechcomp){
			ltechno.add(this.checktechno(val.split(",")[0]));
			lcomp.add(this.checkcomp(val.split(",")[1]));
			llevls.add(val.split(",")[2]);
		}

		Collaborateurs mrh=em.find(Collaborateurs.class, idrh);

		((Collaborateur)col).setManageractuel((ManagerRH)mrh);

		col.setBu(em.find(BusinessUnite.class, ibu));
		col.setSite(em.find(Site.class, ist));

		em.persist(col);

		Long idcol=col.getCodecol();

		System.out.println("Code colaborateur IDCOL "+idcol);
		for(String dp:dips){
			this.addDiplomat(dp.split(",")[0], dp.split(",")[4], dp.split(",")[0], dp.split(",")[2], dp.split(",")[3], dp.split(",")[1], idcol);
		}

		Collaborateurs crh=em.find(Collaborateurs.class, idcol);
		System.out.println("new id col "+crh.getCodecol());

		//a voire la date 
		System.out.println("date d'aumbauche "+crh.getDateembauche());
		this.addsalhisto(crh.getCodecol(), crh.getSalaireactuel(), crh.getDateembauche());

		for (int i = 0; i < llevls.size(); i++) {
			this.addColCompTechno(crh.getCodecol(), lcomp.get(i).getCodecompt(), ltechno.get(i).getCodetechno(), llevls.get(i));
		}

	}


	@Override
	public void editerCollaborateur(long idcol, String post, double sal,long idmanagerrh,String dt) {
		// TODO Auto-generated method stub
		try {
			Collaborateurs col=em.find(Collaborateurs.class, idcol);

			System.out.println("bdina bdina");
			col.setPosttravail(post);
			col.setSalaireactuel(sal);

			ManagerRH mngac=(ManagerRH)em.find(Collaborateurs.class, idmanagerrh);
			ManagerRH mnganc=((Collaborateur)col).getManageractuel();


			if(mngac.getCodecol() != mnganc.getCodecol()){
				((Collaborateur)col).setManagerancien(mnganc);
				((Collaborateur)col).setManageractuel(mngac);
			}


			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");


			this.addsalhisto(idcol, sal, sdf.format(new Date()));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	@Override
	public void desactiverMRHCols(long idmrh, List<Long> listcol) {
		// TODO Auto-generated method stub
		for(long col:listcol){
			this.deaffecterRhCol(col,idmrh);
		}
	}

	@Override
	public List<Collaborateur> consulterlistCollaborateur() {
		List<Collaborateur> cols=new ArrayList<Collaborateur>();
		Query sql=em.createQuery("select mg from Collaborateurs mg");

		for (int i = 0; i < sql.getResultList().size(); i++) {

			if(sql.getResultList().get(i) instanceof Collaborateur){
				cols.add((Collaborateur) sql.getResultList().get(i));
			}
		}
		return cols;

	}

	@Override
	public List<ManagerRH> consulterlistManagerRH() {
		List<ManagerRH> rh=new ArrayList<ManagerRH>();
		Query sql=em.createQuery("select mg from Collaborateurs mg");

		for (int i = 0; i < sql.getResultList().size(); i++) {

			if(sql.getResultList().get(i) instanceof ManagerRH){
				rh.add((ManagerRH) sql.getResultList().get(i));
			}
		}
		return rh;

	}

	@Override
	public Collaborateur consulterColab(long id) {
		// TODO Auto-generated method stub
		return em.find(Collaborateur.class, id);
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
		Collaborateurs cl=this.consulterColab(col);

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

		dip.setDldip(0);
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
	public void addsalhisto(long idcol, double nsal ,String dt) {
		// TODO Auto-generated method stub
		try {
			
			Collaborateurs col=em.find(Collaborateurs.class, idcol);
			System.out.println("voila notre collaborateur "+col.getNom());

			System.out.println("bedua bedua");
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String sdt=sdf.format(new Date());
			System.out.println("voila date parser "+sdt);
			HistoriqueSalPostTravail histo=new HistoriqueSalPostTravail(nsal,sdt, "");
			
				String dy=sdt.split("/")[2];
				String dm=sdt.split("/")[1];
				histo.setAnnee(dy);
				histo.setMois(dm);
			

			col.getHistoriquesal().add(histo);
			histo.setColab(col);

			System.out.println("voila historique "+histo.getHsalaire());

			em.persist(histo);
			System.out.println("fin de persistance");


			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	@Override
	public List<Collaborateur> consulterlistCollabRH(long rh) {
		// TODO Auto-generated method stub
		Query sql=em.createQuery("select col from Collaborateur col where col.manageractuel.codecol = :x");
		sql.setParameter("x", rh);

		return sql.getResultList();
	}

	@Override
	public void affecterRhCol(long cl, long rh) {
		Collaborateur col=(Collaborateur) em.find(Collaborateurs.class, cl);
		ManagerRH mngac=(ManagerRH)em.find(Collaborateurs.class, rh);
		ManagerRH mnganc=((Collaborateur)col).getManageractuel();

		if(mnganc != null){
			if( mngac.getCodecol() != mnganc.getCodecol() ){
				((Collaborateur)col).setManagerancien(mnganc);
				((Collaborateur)col).setManageractuel(mngac);
			}
		}
		else {
			((Collaborateur)col).setManageractuel(mngac);
		}
		em.persist(col);
	}

	@Override
	public void deaffecterRhCol(long cl, long rh) {
		// TODO Auto-generated method stub
		Collaborateur col=(Collaborateur) em.find(Collaborateurs.class, cl);
		ManagerRH mnganc=(ManagerRH)em.find(Collaborateurs.class, rh);
		//ManagerRH mnganc=((Collaborateur)col).getManageractuel();


		((Collaborateur)col).setManagerancien(mnganc);
		((Collaborateur)col).setManageractuel(null);
		em.persist(col);
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
	public List<Collaborateur> consulterlistCollabNRH(long rh) {
		Query sql=em.createQuery("select col from Collaborateur col where col.manageractuel.codecol != :x");
		sql.setParameter("x", rh);

		return sql.getResultList();
	}


	@Override
	public String parseDate(Date d) {
		String a = d+"";
		String jour = a.split(" ")[2];
		String mois = a.split(" ")[1];
		String anne = a.split(" ")[5];


		String mm;
		switch (mois) {
		case "Jan": mm = "01";
		break;
		case "Feb":mm = "02";
		break;
		case "Mar":mm = "03";
		break;
		case "Apr":mm = "04";
		break;
		case "May":mm = "05";
		break;
		case "Jun":mm = "06";
		break;
		case "Jul":mm = "07";
		break;
		case "Aug":mm = "08";
		break;
		case "Sep":mm = "09";
		break;
		case "Oct":mm = "10";
		break;
		case "Nov":mm = "11";
		break;
		case "Dec":mm = "12";
		break;
		default: mm = "1";
		break;
		}

		return jour+"/"+mm+"/"+anne;
	}

	@Override
	public int editermyprofile(long idadm, String nom, String prenom,
			String email, String sexe, String username, String password) {
		// TODO Auto-generated method stub
		Collaborateurs col=em.find(Collaborateurs.class, idadm);
		int n=0;
		if(this.checkLogin(username) || username.equals(col.getProfil().getUsername())){
			col.setNom(nom);
			col.setPrenom(prenom);
			col.setEmail(email);
			col.setSexe(sexe);
			col.getProfil().setUsername(username.toLowerCase());
			col.getProfil().setPassword(this.crypterMDF5(password));
			n=1;
		}
		return n;
	}

	@Override
	public boolean checkrhcol(long rh, long col) {
		Query sql=em.createQuery("select col from Collaborateur col where col.manageractuel.codecol = :x and col.codecol = :y ");
		sql.setParameter("x", rh);
		sql.setParameter("y", col);
		if(sql.getResultList().size() == 0)return true;
		return false;
	}


	@Override
	public void activerMRHCols(long idmrh, List<Long> listcol) {

		System.out.println("Hana jite");
		List<Long> colsact=new ArrayList<Long>();

		for(Collaborateur col:consulterlistCollabRH(idmrh)){
			colsact.add(col.getCodecol());
		}

		for(Long id:listcol){
			if(checkrhcol(idmrh, id)){
				this.affecterRhCol(id,idmrh);
			}
		}

		for(Long id:colsact){
			if(!listcol.contains(id)){
				this.deaffecterRhCol(id, idmrh);
			}
		}
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
	public List<String> listDiplomes(long id) {
		// TODO Auto-generated method stub
		int k=0;
		Query sql=em.createQuery("select dip from Diplomes dip where dip.col.codecol = :x and dip.dldip = :z");
		sql.setParameter("x", id);
		sql.setParameter("z", 0);
		//System.out.println("in remplire dba dt "+new Date());
		List<String> diplo=new ArrayList<String>();
		Diplomes cdp=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cdp=(Diplomes) sql.getResultList().get(i);
			diplo.add(cdp.getTitre()+","+cdp.getNiveau()+","+cdp.getTypediplome()+","+cdp.getTypecole()+","+cdp.getPromotion());
			
		}
		System.out.println("dkhlne base bahc n3ameroo k = "+k);
		k++;
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
			techno.add(cdp.getTechno().getDesctechno()+","+cdp.getComp().getdicrpt()+","+cdp.getLevel());
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

					if(profil.equals("ManagerRH")){

						String conct=""+new Date();
						String vl=conct.split(" ")[3];
						col = new ManagerRH(mat, mg.split(",")[1], mg.split(",")[2],"abv", mg.split(",")[9],mg.split(",")[3],"bap",mg.split(",")[4],mg.split(",")[5],Double.parseDouble(mg.split(",")[8]),mg.split(",")[7],mg.split(",")[6]);
						col.setMoisBAP(this.MoisBap(mg.split(",")[3]));
						col.setAbreviation(this.Abrvis(mg.split(",")[1], mg.split(",")[2]));
						log=profil.toLowerCase()+String.valueOf(mat);


						this.ajouterExcelManager(col, log, profil.toLowerCase(), profil, this.checkBu(mg.split(",")[10]), this.checkSite(mg.split(",")[11]));

					}
					else{
						n=3;
						return n;
					}

				}
				else {
					n=2;
					return n;
				}

			}
			else{
				n=1;
				return n;
			}


		}

		return n;
	}



	@Override
	public int ajouterExcelManager(Collaborateurs col, String log, String pwd,String prof, long idbu, long idst) {
		int n=0;
		if(idbu == 0)idbu=1;
		if(idst == 0)idst=2;

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

		n=(Integer) sql.getResultList().get(0);



		return n;
	}


	@Override
	public int CreerCollaborateurFExcel(String mg) {
		String log;
		
		int mat=0;
		String profil;
		double sal;
		int n=0;
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

			profil=mg.split(",")[12];

			//String mgnm=String.valueOf(mg.split(",")[13]);
			
			
			int matmngr= 0;
			/*if(mgnm.contains(".")){
				
				matmngr=Integer.parseInt(mgnm.substring(0, mgnm.indexOf(".")));

			}
			else{
				matmngr=Integer.parseInt(nm);
			}
*/
			
			System.out.println("in here");
			System.out.println("in collab id "+mat+" et RH "+matmngr);
			if(this.checkMatricuke(mat) && !this.checkMatricuke(matmngr)){


				if(this.checkBu(mg.split(",")[10]) > 0 && this.checkSite(mg.split(",")[11]) > 0){

					if(profil.equals("Collaborateur")){

						String conct=""+new Date();
						String vl=conct.split(" ")[3];
						col = new Collaborateur(mat, mg.split(",")[1], mg.split(",")[2],"abv", mg.split(",")[9],mg.split(",")[3],"bap",mg.split(",")[4],mg.split(",")[5],Double.parseDouble(mg.split(",")[8]),mg.split(",")[7],mg.split(",")[6]);
						col.setMoisBAP(this.MoisBap(mg.split(",")[3]));
						col.setAbreviation(this.Abrvis(mg.split(",")[1], mg.split(",")[2]));


						this.ajouterExcelCollaborateur(col, this.checkBu(mg.split(",")[10]), this.checkSite(mg.split(",")[11]), matmngr);
					}
					else{
						n=3;
						return n;
					}

				}
				else {
					n=2;
					return n;
				}

			}
			else{
				n=1;
				return n;
			}


		}

		return n;
	}


	@Override
	public int ajouterExcelCollaborateur(Collaborateurs col,long idbu,long idst,long mgract) {
		System.out.println("ajouterExcelCollaborateur");
		int n=0;
		if(idbu == 0)idbu=1;
		if(idst == 0)idst=2;

		col.setBu(em.find(BusinessUnite.class, idbu));
		col.setSite(em.find(Site.class, idst));
		em.persist(col);
		System.out.println("manager rh "+mgract);
		this.affecterRhCol(col.getCodecol(), mgract);
		System.out.println("fin affectation");

		return n;
	}


	@Override
	public List<String> SauvegarderCollaborateurFromExcel(List<String> res) {
		System.out.println("in invocation methode");

		res.remove(0);
		for(String st:res){
			System.out.println(st);
		}

		List<String> managererrone=new ArrayList<String>();

		for(String st:res){
			if(this.CreerCollaborateurFExcel(st) != 0 ){
				managererrone.add(st);
			}
		}
		return managererrone;
	}


	@Override
	public long organiserRitules(long idcol, long idmanagerRh, long idmanager) {
	
				String desc = "designation,notification,bienvenue";
				String theme = "Designation comme Manager RH,Collaboratuer "+idcol+"success,bienvenue";
				String risala = "Vous etes choisi comme designateur du Collaborateur "+idcol +
						"Le collaborateur bien ajouter avec success" +
						"Bienvenue dans notre Societe";
				
				String lu = "non";
			Rituls rt=new Rituls(idcol, idmanagerRh,  idmanager, theme, desc, lu, risala);
			rt.setCol(this.consulterColab(idcol));
			rt.setDescrt(desc);
			rt.setMessage(risala);
			rt.setThemert(theme);
			em.persist(rt);
		
		return rt.getIdrt();
	}


	@Override
	public Rituls consulterRituls(long id) {
		return em.find(Rituls.class, id);
	}


	//pour web service RS
	@Override
	public long getIdFMatricule(int mat) {
		Query sql=em.createQuery("select col from Collaborateurs col where col.matricule = :x");
		sql.setParameter("x", mat);
		long idmgr=0;
		if(sql.getResultList().size() != 0){
			Collaborateurs cl=(Collaborateurs) sql.getResultList().get(0);
			idmgr=cl.getCodecol();
		}
		return idmgr;
	}
	
	
	@Override
	public Collaborateur consulterColFromMat(int mat) {
		Query sql=em.createQuery("select col from Collaborateurs col where col.matricule = :x");
		sql.setParameter("x", mat);
		Collaborateur col=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			col=(Collaborateur) sql.getResultList().get(i);
		}
		return col;
	}


	@Override
	public void ajouterCollaborateurDips(long col, String dip) {
		// TODO Auto-generated method stub
		/*Diplomes ldips;
		Collaborateurs col=em.find(Collaborateurs.class, id);
		
		ldips=this.addDiplomat(dp.split(",")[0], dp.split(",")[4],dp.split(",")[0], dp.split(",")[2],dp.split(",")[3], dp.split(",")[1]);

		this.colabDiplomes(col.getCodecol(), ldips.getCodedip());
		*/
		
	}
	
	@Override
	public void ajouterCollaborateurTeCmp(long col, String dip) {
		// TODO Auto-generated method stub
		/*Collaborateurs col=em.find(Collaborateurs.class, id);
		Technologies ltechno;
		Competence lcomp;
		String llevls;
		 
		
		ltechno=this.checktechno(tecmp.split(",")[0]);
		lcomp=this.checkcomp(tecmp.split(",")[1]);
		llevls=tecmp.split(",")[2];
		
		this.addColCompTechno(col.getCodecol(), lcomp.getCodecompt(), ltechno.getCodetechno(), llevls);
		*/
	}
	
	@Override
	public List<String> consulterTechno() {
		// TODO Auto-generated method stub
		List<String> tecno=new ArrayList<String>();
		Query sql=em.createQuery("select  tec from Technologies tec");
		for (int i = 0; i < sql.getResultList().size(); i++) {
			tecno.add(((Technologies)sql.getResultList().get(i)).getDesctechno());
		}
		return tecno;
		
	}
	
	@Override
	public List<String> consulterComp() {
		List<String> tecno=new ArrayList<String>();
		Query sql=em.createQuery("select  tec from Competence tec");
		for (int i = 0; i < sql.getResultList().size(); i++) {
			tecno.add(((Competence)sql.getResultList().get(i)).getdicrpt());
		}
		return tecno;
	}
	
	@Override
	public void ajouterCollaborateurRS(int mat, String nm, String pr,
			String em, String abr, String sx, String dtem, String mb,
			String pd, String dtps, String pt, String sal, String ltechcomp,
			String dips, long ibu, long ist, long idrh) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Collaborateurs consulterManagersFromMat(int mat) {
		Query sql=em.createQuery("select col from Collaborateurs col where col.matricule = :x");
		sql.setParameter("x", mat);
		Collaborateurs col=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			col=(Collaborateurs) sql.getResultList().get(i);
		}
		return col;
	}
	
	@Override
	public List<String> consulterAllTechno() {
		List<String> tecs=new ArrayList<String>();
		Query sql=em.createQuery("select tec from Technologies tec");
		Technologies tec=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			tec=(Technologies) sql.getResultList().get(i);
			tecs.add(tec.getDesctechno());
		}
		
		return tecs;
	}
	
	@Override
	public List<String> consulterAllComp() {
		List<String> comps=new ArrayList<String>();
		Query sql=em.createQuery("select cmp from Competence cmp");
		Competence cmp=null;
		for (int i = 0; i < sql.getResultList().size(); i++) {
			cmp=(Competence) sql.getResultList().get(i);
			comps.add(cmp.getdicrpt());
		}
		
		return comps;
	}
	
	
	@Override
	public List<ManagerRH> consulterlistRhNon(long idmg) {
		System.out.println("voila id rh"+idmg);
		List<ManagerRH> rh=new ArrayList<ManagerRH>();
		Query sql=em.createQuery("select mg from Collaborateurs mg where mg.codecol != :x");
		sql.setParameter("x", idmg);
		for (int i = 0; i < sql.getResultList().size(); i++) {

			if(sql.getResultList().get(i) instanceof ManagerRH){
				rh.add((ManagerRH) sql.getResultList().get(i));
			}
		}
		
		for(ManagerRH mg:rh){
			System.out.println("liste rh "+mg);
		}
		return rh;

	}
	
	
	
	
}
