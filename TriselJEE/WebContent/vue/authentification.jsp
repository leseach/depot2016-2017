<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <script type="text/javascript" src="js/controle.js"></script>
        <title> Formulaire authentification</title>
    </head>
	<H1> <img src="img/Trisel.jpg" width="150" height="150"> Accès au portail de la Communauté des Communes</H1>
    <body>
    <% String message = request.getParameter("message");
    if (message != null) {
    	out.println("<font color=Red> "+ message + "</br></font>");
    }
    %>
      <p>Veuillez vous authentifier avec le code usager et le mot de passe que vous avez reçu par courrier</p>
       <form name = "authentification" method="post"  onSubmit="return verifForm(this)" action="./Authentification">
    <table >
     	  <tr>
      		<td>code usager</td>
      		<td><input type=text name=user> </td>
          </tr>
          <tr>
      		<td>mot de passe</td>
      		<td><input type=text name=mdp></td>
       	  </tr>
       </table>
       <input type=submit name=valider value = valider >
       <input type=reset name=annuler value = annuler>
       </form>
      </body>
</html>