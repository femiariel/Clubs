package fr.esigelec.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.esigelec.model.ActeurInfos;


/**
 * Servlet implementation class Ajout_infos_acteur
 */
@WebServlet("/Ajout_infos_acteur")
public class Ajout_infos_acteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private InfosActeurDAO infosActeurDAO = new InfosActeurDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajout_infos_acteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = request.getParameter("titreAjouter");
		String infos = request.getParameter("infosAjouter");
		int code_mairie = Integer.parseInt(request.getParameter("mairie"));
		int code_federation = Integer.parseInt(request.getParameter("federation"));
		
		HttpSession session = request.getSession();
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
		// TODO Auto-generated method stub
		String titre = request.getParameter("titreAjouter");
		String infos = request.getParameter("infosAjouter");
		String code_mairie =request.getParameter("mairie");
		String code_federation= request.getParameter("federation");
		
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
