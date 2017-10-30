package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class EtatMateriel extends Referentiel{
	public EtatMateriel(){
		this.setTable("EtatMateriel");
	}
	public EtatMateriel(String designation){
		super(designation);
		this.setTable("EtatMateriel");
	}
}
