package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usager")
public class Usager {
	@Id
	@Column(name="idUsager")
	private String idUsager;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adrRueUsager")
	private String adrRueUsager;
	@Column(name="cpUsager")
	private String cpUsager;
	@Column(name="adrVilleUsager")
	private String adrVilleUsager;
	@Column(name="login")
	private String login;
	@Column(name="mdp")
	private String mdp;
	@OneToMany  // plusieurs habitations pour 1 usager
	@JoinColumn(name = "idUsager")
	// mise en place navigabilité bidirectionnelle
	private List<Habitation> lesHabitations;


	public Usager() {
		super();
	}

	public Usager(String idUsager, String nom, String prenom, String adrRueUsager, String cpUsager,
			String adrVilleUsager) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adrRueUsager = adrRueUsager;
		this.cpUsager = cpUsager;
		this.adrVilleUsager = adrVilleUsager;
		this.login ="";
		this.mdp="";
		lesHabitations = new ArrayList<Habitation>();
	}

	public String getIdUsager() {
		return idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdrRueUsager() {
		return adrRueUsager;
	}

	public void setAdrRueUsager(String adrRueUsager) {
		this.adrRueUsager = adrRueUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public String getAdrVilleUsager() {
		return adrVilleUsager;
	}

	public void setAdrVilleUsager(String adrVilleUsager) {
		this.adrVilleUsager = adrVilleUsager;
	}

	public List<Habitation> getLesHabitations() {
		return  lesHabitations;
	}

	public void setLesHabitations(ArrayList<Habitation> lesHabitations) {
		this.lesHabitations = lesHabitations;
	}

	public void addHabitation(Habitation h) {
		lesHabitations.add(h);
	}

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager
				+ ", cpUsager=" + cpUsager + ", adrVilleUsager=" + adrVilleUsager + "]";
	}

}
