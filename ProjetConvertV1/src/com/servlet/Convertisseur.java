package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Temperature;

@WebServlet("/Convertisseur")
public class Convertisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Convertisseur() {
        super();
          }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<title>Convertisseur de température</title>");
		out.println("</head><body>Vous pouvez convertir une température exprimée en");
		out.println("<b>Celsius</b> en une valeur exprimée en  <b>Fahrenheit</b><hr />");
		out.println("<form method='post'  action='./Convertisseur'>");
		out.println("Valeur en Celsius: <input type='text' size='20' name='celsius'/> <br/>");
		out.println("<input type='submit' value='Convertir' />");
		out.println( "</form><hr/></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // on récupère le paramètre transmis dans l'URL  
		 String valCelsius = request.getParameter("celsius");
		 // variable pour test de conversion
		  double celsius=0;
		  // objet Temperature
		  Temperature t;
		  // génération début page html pour la réponse
		  response.setContentType("text/html");
		  response.setCharacterEncoding( "UTF-8" );
		  // instanciation d'un objet édition de réponse
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<title>Résultat de la conversion</title>");
			// test des différentes situations du cas d'utilisation
	        if (valCelsius.isEmpty()) {
		          	  out.println("vous n'avez rien saisi, on vous donne par dÃ©faut la conversion pour 20 degrÃ©s");
		              t= new Temperature(20);
			          out.println("<p>Et le résultat est "+ t.getFahrenheit() +" degrés Fahrenheit </p>");
	        			}
	        else
		          {
		          try
		          {  // tentative conversion , instanciation objet temperature et génération du résultat
		        	  celsius=Double.valueOf(valCelsius);
		        	  t= new Temperature(celsius);
		        	  out.println("<p>Vous avez demandé la conversion en Fahrenheit de la valeur en  Celsius=" + t.getCelsius() +"</p>"); 
		        	  out.println("<p>Et le résultat est "+ t.getFahrenheit() +" degrés Fahrenheit </p>");
		          }
		          catch (NumberFormatException e)
		          {
		        	  out.println("<p>la valeur saisie doit être numérique</p> ");
		          }
		   }
	        // proposition lien vers formualire
		          out.println("<p><a href='./Convertisseur'> Retour Formulaire</p> ");
	}

}
