package com.douane.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Agent {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long im;
	
	private String nomAgent;
	private String prenomAgent;
	
	//@Column(name="roleAgent")
	@ManyToOne
	@JoinColumn(name="idUser")
	private User roleAgent;
	
	//ADD OR NOT Getters and Setters
	@OneToMany(mappedBy="detenteur")
	private List<Materiel> matdetenu;
	
	//@OneToMany(mappedBy="dc")
	@Transient
	private List<Materiel> matEntree;
	
	public Agent(Long im, String nom_agent, String prenom_agent, User role) {
		super();
		this.im = im;
		this.nomAgent = nom_agent;
		this.prenomAgent = prenom_agent;
		this.roleAgent = role;
	}
	
	public Agent(Long im, String nom_agent, String prenom_agent) {
		super();
		this.im = im;
		this.nomAgent = nom_agent;
		this.prenomAgent = prenom_agent;
	}
	
	public Agent(){
		
	}

	public Long getIm() {
		return im;
	}

	public void setIm(Long im) {
		this.im = im;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nom_agent) {
		this.nomAgent = nom_agent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenom_agent) {
		this.prenomAgent = prenom_agent;
	}

	public User getRoleAgent() {
		return roleAgent;
	}

	public void setRoleAgent(User role) {
		this.roleAgent = role;
	}
	
}
