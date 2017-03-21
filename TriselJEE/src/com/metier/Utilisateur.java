package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
	@Id
	@Column(name="idUtilisateur")
private String idUtilisateur;
	@Column(name="nomUtilisateur")
private String nomUtilisateur;
	@Column(name="prenomutilisateur")
private String prenomutilisateur;
	@Column(name="login")
private String login;
	@Column(name="mdp")
private String mdp;
	@Column(name="niveau")
private int niveau;
	
public Utilisateur() {
		super();
	}
public Utilisateur(String idUtilisateur, String nomUtilisateur,
		String prenomutilisateur, String login, String mdp, int niveau) {
	super();
	this.idUtilisateur = idUtilisateur;
	this.nomUtilisateur = nomUtilisateur;
	this.prenomutilisateur = prenomutilisateur;
	this.login = login;
	this.mdp = mdp;
	this.niveau = niveau;
}

public Utilisateur(String idUtilisateur, String nomUtilisateur,
		String prenomutilisateur, int niveau) {
	super();
	this.idUtilisateur = idUtilisateur;
	this.nomUtilisateur = nomUtilisateur;
	this.prenomutilisateur = prenomutilisateur;
	this.niveau = niveau;
}
public String getIdUtilisateur() {
	return idUtilisateur;
}
public String getNomUtilisateur() {
	return nomUtilisateur;
}
public String getPrenomUtilisateur() {
	return prenomutilisateur;
}
public String getLogin() {
	return login;
}
public String getMdp() {
	return mdp;
}

public void setLogin(String login) {
	this.login = login;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public int getNiveau() {
	return niveau;
}
@Override
public String toString() {
	return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur="
			+ nomUtilisateur + ", prenomutilisateur=" + prenomutilisateur
			+ ", login=" + login + ", mdp=" + mdp + ", niveau=" + niveau + "]";
}
}
