package com.douane.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MA")
public class ModeAcquisition extends Referentiel{

	public ModeAcquisition() {
		// TODO Auto-generated constructor stub
		this.setTable("MA");
	}

	public ModeAcquisition(String designation) {
		super(designation);
		this.setTable("MA");
		// TODO Auto-generated constructor stub
	}
	
	
}
