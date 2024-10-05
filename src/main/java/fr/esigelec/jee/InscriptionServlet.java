package fr.esigelec.jee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class InscriptionServlet
*/
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RechercheClubDAO club = new RechercheClubDAO();
		String Fed = request.getParameter("Federation");
		System.out.println(Fed);
		request.setAttribute("clubos", club.recupererListeCommune());
		request.setAttribute("clubx", club.recupererListeReg());
		request.setAttribute("clubv", club.recupererListeFed());
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status_de_la_demande=0;
		String nom = request.getParameter("le_nom");
		String prenom = request.getParameter("le_prenom");
		String mail = request.getParameter("l_email");
		String motdp = request.getParameter("le_pass");
		String fed = request.getParameter("Federation");
		String reg = request.getParameter("Region");
		String com  = request.getParameter("Commune");
		String le_role =request.getParameter("choix_role");
		
		ConnexionDAO inscription = new ConnexionDAO();
		int code = inscription.get_code_info(fed, com, reg);
		if(inscription.check_inscription(nom, prenom, mail, motdp, status_de_la_demande, le_role, fed, com,reg,code)==true) {
			response.sendRedirect("ConfirmationDeDemandeinscription.jsp");
		} else {
			System.err.println("Inscription non effectuer");
			RequestDispatcher rd = request.getRequestDispatcher("inscription.jsp");
			rd.forward(request, response);
		}
	}

}