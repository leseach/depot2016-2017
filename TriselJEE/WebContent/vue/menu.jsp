<%@ page language="java" contentType="text/html"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultation factures ordures m�nag�res</title>
</head>
<body>
<form action="./MenuGeneral" method="post">
<p><a href='./Authentification'> D�connexion</a>
<Table border=1>

<tr>
<td>Liste des factures en serv-jsp-scriptjava-avec navigabilit�</td>
<td><input type="submit" name="action" value="ServScript"/></td>
</tr>
<tr>
<td>Liste des factures en serv-jsp-jslt-avec navigabilit� </td>
<td><input type="submit" name="action" value="ServJslt"/></td>
</tr>
<tr>
<td>Liste des factures en serv-jsp-scriptjava-sans navigabilit�</td>
<td><input type="submit" name="action" value="ServNonNavScript"/></td>
</tr> 
<tr>
<td> Liste des factures en serv-jsp-jslt-sans navigabilit�-liste facture </td>
<td><input type="submit" name="action" value="ServNonNavJslt"/></td>
</tr> 
<tr>
<td> Liste des factures en serv-jsp-script-sans navigabilit�-liste nom facture </td>
<td><input type="submit" name="action" value="ServNonNavScriptNomF"/></td>
</tr> 
<tr> 
<td> Habitation liste d�roulante script et ajax </td>
<td><input type="submit" name="action" value="HabitationListeDeroulanteScript"/></td>
</tr>
<tr> 
<td> Habitation liste d�roulante jslt et ajax </td>
<td><input type="submit" name="action" value="HabitationListeDeroulanteJslt"/></td>
</tr>  
</Table>
</form>
</body>
</html>