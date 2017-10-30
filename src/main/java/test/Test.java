package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douane.entite.Agent;
import com.douane.entite.EtatMateriel;
import com.douane.entite.Financement;
import com.douane.entite.Fournisseur;
import com.douane.entite.Marque;
import com.douane.entite.MaterielEx;
import com.douane.entite.MaterielNouv;
import com.douane.entite.ModeAcquisition;
import com.douane.entite.MotifDecharge;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.douane.entite.TypeMateriel;
import com.douane.entite.User;
import com.douane.metier.referentiel.IRefMetier;
import com.douane.metier.user.IUserMetier;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[]{"datasource-tx-jpa.xml"});
		System.out.println("BEGIN");
		
		IRefMetier metier = (IRefMetier) context.getBean("refmetier");
		/*
		Nomenclature table = new Nomenclature("Chaise de table", "005");
		Nomenclature stylo = new Nomenclature("Stylo à bille", "006");
		
		ModeAcquisition sera = new ModeAcquisition("Don");
		ModeAcquisition com = new ModeAcquisition("Communiquant");
		
		MotifDecharge affectation = new MotifDecharge("Affectation");
		
		metier.addRef(table);
		metier.addRef(sera);
		metier.addRef(affectation);
		metier.addRef(com);
		
		metier.removeRef(stylo);
		metier.removeRef(table);
		List<Referentiel> lesnomens = metier.listRef(new ModeAcquisition());
		
		ModeAcquisition nom = null;
		for(int i=0; i<lesnomens.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			nom = (ModeAcquisition) lesnomens.get(i);
			System.out.println(nom.getDesignation());
		}
		
		
		*/
		
		IUserMetier usermetier = (IUserMetier) context.getBean("usermetier");
		
		User role1 = new User("Un utilisateur qui peut tout faire", "GAC");
		User role2 = new User("Un utilisateur normal", "Agent");
		
		usermetier.addUser(role1);
		usermetier.addUser(role2);
		
		//usermetier.remUser(role1);
		
		List<User> lesusers = (List<User>) usermetier.listUser();
		for(int i=0; i<lesusers.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println(lesusers.get(i).getRole());
		}
		
		Agent agent1 = new Agent(2252L, "RAKOTONANDRA", "Zazo");
		Agent agent2 = new Agent(2244L, "RASAMY", "Natacha", role2);
		
		usermetier.addAgentUser(agent1, role1);
		usermetier.addAgent(agent2);
		
		List<Agent> lesagents = usermetier.findAllAgents();
		
		for(int i=0; i<lesagents.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println(lesagents.get(i).getPrenomAgent());
		}
		
		//usermetier.remAgent(agent2);
		
		//lesagents = usermetier.findAgentByNom("Ra");
		List<Agent> lesagentss = usermetier.findAllAgents();
		lesagentss = usermetier.findAgentByNom("mY");
		for(int i=0; i<lesagentss.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println("lesagents:"+lesagentss.get(i).getPrenomAgent());
		}
		
		//System.out.println("findbyone:"+ usermetier.findAgentByIm(agent1.getIm()).getNomAgent());
		Nomenclature nm = new Nomenclature("Jus", "001");
		EtatMateriel etat = new EtatMateriel("Neuf");
		TypeMateriel caract = new TypeMateriel("Bureau");
		
		Nomenclature nm1 = new Nomenclature("BAS", "002");
		EtatMateriel etat1 = new EtatMateriel("Old");
		TypeMateriel caract1 = new TypeMateriel("KAKA");
		ModeAcquisition modAcq = new ModeAcquisition("MAet");
		Financement financement = new Financement("DON");
		Fournisseur fournisseur = new Fournisseur("Vitsika");
		
		Marque marq = new Marque("sinoa");
		Marque marq1 = new Marque("vita malagasy");
		
		
		List<Referentiel> listeRef= new ArrayList<Referentiel>();
		
		listeRef.add(nm);
		listeRef.add(etat);
		listeRef.add(caract);
		
		listeRef.add(nm1);
		listeRef.add(etat1);
		listeRef.add(caract1);
		listeRef.add(modAcq);
		listeRef.add(financement);
		listeRef.add(fournisseur);
		listeRef.add(marq);
		listeRef.add(marq1);
		
		metier.saveRefs(listeRef);
		
		
		MaterielEx mat = new MaterielEx(1000.0f, "ref0101", "numserie0101", "autre",null, nm	, etat, caract, agent1, agent2,marq1);
		MaterielNouv mat1 = new MaterielNouv(154.25f, "Ma reference", "NumeroSerie1234", "",
				nm1 , etat1, caract1, agent2, agent2, modAcq, financement, fournisseur, 
			200.25f,"0012", "io/45/toi", marq);
		usermetier.entrerMateriel(mat1, agent2);
		usermetier.entrerMateriel(mat, agent1);
		usermetier.delMat(mat);
		
		usermetier.seeMat(mat1);
	}

}
