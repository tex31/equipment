package com.douane.entite;

import javax.persistence.Entity;

@Entity
public class MotifDecharge extends Referentiel{

	public MotifDecharge() {
		this.setTable("MotifDecharge");
		// TODO Auto-generated constructor stub
	}

	public MotifDecharge(String designation) {
		super(designation);
		this.setTable("MotifDecharge");
		// TODO Auto-generated constructor stub
	}
	
}
