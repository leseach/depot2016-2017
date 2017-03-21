<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, com.metier.Habitation, com.metier.Facture, com.metier.Usager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage Factures</title>
<% 
// on récupère le paramètre transmis à la vue
// type Object par défaut donc transtypage obligatoire
// navigabilite habitation , facture donc usag suffit
Usager u = (Usager) request.getSession().getAttribute("usag");
List<Habitation> listeHabitation = u.getLesHabitations();
 %>
</head>
<body>
<p><a href='./MenuGeneral'> Retour MenuGeneral</a></p><br/>
<% 
out.println(u.getNom() + " " + u.getPrenom()+"<br/>");
//parcours des habitations
if (listeHabitation.size() == 0 ) {
	out.println("Aucune habitation connue ");
}
else {
	for (Habitation  h: listeHabitation) 	{
		out.println("<p> pour le logement situé à </p>");
		out.println(h.getAdrRueHab()+"<br/>");
		out.println(h.getCpHab() + "  "+ h.getAdrVilleHab()+ "<br/>");
		// on récupère les factures, navigabilité mise en place
		List<Facture> listeFacture = h.getLesFactures();
		if (listeFacture.size()!=0) {
			for(Facture f : listeFacture) {%>
		<table border="1">
		<tr>
			<th>liste des factures</th>
		</tr>
		<tr>
			<%
   			String lienFacture ="pdf/" + f.getNomFacture();
			String nomFacture = f.getNomFacture();
			out.println("<td><a href="+ lienFacture +" target='_blank'><img src='img/logoadobe.png'>" + nomFacture +"</a></td>");
			%>
		</tr>
		<%  }%>
	</table>
	<%  }
	
     else
    	 out.println("pas de facture");
     }
 }%>
</body>
</html>
