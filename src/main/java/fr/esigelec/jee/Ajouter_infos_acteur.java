package fr.esigelec.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.esigelec.model.ActeurInfos;
import fr.esigelec.jee.InfosActeurDAO;

/**
 * Servlet implementation class Ajouter_infos_acteur
 */
public class Ajouter_infos_acteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfosActeurDAO infosActeurDAO = new InfosActeurDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_infos_acteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titreAjouter");
		String infos = request.getParameter("infosAjouter");
		int code_mairie = Integer.parseInt(request.getParameter("mairie"));
		int code_federation = Integer.parseInt(request.getParameter("federation"));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("titreAjout", titre);
		session.setAttribute("infosAjout", infos);
		session.setAttribute("code_mairie", code_mairie);
		session.setAttribute("code_federation", code_federation);
		
		request.getRequestDispatcher("/page_acteur_ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titreAjouter");
		String infos = request.getParameter("infosAjouter");
		int code_mairie = Integer.parseInt(request.getParameter("mairie"));
		int code_federation = Integer.parseInt(request.getParameter("federation"));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("titreAjout", titre);
		session.setAttribute("infosAjout", infos);
		session.setAttribute("code_mairie", code_mairie);
		session.setAttribute("code_federation", code_federation);
		
		ActeurInfos newInfos = new ActeurInfos();
		newInfos.setTitre(titre);
		newInfos.setInformations(infos);
		newInfos.setCode_mairie(code_mairie);
		newInfos.setCode_federation(code_federation);
		
		infosActeurDAO.ajouter_infos(newInfos);
		
		request.getRequestDispatcher("/page_acteur_monde_sportif.jsp").forward(request, response);
	}

}
