<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href='./MenuGeneral'> Retour Menu général</a>
</body>
<h1>
<c:out value="${usag.nom}"/> 
 <c:out value="${usag.prenom}"/></h1>
<c:choose> 
<c:when test ="${usag.lesHabitations.size() == 0}">
	 <p>Aucune habitation connue</p>
</c:when>
<c:otherwise>
     <c:forEach var="hab" items="${usag.lesHabitations}">
	<p> pour le logement situé à </p>
	<c:out value="${hab.adrRueHab}"/></br>
	<c:out value="${hab.cpHab}"/>
	<c:out value="${hab.adrVilleHab}"/></br>
	<c:choose> 
 	  <c:when test="${hab.lesFactures.size()== 0}">
 		 <p>Aucune facture pour cette habitation</p>
 	  </c:when>
 	  <c:otherwise>
  		<p> Vous disposez de <c:out value="${hab.lesFactures.size()}"/> facture(s)
  		<table border="1">
		<tr>
		    <th>liste des factures</th>
		</tr>
		<c:forEach var="facture" items="${hab.lesFactures}">
		  <tr> 
			<td>
				<a href=pdf/<c:out value="${facture.nomFacture}"/> target='_blank'>
				<img src='img/logoadobe.png'>
				<c:out value="${facture.nomFacture}"/>
				</a>
			</td>
		  </tr>
		</c:forEach>
		</table>
   	 </c:otherwise>
   	</c:choose>
     </c:forEach>
</c:otherwise>
</c:choose>
</html>
