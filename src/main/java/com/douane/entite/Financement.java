package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class Financement extends Referentiel{
	public Financement(){
		this.setTable("Financement");
	}
	public Financement (String designation){
		super(designation);
		this.setTable("Financement");
	}
}
