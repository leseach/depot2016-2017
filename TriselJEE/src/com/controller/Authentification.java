package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metier.Usager;
import com.persistance.AccesData;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Authentification() {
		super();
		System.out.println("ttt");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupération du message éventuel s'il ne s'agit pas du premier appel
		// à la méthode
		String message = request.getParameter("message");
		if (message != null) {
			// on transmets le paramètre
			request.setAttribute("message", message);
		}
		// on appelle la page authentification.jsp
		request.getRequestDispatcher("vue/authentification.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// on récupère les paramètres transmis par le formulaire
		String user = request.getParameter("user");
		String mdp = request.getParameter("mdp");
		// on récupère l'usager éventuel dans le modèle
		Usager usag = AccesData.getUsager(user, mdp);
		// si l'usager n'existe pas
		if (usag == null) {
			// préparation du message à transmettre
			String message = "Authentification incorrecte";
			// on refait appel à la servlet , méthode doGet
			response.sendRedirect("./Authentification?message=" + message + "&user=" + user + "&mdp=" + mdp);
		} else {
			// ServletContext application =
			// getServletConfig().getServletContext();
			// application.setAttribute("usag", usag);
			// on met l'usager en variable session pour y accéder facilement
			HttpSession session = request.getSession();
			session.setAttribute("usag", usag);
			// on appelle la servetMenuGeneral
			response.sendRedirect("./MenuGeneral");
		}
	}
}


