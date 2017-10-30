package com.douane.metier.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airial.repository.AgentRepository;
import com.airial.repository.MaterielRepository;
import com.airial.repository.UserRepository;
import com.douane.entite.Agent;
import com.douane.entite.Financement;
import com.douane.entite.Fournisseur;
import com.douane.entite.Materiel;
import com.douane.entite.MaterielNouv;
import com.douane.entite.ModeAcquisition;
import com.douane.entite.User;

public class UserMetier implements IUserMetier{
	@Autowired
	private UserRepository userrepos;
	@Autowired
	private AgentRepository agentrepos;
	@Autowired
	private MaterielRepository matrepos;
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		userrepos.save(u);
		return u;
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return (List<User>)userrepos.findAll();
	}

	@Override
	public void remUser(User u) {
		// TODO Auto-generated method stub
		userrepos.delete(u);
	}
	
	@Override
	public Agent addAgent(Agent a) {
		// TODO Auto-generated method stub
		agentrepos.save(a);
		return a;
	}

	@Override
	public Agent addAgentUser(Agent a, User u) {
		// TODO Auto-generated method stub
		a.setRoleAgent(u);
		//u.addAgentToList(a);
		agentrepos.save(a);
		
		return a;
	}

	@Override
	public void remAgent(Agent a) {
		// TODO Auto-generated method stub
		System.out.println("remove agent "+a.getIm());
		agentrepos.delete(a.getIm());
		
	}

	@Override
	public List<Agent> findAgentByNom(String name) {
		// TODO Auto-generated method stub
		
		return agentrepos.findByNomAgentContainingIgnoreCase(name);
	}

	@Override
	public Agent findAgentByIm(Long im_agent) {
		// TODO Auto-generated method stub
		return agentrepos.findOne(im_agent);
	}
	
	//temporary
	@Override
	public List<Agent> findAllAgents() {
		// TODO Auto-generated method stub
		return (List<Agent>) agentrepos.findAll();
	}

	@Override
	public Materiel entrerMateriel(Materiel m, Agent dc) {
		// TODO Auto-generated method stub*
		m.setDc(dc);
		matrepos.save(m);
		return null;
	}

	@Override
	public Materiel attriuberMateriel(Long idMat, Long im) {
		// TODO Auto-generated method stub
		Materiel m = (Materiel) matrepos.findOne(idMat);
		Agent detenteur = (Agent) agentrepos.findOne(im);
		m.setDetenteur(detenteur);
		matrepos.save(m);
		return m;
	}

	@Override
	public Materiel attriuberMateriel(Materiel m, Agent d) {
		// TODO Auto-generated method stub
		m.setDetenteur(d);
		matrepos.save(m);
		return m;
	}

	@Override
	public Materiel dettacherMateriel(Materiel m) {
		// TODO Auto-generated method stub
		m.setDetenteur(null);
		matrepos.save(m);
		return null;
	}

	@Override
	public void delMat(Materiel m) {
		// TODO Auto-generated method stub
		matrepos.delete(m);
	}

	
	/*
	 * Affichage
	 */
	@Override
	public void seeMat(Materiel m) {
		// TODO Auto-generated method stub
		ModeAcquisition ma=null;
		Financement fi=null;
		Fournisseur f=null;
		Float mont=0f;
		String refFact=null;
		
		if(m instanceof MaterielNouv){
			ma = ((MaterielNouv)m).getModAcq();
			fi = ((MaterielNouv)m).getFinancement();
			f = ((MaterielNouv)m).getFournisseur();
			mont = ((MaterielNouv)m).getMontant_facture();
			refFact = ((MaterielNouv)m).getRefFacture();
		}
		
		System.out.println("MATERIEL:");
		System.out.println("--------");
		System.out.println("Type| Nomenclature| marque | pu| ref| numSerie | caract | detenteur | autre |"
				+ "|Etat | Mode Acqui | Financement | Montant | ref Fact | Fournisseur| :");
		System.out.println(m.getCaract()+"|"+m.getNomenMat()+"|"+ m.getMarque()+"|"+ m.getPu()+"|"+ m.getReference()+"|"+ 
				m.getNumSerie()+"|"+ "XX"+"|"+ m.getDetenteur().getNomAgent()+"|"+ m.getAutre()+"|"+m.getEtat()+"|"+ma+"|"+
				fi+"|"+mont+"|"+refFact+"|"+f);
		
	}

	@Override
	public void seeAgent(Agent a) {
		// TODO Auto-generated method stub
		System.out.println("");
		
	}

}
