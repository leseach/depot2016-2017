package com.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="poubelle")
public class Poubelle {
	@Id
	@Column(name="idPoubelle")
	private String idPoubelle;
	@ManyToOne  // plusieurs poubelles pour 1 type d�chet
	@JoinColumn(name="idTypeDechet")
	private TypeDechet nature;
	@Column(name="idHabitation")
	private String idHabitation;
	@OneToMany // plusieurs lev�es pour 1 poubelle
	@JoinColumn(name = "idPoubelle")
	private List<Levee> lesLevees;

	public Poubelle() {
		super();
	}
	public Poubelle(String idPoubelle, String idHabitation, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.idHabitation = idHabitation;
		this.nature = nature;
		lesLevees = new ArrayList<Levee>();
	}
	public String getIdPoubelle() {
		return idPoubelle;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	public TypeDechet getNature() {
		return nature;
	}
	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}
	public List<Levee> getLesLevees() {
		return lesLevees;
	}
	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	
	public void addLevee(Levee l){
		lesLevees.add(l);
	}

	public ArrayList<Levee> getLesLevees(int an, int mois) {
		// d�claration et instanciation collection de travail
		ArrayList<Levee> listeLevee = new ArrayList<Levee>();
		// r�cup�ration d'une instance de Calendar
		Calendar cal = Calendar.getInstance();
		// parcours des lev�es
		for (Levee uneLevee : lesLevees) {
			// passage par la classe Calendar pour extraire les composants de la
			// date
			cal.setTime(uneLevee.getLaDate());
			int anL = cal.get(Calendar.YEAR);
			// extraction du mois mettre + 1 car d�marre � 0 et non pas 1
			int moisL = cal.get(Calendar.MONTH) + 1;
			// test sur date
			if ((anL == an) && (moisL == mois)) {
				// ajout de la lev�e � la collection
				listeLevee.add(uneLevee);
			}
		}
		// on d�livre la collection
		return listeLevee;
	}

	public double getCout(int an, int mois) {
		// variables de cumul
		double totalPoids = 0;
		double cout = 0;
		// d�claration collection de travail pour r�cup�rer les lev�es
		// concern�es
		ArrayList<Levee> listeLevee = this.getLesLevees(an, mois);
		// parcours des lev�es pour faire la somme des pes�es
		for (Levee uneLevee : listeLevee) {
			totalPoids = totalPoids + uneLevee.getPoids();
		}
		// prise en compte du tarif en fonction de la nature des d�chets
		cout = totalPoids * nature.getTarif();
		return (double) Math.round(cout * 100) / 100;
	}


	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", nature=" + nature
				+ ", lesLevees=" + lesLevees + "]";
	}
}
