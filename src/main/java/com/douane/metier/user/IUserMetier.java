package com.douane.metier.user;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.User;

public interface IUserMetier {
	public User addUser(User u);
	public List<User> listUser();
	public void remUser(User u);
	
	public Agent addAgent(Agent a);
	public void remAgent (Agent a);
	
	//temporary
	public List<Agent> findAllAgents();
	
	public Agent addAgentUser(Agent a, User u);
	public List<Agent> findAgentByNom(String name);
	public Agent findAgentByIm (Long im_agent);
	
	public Materiel entrerMateriel(Materiel m, Agent dc);
	public Materiel attriuberMateriel (Long idMat, Long im);
	public Materiel attriuberMateriel (Materiel m, Agent d);
	public Materiel dettacherMateriel (Materiel m);
	public void delMat(Materiel m);
	
	
	/**
	 * Affichage
	 */
	public void seeMat(Materiel m);
	public void seeAgent(Agent a);
	
	
	 
}
