package com.metier;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typedechet")
public class TypeDechet {
	@Id
	@Column(name="idTypeDechet")
	private String idTypeDechet;
	@Column(name="libelle")
	private String libelle;
	@Column(name="tarif")
	private double tarif;
	public TypeDechet(String idTypeDechet, String libelle, double tarif) {
		this.idTypeDechet = idTypeDechet;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	
	public TypeDechet() {
		super();
	}

	public String getIdTypeDechet() {
		return idTypeDechet;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public String getLibelle() {
		return libelle;
	}
	@Override
	public String toString() {
		return "TypeDechet [idTypeDechet=" + idTypeDechet + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
}
