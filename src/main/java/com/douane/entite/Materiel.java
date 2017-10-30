package com.douane.entite;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeMateriel", discriminatorType=DiscriminatorType.STRING,length=4)
public class Materiel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMateriel;
	
	private Float pu;
	private String reference;
	private String numSerie;
	private String autre;
	private String codification;
	
	@ManyToOne
	@JoinColumn(name="idNom")
	private Nomenclature nomenMat;
	@ManyToOne
	@JoinColumn(name="idEtat")
	private EtatMateriel etat;
	@ManyToOne
	@JoinColumn(name="idCar")
	private TypeMateriel caract;
	@ManyToOne
	@JoinColumn(name="idMarque")
	private Marque marque;
	
	
	@ManyToOne
	@JoinColumn(name="imAgent")
	private Agent detenteur;
	
	//@ManyToOne
	//@JoinColumn(name="im")
	@Transient
	private Agent dc;
	

	/*
	 * MANAGE LATER
	Collection Operations
	File documents;
	Photo Blob
	Codification
	List<Agent> Liste des agents detenteurs successifs
	Code Barre
	Localisation
	*/
	
	public Long getIdMateriel(){
		return this.idMateriel;
	}
	public Float getPu() {
		return pu;
	}
	public void setPu(Float pu) {
		this.pu = pu;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public Nomenclature getNomenMat() {
		return nomenMat;
	}
	public void setNomenMat(Nomenclature nomenMat) {
		this.nomenMat = nomenMat;
	}
	public Agent getDetenteur() {
		return detenteur;
	}
	public void setDetenteur(Agent detenteur) {
		this.detenteur = detenteur;
	}
	public EtatMateriel getEtat() {
		return etat;
	}
	public void setEtat(EtatMateriel etat) {
		this.etat = etat;
	}
	public TypeMateriel getCaract() {
		return caract;
	}
	public void setCaract(TypeMateriel caract) {
		this.caract = caract;
	}
	public Agent getDc() {
		return dc;
	}
	public void setDc(Agent dc) {
		this.dc = dc;
	}
	public String getCodification() {
		return codification;
	}
	public void setCodification(String codification) {
		this.codification = codification;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	public Materiel(Float pu, String reference, String numSerie, String autre, String codification,
			Nomenclature nomenMat, EtatMateriel etat, TypeMateriel caract, Agent detenteur, Agent dc, Marque m) {
		super();
		this.pu = pu;
		this.reference = reference;
		this.numSerie = numSerie;
		this.autre = autre;
		this.codification = codification;
		this.nomenMat = nomenMat;
		this.etat = etat;
		this.caract = caract;
		this.detenteur = detenteur;
		this.dc = dc;
		this.marque = m;
	}
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
