package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	@Id
	@GeneratedValue
	@Column(name = "idFacture")
	private int idFacture;
	@Column(name = "moisF")
	private int moisF;
	@Column(name = "anF")
	private int anF;
	@Column(name = "nomFacture")
	private String nomFacture;
	@Column(name = "idHabitation")
	private String idHabitation;
	

	public Facture() {
		super();
	}

	public Facture(int idFacture, int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;

	}

	// constructeur pour créer une nouvelle facture
	public Facture(int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFacture = 0;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;

	}

	public int getIdFacture() {
		return idFacture;
	}

	public int getMoisF() {
		return moisF;
	}

	public int getAnF() {
		return anF;
	}

	public String getNomFacture() {
		return nomFacture;
	}

	public String getIdhabitation() {
		return idHabitation;
	}

	public void setIdhabitation(String idhabitation) {
		this.idHabitation = idhabitation;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", moisF=" + moisF + ", anF=" + anF + ", nomFacture=" + nomFacture
				+ ", idhabitation=" + idHabitation + "]";
	}

}
