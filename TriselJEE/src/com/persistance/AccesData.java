package com.persistance;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Tarif;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.metier.Utilisateur;

public class AccesData {
	private static Session s = HibernateSession.getSession();

	public static List<Habitation> getLesHabitations() {
		return s.createQuery("from Habitation").list();
	}
	public static Habitation getHabitations(String idHabitation) {
		return (Habitation) s.get(Habitation.class, idHabitation);
	}
	public static List<Facture> getLesFacturesHabitation(String idHabitation) {
		return s.createQuery("from Facture f where f.idHabitation ='" + idHabitation +"'").list();
	}
	public static List<Usager> getLesUsagers() {
		return s.createQuery("from Usager").list();
	}
	public static Usager getUsager(String login , String mdp) {
		String hql= "from Usager u where u.login='"+ login +"' and  u.mdp='" + mdp + "'";
		return (Usager) s.createQuery(hql).uniqueResult();
	}
	public static List<Habitation> getLesHabitationsUsager(String idUsager) {
		return s.createQuery("from Habitation h where h.usager.idUsager = '" + idUsager + "'").list();
	}
	public static boolean ajoutLevee(Levee l) {
		boolean ok = false;
		try {
			Transaction t = s.beginTransaction();
			s.save(l);
			t.commit();
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ok;
	}

	public static boolean ajouterFacture(Facture f) {
		boolean ok = false;
		try {
			Transaction t = s.beginTransaction();
			s.save(f);
			t.commit();
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ok;
	}
	public static boolean ajouterTypeDechet(TypeDechet td) {
		boolean ok = false;
		try {
			Transaction t = s.beginTransaction();
			s.save(td);
			t.commit();
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ok;
	}
	public static Tarif getTarif(int id) {
		return (Tarif) s.get(Tarif.class, id);
	}
	public static TypeDechet getTypeDechet(String  id) {
		return (TypeDechet) s.get(TypeDechet.class, id);
	}
	public static List<TypeDechet> getLesTypeDechet()
	{
		return s.createQuery("From TypeDechet").list();
	}
	public static boolean modifierTypeDechet (TypeDechet td)
	{
		boolean ok=false;

		try {
			Transaction t = s.beginTransaction();
			s.update(td);
			t.commit();
			ok=true;
		}
			catch (HibernateException e) {
			ok = false;
		}
		return ok;
	}
	

	public static Utilisateur getUtilisateur(String login, String mdp) {
		Utilisateur u = null;
		String hql = "from Utilisateur  u where u.login ='" + login +"' and u.mdp ='" + mdp +"'";
		return (Utilisateur)  s.createQuery(hql).uniqueResult();
     }

	public static boolean ajouterControleFacture(Facture f) {
		boolean ok = false;
		// vérification existence facture déjà dans la base
		// requête hql
		String hql = "from Facture f where f.anF =" + f.getAnF();
		hql = hql + " and f.moisF = " + f.getMoisF();
		hql = hql + " and f.idHabitation ='" + f.getIdhabitation() + "'";
		Facture existf = (Facture) s.createQuery(hql).uniqueResult();
		if (existf == null){
		try {
			Transaction t = s.beginTransaction();
			s.save(f);
			t.commit();
			ok = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		}
		return ok;
	}
	
}
