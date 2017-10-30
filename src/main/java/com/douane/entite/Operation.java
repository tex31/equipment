package com.douane.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Operation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	protected Long id;
	protected String date;
	
	protected String poste;
	
	@transient
	protected Agent operateur;
	
	public Long getId() {
		return id;
	}



	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public Agent getOperateur() {
		return operateur;
	}


	public void setOperateur(Agent operateur) {
		this.operateur = operateur;
	}

}
