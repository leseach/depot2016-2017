package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="habitation")
public  class Habitation {
	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	@Column(name="adrRueHab")
	private String adrRueHab;
	@Column(name="cpHab")
	private String cpHab;
	@Column(name="adrVilleHab")
	private String adrVilleHab;
	@Column(name="nbPersonne")
	private int nbPersonne;
	@ManyToOne  // 1 usager pour l’habitation
	@JoinColumn(name="idUsager")
	private Usager usager;
	@OneToMany  // plusieurs poubelles pour 1 habitation
	@JoinColumn(name = "idHabitation")
	private List<Poubelle> lesPoubelles;
	@OneToMany  // plusieurs factures pour 1 habitation
	@JoinColumn(name = "idHabitation")
	private List<Facture> lesFactures;
		
	public Habitation() {
		super();
	}
	public Habitation(String idHabitation, String adrRueHab, String cpHab, String adrVilleHab, int nbPersonne,
			Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adrRueHab;
		this.cpHab = cpHab;
		this.adrVilleHab = adrVilleHab;
		this.nbPersonne = nbPersonne;
		this.usager = usager;
		this.lesPoubelles = new ArrayList<Poubelle>();
		this.lesFactures = new ArrayList<Facture>();
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public String getAdrRueHab() {
		return adrRueHab;
	}

	public void setAdrRueHab(String adrRueHab) {
		this.adrRueHab = adrRueHab;
	}

	public String getCpHab() {
		return cpHab;
	}

	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}

	public String getAdrVilleHab() {
		return adrVilleHab;
	}

	public void setAdrVilleHab(String adrVilleHab) {
		this.adrVilleHab = adrVilleHab;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public Usager getUsager() {
		return usager;
	}
	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	public List<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}
	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	public void addPoubelle(Poubelle p) {
		lesPoubelles.add(p);
	}
	public double getCout(int an , int mois)
	{
		double total=0;
	// parcours des poubelles pour cumul des poubelles du mois et de l'année
		for(Poubelle p : lesPoubelles) {
			total = total + p.getCout(an, mois);
		}
		return (double) Math.round(total * 100) / 100;
	}

	public List<Facture> getLesFactures() {
		return lesFactures;
	}
	public void setLesFactures(List<Facture> lesFactures) {
		this.lesFactures = lesFactures;
	}
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adrRueHab=" + adrRueHab + ", cpHab=" + cpHab
				+ ", adrVilleHab=" + adrVilleHab + ", nbPersonne=" + nbPersonne + ", usager=" + usager
				+ ", lesPoubelles=" + lesPoubelles + "]";
	}
	
	
}
